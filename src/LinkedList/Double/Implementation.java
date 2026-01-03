package LinkedList.Double;

public class Implementation {

    public static class Node{
        int val;
        Node next, prev;

        Node(int val){
            this.val = val;
        }
    }

    public static void display(Node head){
        Node temp = head;
        System.out.print("Null <--> ");
        while(temp.next != null){
            System.out.print(temp.val + " <--> ");
            temp = temp.next;
        }
        System.out.println(temp.val + " <--> Null");
    }

    public static void displayReverse(Node tail){
        Node temp = tail;
        System.out.print("Null <--> ");
        while(temp.prev != null){
            System.out.print(temp.val + " <--> ");
            temp = temp.prev;
        }
        System.out.println(temp.val + " <--> Null");
    }

    public static void display2(Node random){
        Node temp = random;
        while(temp.prev != null){
            temp = temp.prev;
        }
        System.out.print("Null <--> ");
        while(temp.next != null){
            System.out.print(temp.val + " <--> ");
            temp = temp.next;
        }
        System.out.println(temp.val + " <--> Null");
    }

    public static Node insetAtHead(Node head, int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }

    public static Node insertAtTailUsingTail(Node tail, int val){
        Node newNode = new Node(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return tail;
    }

    public static void insertAtTailUsingHead(Node head, int val){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.prev = temp;

    }

    public static void insertAtIndex(Node head, int val, int index){
        Node temp = head;
        int counter = 1;
        while(counter < index - 1 && temp != null){
            temp = temp.next;
            counter++;
        }

        Node newNode = new Node(val);

        Node tempNext = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = tempNext;
        tempNext.prev = newNode;
    }




    public static void main(String[] args) {
        //4 10 2 99 13
        Node  a =  new Node(4);
        Node  b  = new Node(10);
        Node  c =  new Node(2);
        Node  d =  new Node(99);
        Node  e =  new Node(13);

        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;

        Node newHead = insetAtHead(a, 10);
        Node f = insertAtTailUsingTail(e, 20);
        insertAtTailUsingHead(a, 34);
        display(newHead);
        insertAtIndex(a, 45, 4);
        display(newHead);
    }
}
