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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode divideAndConquer(ListNode[] lists, int l, int r) {
        if(l == r) return lists[l];
        
        int mid = l + (r - l) / 2;
        ListNode l1 = divideAndConquer(lists, l, mid);
        ListNode l2 = divideAndConquer(lists, mid+1, r);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divideAndConquer(lists, 0, lists.length-1);
    }
}