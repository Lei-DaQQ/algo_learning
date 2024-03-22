
### 二分查找

#### 704.二分查找
https://programmercarl.com/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.html
https://leetcode.cn/problems/binary-search/description/

**有序、不重复**的数组，找到目标值的下标。如果没有找到，返回 -1。

注意区间开闭的两种写法，左闭右开和左闭右闭。
注意 mid 的取值可以是 `mid = left + (right - left) // 2` 或者 `mid = (left + right) // 2`。
前者是为了避免数据溢出（PS：python应该不需要手动解决这个问题）。



#### 35.搜索插入位置
https://programmercarl.com/0035.%E6%90%9C%E7%B4%A2%E6%8F%92%E5%85%A5%E4%BD%8D%E7%BD%AE.html
https://leetcode.cn/problems/search-insert-position/description/
是找到目标值的下标，如果没有找到，返回target应该放入的下标。




#### 😊34.在排序数组中查找元素的第一个和最后一个位置
https://programmercarl.com/0034.%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%92%8C%E6%9C%80%E5%90%8E%E4%B8%80%E4%B8%AA%E4%BD%8D%E7%BD%AE.html
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

有点类似STL 的 lower_bound 和 upper_bound。
是*有序、可重复数组*中查找元素的第一个和最后一个位置。如果没有找到，返回 [-1, -1]。

这个转化为找小数的answer挺有意思
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/comments/2252825
如果要找8，就找7.5和8.5。。。找7.5的时候 最后left停在7.5右边，right停在7.5左边，然后看left是不是8，是就pushback，不是就不存在8 然后还有些越界情况处理一下


https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4
这是官方给的题解，
不过这个更容易理解：
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/comments/1989894

大家不要太纠结，搞两次正常的二分查找就好了，不要想什么大于等于，什么大于，就是等于，就找等于的
```cpp
 
 // 两次二分查找，分开查找第一个和最后一个
  // 时间复杂度 O(log n), 空间复杂度 O(1)
  // [1,2,3,3,3,3,4,5,9]
  public int[] searchRange2(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int first = -1;
    int last = -1;
    // 找第一个等于target的位置
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        first = middle;
        right = middle - 1; //重点
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    // 最后一个等于target的位置
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] == target) {
        last = middle;
        left = middle + 1; //重点
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return new int[]{first, last};
  }
```

#### 69.x 的平方根
https://leetcode.cn/problems/sqrtx/description/

copilot 有点厉害，把题目的框架贴上，直接就把答案写出来了🤣

这道题注意要把小数部分去除，所以要判断一下 mid_square 和 (mid+1)_square

#### 367.有效的完全平方数
https://leetcode.cn/problems/valid-perfect-square/description/

### 移除元素
#### 27.移除元素
https://programmercarl.com/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.html
https://leetcode-cn.com/problems/remove-element/description/
copilot真神了，直接把题目编号给出来了，连链接都能写出来。。。

稍微简单的思路O(n^2)
O(n)的解法是双指针，一个指向当前位置，一个指向最后一个位置，如果当前位置的值等于目标值，就把当前位置的值换成最后一个位置的值，然后最后一个位置减一。
或者快慢双指针

#### 26.删除有序数组中的重复项
https://programmercarl.com/0026.%E5%88%A0%E9%99%A4%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%87%8D%E5%A4%8D%E9%A1%B9.html
https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/

slow 和 fast 代表的含义理解清楚
```python
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow = 1
        fast = 1
        # fast 指向 和nums[slow-1]不同的元素，放在 slow 处
        nums_len = len(nums)
        while fast < nums_len:
            if nums[fast] != nums[slow-1]:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow # slow 是要放新的元素的位置，也是数组的新长度
```

---

回答的一个讨论区的问题，可以理解题目中说的 原地替换？ 或者说是函数中的引用值不要更改。

你的代码：
```python
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        print id(nums)
        nums = list(set(nums))
        print id(nums)
        return len(nums) 

```
输出：
```
139804139985728
139804139697408
```
我的理解：
```
GPT回答：在 Python 中，当使用 list(set(nums)) 这样的语法创建一个新的列表时，会生成一个新的列表对象，并将其赋值给 nums 变量。这意味着 nums 的地址将会发生变化，指向新创建的列表对象。

leetcode是提交核心代码，所以在代码里把 nums的地址更改了，但是最后检查的时候应该是输出原来nums的地址里的数据，这个点比较有意思。
不过这种写法对于这道题好像没什么意思。
```
这样可以，只是替换 nums 里的数据，nums的地址没改变，没新建新的列表：
```python
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nums[0:-1] = list(set(nums))[0:-1]
        return len(nums) 
```
---

#### 283.移动零
https://leetcode-cn.com/problems/move-zeroes/description/
快慢双指针，快指针找非零元素，慢指针放非零元素

#### 😊🤞844.比较含退格的字符串
https://leetcode-cn.com/problems/backspace-string-compare/description/

python 字符串能这么修改吗： str[1] = str[10]

不可以直接修改字符串中的某个字符，因为字符串是不可变的数据类型。如果想要修改字符串中的某个字符，可以先将字符串转换成列表，修改列表中的元素，然后再将列表转换回字符串。例如：

```python
str = "Hello, world!"
lst = list(str)
lst[1] = lst[10]
str = ''.join(lst)
print(str)
```

输出结果为：

```
Hdlo, world!
```

反向，双指针
```python

class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #  倒序 双指针
        s_right = len(s) - 1
        t_right = len(t) - 1

        s_del = 0
        t_del = 0
        while True:

            while s_right >= 0:
                if s[s_right] == '#':
                    s_del += 1
                elif s_del > 0:
                    s_del -= 1
                else:
                    break
                s_right -= 1
            while t_right >= 0:
                if t[t_right] == '#':
                    t_del += 1
                elif t_del > 0:
                    t_del -= 1
                else:
                    break
                t_right -= 1
            # 两个都 < 0，则True，只有一个 < 0，则False
            if s_right < 0 and t_right < 0:
                return True
            if s_right < 0 or t_right < 0:
                return False
            if s[s_right] != t[t_right]:
                return False
            s_right -= 1
            t_right -= 1
```

#### 977.有序数组的平方
https://leetcode.cn/problems/squares-of-a-sorted-array/description/

不知道有没有空间复杂度 O(1)的做法，不开新的数组



### 长度最小的子数组
#### 😊209.长度最小的子数组
https://programmercarl.com/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.html

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.md

https://leetcode.cn/problems/minimum-size-subarray-sum/description/

滑动窗口

前缀和版
```python
class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        # 前缀和版滑动窗口
        prefix = [0]
        for i in range(len(nums)):
            prefix.append(prefix[-1] + nums[i])

        min_len = float('inf')
        for i in range(len(prefix)):
            if prefix[i] >= target:
                min_len = i
                break
        if min_len == float('inf'):
            return 0

        # 逐步减小 min_len
        i = 1
        # nums有多少元素， prefix 下标就可以取到该数
        while i + min_len - 1 < len(prefix):
            # 看减小 min_len 是否可行
            while prefix[i+min_len-1] - prefix[i] >= target:
                min_len -= 1
            i += 1
        return min_len


print(Solution().minSubArrayLen(7, [2, 3, 1, 2, 4, 3]))
```


#### 904.水果成篮
https://leetcode.cn/problems/fruit-into-baskets/description/
滑动窗口

```python
m_dict = Counter()
# 这个比较有意思
```

#### 76.最小覆盖子串

https://leetcode-cn.com/problems/minimum-window-substring/description/
