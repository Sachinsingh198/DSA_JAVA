package ARRAYS;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {4,10,20,10,6,3,8};
        int max = Integer.MIN_VALUE;
        int smax = arr[0];
        for(int el: arr){
            if(el > max){
                max = el;
            }
        }
        for(int el: arr){
            if(el > smax && el != max){
                smax = el;
            }
        }
        System.out.println("max : "+ max);
        System.out.println("smax: "+ smax);
    }
}
