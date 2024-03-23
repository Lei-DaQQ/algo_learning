# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(saelf, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy_h = ListNode(next=head)
        cur = dummy_h
        while cur.next:
            if cur.next.val == val:
                cur.next = cur.next.next
            cur = cur.next
            '''
                这里不对，应该是 else cur = cur.next
                判断的永远是 cur.next 节点的值，所以 if 里是修改了 cur的 后续节点，这个后续节点还为判断，仍要通过 cur.next 进行判断，所以 cur 不可更改
            '''
        return dummy_h.next



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        # 创建虚拟头部节点以简化删除过程
        dummy_head = ListNode(next = head)
        
        # 遍历列表并删除值为val的节点
        current = dummy_head
        while current.next:
            if current.next.val == val:
                current.next = current.next.next
            else:
                current = current.next
        
        return dummy_head.next
