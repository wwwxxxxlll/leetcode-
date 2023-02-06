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
    public void reorderList(ListNode head) {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode mid = getMid(head);
        l2 = reverse(mid.next);
        mid.next = null;
        l1 = head;
        l1 = merge(l1, l2);
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head1 = new ListNode(0, null);
        ListNode tail = head1;
        while (l1 != null && l2 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        return head1.next;
    }
}