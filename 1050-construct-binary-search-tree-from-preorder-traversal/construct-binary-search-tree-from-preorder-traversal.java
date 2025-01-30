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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFormPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFormPreorder(int[] A, int bound) {
        // base case
        if(i == A.length || A[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i++]);
        // Store elem less than root
        root.left = bstFormPreorder(A, root.val);
        root.right = bstFormPreorder(A, bound);

        return root;
    }
}

// preorder = [8,5,1,7,10,12]