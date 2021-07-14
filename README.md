# leetcode-hub-java

基于 java11 + junit5 + allure2 的 leetcode 练习仓库

（拼搏百天，我要完成 300 道 leetcode 题！额。。不好意思，走错片场了。。

其中，leetcode-n 存放 `100 * (n - 1) + 1` ~ `100 * n` 的题目（如 leetcode-19 存放 1801 ~ 1900 的题目）。

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

注意：由于 leetcode 部分题目使用了自定义对象（如 21、23 题等），使用 Assertions.assertEquals 对自定义对象进行判等时要注意重写 equals 方法。根据编码规范，在重写 equals 方法的同时也须重写 hashCode 方法（否则在 HashSet, HashTable, HashMap 等集合中将存在重复元素）。

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

- [1094. 拼车](https://leetcode-cn.com/problems/car-pooling/)
- [1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings/)
- [1854. 人口最多的年份](https://leetcode-cn.com/problems/maximum-population-year/)

### 快速幂

```java
public long fastPower(long x, long pow, int mod) {
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

### 双指针

二分搜索（二分找单元素，二分找左边界，二分找右边界）

滑动窗口

- [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) 双指针-滑动窗口
- [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) 双指针-滑动窗口
- [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) 滑动窗口-固定窗口
- [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/) 滑动窗口-固定窗口

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

### 深度优先搜索 DFS

### KMP 算法

- [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

### Manacher 马拉车算法

- [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
