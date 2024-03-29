# Definition for singly-linked list.
class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def detectCycle(self, head):
        '''
        取巧的做法
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


class Solution:
    def detectCycle(self, head):
        '''
        双指针做法，这种做法是在head就算出发了，即开始计算步数了
        '''

        slow, fast = head, head.next if head else None
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        if (not fast) or fast != slow:
            return None
        # 有环
        slow = head
        fast = fast.next
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow

class Solution:
    def detectCycle(self, head):
        '''
        双指针做法，这种做法是在head不算步数，要能解决slow 和fast都没出发的情况
        '''

        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                # 有环
                slow = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        return None
        

ln3 = ListNode(3)
ln2 = ListNode(2)
ln0 = ListNode(0)
ln4 = ListNode(-4)
ln3.next = ln2
ln2.next = ln0
ln0.next = ln4
ln4.next = ln2
head = ln3

Solution().detectCycle([])
