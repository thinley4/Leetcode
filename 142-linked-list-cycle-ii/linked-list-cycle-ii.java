/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next; // Increament by 2
            slow = slow.next; // Increament by 1
            if(fast == slow) {
                break;
            }
        }
        // No cycle return null
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        // Find starting of the loop
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}