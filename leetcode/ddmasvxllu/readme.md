https://github.com/youngyangyang04/leetcode-master

## 数组
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

字典版滑动窗口


### 螺旋矩阵
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0059.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5II.md
#### 59.螺旋矩阵II
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0059.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5II.md
https://leetcode.cn/problems/spiral-matrix-ii/description/

从左向右，从上向下，从右向左，从下向上，循环遍历，每次遍历完一个方向，就把这个方向的边界缩小一格。


#### 54.螺旋矩阵
https://leetcode-cn.com/problems/spiral-matrix/description/

和 59 一样， 没写这道题



#### LCR 146. 螺旋遍历二维数组
https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
和54一模一样了，不写了吧

### 数组总结
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E6%95%B0%E7%BB%84%E6%80%BB%E7%BB%93%E7%AF%87.md


## 链表
https://programmercarl.com/%E9%93%BE%E8%A1%A8%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html#%E9%93%BE%E8%A1%A8%E7%9A%84%E7%B1%BB%E5%9E%8B
[text](https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%93%BE%E8%A1%A8%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md?tab=readme-ov-file)


#### 😊203.移除链表元素
[链表：203.移除链表元素](./problems/0203.移除链表元素.md)
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0203.%E7%A7%BB%E9%99%A4%E9%93%BE%E8%A1%A8%E5%85%83%E7%B4%A0.md
https://leetcode.cn/problems/remove-linked-list-elements/

这个还是有意思的，因为总是会忘记 cur cur.next 的判断关系
```python
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
```

```python
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
```

#### 707.设计链表
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0707.%E8%AE%BE%E8%AE%A1%E9%93%BE%E8%A1%A8.md
https://leetcode.cn/problems/design-linked-list/

😊更有意思了，如果用了 dummy_head，那就cur = dummy_head， 然后永远 cur.next 是目的节点

#### 206.反转链表
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.md
https://leetcode.cn/problems/reverse-linked-list/

#### ⭐24.两两交换链表中的节点
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0024.%E4%B8%A4%E4%B8%A4%E4%BA%A4%E6%8D%A2%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.md
https://leetcode.cn/problems/swap-nodes-in-pairs/

我说挺有意思，比较繁琐，容易出错，倒不是难。
然后如果有一个dummy_head，会容易一些，cur 目前处在dummy_head的位置，接下来要交换之后的两个节点，然后 cur.next = 交换后的第一个节点，然后 cur = 交换后的第二个节点，继续这个过程，cur所处的位置仍然可以当作虚节点，继续交换之后的两个节点。
如果之后是一个节点，则不用交换。


#### 😀19.删除链表的倒数第 N 个结点
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0019.%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E7%9A%84%E5%80%92%E6%95%B0%E7%AC%ACN%E4%B8%AA%E8%8A%82%E7%82%B9.md

https://leetcode.cn/problems/remove-nth-node-from-end-of-list/


双指针解决，一个指针先走 n 步，然后两个指针一起走，当先走的指针走到头的时候，后走的指针就是倒数第 n 个节点的前一个节点。
```python
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
```

**用一个哑节点，还是很方便的。**


#### 😀⭐⭐面试题02.07.链表相交
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.md

https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/description/

取巧做法：
https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/comments/2139357
一个投机取巧的办法:把A全打负，再从B开始遍历看找到的第一个负数就是交点，最后把A变回来

（这里因为是指针判等，所以改了A中的值，B中的值也会改变）

---

比较常规的做法是让较长的链表先走，当它剩余的节点和短链表一样时，两个链表一起走，如果有相交的节点，那么两个指针就会相等，如果没有相交的节点，那么两个指针就会同时为 None。

---

另一种做法是，
将两个链表拼接起来，然后遍历，如果有相交的节点，那么遍历到最后，两个指针就会相等，如果没有相交的节点，那么遍历到最后，两个指针就会同时为 None，题解：

---

Per:关窍应该还是将公共部分对齐，像第一种做法，让长的链表先走一些步数，如此两个链表的结尾就对齐了，也就是公共部分对齐了：
```md
a先走，剩下和b一样长即可一起走
[aaaaaaaaa]
      [bbb]
```

然后拼接的做法，也是，如下，两个链表的结尾一定是对齐的，也就是公共部分一定是对齐的：
```md
[aaaaaaaaa][bbb]
[bbb][aaaaaaaaa]
```

https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/solutions/1190240/mian-shi-ti-0207-lian-biao-xiang-jiao-sh-b8hn


#### ⭐⭐⭐⭐142.环形链表II
[github 题解](https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.md)
[142 leetcode](https://leetcode.cn/problems/linked-list-cycle-ii/description/)



取巧做法：
https://leetcode.cn/problems/linked-list-cycle-ii/description/comments/37475
o(n)算法，应该是最快的。 堆的地址从低到高，LeetCode的链表内存是顺序申请的，如果有环，head->next一定小于或等于head，哈哈哈哈哈
```cpp
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        while(head) {
            if(!less<ListNode *>()(head, head->next)) {
                return head->next;
            }
            head = head->next;
        }
        return nullptr;
    }
};
```

另一种取巧的做法，每个节点先增加一个 10^5 * 2 + 5 的值，如果有环，那么环的起点一定是大于 10^5 的，这样就可以找到环的起点了。
然后再把所有节点减去 10^5 * 2 + 5，还原链表。
```python
class Solution:
    def detectCycle(self, head):
        '''
        '''
        added_num = 10**5 * 2 + 5
        max_num = 10**5
        cur = head
        loop_begin = None
        while cur:
            if cur.val >= max_num:
                loop_begin = cur

                while True:
                    cur.val -= added_num
                    cur = cur.next
                    if cur == loop_begin:
                        break

                break
            cur.val += added_num
            cur = cur.next
        cur = head
        while cur != loop_begin:
            cur.val -= added_num
            cur = cur.next
        return loop_begin
```

正常做法：
还是挺有意思的


```python


class Solution:
    def detectCycle(self, head):
        '''
        双指针做法，这种做法是在head就算出发了，即开始计算步数了
        '''

        slow, fast = head, head.next if head else None
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        if (not fast) or fast != slow:
            return None
        # 有环
        slow = head
        fast = fast.next
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow

```

## 🤓哈希表
### 2
#### 242.有效的字母异位词
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0242.%E6%9C%89%E6%95%88%E7%9A%84%E5%AD%97%E6%AF%8D%E5%BC%82%E4%BD%8D%E8%AF%8D.md#%E7%9B%B8%E5%85%B3%E9%A2%98%E7%9B%AE

https://leetcode.cn/problems/valid-anagram/description/



#### 383.赎金信
https://programmercarl.com/0383.%E8%B5%8E%E9%87%91%E4%BF%A1.html
https://leetcode.cn/problems/ransom-note/

在 `collections` 模块的 `Counter` 类中，有两种方法可以计算两个 `Counter` 对象之间的差异：减号 `-` 运算符和 `subtract` 方法。

1. 减号 `-` 运算符：
   通过使用减号运算符，可以计算一个 `Counter` 对象减去另一个 `Counter` 对象后的差异。它返回一个新的 `Counter` 对象，其中包含了两个 `Counter` 对象中元素的差异。如果某个元素在第一个 `Counter` 对象中的计数大于等于第二个 `Counter` 对象中的计数，那么在结果中该元素的计数为两者之差；否则，在结果中该元素不会出现。
   
   例如：
   ```python
   counter1 = Counter({'a': 3, 'b': 2, 'c': 1})
   counter2 = Counter({'a': 2, 'b': 1, 'd': 1})
   diff = counter1 - counter2
   print(diff)
   ```
   输出结果为：`Counter({'a': 1, 'b': 1, 'c': 1})`

2. `subtract` 方法：
   `subtract` 方法也可以用于计算两个 `Counter` 对象的差异。它在原地修改第一个 `Counter` 对象，将其更新为减去第二个 `Counter` 对象后的结果。与减号 `-` 运算符不同，`subtract` 方法会保留所有的元素，即使某个元素在第一个 `Counter` 对象中的计数小于第二个 `Counter` 对象中的计数，它的计数也会变成负数。
   
   例如：
   ```python
   counter1 = Counter({'a': 3, 'b': 2, 'c': 1})
   counter2 = Counter({'a': 2, 'b': 1, 'd': 1})
   counter1.subtract(counter2)
   print(counter1)
   ```
   输出结果为：`Counter({'a': 1, 'b': 1, 'c': 1, 'd': -1})`

因此，减号 `-` 运算符返回一个新的 `Counter` 对象，其中只包含计数大于零的元素，而 `subtract` 方法则原地修改第一个 `Counter` 对象，保留所有元素，并将计数变为负数（如果有必要）。


#### 😀49. 字母异位词分组
https://leetcode.cn/problems/group-anagrams/description/

还是有点意思的，因为一些python的语法不太清楚。

前言
两个字符串互为字母异位词，当且仅当两个字符串包含的字母相同。同一组字母异位词中的字符串具备相同点，可以使用相同点作为一组字母异位词的标志，使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。

遍历每个字符串，对于每个字符串，得到该字符串所在的一组字母异位词的标志，将当前字符串加入该组字母异位词的列表中。遍历全部字符串之后，哈希表中的每个键值对即为一组字母异位词。

以下的两种方法分别使用排序和计数作为哈希表的键。

方法一：排序
由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键

作者：力扣官方题解
链接：https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```PYTHON
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = collections.defaultdict(list)

        for st in strs:
            key = "".join(sorted(st))
            mp[key].append(st)
        
        return list(mp.values())
```
作者：力扣官方题解
链接：https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

#### 😀438.找到字符串中所有字母异位词
https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
滑动窗口

自己写的比较慢的code：
```python

class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        from typing import Counter
        len_s = len(s)
        len_p = len(p)
        counter_p = Counter(p)
        start, end = 0, len_p-1
        counter_sub = Counter(s[start:end])
        res = []
        for start in range(0, len_s - len_p+1):
            counter_sub[s[end]] += 1
            if counter_p == counter_sub:
                res.append(start)
            counter_sub[s[start]] -= 1
            if counter_sub[s[start]] == 0:
                del counter_sub[s[start]]
            end += 1
        return res
```

官方的code：
https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/19988/pythonshi-xian-da-lao-hua-dong-chuang-kou-si-xiang

```python
class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        from typing import Counter
        len_s = len(s)
        counter_p = Counter(p)
        counter_sub = {}
        res = []
        left, right = 0, 0
        while right < len_s:
            if s[right] not in p:
                counter_sub.clear()
                left = right = right + 1
            else:
                counter_sub[s[right]] = counter_sub.get(s[right], 0) + 1
                if right - left + 1 == len(p):
                    if counter_p == counter_sub:
                        res.append(left)
                    counter_sub[s[left]] -= 1
                    left += 1
                right += 1
        return res
```

### 3
#### 1002.查找常用字符
<a href='https://github.com/youngyangyang04/leetcode-master/blob/master/problems/1002.%E6%9F%A5%E6%89%BE%E5%B8%B8%E7%94%A8%E5%AD%97%E7%AC%A6.md'>leetcode-master/problems/1002.查找常用字符.md at master · youngyangyang04/leetcode-master</a>
https://leetcode-cn.com/problems/find-common-characters/description/


```md
在Python中，`collections` 模块的 `Counter` 类是一个非常有用的工具，用于统计可哈希对象（如列表中的元素）的出现次数。如果你想要根据 `Counter` 对象的结果将其转换为列表，这主要取决于你想要列表中包含什么。以下是几种基于 `Counter` 结果转换为列表的常见方式：

1. **仅元素列表**：如果你只想要出现过的元素，可以直接从 `Counter` 对象的键中获取。

2. **元素重复列表**：如果你想要一个列表，其中每个元素根据其出现次数重复，可以使用列表推导式。

3. **元素和计数对列表**：如果你想要一个包含元素及其出现次数的元组列表，可以直接使用 `Counter` 对象的 `.items()` 方法。

下面是这三种方法的示例代码：


from collections import Counter

# 示例数据
data = ['apple', 'banana', 'apple', 'orange', 'banana', 'apple']

# 使用Counter统计元素出现次数
counter = Counter(data)

# 1. 仅元素列表
elements_list = list(counter.keys())
print("仅元素列表:", elements_list)

# 2. 元素重复列表
repeated_elements_list = [item for item, count in counter.items() for _ in range(count)]
print("元素重复列表:", repeated_elements_list)

# 3. 元素和计数对列表
items_count_list = list(counter.items())
print("元素和计数对列表:", items_count_list)


输出将类似于：


仅元素列表: ['apple', 'banana', 'orange']
元素重复列表: ['apple', 'apple', 'apple', 'banana', 'banana', 'orange']
元素和计数对列表: [('apple', 3), ('banana', 2), ('orange', 1)]


这三种方法分别适用于不同的场景，你可以根据自己的需求选择使用。
```


```md
你的代码尝试通过列表推导式来创建一个列表，其中元素根据它们在 `Counter` 对象中的计数重复出现。问题在于表达式 `item * counter` 并不会按你所期望的方式工作，因为这里 `item * counter` 尝试将一个字符串（假设 `item` 是字符串）与一个整数（`counter`，表示计数）相乘。字符串与整数的乘法会导致字符串重复，而不是按照你想要的方式创建多个独立的元素。

正确的方式是在内部列表推导式中重复每个元素 `count` 次，其中 `count` 是该元素出现的次数。这里是如何正确做到这一点的：


from collections import Counter

# 假设 insert_cnt 是你的 Counter 对象
insert_cnt = Counter(['apple', 'banana', 'apple', 'orange', 'banana', 'apple'])

# 正确的方法
lst = [item for item, count in insert_cnt.items() for _ in range(count)]

print(lst)

这段代码首先遍历 `insert_cnt.items()`，这会给你每个元素及其计数。然后，对于每个 `(item, count)` 对，它使用 `for _ in range(count)` 来重复 `item` `count` 次。这正是你想要达到的效果：如果一个元素在 `Counter` 中出现了几次，它就会在列表中出现几次。

注意，我在内部循环中使用了 `_` 作为循环变量，因为我们实际上不需要在循环体内使用这个变量的值；它仅仅是用来重复次数的。
```

python中的交集运算符 `&` 用于计算两个集合的交集。对于两个 `Counter` 对象，`&` 运算符返回一个新的 `Counter` 对象，其中包含两个 `Counter` 对象中共同的元素及其最小的计数。这意味着，如果一个元素在两个 `Counter` 对象中的计数分别为 `count1` 和 `count2`，那么在结果中该元素的计数为 `min(count1, count2)`。

### 4
#### 340. 两个数组的交集
<a href='https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0349.%E4%B8%A4%E4%B8%AA%E6%95%B0%E7%BB%84%E7%9A%84%E4%BA%A4%E9%9B%86.md'>leetcode-master/problems/0349.两个数组的交集.md at master · youngyangyang04/leetcode-master</a>

https://leetcode.cn/problems/intersection-of-two-arrays/description/

#### 350. 两个数组的交集 II
https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/

### 5
#### 202.快乐数
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0202.%E5%BF%AB%E4%B9%90%E6%95%B0.md

https://leetcode.cn/problems/happy-number/description/





```md

return sum(map(lambda x: int(x) ** 2, str(n)))

您提供的这行代码是另一个非常简洁且高效的方法来计算一个整数 `n` 中每个数字的平方和，而且它同样避免了显式的循环结构。这次，您使用了 `lambda` 函数配合 `map` 函数来实现这一目标。让我们逐步解析这段代码：

return sum(map(lambda x: int(x) ** 2, str(n)))

1. **`str(n)`**: 首先，整数 `n` 被转换成字符串。这样做是为了能够迭代 `n` 的每个数字。例如，如果 `n` 是 123，`str(n)` 的结果是字符串 `"123"`。

2. **`lambda x: int(x) ** 2`**: 这是一个匿名函数（也称为 lambda 函数），它接受一个参数 `x`，将 `x` 转换为整数，并计算它的平方。这个 lambda 函数将应用于 `str(n)` 生成的字符串的每个字符上。

3. **`map(lambda x: int(x) ** 2, str(n))`**: `map` 函数将上述的 lambda 函数应用于 `str(n)` 的每个字符上。由于 `str(n)` 是一个字符串，它的每个元素（即每个字符）都会被转换成整数并计算平方。因此，这个 `map` 调用返回一个迭代器，迭代器中的元素是 `n` 的每个数字的平方。

4. **`sum(map(lambda x: int(x) ** 2, str(n)))`**: 最后，使用 `sum` 函数来计算上一步 `map` 函数返回的迭代器中所有元素的总和。这个总和就是整数 `n` 中每个数字的平方和。

总结来说，这行代码通过将整数转换为字符串，然后使用 `map` 函数和一个 lambda 函数来计算每个数字的平方，并最终使用 `sum` 函数来计算这些平方的总和，从而实现了计算一个整数中每个数字的平方和的目标，而且这一切都在一行代码中完成。

这个行为来自于 `map` 函数的工作原理，结合了 `str(n)` 的结果。让我们再次审视这个过程，特别是 `map` 函数如何应用于 `str(n)` 的结果上，以及为什么会导致每个字符都被调用一次。

### 步骤解析

1. **转换为字符串**：`str(n)` 将整数 `n` 转换成字符串。这是因为字符串可以被视为一个字符序列，即一个字符的列表。例如，如果 `n = 123`，`str(n)` 的结果是 `"123"`。

2. **字符串的迭代性**：字符串在 Python 中是可迭代的，意味着你可以像遍历列表或元组那样遍历字符串的每个元素（在这个情况下，每个元素是一个字符）。

3. **`map` 函数的应用**：当你将 `map` 函数应用于 `str(n)`，你实际上是在对 `str(n)` 生成的字符串的每个字符进行操作。`map` 函数按顺序取出字符串中的每个字符，并将指定的函数（在这个例子中是 `lambda x: int(x) ** 2`）应用于这些字符。

### 为什么每个字符都会被调用一次？

- 这是因为 `map` 函数设计用来对可迭代对象的每个元素执行给定的函数。在这个例子中，可迭代对象是通过 `str(n)` 得到的字符串，其每个元素是单独的字符。
- 当 `map` 函数执行时，它内部实现了一个迭代过程，遍历 `str(n)` 的每个字符，并对这些字符逐一应用 `lambda x: int(x) ** 2` 函数。这意味着 `lambda` 函数会被调用多次，具体调用次数等于 `n` 转换成字符串后的长度。

### 结论

因此，结论是每个字符都被调用一次来自于 `map` 函数和字符串的迭代性质。`map` 函数确保了对 `str(n)` 中的每个字符执行了一次转换和平方操作，这正是为什么每个字符都会被单独处理的原因。
```

### 6
#### 1.两数之和

```python
from collections import Counter


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

        all = Counter(nums)

        for index, item in enumerate(nums):
            complement = target - item
            all[item] -= 1
            if all[complement] > 0:
                return [index, nums[index+1:].index(complement)+index+1]

```

```md
你的方法是解决LeetCode上“两数之和”问题的一种尝试，这里我将详细解释你的代码及其逻辑。

首先，问题的描述是这样的：给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。

你的解决方案采用了如下步骤：

1. **使用`Counter`统计每个元素出现的次数**：
   - `all = Counter(nums)` 利用`Counter`从`collections`模块创建一个计数器`all`，它会为`nums`列表中的每个元素计算出现的次数。

2. **遍历`nums`列表**：
   - 通过`for index, item in enumerate(nums):`遍历列表，同时获取每个元素的值`item`和它的索引`index`。

3. **计算补数并检查**：
   - 计算当前元素`item`的补数`complement`，即`target - item`。这个补数是我们需要在数组的其余部分找到的数，以使得`item + complement = target`。

4. **更新当前元素的计数**：
   - 通过`all[item] -= 1`减少当前元素的计数。这一步是为了处理元素可能重复的情况，比如当`nums`中有两个相同的数且它们的和等于`target`时，我们需要确保在找补数时不会重复使用同一个元素。

5. **检查补数是否存在**：
   - 通过`if all[complement] > 0:`检查补数是否存在于数组中（即，补数的计数是否大于0）。如果存在，说明我们找到了一对数，它们的和为`target`。

6. **返回结果**：
   - 如果找到了这样的一对数，返回它们的索引。第一个数的索引是`index`，第二个数的索引通过`nums[index+1:].index(complement)+index+1`计算得到。这里，`nums[index+1:].index(complement)`是在当前元素之后的子数组中寻找补数的索引，然后加上`index+1`来调整为在原始数组`nums`中的正确索引。

这种方法的关键在于利用`Counter`来快速检查补数是否存在，并且通过调整计数来避免重复使用同一个元素。这是一种有效的解决方案，尤其是当数组中有重复元素时。不过，需要注意的是，由于`index(complement)`的调用，这个方法的时间复杂度略高，因为每次找到补数时都要在子数组中进行一次线性搜索。一个更高效的方法可能是直接使用一个哈希表（或Python中的字典）来一边遍历数组一边记录已经访问过的元素及其索引，这样可以在常数时间内检查补数是否存在。
```

其他解法：

### 7
#### 454.四数相加 II
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0454.%E5%9B%9B%E6%95%B0%E7%9B%B8%E5%8A%A0II.md

https://leetcode.cn/problems/4sum-ii/description/

### 8
#### 383.赎金信

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0383.%E8%B5%8E%E9%87%91%E4%BF%A1.md

https://leetcode.cn/problems/ransom-note/

### 9
#### 🤓🤓15.三数之和
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.md

https://leetcode.cn/problems/3sum/description/

还挺有意思。。。。。。

```python

class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        '''
        如果先将两数之和存入haspmap?
        '''
        '''
        如果先将两数之和存入haspmap，但是比较麻烦的就是index， 可能的解决方式是存储时：{key:sum, value:[index1, index2]}
        但是sum是可重复的

        如果先所有数排序？
        [- - - - 0 0 0 + + + +]
        '''

        ans = []
        length = len(nums)
        nums.sort()
        for index, num1 in enumerate(nums):
            if num1 > 0 or index + 2 == length:
                break
            if index > 0 and num1 == nums[index-1]:
                continue
            left, right = index + 1, length - 1
            while left < right:
                left_num, right_num = nums[left], nums[right]
                if num1 + left_num + right_num == 0:
                    ans.append([num1, left_num, right_num])
                    while left < right and nums[left] == left_num:
                        left += 1
                    while left < right and nums[right] == right_num:
                        right -= 1
                elif num1+left_num + right_num < 0:
                    left += 1
                else:
                    right -= 1
        return ans

            
            
        
        
Solution().threeSum([-1,0,1,2,-1,-4])
```


### 10
#### 😀18.四数之和

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0018.%E5%9B%9B%E6%95%B0%E4%B9%8B%E5%92%8C.md

https://leetcode.cn/problems/4sum/description/
