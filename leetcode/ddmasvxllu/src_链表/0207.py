# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        '''
        常规解法
        '''
        lengthA = self.getLength(headA)
        lengthB = self.getLength(headB)

        # make sure headA is longer than headB
        if lengthA < lengthB:
            lengthA, lengthB = lengthB, lengthA
            headA, headB = headB, headA
            # 就是交换了headA和headB，这样headA就是长的，headB就是短的
        return self.getInter(headA, lengthA, headB, lengthB)

    def getLength(self, head):
        length = 0
        cur = head
        while cur:
            cur = cur.next
            length += 1
        return length

    def getInter(self, headA, lenA, headB, lenB):
        delta = lenA - lenB
        curA = headA
        for i in range(delta):
            curA = curA.next
            # A先走
        curB = headB
        while curA:
            if curA == curB:
                return curA
            curA = curA.next
            curB = curB.next
        return None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        '''
        拼接解法
        '''
        curA = headA
        curB = headB
        while True:
            if curA == curB:
                return curA
            curA = curA.next if curA else headB
            curB = curB.next if curB else headA

    