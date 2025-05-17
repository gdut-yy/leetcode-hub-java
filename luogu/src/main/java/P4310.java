import java.util.Arrays;
import java.util.Scanner;

public class P4310 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] f = new int[30];
        int mx = 0;
        for (int v : a) {
            for (int i = v; i > 0; i &= i - 1) {
                mx = Math.max(mx, f[Integer.numberOfTrailingZeros(i)]);
            }
            for (; v > 0; v &= v - 1) {
                f[Integer.numberOfTrailingZeros(v)] = mx + 1;
            }
        }
        int ans = Arrays.stream(f).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P4310

灵茶の试炼 2025-04-30
输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
找一个 a 的子序列 b，满足 b 中任意相邻元素的 AND 不等于 0。
输出 b 的最长长度。
注：长为 1 的 b 一定满足要求。

从左到右遍历 a，比如 a[i]=10010，我们需要知道最后一个数包含 10 或者 10000 的最长子序列的长度。
于是定义 f[0],f[1],...,f[29] 分别表示子序列最后一个数包含 1<<0,1<<1,...,1<<29 的最长子序列的长度。
枚举 a[i] 中的 1，计算转移来源的最大值。
然后用最大值加一更新相应的 f。
代码 https://www.luogu.com.cn/paste/dm8l11l8

# P4310 绝世好题

## 题目描述

给定一个长度为 $n$ 的数列 $a_i$，求 $a_i$ 的子序列 $b_i$ 的最长长度 $k$，满足 $b_i \& b_{i-1} \ne 0 $，其中 $2\leq i\leq k$， $\&$ 表示位运算取与。

## 输入格式

输入文件共 2 行。
第一行包括一个整数 $n$。
第二行包括 $n$ 个整数，第 $i$ 个整数表示 $a_i$。

## 输出格式

输出文件共一行。
包括一个整数，表示子序列 $b_i$ 的最长长度。

## 输入输出样例 #1

### 输入 #1

```
3
1 2 3
```

### 输出 #1

```
2
```

## 说明/提示

对于100%的数据，$1\leq n\leq 100000$，$a_i\leq 10^9$。
 */