package p2064;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2064D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int[] pre = new int[31];
        Arrays.fill(pre, -1);
        int[][] pres = new int[n + 1][31];
        for (int i = 0; i < n; i++) {
            int m = bitsLen(a[i]);
            pres[i] = pre.clone();
            pre[m] = i;
        }
        pres[n] = pre.clone();
        int[] s = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            s[i] = s[i + 1] ^ a[i];
        }

        while (q-- > 0) {
            int x = scanner.nextInt();
            int oriX = x;
            int cur = n, preM = 31, maxP = -1;
            while (true) {
                int m = bitsLen(x);
                if (m + 1 < preM) {
                    // maxP = max(maxP, slices.Max(pres[cur][m+1:preM]))
                    int mx = Integer.MIN_VALUE;
                    for (int i = m + 1; i < preM; i++) {
                        mx = Math.max(mx, pres[cur][i]);
                    }
                    maxP = Math.max(maxP, mx);
                }
                int p = pres[cur][m];
                if (p <= maxP) {
                    out.print((n - 1 - maxP) + " ");
                    break;
                }
                x = oriX ^ s[p + 1];
                if (x < a[p]) {
                    out.print((n - 1 - p) + " ");
                    break;
                }
                x ^= a[p];
                preM = m + 1;
                cur = p;
            }
        }
        out.println();
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
//        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
//        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
D. Eating
https://codeforces.com/contest/2064/problem/D

灵茶の试炼 2025-05-29
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]<2^30)。
然后输入 q 个询问，每个询问输入 x(1≤x<2^30)。
有 n 个史莱姆排成一行，大小为 a[i]。
在 a 的最右边添加一个大小为 x 的史莱姆。
如果 x >= 左边相邻史莱姆的大小 v，那么 x 吃掉左边的史莱姆，同时 x 更新为 x XOR v。
如果没有史莱姆，或者 x < 左边相邻史莱姆的大小，结束。
输出被吃掉的史莱姆的个数。
注意：每个询问互相独立。

rating 1900
核心观察：
设 x 的二进制长度为 m。
不能吃掉二进制长度大于 m 的史莱姆，此时结束。
吃掉二进制长度小于 m 的史莱姆，不会减少 x 的二进制长度。
吃掉二进制长度等于 m 的史莱姆，会减少 x 的二进制长度。
首先，跳到左边最近的二进制长度等于 m 的史莱姆 y。
如果这中间有二进制长度大于 m 的史莱姆，结束。需要计算这中间的二进制长度大于 m 的史莱姆的最大下标。
否则判断 x 和 y 的大小关系，要么无法吃掉，结束；要么吃掉 y，更新 x，并重新计算 x 的二进制长度。
重复上述过程，要么中途结束，要么全部吃掉。
编程细节：
为方便计算异或和，预处理异或前缀和（或者后缀和）。
如何计算左边最近的二进制长度等于 m 的史莱姆 y 的下标？
可以把史莱姆按照二进制长度分组（记录下标），然后二分查找。
更快的做法是，定义 pres[i][j] 表示下标 < i 且二进制长度等于 j 的最近史莱姆位置。（类似子序列自动机的 next 数组）
这样单次询问可以做到 O(log)。
代码 https://codeforces.com/contest/2064/submission/320878719
代码备份（洛谷）
======

Input
3
1 1
5
6
4 4
1 5 4 11
8
13
16
15
10 9
10 4 3 9 7 4 6 1 9 4
2
6
5
6
9
8
6
2
7
Output
1
0 2 4 2
0 1 1 1 3 3 1 0 1
 */
