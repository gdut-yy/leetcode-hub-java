package p2053;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2053C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = n + 1;
        long ans = 0;
        if ((n & 1) > 0) {
            ans = m / 2;
        }

        n /= 2;
        if (n >= k) {
            int d = bitsLen(n) - bitsLen(k);
            if (n >> d >= k) {
                d++;
            }
            ans += (n & ((1L << d) - 1)) * m;
        }
        out.println(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Bewitching Stargazer
https://codeforces.com/contest/2053/problem/C

灵茶の试炼 2025-08-12
题目大意：
输入 T(≤1e5) 表示 T 组数据。
每组数据输入 n k(1≤k≤n≤2e9)。
定义递归函数 dfs(L,R)：
1. 如果 R-L+1 < k，返回。
2. 设 M = floor((L+R)/2)。
3. 如果 R-L+1 是偶数，递归 dfs(L,M) 和 dfs(M+1,R)。
4. 否则，得到 M 分；然后，如果 L<R，递归 dfs(L,M-1) 和 dfs(M+1,R)。
递归入口为 dfs(1,n)。
输出总得分。
进阶：用 O(1) 时间解决每组数据。

rating 1500
动手算算几个不同的 n 吧~
比如 n = 10，分成 [1,5] 和 [6,10]，每个区间长度都是 n'=5，是奇数，内部的 M 为 3 和 8，而 3+8=11，刚好是 n+1。
继续往下分，递归函数每一层的总得分依次为 n+1，2(n+1), 4(n+1), 8(n+1), ... 当 n' 是奇数的时候增加这一层的总得分。
比如 n = 二进制的 1101011，n 是奇数。先计算一开始的得分 (n+1)/2，然后把 n 变成 floor(n/2)。
现在
n = 110101
k = 10
当 n 减小到二进制长度和 k 的二进制长度相等之前，我们遍历的二进制为 0101，贡献分别为 n+1 和 4(n+1)，即 5*(n+1)，而 5 刚好是 0101。
继续，比较 n'=11 和 k=10 的大小，发现 n' >= k，那么这一层还可以继续贡献一个 16(n+1)，总和为 21，即 10101。
设 d = |bin(n)| - |bin(k)|，如果 n>>d >= k 则把 d 加一。其中 |bin(n)| 表示 n 的二进制长度。
得分增加 n 的低 d 位乘以 n+1。
注意一开始 n 为奇数的时候，还有一个 (n+1)/2 的得分。
代码 https://codeforces.com/problemset/submission/2053/330965319
代码备份（Ubuntu Pastebin）
======

Input
6
7 2
11 3
55 13
5801 6
8919 64
8765432 1
Output
12
18
196
1975581
958900
38416403456028
 */
