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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        insertVal(root, val);

        return root;
    }

    public void insertVal(TreeNode root, int val) {
        while(root != null) {
            if(val > root.val) {
                if(root.right == null){
                    root.right = new TreeNode(val);
                    return;
                }
                root = root.right;
            } else {
                // val smaller than root value
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    return;
                }
                root = root.left;
            }
        }
    }
}