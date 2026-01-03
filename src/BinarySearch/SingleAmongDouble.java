package BinarySearch;

public class SingleAmongDouble {

    static int findOnce(int[] arr){

        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];
        int n = arr.length , hi = n , lo = 0;

        while(hi >= lo){
            int mid = lo + (hi - lo)/2;
            if(((mid % 2 != 0) && arr[mid]==arr[mid - 1]) || ((mid % 2 == 0) && arr[mid]==arr[mid + 1]) ){
                lo = mid + 1;
            }
            else if (((mid % 2 == 0 ) && arr[mid] == arr[mid - 1]) || ((mid % 2 != 0) && arr[mid]==arr[mid + 1]) ){
                hi = mid - 1;
            }

            else return arr[mid];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2, 3, 3, 50, 65,65};

        System.out.println(findOnce(arr));
    }
}