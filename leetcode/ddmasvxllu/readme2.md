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
#### 替换数字
https://programmercarl.com/kama54.%E6%9B%BF%E6%8D%A2%E6%95%B0%E5%AD%97.html

非leetcode题目，且比较简单，所以没做。

### 4
#### 151. 翻转字符串里的单词
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0151.%E7%BF%BB%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%87%8C%E7%9A%84%E5%8D%95%E8%AF%8D.md

https://leetcode.cn/problems/reverse-words-in-a-string/

