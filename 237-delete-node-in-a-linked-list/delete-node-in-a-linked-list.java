/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Change given node value to next node
        node.val = node.next.val;
        // Point to next.next node
        node.next = node.next.next;
    }
}