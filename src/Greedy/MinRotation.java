package Greedy;

public class MinRotation {
    private static int rotationCount(long R, long D) {
        int ans = 0;
        int first , second;

        while(R > 0){
            first = (int)R % 10;
            second = (int)D % 10;
            R/=10;
            D/=10;

            ans += Math.min(Math.abs(first - second) , 10 - Math.abs(first - second));
        }

        return ans;
    }
    public static void main(String[] args) {
        long  R = 2345;
        long   D = 5432;

        System.out.println(rotationCount(R, D));
    }
}
