# Definition for singly-linked list.
class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next


class Solution:
    def detectCycle(self, head):
        '''
        '''
        added_num = 10**5 * 2 + 5
        max_num = 10**5
        cur = head
        loop_begin = None
        while cur:
            if cur.val >= max_num:
                loop_begin = cur

                while True:
                    cur.val -= added_num
                    cur = cur.next
                    if cur == loop_begin:
                        break

                break
            cur.val += added_num
            cur = cur.next
        cur = head
        while cur != loop_begin:
            cur.val -= added_num
            cur = cur.next
        return loop_begin


head = ListNode(3, ListNode(2, ListNode(0, ListNode(-4, None))))
Solution().detectCycle(head)
