package Heaps;
class Heap{
    int[] arr;
    int idx = 1;
    int peek(){return arr[1];}

    void add(int ele){
        arr[idx++] = ele;
        //rearrangement
        int root = idx - 1;
        while(root != 1){
            int parent  = root /2;
            if(arr[root ] < arr[parent]){
                int temp = arr[root];
                arr[root]= arr[parent];
                arr[parent] = temp;
                root = parent;
            }
            else break;
        }
    }

    void display(){
        for(int i = 1; i < idx; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    int size(){
        return idx - 1;
    }

    Heap(int capacity){arr = new int[capacity + 1];}
}
public class MinHeapImplementation {
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.add(1);
        h.add(2);
        h.add(10);
        h.add(7);
        h.add(4);
        h.add(5);
        h.display();
    }
}
