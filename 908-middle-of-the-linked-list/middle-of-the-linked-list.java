/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // Fast Node is moving by twice '2'
        // slow Node is moving by '1' step
        
        // It perfectly work for 'odd' number of Nodes
        // But inorder for it to work for 'even' no. of Nodes
        // 'fast.next != null' concept come into play.
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}