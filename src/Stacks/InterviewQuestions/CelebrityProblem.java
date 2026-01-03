package Stacks.InterviewQuestions;

import java.util.Stack;

public class CelebrityProblem {
    private static int celebrity(int M[][]) {
        int n = M.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();
            if (M[v1][v2] == 1) {
                // v1 knows v2 -> v1 cannot be celebrity
                st.push(v2);
            } else {
                // v1 does NOT know v2 -> v2 cannot be celebrity
                st.push(v1);
            }
        }

        if (st.isEmpty()) return -1;
        int potential = st.pop();

        // verify row: celebrity should not know anyone (ignore self)
        for (int j = 0; j < n; j++) {
            if (j == potential) continue;
            if (M[potential][j] == 1) return -1;
        }

        // verify column: everyone else must know the celebrity
        for (int i = 0; i < n; i++) {
            if (i == potential) continue;
            if (M[i][potential] == 0) return -1;
        }

        return potential;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int n = 3;
        int[][] m = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int celebrity = celebrity(m);
        System.out.println(celebrity);

    }
}
