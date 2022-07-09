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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head, next;
        while (cur != null) {
            for (int i = 0; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null)
                break;
            next = end.next;
            end.next = null;
            cur = pre.next;
            pre.next = reverse(cur);
            cur.next = next;
            pre = cur;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode end = null;
        ListNode cur = head;
        while (cur != null) {
            end = cur.next;
            cur.next = pre;
            pre = cur;
            cur = end;
        }
        return pre;
    }
}