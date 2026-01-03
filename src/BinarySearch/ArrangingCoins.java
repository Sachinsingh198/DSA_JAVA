package BinarySearch;

public class ArrangingCoins {
    static int arrangeCoins(int n){
        if(n == 0) return 0;
        int lo= 0, hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(mid * (mid + 1)/2 >n){
                hi = mid -1;
            }
            else if(mid * (mid + 1)/2 < n){
                lo = mid + 1;
            }
            else{
                return mid ;
            }
        }
        return hi;
    }
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Number of Complete rows: "+ arrangeCoins(n));
    }
}
