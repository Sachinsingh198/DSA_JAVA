package BinaryTree.Traversal;
import BinaryTree.Node;
public class Inorder {
    private static void inorder(Node node){
        if(node == null) {
            return;
        };
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    public static void main(String[] args) {

    }
}
