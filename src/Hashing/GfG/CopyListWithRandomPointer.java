package Hashing.GfG;

import BinaryTree.Node;

import java.util.HashMap;

class NodeCopy{
    NodeCopy next, random;
    int val;

    NodeCopy(int val){
        this.val = val;
        next = null;
        random = null;
    }
}
public class CopyListWithRandomPointer {
    public NodeCopy deepCopy(NodeCopy head1){
        NodeCopy temp1 = head1;
        NodeCopy head2 = new NodeCopy(-1);
        NodeCopy temp2 = head2;
        while(temp1 != null){
            NodeCopy t = new NodeCopy(temp1.val);
            temp2.next = t;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return head2.next;
    }

    public NodeCopy cloneLinkedList(NodeCopy a){
        NodeCopy b = deepCopy(a);
        NodeCopy tempA = a;
        NodeCopy tempB = b;
        HashMap<NodeCopy, NodeCopy> map = new HashMap<>();
        map.put(null, null);
        while(tempA!= null){
            map.put(tempA, tempB);
            tempA = tempA.next;
            tempB = tempB.next;
        }
        tempA = a;
        while (tempA != null){
            tempB = map.get(tempA);
            tempB.random = map.get(tempA.random);
            tempA = tempA.next;
        }
        return b;

    }

    public static void main(String[] args) {
        // Deep copy

    }
}
