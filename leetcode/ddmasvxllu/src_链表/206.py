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
        return self.recu(head, None)

    def recu(self, cur, pre):

        if cur == None:
            return pre
        tail = self.recu(cur.next, cur)
        cur.next = pre
        return tail


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
