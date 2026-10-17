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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0;i<size;i++){

                TreeNode cur = q.poll();
                row.add(cur.val);

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                
            }

            ans.add(row);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<ans.size();i++){

            List<Integer> r = ans.get(i);
            res.add(r.get(r.size() - 1));
        } 

        return res;
    }
}
