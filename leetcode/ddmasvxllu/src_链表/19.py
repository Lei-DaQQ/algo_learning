# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head, n: int):
        '''
        stupid solution
        '''
        cur = head
        node_list = []
        while cur:
            node_list.append(cur)
            cur = cur.next
        if n == len(node_list):
            return head.next
        else:
            node_list[-n-1].next = node_list[-n].next
        return head


class Solution:
    def removeNthFromEnd(self, head, n: int):
        '''
        double pointer
        要找到倒数第n个的前一个
        '''
        dummy_head = ListNode(0, head)

        cur = dummy_head
        end = dummy_head

        # for i in range(n):
        #     end = end.next
        # while end.next:
        #     cur = cur.next
        #     end = end.next

        for i in range(n+1):
            end = end.next
        while end:
            cur = cur.next
            end = end.next
            
        cur.next = cur.next.next
        return dummy_head.next
