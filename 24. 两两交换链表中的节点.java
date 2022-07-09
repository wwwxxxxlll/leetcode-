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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy1 = new ListNode(0, head);
        ListNode dummy = dummy1;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp = dummy.next;
            dummy.next = temp.next;
            temp.next = temp.next.next;
            dummy.next.next = temp;
            dummy = dummy.next.next;
        }
        return dummy1.next;
    }
}