package LinkedList.Single;

import java.util.ArrayList;
import java.util.List;

public class DeleteNode {

    public static class Node{
        int data;
        Node next;
        boolean isVisited;
        Node(int data){
            this.data = data;
        }
    }

    public static void insertAtEnd(Node head, int val){
        Node newNode = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static int NthFromLast(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i = 0; i< n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    public static Node DeleteNthFromLast(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i = 0; i< n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static Node intersection(Node head1, Node head2){
        Node temp1 = head1;
        while(temp1!=null){
            temp1.isVisited = true;
            temp1 = temp1.next;
        }
        Node temp2 = head2;
        while(temp2!= null){
            if(temp2.isVisited) return temp2;
            temp2 = temp2.next;
        }
        return null;
    }

    public static Node intersection2(Node head1, Node head2){
        Node temp1 = head1, temp2 = head2;
        int l1 = 0;
        while(temp1 != null){
            temp1 = temp1.next;
            l1++;
        }
        int l2 = 0;
        while(temp2 != null){
            temp2 = temp2.next;
            l2++;
        }
        temp1 = head1;
        temp2 = head2;
        if(l1 > l2){
            for(int i = 0; i< l1 - l2; i++){
                temp1 = temp1.next;
            }
        }
        else{
            for(int i = 0; i< l2 - l1; i++){
                temp2 = temp2.next;
            }
        }
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    public static int middle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void deleteMiddle(Node head){
        if(head.next == null){
            head = null;
            return;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }

    public static boolean isCycle(Node head){
        if(head == null) return false;
        if(head.next == null) return false;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            if(fast == slow)return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static Node DetectCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        Node temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }

    public static int NodesInCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        Node temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        int counts = 0;
        do{
            slow = slow.next;
            counts++;
        }while(temp != slow);
        return counts;
    }

    public static Node mergeTwoSortedLl(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(100);
        Node newNode = head;
        int data;
        while(temp1.next != null && temp2.next != null){
            if(temp1.data > temp2.data){
                data = temp2.data;
                newNode.next = new Node(data);
                newNode = newNode.next;
                temp2 = temp2.next;
            }
            else{
                data = temp1.data;
                newNode.next =  new Node(data);
                newNode = newNode.next;
                temp1 = temp1.next;
            }
        }
        if(temp1 != null){
            newNode.next = temp2;
        }
        else{
            newNode.next = temp1;
        }
        return newNode;
    }

    public static Node mergeTwoSortedllWitoutExtraNode(Node head1, Node head2){
        Node h = new Node(100);
        Node t = h;
        Node t1 = head1;
        Node t2 = head2;

        while(t1!=null && t2!=null){
            if(t1.data < t2.data){
                t.next = t1;
                t = t1;
                t1 = t1.next;
            }
            else{
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null){
            t.next = t2;
        }
        else{
            t.next = t1;
        }
        return h.next;
    }

    public static List<Node> splitOddEven(Node head){
        Node temp = head;
        Node even = new Node(12);
        Node evnInsert = even;
        Node odd = new Node(10);
        Node oddInsert = odd;
        while(temp != null){
            if(temp.data % 2 == 0){
                evnInsert.next = new Node(temp.data);
                evnInsert = evnInsert.next;
            }
            else{
                oddInsert.next = new Node(temp.data);
                oddInsert = oddInsert.next;
            }
            temp = temp.next;
        }
        List<Node> lst = new ArrayList<>();
        lst.add(odd.next);
        lst.add(even.next);

        return lst;
    }

    public static Node oddEvenList(Node head){
        Node temp = head;
        Node odd = new Node(0);
        Node even = new Node(0);
        Node tempo = odd;
        Node tempe = even;

        while(temp != null){
            tempo.next = temp;
            temp = temp.next;
            tempo = tempo.next;

            temp.next = temp;
            if(temp == null) break;
            temp = temp.next;
            tempe = tempe.next;
        }
        odd = odd.next;
        even = even.next;
        tempe = tempe.next;
        return odd;

    }


    public static Node reverseLL(Node head){
        if(head.next == null) return head;
        Node newHead = reverseLL(head.next);
        head.next.next = head;//interchanging the connections
        head.next = null;
        return newHead;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node agla = null;

        while(curr!=null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        return prev;
    }

    public static boolean isPallindrome(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = reverse(slow.next);
        slow.next = temp;
        Node p1 = head;
        Node p2 = slow.next;
        while(p2 != null){
            if(p1.data != p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static int maxTwinSum(Node head){

        int twinSum = Integer.MIN_VALUE;

        Node fast = head;
        Node slow = head;
        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = reverse(slow.next);
        slow.next = temp;
        Node p1 = head;
        Node p2 = slow.next;
        while(p2 != null){
            twinSum = Integer.max((p1.data + p2.data), twinSum);
            p2 = p2.next;
            p1 = p1.next;
        }
        return twinSum;
    }



    public static void main(String[] args) {
        Node ll = new Node(1);
        insertAtEnd(ll,2);
        insertAtEnd(ll,3);
        insertAtEnd(ll,4);
        insertAtEnd(ll,5);
        insertAtEnd(ll,4);
        insertAtEnd(ll,3);
        insertAtEnd(ll,2);
//        insertAtEnd(ll,1);

//        Node ll1 = new Node(10);
//        insertAtEnd(ll1,11);
//        insertAtEnd(ll1,12);
//        insertAtEnd(ll1,13);
//        ll1.next.next.next = ll.next.next.next;
//        insertAtEnd(ll1,14);
//        insertAtEnd(ll1,15);
//        insertAtEnd(ll1,16);


//        display(ll);
//        display(ll1);
//        System.out.println(NthFromLast(ll,1));
//        ll  = DeleteNthFromLast(ll,8);
//        display(ll);
//        Node intersectionPoint = intersection(ll, ll1);
//        System.out.println(ll1.next.next.next.data);
//        System.out.println(intersectionPoint.data);
//        Node intersectionPoint2 = intersection2(ll,ll1);
//        System.out.println(intersectionPoint2.data);
//        System.out.println(middle(ll));
//        deleteMiddle(ll);
//        display(ll);

        List<Node> lst = splitOddEven(ll);
//        Node odd = lst.get(0);
//        Node even = lst.get(1);
//        display(odd);
//        display(even);
        Node reversed = reverse(ll);
        display(reversed);
        System.out.println(isPallindrome(ll));
        System.out.println(maxTwinSum(reversed));
    }
}
