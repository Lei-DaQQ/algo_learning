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

## 哈希表
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