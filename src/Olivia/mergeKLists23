/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
   ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* result = new ListNode(-1);
        ListNode*p = result;
        while(l1!=NULL&&l2!=NULL){
           if(l1->val>l2->val){
               p->next = l2;
               l2 = l2->next;
           }
            else{
                p->next = l1;
                l1 = l1->next;
            }
            p = p->next;
        }
        while(l1==NULL&&l2!=NULL){p->next = l2; l2 = l2->next;p=p->next;}
        while(l2==NULL&&l1!=NULL){p->next = l1; l1 = l1->next;p=p->next;}
     return result->next;
    }

    ListNode* split(vector<ListNode*>& lists, int startLoc, int size) {
        if (size <= 1) return lists[startLoc];
        ListNode *p = split(lists, startLoc, size / 2);
        ListNode *q = split(lists, startLoc+size / 2, size-size / 2);
        return mergeTwoLists(p, q);
    }
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.empty()) return NULL;
        return split(lists, 0, lists.size());
    }
};