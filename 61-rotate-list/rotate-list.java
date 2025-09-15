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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;

        // find length
        int len = 0;
        ListNode iterNode = head;
        while(iterNode != null) {
            len++;
            iterNode = iterNode.next;
        }

        k = k % len;

        if(k == 0)
            return head;

        ListNode tail = head;
        int i=1;
        while(i < len-k) {
            tail = tail.next;
            i++;
        }

        ListNode newHead = tail.next;
        ListNode connectNode = newHead;
        while(connectNode.next != null) {
            connectNode = connectNode.next;
        }
        connectNode.next = head;
        tail.next = null;

        return newHead;
    }
}