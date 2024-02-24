package p1038;

import java.util.Arrays;
import java.util.Scanner;

public class CF1038D {
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
        if (n == 1) {
            return String.valueOf(a[0]);
        }
        Arrays.sort(a);
        long ans = a[n - 1] - a[0];
        for (int i = 1; i < n - 1; i++) {
            ans += Math.abs(a[i]);
        }
        return String.valueOf(ans);
    }
}
/*
D. Slime
https://codeforces.com/contest/1038/problem/D

灵茶の试炼 2022-06-22
题目大意：
给你一个 n(1<=n<=5e5) 和一个长为 n 的数组 a（-1e9<=a[i]<=1e9)，表示有 n 个卡比排成一排，每个卡比有个分数 a[i]。
每次你可以选择一个卡比，让它吃掉它左边或者右边的一个相邻的卡比，吃完后它的分数要减掉所吃的卡比的分数。
如此操作 n-1 次后，最后剩下的那只卡比的分数的最大值是多少？

rating 1800
https://codeforces.com/contest/1038/submission/61225429
从特例入手：
如果 a 全为正数要怎么做？
如果 a 全为负数要怎么做？
如果全为正数，我们可以找到最小的卡比 x，让它暴风吸入它左右两侧的所有卡比（保留一个最旁边的），然后用这个最旁边的卡比吸入 x，这样最小的卡比取负号，其余卡比均取正号。
如果全为负数，我们可以找到绝对值最小的卡比，让它暴风吸入它左右两侧的所有卡比即可。
如果有正有负（把 0 归到正数中），我们可以先让与正数相邻的那个负数把它旁边的正数都暴风吸入（保留一个正数），然后用这个正数暴风吸入其余卡比（这些卡比均为负）。这种情况答案为 sum(abs(a[i]))。
上述三种情况都可以总结成 max(a)-min(a)+sum(abs(a[i]) for other a[i])
注意特判 n=1 的情况。
======

input
4
2 1 2 1
output
4

input
5
0 -1 -1 -1 -1
output
4
 */
