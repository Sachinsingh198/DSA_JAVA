package BinaryTree.Questions;
import BinaryTree.Node;

public class MinDistance {
    public static int findDist(Node root, int a, int b){
        Node lca = lowestCommonAncestor(root, a, b);
        int[] dis = {0, 0};
        dfs(lca, a, b, 0, dis);
        return dis[0] + dis[1];
    }

    private static void dfs(Node lca, int a, int b, int level, int[] dis) {
        if(lca == null) return;
        if(lca.val == a)  dis[0] = level;
        if(lca.val == b)  dis[1] = level;
        dfs(lca.left, a, b, level + 1, dis);
        dfs(lca.right, a, b, level + 1, dis);
    }

    public static Node lowestCommonAncestor(Node root, int p, int q){
        if(root == null) return null;
        if(root.val == p || root.val == q) return root;

        Node l = lowestCommonAncestor(root.left, p, q);
        Node r = lowestCommonAncestor(root.right, p, q);
        if(l!=null && r!=null) return root;
        return (l == null) ? r : l;
    }



    public static void main(String[] args) {

// Build a simple tree:
//        1
//      /   \
//     2     3
//    / \   /
//   4   5 6
//
// dist(4,5) = 2 (4 -> 2 -> 5)
// dist(4,6) = 4 (4 -> 2 -> 1 -> 3 -> 6)

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);


        System.out.println(findDist(root, 4, 5)); // 2
        System.out.println(findDist(root, 4, 6)); // 4
        System.out.println(findDist(root, 4, 42)); // -1 (42 not in tree)
    }
}

