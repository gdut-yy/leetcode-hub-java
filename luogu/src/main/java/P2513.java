import java.util.Scanner;

public class P2513 {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    static final int mod = 10000;

    private static String solve() {
        long[] f = new long[k + 1];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                f[j] = (f[j] + f[j - 1]) % mod;
            }
            for (int j = k; j > i; j--) {
                f[j] = (f[j] - f[j - i - 1] + mod) % mod;
            }
        }
        return String.valueOf(f[k]);
    }
}
/*
https://www.luogu.com.cn/problem/P2513

灵茶の试炼 2025-05-07
输入 n(1≤n≤1000) k(0≤k≤1000)。
输出有多少个 1~n 的排列，满足逆序对数恰好等于 k。
答案模 10000。

本题是 3193. 统计逆序对的数目 的简化版，做法见我题解。
代码 https://www.luogu.com.cn/paste/fx4nlgwt

# P2513 [HAOI2009] 逆序对数列

## 题目描述

对于一个数列 $\{a_i\}$，如果有 $i<j$ 且 $a_i>a_j$，那么我们称 $a_i$ 与 $a_j$ 为一对逆序对数。若对于任意一个由 $1 \sim n$ 自然数组成的数列，可以很容易求出有多少个逆序对数。那么逆序对数为 $k$ 的这样自然数数列到底有多少个？

## 输入格式

第一行为两个整数n，k。

## 输出格式

写入一个整数，表示符合条件的数列个数，由于这个数可能很大，你只需输出该数对10000求余数后的结果。

## 输入输出样例 #1

### 输入 #1

```
4 1
```

### 输出 #1

```
3
```

## 说明/提示

样例说明：

下列3个数列逆序对数都为1；分别是1 2 4 3 ；1 3 2 4 ；2 1 3 4；

测试数据范围

30%的数据  $n\le 12$。

100%的数据  $n\le 1000$，$k\le 1000$。
 */