/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *result = NULL;
    struct ListNode **write = &result;
    int carry = 0, temp = 0;
    while (l1 != NULL){
        if (l2 != NULL) temp = l2->val;
        temp = temp + l1->val + carry; 
        if (temp >= 10){
            carry = 1;
            temp -= 10;
        }else carry = 0;
        (*write) = malloc(sizeof(struct ListNode));
        (**write) = (struct ListNode){temp, NULL};
        temp = 0;
        l1 = l1->next;
        if (l2 != NULL) l2 = l2->next;
        write = &((*write)->next);
    }
    while (l2 != NULL){
        temp = l2->val + carry; 
        if (temp >= 10){
            carry = 1;
            temp -= 10;
        }else carry = 0;
        (*write) = malloc(sizeof(struct ListNode));
        (**write) = (struct ListNode){temp, NULL};
        l2 = l2->next;
        write = &((*write)->next);
    }
    if (carry == 1){
        (*write) = malloc(sizeof(struct ListNode));
        (**write) = (struct ListNode){carry, NULL}; 
    }
    return result;
}
