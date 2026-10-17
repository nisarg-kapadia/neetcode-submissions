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

    public int goodNodes(TreeNode root) {
        
        return count(root, root.val);


    }

    public int count(TreeNode root, int maxVal){

        if(root == null){
            return 0;
        }

        int ans = 0;
        if(root.val >= maxVal){
            ans = 1;
        }

        maxVal = Math.max(maxVal, root.val);

        ans += count(root.left, maxVal);
        ans += count(root.right, maxVal);

        return ans;
    }
}
