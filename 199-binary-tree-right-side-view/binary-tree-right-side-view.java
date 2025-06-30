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
    List<Integer> res = new ArrayList<>();
    
    public void helper(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode currQueue = null;
            // inner loop to store left and right of queue
            while(size > 0) {
                currQueue = q.poll();
                size--;

                if(currQueue.left != null)
                    q.add(currQueue.left);
                if(currQueue.right != null)
                    q.add(currQueue.right);
            }
            res.add(currQueue.val);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        helper(root);
        return res;
    }
}