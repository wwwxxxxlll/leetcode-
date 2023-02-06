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
    public int numComponents(ListNode head, int[] nums) {
        int max = 0;
        int n = nums.length;
        HashSet<Integer> occ = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            occ.add(nums[i]);
        }
        while (head != null) {
            if (occ.contains(head.val)) {
                while (head != null && occ.contains(head.val)) {
                    head = head.next;
                }
                max++;
            } else {
                head = head.next;
            }
        }
        return max;
    }
}