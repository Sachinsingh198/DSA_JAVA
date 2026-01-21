package BinarySearchTree;

import BinaryTree.Node;

public class SortedArrayToBst {
    Node helper(int[] nums, int r, int l){
        if(r > l) return null;
        int mid = (l + r)/2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums,r, mid - 1);
        root.right = helper(nums, mid + 1, l);

        return root;
    }
    public Node sortedArrayToBST(int[] nums) {
       Node root = helper(nums, 0, nums.length - 1);
       return root;
    }
    public static void main(String[] args) {

    }
}
