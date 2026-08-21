/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        swap(root);

        return root;
    }

    public void swap(TreeNode root){

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.right != null) swap(root.right);
        if(root.left != null) swap(root.left);
    }
}
