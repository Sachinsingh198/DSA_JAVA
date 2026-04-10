package CompPro;




import LinkedList.Single.BasicsLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Intersection {
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    public Node getIntersetion(Node headA, Node headB){
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;

        ArrayList<Node> listA = new ArrayList<>();
        Node temp = headA;
        while(temp != null){
            listA.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            if(listA.contains(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }
}
