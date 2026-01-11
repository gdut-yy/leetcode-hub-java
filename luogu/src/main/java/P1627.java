import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1627 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int b = scanner.nextInt();

        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        boolean findB = false;
        int s = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();

            if (v == b) {
                findB = true;
            } else if (v < b) {
                s--;
            } else {
                s++;
            }

            if (!findB) {
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            } else {
                ans += cnt.getOrDefault(s, 0);
            }
        }
        out.print(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P1627

灵茶の试炼 2025-12-16

输入 n(1≤n≤1e5) med(1≤med≤n) 和一个 1~n 的排列 p。
输出 p 有多少个长为奇数的连续子数组，满足 med 是子数组的中位数。
进阶：如果没有「长为奇数」的限制呢？长为偶数时取中间靠左的数作为中位数。

设中位数为 b。
由于输入是一个排列，如果大于 b 的元素个数 = 小于 b 的元素个数，那么 b 就是中位数。
也就是，大于 b 的元素个数 - 小于 b 的元素个数 = 0。
把大于 b 的数看成 1，小于 b 的数看成 -1，等于 b 的数看成 0。问题变成：包含 0 且和为 0 的子数组个数。
做法类似 LC560. 和为 K 的子数组。
用前缀和处理，s[R] - S[L] = 0，即 s[R] = s[L]。
统计 b 左边的前缀和及其出现次数（包含空前缀 0），记在一个 map 中。
对于 b 及其右边的前缀和，去 map 中找对应的出现次数，加到答案中。
进阶：如果没有长度是奇数的限制，本题是 LC2488. 统计中位数为 K 的子数组。
代码 https://paste.ubuntu.com/p/M6GwcDCjSD/
======
# P1627 [CQOI2009] 中位数

## 题目描述

给出 $1,2,...,n$ 的一个排列，统计该排列有多少个长度为奇数的连续子序列的中位数是 $b$。中位数是指把所有元素从小到大排列后，位于中间的数。

## 输入格式

第一行为两个正整数 $n$ 和 $b$，第二行为 $1,2,...,n$ 的排列。

## 输出格式

输出一个整数，即中位数为 $b$ 的连续子序列个数。

## 输入输出样例 #1

### 输入 #1

```
7 4
5 7 2 4 3 1 6
```

### 输出 #1

```
4
```

## 说明/提示

#### 数据规模与约定

对于 $30\%$ 的数据中，满足 $n \le 100$；

对于 $60\%$ 的数据中，满足 $n \le 1000$；

对于 $100\%$ 的数据中，满足 $n \le 100000,1 \le b \le n$。
 */