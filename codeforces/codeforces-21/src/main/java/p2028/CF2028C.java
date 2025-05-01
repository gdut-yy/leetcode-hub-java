package p2028;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2028C {
    static int n, m, low;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            low = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long tot = 0, s = 0;
        List<Long> pre = new ArrayList<>();
        pre.add(0L);
        for (int i = 0; i < n; i++) {
            tot += a[i];
            s += a[i];
            if (s >= low) {
                pre.add(tot);
                s = 0;
            }
        }
        if (pre.size() <= m) return "-1";

        long ans = tot - pre.get(m);
        s = 0;
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            tot -= a[i];
            s += a[i];
            if (s >= low) {
                ans = Math.max(ans, tot - pre.get(j));
                j--;
                s = 0;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Alice's Adventures in Cutting Cake
https://codeforces.com/contest/2028/problem/C

灵茶の试炼 2024-12-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤n) low(1≤low≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你需要把数组 a 分成 m+1 段，选择其中一段留给自己，其余 m 段的元素和都必须 >= low。
输出留给自己的那段子数组（可以为空）的元素和的最大值。
如果无法做到，输出 -1。

rating 1600
贪心+前后缀分解。
先判断什么时候输出 -1。
从左到右遍历 a，并累加当前这一段的元素和 s，只要 s>=low，就立刻切开，并记录此时的前缀和（记录到一个列表中），然后重置 s=0，继续向后遍历。
如果没法切出 m 段，输出 -1。
切出 m 段后，a 末尾剩余元素留给自己，其元素和作为答案的初始值。
然后从右到左遍历 a（倒着切），方法同上。
比如倒着切出了 2 段，后缀和为 suf，那么找到之前记录的切出 m-2 段时的前缀和 pre，此时我们自己得到的元素和为 sum(a) - pre - suf，更新答案的最大值。
代码 https://codeforces.com/contest/2028/submission/292621492
代码备份（洛谷）
======

Input
7
6 2 1
1 1 10 1 1 10
6 2 2
1 1 10 1 1 10
6 2 3
1 1 10 1 1 10
6 2 10
1 1 10 1 1 10
6 2 11
1 1 10 1 1 10
6 2 12
1 1 10 1 1 10
6 2 12
1 1 1 1 10 10
Output
22
12
2
2
2
0
-1
 */
