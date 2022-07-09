/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummya = headA;
        ListNode dummyb = headB;
        int la = 0, lb = 0;
        int div = 0;
        while (dummya != null) {
            ++la;
            dummya = dummya.next;
        }
        while (dummyb != null) {
            ++lb;
            dummyb = dummyb.next;
        }
        dummya = headA;
        dummyb = headB;
        if (lb > la) {
            int tmpLen = la;
            la = lb;
            lb = tmpLen;
            ListNode tmpNode = dummya;
            dummya = dummyb;
            dummyb = tmpNode;
        }
        div = la - lb;
        while (div > 0) {
            dummya = dummya.next;
            --div;
        }
        while (dummya != null && dummyb != null) {
            if (dummya == dummyb)
                return dummya;
            dummya = dummya.next;
            dummyb = dummyb.next;
        }
        return null;
    }
}