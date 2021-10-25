# leetcode-hub-java

基于 `jdk17` + `maven3.8` + `junit5` 的 leetcode 练习仓库。

~~（拼搏百天，我要完成 300 道 leetcode 题！（Day86 已完成 300 题）~~

（拼搏 300 天，完成 1000 道 leetcode 题！

- `leetcode-n` 存放 `100 * (n - 1) + 1` ~ `100 * n` 的题目（如 `leetcode-19` 存放 `1801` ~ `1900` 的题目）。
- `leetcode-core` 存放 leetcode 自定义对象。
- `leetcode-extends` 存放 LCCUP/OJ 题目
- `leetcode-interview` 存放 《程序员面试金典》 题目。
- `leetcode-offer` 存放 《剑指 Offer》 题目。

## 环境信息

```sh
$ java -version
openjdk version "17" 2021-09-14
OpenJDK Runtime Environment (build 17+35-2724)
OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)

$ mvn -v
Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
Maven home: C:\Program Files\apache-maven-3.8.2
Java version: 17, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

IntelliJ IDEA 2021.2.2 (Ultimate Edition)
Build #IU-212.5284.40, built on September 14, 2021
```

## 构建命令

```sh
# jdk17:
mvn clean test -gs settings.xml

# 如果系统 PATH 中使用的是 jdk8，需要指定 jdk17:
"C:\Program Files\Java\jdk-17\bin\java.exe" \
-Dmaven.multiModuleProjectDirectory=C:\Users\DEVYY\Documents\GitHub\LTS\leetcode-hub-java \
"-Dmaven.home=C:\Program Files\apache-maven-3.8.2" \
"-Dclassworlds.conf=C:\Program Files\apache-maven-3.8.2\bin\m2.conf" \
-Dfile.encoding=UTF-8 \
-classpath "C:\Program Files\apache-maven-3.8.2\boot\plexus-classworlds-2.6.0.jar" \
org.codehaus.classworlds.Launcher \
clean test -gs settings.xml
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
3. 部分题目符合题意的答案是一个集合，但对集合元素的顺序没有要求，可以对 `expected` 和 `actual` 集合进行排序后判等，如第 30、46、51 题等；
4. 部分题目是非精确判等（随机问题），如第 384、528 题等；

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

### 二分查找

```java
private int binarySearchLeftBound(int[] nums, int target) {
    if (nums.length == 0) {
        return -1;
    }
    int left = 0;
    int right = nums.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left;
}

private static int binarySearchRightBound(int[] nums, int target) {
    if (nums.length == 0) {
        return -1;
    }
    int left = 0;
    int right = nums.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            left = mid + 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left - 1;
}
```

朴素二分

- [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)

左边界二分

- [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)
- [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)
- [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)
- [1011. 在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/)
- [1870. 准时到达的列车最小时速](https://leetcode-cn.com/problems/minimum-speed-to-arrive-on-time/)

右边界二分

- [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

### 双指针

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

### 最大连续 1 的个数

- [485. 最大连续 1 的个数](https://leetcode-cn.com/problems/max-consecutive-ones/)
- [$487. 最大连续 1 的个数 II](https://leetcode-cn.com/problems/max-consecutive-ones-ii/)
- [1004. 最大连续 1 的个数 III](https://leetcode-cn.com/problems/max-consecutive-ones-iii/)

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

### 并查集（UnionFind）

```java
    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        /**
         * 返回节点 x 的根节点
         *
         * @param x 节点 x
         * @return 节点 x 的根节点
         */
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        /**
         * 将 p 和 q 连通
         *
         * @param p p
         * @param q q
         */
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }
    }
```

- [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [1992. 找到所有的农场组](https://leetcode-cn.com/problems/find-all-groups-of-farmland/)

### KMP 算法

- [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

### Manacher 马拉车算法

- [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
- [1960. 两个回文子字符串长度的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/)

### 约瑟夫环问题

```java
// n 人，编号 0 ~ n-1
public int josephus(int n, int m) {
    if (n == 1) {
        return 0;
    }
    return (josephus(n - 1, m) + m) % n;
}

// n 人，编号 1 ~ n
public int josephus(int n, int k) {
    if (n == 1) {
        return 1;
    }
    return (josephus(n - 1, k) + k - 1) % n + 1;
}
```

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

注意二者转 stream 时的顺序：

```java
Stack<Integer> stack1 = new Stack<>();
Deque<Integer> stack2 = new ArrayDeque<>();
stack1.push(1); stack1.push(2); stack1.push(3);
stack2.push(1); stack2.push(2); stack2.push(3);
System.out.println(Arrays.toString(stack1.stream().mapToInt(i -> i).toArray())); // [1, 2, 3]
System.out.println(Arrays.toString(stack2.stream().mapToInt(i -> i).toArray())); // [3, 2, 1]
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
- [excalidraw](https://excalidraw.com/)

## 《剑指 Offer（专项突破版）》

### 1 整数

1. [29. 两数相除](https://leetcode-cn.com/problems/divide-two-integers/)
2. [67. 二进制求和](https://leetcode-cn.com/problems/add-binary/)
3. [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)
4. [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)
5. [318. 最大单词长度乘积](https://leetcode-cn.com/problems/maximum-product-of-word-lengths/)

### 2 数组

6. [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)
7. [15. 三数之和](https://leetcode-cn.com/problems/3sum/)
8. [209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)
9. [713. 乘积小于 K 的子数组](https://leetcode-cn.com/problems/subarray-product-less-than-k/)
10. [560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)
11. [525. 连续数组](https://leetcode-cn.com/problems/contiguous-array/)
12. [724. 寻找数组的中心下标](https://leetcode-cn.com/problems/find-pivot-index/)
13. [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)

### 3 字符串

14. [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)
15. [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
16. [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
17. [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)
18. [125. 验证回文串](https://leetcode-cn.com/problems/valid-palindrome/submissions/)
19. [680. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)
20. [647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)

### 4 链表

21. [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
22. [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
23. [160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)
24. [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
25. [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii/)
26. [143. 重排链表](https://leetcode-cn.com/problems/reorder-list/)
27. [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)
28. [430. 扁平化多级双向链表](https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/)
29. [$708. 循环有序列表的插入](https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/) | [《剑指 Offer II》029. 排序的循环链表](https://leetcode-cn.com/problems/4ueAj6/)

### 5 哈希表

30. [380. O(1) 时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/)
31. [146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
32. [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
33. [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
34. [953. 验证外星语词典](https://leetcode-cn.com/problems/verifying-an-alien-dictionary/)
35. [539. 最小时间差](https://leetcode-cn.com/problems/minimum-time-difference/)

### 6 栈

36. [150. 逆波兰表达式求值](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)
37. [735. 行星碰撞](https://leetcode-cn.com/problems/asteroid-collision/)
38. [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)
39. [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)
40. [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

### 7 队列

41. [$346. 数据流中的移动平均值](https://leetcode-cn.com/problems/moving-average-from-data-stream/) | [《剑指 Offer II》041. 滑动窗口的平均值](https://leetcode-cn.com/problems/qIsx9U/)
42. [933. 最近的请求次数](https://leetcode-cn.com/problems/number-of-recent-calls/)
43. [919. 完全二叉树插入器](https://leetcode-cn.com/problems/complete-binary-tree-inserter/)
44. [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/) 两个队列实现二叉树广搜
45. [513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/) 两个队列实现二叉树广搜
46. [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/) 两个队列实现二叉树广搜

### 8 树

47. [814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning/)
48. [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
49. [129. 求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)
50. [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)
51. [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
52. [897. 递增顺序搜索树](https://leetcode-cn.com/problems/increasing-order-search-tree/)
53. [$285. 二叉搜索树中的中序后继](https://leetcode-cn.com/problems/inorder-successor-in-bst/) | [《剑指 Offer II》053. 二叉搜索树中的中序后继](https://leetcode-cn.com/problems/P5rCT8/)
54. [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)
55. [173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator/)
56. [653. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)
57. [220. 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii/)
58. [729. 我的日程安排表 I](https://leetcode-cn.com/problems/my-calendar-i/)

### 9 堆

59. [703. 数据流中的第 K 大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/)
60. [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)
61. [373. 查找和最小的 K 对数字](https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/)

### 10 前缀树

62. [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
63. [648. 单词替换](https://leetcode-cn.com/problems/replace-words/)
64. [676. 实现一个魔法字典](https://leetcode-cn.com/problems/implement-magic-dictionary/)
65. [820. 单词的压缩编码](https://leetcode-cn.com/problems/short-encoding-of-words/)
66. [677. 键值映射](https://leetcode-cn.com/problems/map-sum-pairs/)
67. [421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/)

### 11 二分查找

68. [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)
69. [852. 山脉数组的峰顶索引](https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/)
70. [540. 有序数组中的单一元素](https://leetcode-cn.com/problems/single-element-in-a-sorted-array/)
71. [528. 按权重随机选择](https://leetcode-cn.com/problems/random-pick-with-weight/)
72. [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
73. [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)

### 12 排序

74. [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)
75. [1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)
76. [215. 数组中的第 K 个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
77. [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)
78. [23. 合并 K 个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

### 13 回溯法

79. [78. 子集](https://leetcode-cn.com/problems/subsets/)
80. [77. 组合](https://leetcode-cn.com/problems/combinations/)
81. [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)
82. [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)
83. [46. 全排列](https://leetcode-cn.com/problems/permutations/)
84. [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
85. [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
86. [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)
87. [93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)

### 14 动态规划

**单序列问题**

88. [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)
89. [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)
90. [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)
91. [$256. 粉刷房子](https://leetcode-cn.com/problems/paint-house/) | [《剑指 Offer II》091. 粉刷房子](https://leetcode-cn.com/problems/JEj789/)
92. [926. 将字符串翻转到单调递增](https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/)
93. [873. 最长的斐波那契子序列的长度](https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/)
94. [132. 分割回文串 II](https://leetcode-cn.com/problems/palindrome-partitioning-ii/)

**双序列问题**

95. [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
96. [97. 交错字符串](https://leetcode-cn.com/problems/interleaving-string/)
97. [115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)

**矩阵路径问题**

98. [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)
99. [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
100.  [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

**背包问题**

101. [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
102. [494. 目标和](https://leetcode-cn.com/problems/target-sum/)
103. [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
104. [377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv/)

### 15 图

**图的搜索**

105. [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)
106. [785. 判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite/)
107. [542. 01 矩阵](https://leetcode-cn.com/problems/01-matrix/)
108. [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/)
109. [752. 打开转盘锁](https://leetcode-cn.com/problems/open-the-lock/)
110. [797. 所有可能的路径](https://leetcode-cn.com/problems/all-paths-from-source-to-target/)
111. [399. 除法求值](https://leetcode-cn.com/problems/evaluate-division/)
112. [329. 矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/)

**拓扑排序**

113. [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)
114. [$269. 火星词典](https://leetcode-cn.com/problems/alien-dictionary/) | [《剑指 Offer II》114. 外星文字典](https://leetcode-cn.com/problems/Jf1JuT/)
115. [$444. 序列重建](https://leetcode-cn.com/problems/sequence-reconstruction/) | [《剑指 Offer II》115. 重建序列](https://leetcode-cn.com/problems/ur2n8P/)

**并查集**

116. [547. 省份数量](https://leetcode-cn.com/problems/number-of-provinces/)
117. [839. 相似字符串组](https://leetcode-cn.com/problems/similar-string-groups/)
118. [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)
119. [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)

（全文完）
