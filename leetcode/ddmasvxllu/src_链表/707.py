class MyLinkedList:

    def __init__(self):
        self.dummy_head = MyNode()
        self.length = 0
        pass

    def get(self, index: int) -> int:
        if index >= self.length or index < 0:
            return -1
        cur = self.dummy_head
        for i in range(index):
            cur = cur.next
        return cur.next.val

    def addAtHead(self, val: int) -> None:
        new_node = MyNode(val, self.dummy_head.next)
        self.dummy_head.next = new_node
        self.length += 1

    def addAtTail(self, val: int) -> None:
        cur = self.dummy_head
        while cur.next:
            cur = cur.next
        cur.next = MyNode(val, None)
        self.length += 1

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.length or index < 0:
            return
        cur = self.dummy_head
        for i in range(index):
            cur = cur.next
        # insert after cur, and change cur.next to new node
        cur.next = MyNode(val, cur.next)
        self.length += 1

    def deleteAtIndex(self, index: int) -> None:
        if index >= self.length or index < 0:
            return
        cur = self.dummy_head
        for i in range(index):
            cur = cur.next
        # delete cur.next
        cur.next = cur.next.next
        self.length -= 1


class MyNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
