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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = null;
        int carry = 0;
        ListNode head = tail;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int temp = (v1 + v2 + carry);
            ListNode t = new ListNode(temp%10,null);
            carry = temp/10;
            if(head != null){
                tail.next = t;
                tail = t;
            }
            else{
                head = t;
                tail = t;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry != 0){
            ListNode t = new ListNode(carry,null);
            tail.next = t;
            tail = t;
        }
        return head;
    }
}