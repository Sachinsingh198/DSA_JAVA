package SORTING.Merge;

public class Merge {
    public static void sort(int[] arr){
        if(arr.length == 1) return;
        int[] a = new int[arr.length/2];
        int[] b = new int[arr.length - arr.length/2];

        int idx = 0;
        for(int i = 0; i< a.length; i++){
            a[i] = arr[idx++];
        }
        for(int i = 0; i < b.length; i++){
            b[i] = arr[idx++];
        }
        sort(a);
        sort(b);
        merge(a,b,arr);

    }

    public static void merge(int[] a, int[] b, int[] c){
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(i < a.length) c[k++] = a[i++];
        while(j < b.length) c[k++] = b[j++];

    }

    public static void main(String[] args) {
        int[] arr = {5,2,8,4,1,6,7,8};
        sort(arr);
        for(int el: arr){
            System.out.print(el + " ");
        }
    }
}