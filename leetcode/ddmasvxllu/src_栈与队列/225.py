class MyStack:

    def __init__(self):
        self.queue1 = []
        self.queue2 = []
        

    def push(self, x: int) -> None:
        self.queue1.append(x)


    def pop(self) -> int:
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.pop(0))
            # 这里可以 for i in range，但是为了原汁原味的队列，就pop(0)
        self.queue2, self.queue1 = self.queue1, self.queue2
        return self.queue2.pop()


    def top(self) -> int:
        res = self.pop()
        self.queue1.append(res)
        return res


    def empty(self) -> bool:
        return len(self.queue1) == 0





from collections import deque
class MyStack:

    def __init__(self):
        self.queue = deque()
        

    def push(self, x: int) -> None:
        self.queue.append(x)


    def pop(self) -> int:
        length = len(self.queue)
        for i in range(length-1):
            self.queue.append(self.queue.popleft())
        return self.queue.popleft()


    def top(self) -> int:
        res = self.pop()
        self.queue.append(res)
        return res


    def empty(self) -> bool:
        return len(self.queue) == 0




# Your MyStack object will be instantiated and called as such:
obj = MyStack()
obj.push(1)
obj.push(2)
param_3 = obj.top()
param_2 = obj.pop()
param_4 = obj.empty()