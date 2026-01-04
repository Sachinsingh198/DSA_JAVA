package BinaryTree.Traversal;
import BinaryTree.Node;

public class Postorder {
    private static void postOrder(Node node){
        if(node == null) {
            return;
        };
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    public static void main(String[] args) {

    }
}
