package LinkedList.Single;

public class BasicsLL {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data  = data;
        }
    }

//    private static void insert(Node head, )

    private static void display(Node head){
        Node temp =head;

        while(temp .next!= null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    private static void displayRecursively(Node head){
        if(head.next == null){
            if(head.data != 0) {
                System.out.println(head.data);
            }
            return;
        }
        System.out.print(head.data + "->");
        displayRecursively(head.next);
    }

    private static void displayRecursivelyReverse(Node head){
        if(head.next == null){
            if(head.data != 0) {
                System.out.print(head.data +"->");
            }
            return;
        }
        displayRecursivelyReverse(head.next);
        System.out.print(head.data + "->");
    }

    private static int length(Node head){
        Node temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;

        }
        return length;
    }

    private  static int lengthRecursively(Node head, int length){
        return (head==null)?length:(lengthRecursively(head.next, length + 1));
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next= new Node(4);
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = new Node(6);

        displayRecursively(a);
        System.out.println(length(a));
        System.out.println(lengthRecursively(a, 0));
//        display(a);

    }
}
