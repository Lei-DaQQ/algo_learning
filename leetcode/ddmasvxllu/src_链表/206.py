# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]):
        '''
        递归
        '''
        if head.next:
            new_head, new_tail  = self.reverseList(head.next)
            new_tail.next = head
            return new_head, head
        else:
            return head, head
        
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]):
        '''
        迭代
        None    []      []      []
        pre     cur     nn
        '''
        cur = head
        prev = None
        while cur:
            nn = cur.next
            cur.next = prev
            prev = cur
            cur = nn
        return prev