/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode l1 = dummy;
        while (l1.next != null && l1.next.next != null) {
            if (l1.next.val == l1.next.next.val) {
                int val = l1.next.val;
                while (l1.next != null && l1.next.val == val)
                    l1.next = l1.next.next;
            } else
                l1 = l1.next;
        }
        return dummy.next;
    }
}