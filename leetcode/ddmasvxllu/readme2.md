## 字符串
### 1
#### 344. 反转字符串
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0344.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.md
https://leetcode.cn/problems/reverse-string/description/


### 2
#### 541. 反转字符串 II
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0541.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2II.md
https://leetcode.cn/problems/reverse-string-ii/description/

要将一个列表转换为字符串，你可以使用`join()`方法。下面是如何将一个包含字符串的列表转换为一个字符串的示例：

```python
my_list = ['Hello', 'world', 'from', 'Python']
# 使用空格连接列表中的字符串
result_str = ' '.join(my_list)
print(result_str)
```

这将输出:
```
Hello world from Python
```

如果你想要将一个包含数字的列表转换为一个字符串，你需要先将数字转换为字符串，然后再使用`join()`方法：

```python
my_list = [1, 2, 3, 4, 5]
# 将数字转换为字符串，然后使用逗号连接
result_str = ', '.join(str(num) for num in my_list)
print(result_str)
```

这将输出:
```
1, 2, 3, 4, 5
```

这种方法允许你指定一个分隔符，用于连接列表中的元素。

### 3
#### ❓替换数字
https://programmercarl.com/kama54.%E6%9B%BF%E6%8D%A2%E6%95%B0%E5%AD%97.html

非leetcode题目，且比较简单，所以没做。

### 4
#### 😀151. 翻转字符串里的单词
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0151.%E7%BF%BB%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%87%8C%E7%9A%84%E5%8D%95%E8%AF%8D.md

https://leetcode.cn/problems/reverse-words-in-a-string/

如果不用 split()，还是有点麻烦的，不过挺有意思的。


```python
class Solution:
    def reverseWords(self, s: str) -> str:
        '''
        不要使用split，并且原地操作
        2steps：
        3.删去空格
        1：整个字符串反转
        2：每个单词反转


        '''
        str = list(s)
        length = self.moveSpace(str)
        self.reverseStr(str, 0, length-1)

        start = 0
        # 单词反转
        while start < length:
            end = start + 1
            while end < length and str[end] != ' ':
                end += 1
            self.reverseStr(str, start, end - 1)
            start = end + 1
        return "".join(str[0:length])

    def moveSpace(self, str: list):
        start = 0
        idx = 0
        length = len(str)
        while str[length-1] == ' ':
            length -= 1
        while idx < length:
            while idx < length and str[idx] == ' ':
                idx += 1
            # new word
            while idx < length and str[idx] != ' ':
                str[start] = str[idx]
                start += 1
                idx += 1
            if idx < length:
                str[start] = ' '
                start += 1  # a space
        return start  # new length

    def reverseStr(self, str: list, left, right):
        while left < right:
            str[left], str[right] = str[right], str[left]
            left += 1
            right -= 1
```

### 5
#### ❓右旋字符串
github没有这个网页

### 6
#### ⭐⭐⭐28. 实现 strStr()
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md

https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


KMP算法重出江湖了属于。

### 7
#### ⭐⭐⭐ 459. 重复的子字符串
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.md

https://leetcode.cn/problems/repeated-substring-pattern/description/

一个串如果是循环串，那么循环节的长度一定是原串长度的约数。
而且最长的相等前后缀，剩下的部分就是循环节。

## ❗双指针法
暂时跳过

## 栈与队列
### 1栈与队列理论基础
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E6%A0%88%E4%B8%8E%E9%98%9F%E5%88%97%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md


栈提供push 和 pop 等等接口，所有元素必须符合先进后出规则，所以栈不提供走访功能，也不提供迭代器(iterator)。 不像是set 或者map 提供迭代器iterator来遍历所有元素。


栈是以底层容器完成其所有的工作，对外提供统一的接口，底层容器是可插拔的（也就是说我们可以控制使用哪种容器来实现栈的功能）。

所以STL中栈往往不被归类为容器，而被归类为container adapter（容器适配器）。


可插拔（pluggable）指的是系统或组件设计中的一种特性，即允许在不修改核心代码的情况下，通过简单的添加、替换或配置来改变系统的行为或功能。在软件开发中，可插拔性通常通过接口（API）来实现，使得不同的模块可以以统一的方式与系统交互，从而提供了一种灵活、可扩展的设计方式。

```txt
在你提到的栈的例子中，可插拔意味着底层容器可以被替换为不同的实现，而不影响栈对外部提供的接口。这种设计允许栈的实现在不同的底层容器上运行，比如可以基于数组实现栈，也可以基于链表实现栈，甚至可以使用自定义的数据结构来实现栈，而不需要修改栈的使用代码。这样一来，栈的使用者就可以根据具体的需求选择最适合的底层容器，而不必担心与栈的接口不兼容的问题。
```


栈的内部结构，栈的底层实现可以是vector，deque，list 都是可以的， 主要就是数组和链表的底层实现。

### 2
#### 😀232. 用栈实现队列
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.md

https://leetcode.cn/problems/implement-queue-using-stacks/description/



进阶做法很有意思。
进阶做法：初次要Pop/peek时，确实要把stack1 -> stack2中，然后 取出stack2的顶部元素就是需要的结果。此时 stack2 不用再 -> stack1了。
因为下次需要 pop/peek时还是从 stack2取就可以了。如果下次是 push，则push到stack1.
如果stack2空了，再把stack1->stack2

```PYTHON

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
```


### 3
#### 😀 225. 用队列实现栈
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.md

https://leetcode.cn/problems/implement-stack-using-queues/description/


这里两个队列也不能改变元素的顺序，因为队列是先进先出的。
多一个队列就是为了完全备份栈的元素，将第一个队列的前面n-1个元素，放到第二个队列，然后取出第一个队列的最后一个元素，再把第二个队列的元素放回第一个队列。

### 4
#### 20. 有效的括号
使用栈来解决括号匹配问题。

### 5
#### 1047. 删除字符串中的所有相邻重复项

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/1047.%E5%88%A0%E9%99%A4%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B8%AD%E7%9A%84%E6%89%80%E6%9C%89%E7%9B%B8%E9%82%BB%E9%87%8D%E5%A4%8D%E9%A1%B9.md

https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/








