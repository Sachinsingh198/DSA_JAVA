package BinarySearch;

public class SearchInSortedMatrix {

    static boolean searchInSortedMatrix(int[][] arr, int tar){
        int rows = arr.length, cols = arr[0].length;
        int lo= 0,hi = rows*cols-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            int midRow = mid/cols, midCol = mid % cols;
            if(arr[midRow][midCol] == tar) return true;
            else if(arr[midRow][midCol] > tar) hi = mid - 1;
            else lo = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,6,12,27,32},
                {38,41,47,49,55},
                {67,68,75,76,81},
                {84,89,91,92,98}
        };

        System.out.println(searchInSortedMatrix(arr,47));
    }
}
