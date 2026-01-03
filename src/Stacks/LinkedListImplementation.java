package Stacks;

public class LinkedListImplementation {

    public static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public static class Stack{
        private Node head = null;
        private int size = 0;

        void push(int val){
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            size++;
        }

        void displayReverse(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        private void displayRec(Node pointer){
            if(pointer == null) return;
            displayRec(pointer.next);
            System.out.print(pointer.val + " ");

        }

        void display(){
            Node temp = head;
            displayRec(temp);
            System.out.println();
        }

        int pop(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = head.val;
            head = head.next;
            size--;
            return top;
        }

        int peek(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.val;
        }

        boolean isEmpty(){
            return size == 0;
        }

        int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        System.out.println(st.size());
        System.out.println(st.pop());
        st.pop();
        st.display();
        System.out.println(st.peek());
        st.push(5);
        st.push(6);
        st.push(3);
        st.push(9);
        st.display();
    }
}
