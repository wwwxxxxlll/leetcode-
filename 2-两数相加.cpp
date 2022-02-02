/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {//模拟加法，管理链表，直接执行加法似乎会超出int范围，所以解题思路是模拟加法，不要忘记最后一位进位
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        int sum = 0;
        ListNode *head = nullptr, *tail = nullptr;
        int v1 = 0, v2 = 0;
        while(l1||l2){
            v1 = l1?l1->val:0;
            v2 = l2?l2->val:0;
            sum = v1+v2+carry;
            if(!head){
                head = new ListNode(sum%10);
                tail = head;
            }
            else{
                tail->next = new ListNode(sum%10);
                tail = tail->next;
            }
            carry = sum/10;
            if(l1)
            l1 = l1->next;
            if(l2)
            l2 = l2->next;
        }
        if (carry > 0) {
            tail->next = new ListNode(carry);
        }
        return head;
    }
};
