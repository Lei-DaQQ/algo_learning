class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        '''
        简单做法，每次pop/peek都重新把stack1的内容全部放到stack2中，获取到需要的数据之后，再把stack2重新放回stack1中
        '''

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())
        res = self.stack2.pop()
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        return res

    def peek(self) -> int:
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())
        res = self.stack2[-1]
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        return res

    def empty(self) -> bool:
        return len(self.stack1) == 0


class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        '''
        进阶做法：初次要Pop/peek时，确实要把stack1 -> stack2中，然后 取出stack2的顶部元素就是需要的结果。此时 stack2 不用再 -> stack1了。
        因为下次需要 pop/peek时还是从 stack2取就可以了。如果下次是 push，则push到stack1.
        如果stack2空了，再把stack1->stack2
        '''

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        if len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        return len(self.stack1) + len(self.stack2) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


class MyQueue:
    '''
    代码随想录的解法
    '''

    def __init__(self):
        """
        in主要负责push，out主要负责pop
        """
        self.stack_in = []
        self.stack_out = []


    def push(self, x: int) -> None:
        """
        有新元素进来，就往in里面push
        """
        self.stack_in.append(x)


    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.empty():
            return None
        
        if self.stack_out:
            return self.stack_out.pop()
        else:
            for i in range(len(self.stack_in)):
                self.stack_out.append(self.stack_in.pop())
            return self.stack_out.pop()


    def peek(self) -> int:
        """
        Get the front element.
        """
        ans = self.pop()
        self.stack_out.append(ans)
        return ans


    def empty(self) -> bool:
        """
        只要in或者out有元素，说明队列不为空
        """
        return not (self.stack_in or self.stack_out)
