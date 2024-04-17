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
#### ⭐⭐28. 实现 strStr()
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md

https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


KMP算法重出江湖了属于。