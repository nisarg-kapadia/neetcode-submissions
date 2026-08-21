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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while(cur != null || !st.isEmpty()){

            while(cur != null){
                st.push(cur);  
                cur = cur.left;  
            }

            TreeNode peek = st.peek();

            if(peek.right != null && peek.right != lastVisited){
                cur = peek.right;
            }else{

                ans.add(st.peek().val);
                lastVisited = st.pop();
            }
        }

        return ans;
    }
}