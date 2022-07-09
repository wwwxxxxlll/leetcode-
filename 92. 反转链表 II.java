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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int div = right - left;
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy, r;
        ListNode pre, next;
        for (int i = 0; i < left - 1; ++i) {
            l = l.next;
        }
        pre = l;
        l = l.next;
        r = l;
        for (int i = 0; i < div; ++i) {
            r = r.next;
        }
        pre.next = null;
        next = r.next;
        ListNode tnext;
        ListNode tpre = null;
        ListNode cur = l;
        while (cur != next) {
            tnext = cur.next;
            cur.next = tpre;
            tpre = cur;
            cur = tnext;
        }
        pre.next = r;
        l.next = next;
        return dummy.next;
    }
}