/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Map <Child, Parent>
    private void trackParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        map.put(root, null);

        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if(currNode.left != null) {
                map.put(currNode.left, currNode);
                q.add(currNode.left);
            }
            if(currNode.right != null) {
                map.put(currNode.right, currNode);
                q.add(currNode.right);
            } 
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map <Child, Parent>
        Map<TreeNode, TreeNode> map = new HashMap<>();
        trackParent(root, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);
        int currLevel = 0;

        while(!q.isEmpty()) {
            if(currLevel == k)
                break;

            int size = q.size();
            while(size != 0) {
                TreeNode nd = q.poll();

                if(nd.left != null && !visited.contains(nd.left)) {
                    visited.add(nd.left);
                    q.add(nd.left);
                }

                if(nd.right != null && !visited.contains(nd.right)) {
                    visited.add(nd.right);
                    q.add(nd.right);
                }
                // check parent
                // root parent is null, if not visited store in queue and visisted set
                
                if(map.get(nd) != null && !visited.contains(map.get(nd))) {
                    // map.get(nd) - getting parent of node
                    visited.add(map.get(nd));
                    q.add(map.get(nd));
                }
                size--;
            }
            currLevel++;
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}