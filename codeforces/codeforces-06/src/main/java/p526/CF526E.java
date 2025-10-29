package p526;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF526E {
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
        int q = scanner.nextInt();
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = scanner.nextInt();
            sum[i] += sum[i - 1]; // 前缀和
        }
        long total = sum[n];

        int[] f = new int[n + 1];
        int[] begin = new int[n + 1];
        while (q-- > 0) {
            long b = scanner.nextLong();
            if (total <= b) { // 只有一段
                out.println(1);
                continue;
            }
            int l = 0;
            for (int i = 1; ; i++) {
                while (sum[i] - sum[l] > b) { // 滑动窗口
                    l++;
                }
                f[i] = f[l] + 1; // 前 i 个数至少要分 f[i] 段
                if (f[i] == 2) {
                    begin[i] = l; // 记录第二段的开始位置
                } else {
                    begin[i] = begin[l];
                }
                // 剩余部分 <= b，说明首尾两段可以拼成一段，或者相当于把剩余的后缀拼到了第一段，所以答案就是 f[i]
                if (total - (sum[i] - sum[begin[i]]) <= b) {
                    out.println(Math.max(f[i], 2)); // 可能找到第一段就触发 if 了，此时答案是 2
                    break;
                }
            }
        }
    }
}
/*
E. Transmitting Levels
https://codeforces.com/contest/526/problem/E

灵茶の试炼 2025-07-04
题目大意：
输入 n(2≤n≤1e6) q(1≤q≤50) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入 q 个询问，每个询问输入 b(max(a)≤b≤1e15)。
a 是一个环形数组。
对于每个询问，输出：把 a 分成若干段，每段元素和不超过 b，最少要分多少段？

rating 2400
https://www.luogu.com.cn/article/dg60rgpy
相似题目：3464. 正方形上的点之间的最大距离
======

Input
6 3
2 4 2 1 3 2
7
4
6
Output
2
4
3
 */
