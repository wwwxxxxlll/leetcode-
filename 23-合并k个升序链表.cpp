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
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1 == nullptr){
            return list2;
        }
        if(list2 == nullptr){
            return list1;
        }
        if(list1->val<list2->val){
            list1->next = mergeTwoLists(list2,list1->next);
            return list1;
        }
        else{
            list2->next = mergeTwoLists(list1,list2->next);
            return list2;
        }
    }
    ListNode* merge(int l, int r, vector<ListNode*>& lists){
        if (l == r) return lists[l];
        if (l > r) return nullptr;
        int mid = (l+r)/2;
        return mergeTwoLists(merge(l,mid,lists),merge(mid+1,r,lists));
        // 注意在mid上加一，除符合逻辑外，若不加会导致死循环
        //注意循环不变量
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int n = lists.size();
        return merge(0,n-1,lists);
    }
    
};