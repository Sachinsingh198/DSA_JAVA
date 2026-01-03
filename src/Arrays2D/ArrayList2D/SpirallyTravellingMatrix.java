package Arrays2D.ArrayList2D;

import java.util.ArrayList;

public class SpirallyTravellingMatrix {
    public static ArrayList<Integer> printSpiralMatrix(int[][] arr){
        ArrayList<Integer> li = new ArrayList<>();
        int m = arr.length, n = arr[0].length;
        int fr = 0, lr = m - 1;
        int fc = 0, lc = n - 1;

        int count = 0;
        int total = m * n;
        while(fr <= lr && fc <= lc){

            //go right
            for(int i = fc; i <= lc; i++){
                li.add(arr[fr][i]);
                count++;
            }
            fr++;


            // go down
            for(int i = fr; i <= lr; i++){
                li.add(arr[i][lc]);
                count++;
            }
            lc--;
            if(count == total) break;

            //go left
            for(int i = lc; i >= fc; i--){
                li.add(arr[lr][i]);
                count++;
            }
            lr--;
            if(count == total) break;

            //go up
            for(int i = lr; i >= fr; i--){
                li.add(arr[i][fc]);
                count++;
            }
            fc++;
            if(count == total) break;
        }

        return li;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12,},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30}
        };
        System.out.println(arr[0].length * arr.length);

        ArrayList<Integer> li = printSpiralMatrix(arr);
        for(Integer el: li){
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println(li.size());
    }
}
