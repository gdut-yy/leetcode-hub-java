# leetcode-hub-java

基于 `jdk11` + `junit5` 的 leetcode 练习仓库。

（拼搏百天，我要完成 300 道 leetcode 题！额，不好意思，走错片场了。。。

`leetcode-n` 存放 `100 * (n - 1) + 1` ~ `100 * n` 的题目（如 `leetcode-19` 存放 `1801` ~ `1900` 的题目）。

```sh
# jdk11:
mvn clean test

# 如果系统 PATH 中使用的是 jdk8，需要指定 jdk11:
"C:\Program Files\Java\jdk-11\bin\java.exe" \
-Dmaven.multiModuleProjectDirectory=C:\Users\DEVYY\Documents\GitHub\LTS\leetcode-hub-java \
"-Dmaven.home=C:\Program Files\apache-maven-3.8.2" \
"-Dclassworlds.conf=C:\Program Files\apache-maven-3.8.2\bin\m2.conf" \
-Dfile.encoding=UTF-8 \
-classpath "C:\Program Files\apache-maven-3.8.2\boot\plexus-classworlds-2.6.0.jar" \
org.codehaus.classworlds.Launcher \
clean test
```

## UT、TDD

java 项目中常见的测试框架：

- [junit4](https://github.com/junit-team/junit4)
- [junit5](https://github.com/junit-team/junit5)
- [testng](https://github.com/cbeust/testng)
- [mockito](https://github.com/mockito/mockito)
- [powermock](https://github.com/powermock/powermock)
- [jmh](https://github.com/openjdk/jmh)

junit5 常用断言：

- Assertions.assertEquals
- Assertions.assertTrue
- Assertions.assertFalse
- Assertions.assertArrayEquals

思考：一些较为特殊的判题 UT 写法：

1. 部分题目使用了自定义对象，`Assertions.assertEquals` 已不能满足这种场景需要（或需重写自定义对象的 `equals` 与 `hashCode` 方法），可以使用自定义断言对这类对象进行判定：
   - `ListNode` 可参考 `ListNode#assertListNodeEquals(ListNode expected, ListNode actual)` 第 19、21、23、83、141、142、876 题等；
   - `TreeNode` 可参考 `TreeNode#assertTreeNodeEquals(TreeNode expected, TreeNode actual)` 第 114、226 题等；
2. 部分题目符合题意的答案并不止一个，可以构造一个 `List<T> expectedList` 去判断是否 `contains()` 如第 5 题等；
3. 部分题目符合题意的答案是一个集合，但对集合元素的顺序没有要求，可以对 `expected` 和 `actual` 集合进行排序后判等，如第 46、51 题等；

## 常用算法模板

### 前缀和数组

```
nums   3 5 2 -2
preSum 0 3 8 10 8

使用场景：求 nums[i..j] 的累加和（preSum[j + 1] - preSum[i] 即可）
```

```java
int len = nums.length;
int[] preSum = new int[len + 1];
preSum[0] = 0;
for (int i = 0; i < len; i++) {
    preSum[i + 1] = preSum[i] + nums[i];
}
```

- [848. 字母移位](https://leetcode-cn.com/problems/shifting-letters/) “反向前缀和”

### 差分数组

```
nums 8  2 6  3 1
diff 8 -6 4 -3 2

diff[i] = nums[i] - nums[i - 1]
使用场景：对 nums[i..j] 区间同时增加或减少某个数值。
```

```java
// nums[i..j] 的元素全部加 3
diff[i] += 3;
diff[j + 1] -= 3;

// 根据差分数组构造结果数组
int[] res = new int[diff.length];
res[0] = diff[0];
for (int i = 1; i < diff.length; i++) {
    res[i] = res[i - 1] + diff[i];
}
```

- [845. 数组中的最长山脉](https://leetcode-cn.com/problems/longest-mountain-in-array/) “反向差分”
- [1094. 拼车](https://leetcode-cn.com/problems/car-pooling/) 区间加减
- [1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings/) 区间加减
- [1854. 人口最多的年份](https://leetcode-cn.com/problems/maximum-population-year/) 区间加减

### 快速幂

```java
private long fastPower(long x, long pow, int mod) {
    // 取模
    x %= mod;
    long ans = 1;
    while (pow > 0) {
        if (pow % 2 == 1) {
            ans *= x;
            // 取模
            ans %= mod;
        }
        x *= x;
        // 取模
        x %= mod;
        pow /= 2;
    }
    return ans;
}
```

- [1922. 统计好数字的数目](https://leetcode-cn.com/problems/count-good-numbers/)
- [1969. 数组元素的最小非零乘积](https://leetcode-cn.com/problems/minimum-non-zero-product-of-the-array-elements/)

### 双指针

二分搜索（二分找单元素，二分找左边界，二分找右边界）

- [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
- [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)
- [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)
- [1011. 在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/)
- [1870. 准时到达的列车最小时速](https://leetcode-cn.com/problems/minimum-speed-to-arrive-on-time/)

滑动窗口

- [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) 双指针-滑动窗口
- [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) 双指针-滑动窗口
- [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) 固定大小窗口
- [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/) 固定大小窗口

快慢指针

- [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
- [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [27. 移除元素](https://leetcode-cn.com/problems/remove-element/)
- [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
- [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
- [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
- [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

### 买卖股票系列

- [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/) 暴力解法、动态规划（Java）
- [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) 暴力搜索、贪心算法、动态规划（Java）
- [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) 动态规划（Java）
- [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv) 动态规划（「力扣」更新过用例，只有优化空间的版本可以 AC）
- [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown) 动态规划（Java）
- [714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee) 动态规划（Java）

### 打家劫舍系列

- [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)
- [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)

### 存在重复元素系列

- [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)
- [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)
- [220. 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii/)

### 广度优先搜索 BFS

```java
public int bfs(char[][] maze, int[] entrance) {
    int mazeM = maze.length;
    int mazeN = maze[0].length;
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    maze[entrance[0]][entrance[1]] = '+';
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{entrance[0], entrance[1], 0});

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] cur = queue.poll();
            if (cur == null) {
                break;
            }
            for (int[] dir : direction) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                int step = cur[2] + 1;
                if (nextM >= 0 && nextM < mazeM && nextN >= 0 && nextN < mazeN && maze[nextM][nextN] == '.') {
                    if (nextM == 0 || nextN == 0 || nextM == mazeM - 1 || nextN == mazeN - 1) {
                        return step;
                    }
                    maze[nextM][nextN] = '+';
                    queue.add(new int[]{nextM, nextN, step});
                }
            }
        }
    }
    return -1;
}
```

- [1293. 网格中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/)
- [1926. 迷宫中离入口最近的出口](https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/submissions/)

### 深度优先搜索 DFS（回溯算法）

- [46. 全排列](https://leetcode-cn.com/problems/permutations/)
- [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

### KMP 算法

- [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

### Manacher 马拉车算法

- [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
- [1960. 两个回文子字符串长度的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/)

### 约瑟夫环问题

- [1823. 找出游戏的获胜者](https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/)

### 数制转换

- [12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/)
- [13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/)
- [504. 七进制数](https://leetcode-cn.com/problems/base-7/)

### 螺旋矩阵

- [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)
- [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/)
- [885. 螺旋矩阵 III](https://leetcode-cn.com/problems/spiral-matrix-iii/)

### 二叉树

- [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)
- [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)
- [116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
- [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

### 单调栈

注意：Java 中 "栈" 应使用 Deque 代替 Stack（Java 官方建议）。即：

```java
// Bad
Stack<T> stack = new Stack<>();

// Good
Deque<T> stack = new ArrayDeque<>();
```

- [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)
- [503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/)
- [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)
- [1944. 队列中可以看到的人数](https://leetcode-cn.com/problems/number-of-visible-people-in-a-queue/)

## 学习资源

- [OI-Wiki](https://oi-wiki.org/)
- [codeforces](https://codeforces.com/)
- [北大 OJ](http://poj.org/)
- [中科大 OJ](http://acm.ustc.edu.cn/ustcoj/)
- [杭电 OJ](https://www.acm.hdu.edu.cn/)
- [哈工大 OJ](http://acm.hit.edu.cn/)
- [洛谷](https://www.luogu.com.cn/)
- [labuladong](https://labuladong.gitbook.io/algo/)

## 《剑指 Offer（专项突破版）》

整数

1. [29. 两数相除](https://leetcode-cn.com/problems/divide-two-integers/)
2. [67. 二进制求和](https://leetcode-cn.com/problems/add-binary/)
3. [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)
4. [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)
5. [318. 最大单词长度乘积](https://leetcode-cn.com/problems/maximum-product-of-word-lengths/)

数组

6. [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

（全文完）
