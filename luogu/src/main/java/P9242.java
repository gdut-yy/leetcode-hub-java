import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P9242 {
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
        int[] f = new int[10];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int head = s.charAt(0) - '0';
            int tail = s.charAt(s.length() - 1) - '0';
            f[tail] = Math.max(f[tail], f[head] + 1);
        }

        int maxF = Arrays.stream(f).max().orElse(0);
        out.print(n - maxF);
    }
}
/*
https://www.luogu.com.cn/problem/P9242

灵茶の试炼 2025-12-22

输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，保证 a[i] 无前导零。
你需要从 a 中删除一些数，得到一个接龙序列 b，满足 b[i-1] 的末位数字等于 b[i] 的首位数字。
例如 12,23,35,56,61,11 是接龙序列；12,23,34,56 不是接龙序列。
长为 1 的序列是接龙序列。
输出最少删除多少个数。

考虑最多保留多少个数。
按照 DP 题单【§7.4 合法子序列 DP】的套路，定义 f[tail] 表示以 tail（0~9）结尾的接龙子序列的最长长度，从子序列的倒数第二个数转移过来。
设 a[i] 的首位为 head，末位为 tail。
我们可以把 a[i] 加到某个以 head 结尾的子序列的末尾，得到 f[head] + 1，用其更新 f[tail] 的最大值。
初始值：f[i] = 0。
答案：n - max(f)。
代码 https://paste.ubuntu.com/p/Xs46Mvbm7v/
======
# P9242 [蓝桥杯 2023 省 B] 接龙数列

## 题目描述

对于一个长度为 $K$ 的整数数列：$A_{1},A_{2},\ldots,A_{K}$，我们称之为接龙数列当且仅当 $A_{i}$ 的首位数字恰好等于 $A_{i-1}$ 的末位数字（$2 \leq i \leq K$）。

例如 $12,23,35,56,61,11$ 是接龙数列；$12,23,34,56$ 不是接龙数列，因为 $56$ 的首位数字不等于 $34$ 的末位数字。所有长度为 $1$ 的整数数列都是接龙数列。

现在给定一个长度为 $N$ 的数列 $A_{1},A_{2},\ldots,A_{N}$，请你计算最少从中删除多少 个数，可以使剩下的序列是接龙序列？

## 输入格式

第一行包含一个整数 $N$。

第二行包含 $N$ 个整数 $A_{1},A_{2},\ldots,A_{N}$。

## 输出格式

一个整数代表答案。

## 输入输出样例 #1

### 输入 #1

```
5
11 121 22 12 2023
```

### 输出 #1

```
1
```

## 说明/提示

**【样例说明】**

删除 $22$，剩余 $11,121,12,2023$ 是接龙数列。

**【评测用例规模与约定】**

对于 $20 \%$ 的数据，$1 \leq N \leq 20$。

对于 $50 \%$ 的数据，$1 \leq N \leq 10^4$。

对于 $100 \%$ 的数据，$1 \leq N \leq 10^{5}$，$1 \leq A_{i} \leq 10^{9}$。所有 $A_{i}$ 保证不包含前导 0。

蓝桥杯 2023 省赛 B 组 E 题。
 */