# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# class Solution:
#     def swapPairs(self, head):
#         pre = head
#         if head:
#             new_h = head.next if head.next else pre
#         else:
#             return None

#         former_pre = self.exchange(pre.next, pre).next
#         pre = pre.next
#         while pre:
#             cur = pre.next
#             former_pre.next = self.exchange(cur, pre)
#             former_pre, pre = pre, pre.next

#         return new_h

#     def exchange(self, cur, pre):
#         if cur == None:
#             return None
#         print(cur.val, pre.val)
#         pre.next = cur.next # error, 之后的邻居也会交换
#         cur.next = pre
#         return cur

class Solution:
    def swapPairs(self, head):
        pre = head
        if head:
            new_h = head.next if head.next else pre
        else:
            return None

        while pre:
            cur = pre.next
            self.exchange(cur, pre)
            next_pre = pre.next
            if next_pre and next_pre.next:
                pre.next = next_pre.next
            pre = next_pre

        return new_h

    def exchange(self, cur, pre):
        if cur == None:
            return None
        print(cur.val, pre.val)
        pre.next = cur.next # error, 之后的邻居也会交换
        cur.next = pre


# 1->2->3->4
lst = ListNode(1, ListNode(2, ListNode(3, ListNode(4, None))))
Solution().swapPairs(lst)


# def test():
#     a = [1, 2, 3]
#     b = [4, 5, 6]

#     def change(a, b):
#         a[0] = 100
#         t = a
#         a = b
#         b = t
#     change(a, b)
#     print(a, b)
#     # [100, 2, 3] [4, 5, 6]，顺序没变
# test()
