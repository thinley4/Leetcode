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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean lr = true;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> dq = new ArrayDeque<>();

            while(size > 0) {
                TreeNode node = q.poll();

                if(lr) {
                    dq.offerLast(node.val);
                } else {
                    dq.offerFirst(node.val);
                }

                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);

                size--;
            }
            ans.add(new ArrayList(dq));
            lr = !lr;
        }

        return ans;
    }
}