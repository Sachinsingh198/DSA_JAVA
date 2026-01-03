package LinkedList.Single;

public class Leetcode {
    public static class Node{
        int data;
        Node next;
        Node random;

        Node(int data){
            this.data = data;
        }
    }

    public static Node copyRandomList(Node head){
        Node head2 = new Node(0);
        Node temp2 = head2;
        Node temp1  = head;

        //creating deep copy
        while(temp1!= null){
            Node t = new Node(temp1.data);
            temp2.next = t;
            temp2 = t;
        }
        head2 = head2.next;
        temp2 = head2;
        temp1 = head;

        //alternate connections
        Node temp = new Node(-1);
        while(temp1!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp2  = head2;
        temp1 = head;

        // assigning random pointers
        while(temp1 != null && temp2!=null){

        }
        return temp2;

    }

    public static void main(String[] args) {

    }
}
