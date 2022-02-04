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
class Solution {//注意head被移除的情况，因此需要一个新的指针来保存位置，此外需要注意循环变量的大小
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0,head);
        ListNode* first = dummy;
        ListNode* second = head;
        int n1 = n;
        while(n1--){
            second = second->next;
        }
        while(second){
             first = first->next;
             second = second->next;
         }
        first->next = first->next->next;
        return dummy->next;
    }
};