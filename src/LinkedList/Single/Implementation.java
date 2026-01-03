package LinkedList.Single;

public class Implementation {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class linkedList{
        Node head = null;
        Node tail = null;

        private int size = 0;

        void insertAtEnd(int data){
            Node temp = new Node(data);
            size++;
            if(head == null){
                head = temp;
            }
            else {
                tail.next = temp;
            }
            tail = temp;
        }

        void display(){
            Node temp = head;
            while(temp.next != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
        int sizell(){
            return this.size;
        }

        void insertAtBegin(int val){
            Node temp = new Node(val);
            if(head == null){
                head = tail = temp;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void insertAtIndex(int val, int idx){
            if(idx < 0 || idx > size) return;
            if(idx == 0) {
                insertAtBegin(val);
                return;
            }
            if(idx == size) {
                insertAtEnd(val);
                return;
            }
            Node newNode = new Node(val);
            Node temp = head;
            int count = idx -1;
            while(count != 0){
                temp = temp.next;
                count--;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        void deleteAtIndex(int index){
            if(index == 0){
                head = head.next;
                size--;
                return;
            }
            if(index >= size) return ;
            Node temp = head;
            for(int i = 1; i< index; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(index == size-1) tail = temp;
            size--;
        }

        int getElement(int index){
            if(index < 0 || index > size) return -1;
            Node temp = head;
            for(int i = 1; i<= index; i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtBegin(5);
        ll.insertAtIndex(6, 3);
        ll.insertAtIndex(7,6);
        ll.insertAtIndex(12,0);
        ll.display();
        System.out.println(ll.size);
        ll.deleteAtIndex(0);
        ll.display();
        System.out.println(ll.tail.data);
    }
}
