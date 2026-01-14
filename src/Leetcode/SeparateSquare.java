package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class SeparateSquare {

    class Solution {
        public double separateSquares(int[][] squares) {
            int n = squares.length;
            if (n == 0) return 0.0;

            // 1) Collect and compress x-coordinates
            TreeSet<Integer> xset = new TreeSet<>();
            for (int[] s : squares) {
                int x1 = s[0];
                int x2 = s[0] + s[2];
                xset.add(x1);
                xset.add(x2);
            }
            int mX = xset.size();
            int[] xsInt = new int[mX];
            int idx = 0;
            for (int x : xset) xsInt[idx++] = x;

            // Map x -> index
            HashMap<Integer, Integer> xIndex = new HashMap<>(mX * 2);
            for (int i = 0; i < mX; i++) xIndex.put(xsInt[i], i);

            // Segment tree built over intervals [i, i+1) -> [xsInt[i], xsInt[i+1]]
            SegTree seg = new SegTree(xsInt);

            // 2) Build y-events: (y, x1_idx, x2_idx, delta)
            class Event {
                int y, l, r, delta;
                Event(int y, int l, int r, int delta) {
                    this.y = y; this.l = l; this.r = r; this.delta = delta;
                }
            }
            ArrayList<Event> events = new ArrayList<>(2 * n);
            TreeSet<Integer> yset = new TreeSet<>();
            for (int[] s : squares) {
                int x1 = s[0], y1 = s[1], l = s[2];
                int x2 = x1 + l, y2 = y1 + l;
                int li = xIndex.get(x1);
                int ri = xIndex.get(x2);
                events.add(new Event(y1, li, ri, +1)); // add interval on enter
                events.add(new Event(y2, li, ri, -1)); // remove on exit
                yset.add(y1);
                yset.add(y2);
            }

            // Sort events by y ascending
            events.sort(Comparator.comparingInt(e -> e.y));

            // Unique sorted Y coordinates
            int mY = yset.size();
            int[] ysInt = new int[mY];
            idx = 0;
            for (int y : yset) ysInt[idx++] = y;

            // 3) Sweep in y and compute union x-length per slab
            double[] L = new double[Math.max(0, mY - 1)]; // union x-length for slab [Y[i], Y[i+1])
            int evPtr = 0;
            for (int i = 0; i < mY; i++) {
                int y = ysInt[i];
                // Apply all events at this y
                while (evPtr < events.size() && events.get(evPtr).y == y) {
                    Event e = events.get(evPtr);
                    seg.update(e.l, e.r, e.delta);
                    evPtr++;
                }
                // Record current union length for slab starting at Y[i]
                if (i + 1 < mY) {
                    L[i] = seg.totalCovered();
                }
            }

            // 4) Compute suffix areas: Suf[i] = area above y = Y[i]
            double[] Suf = new double[mY];
            Suf[mY - 1] = 0.0; // above the highest y is 0 area
            for (int i = mY - 2; i >= 0; i--) {
                double dy = (double) (ysInt[i + 1] - ysInt[i]);
                Suf[i] = Suf[i + 1] + L[i] * dy;
            }
            double totalArea = Suf[0];
            double target = totalArea / 2.0;

            // 5) Find slab where target lies and solve linearly
            // Suf[i] >= target >= Suf[i+1], since Suf decreases with i
            for (int i = 0; i < mY - 1; i++) {
                if (target <= Suf[i] && target >= Suf[i + 1]) {
                    double len = L[i];
                    int yLow = ysInt[i], yHigh = ysInt[i + 1];
                    if (len == 0.0) {
                        // Area doesn't change across this slab; any y in [yLow, yHigh] works
                        return (double) yLow;
                    }
                    // areaAbove(y) within [yLow, yHigh] is: Suf[i] - len * (y - yLow)
                    // Solve Suf[i] - len * (t - yLow) = target -> t = yLow + (Suf[i] - target) / len
                    double t = yLow + (Suf[i] - target) / len;
                    // Clamp numerically to the slab
                    if (t < yLow) t = yLow;
                    if (t > yHigh) t = yHigh;
                    return t;
                }
            }

            // Fallback (shouldn't happen): if all L[i]==0 -> totalArea=0, return lowest y
            return (double) ysInt[0];
        }

        // Segment tree for union length over compressed x intervals
        static class SegTree {
            final int n;           // number of elementary intervals = xs.length - 1
            final int[] xs;        // unique sorted x coords
            final int[] count;     // coverage count per node
            final double[] length; // covered length per node

            SegTree(int[] xs) {
                this.xs = xs;
                this.n = Math.max(0, xs.length - 1);
                int size = (n == 0) ? 1 : (4 * n);
                this.count = new int[size];
                this.length = new double[size];
            }

            // Update coverage over [l, r) in index space with +1/-1
            void update(int l, int r, int delta) {
                if (l >= r || n == 0) return;
                update(1, 0, n, l, r, delta);
            }

            double totalCovered() {
                return (n == 0) ? 0.0 : length[1];
            }

            private void update(int node, int nl, int nr, int ql, int qr, int delta) {
                if (qr <= nl || nr <= ql) return; // no overlap
                if (ql <= nl && nr <= qr) {
                    count[node] += delta;
                    pull(node, nl, nr);
                    return;
                }
                int mid = (nl + nr) >>> 1;
                update(node << 1, nl, mid, ql, qr, delta);
                update((node << 1) | 1, mid, nr, ql, qr, delta);
                pull(node, nl, nr);
            }

            private void pull(int node, int nl, int nr) {
                if (count[node] > 0) {
                    // fully covered
                    length[node] = (double) (xs[nr] - xs[nl]);
                } else if (nl + 1 == nr) {
                    // leaf interval not covered
                    length[node] = 0.0;
                } else {
                    // sum children
                    length[node] = length[node << 1] + length[(node << 1) | 1];
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
