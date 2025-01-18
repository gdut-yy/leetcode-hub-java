package p2004;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF2004F {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j < n; j++) {
                s += a[j]; // s 等于从 a[i] 到 a[j] 的子数组和
                ans += j - i - cnt.getOrDefault(s, 0);
                cnt.merge(s, 1, Integer::sum);
            }
        }
        return String.valueOf(ans);
    }
}
/*
F. Make a Palindrome
https://codeforces.com/contest/2004/problem/F

灵茶の试炼 2024-09-27
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e3。
每组数据输入 n(1≤n≤2e3) 和长为 n 的数组 a(1≤a[i]≤1e5)。
你可以执行如下两类操作：
1. 合并相邻元素。例如把 [2,2,3] 的前两个数合并成 4，得到 [4,3]。
2. 把一个大于 1 的数 v 分解为两个正整数 x 和 y，满足 x+y=v。例如把 [2,2,3] 的第一个数分解为两个 1，得到 [1,1,2,3]。
定义 f(b) 表示把 b 变成回文数组的最少操作次数。
对于 a 的所有非空连续子数组 b，计算 f(b)，输出所有 f(b) 之和。

rating 2600
https://www.luogu.com.cn/article/px3tz8ne
======

Input
4
3
2 1 3
4
1 1 1 1
5
4 2 3 1 5
4
1 2 1 2
Output
3
0
14
5
 */
