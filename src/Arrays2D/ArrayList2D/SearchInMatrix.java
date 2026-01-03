package Arrays2D.ArrayList2D;

public class SearchInMatrix {//Sorted Matrix

    public static boolean searchMatrix(int[][] arr, int target){
        int m = arr.length, n = arr[0].length;
        int i = 0, j = n-1;
        while(i < m && j >= 0){
            if(arr[i][j] > target) j--;
            else if(arr[i][j] < target) i++;
            else return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,7,11,15},
                {2,5,8, 12, 19},
                {3,6,9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26,30}
        };
        System.out.println(searchMatrix(arr, 27));
    }
}
