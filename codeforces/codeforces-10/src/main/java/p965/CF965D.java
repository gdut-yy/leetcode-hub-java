package p965;

import java.util.Scanner;

public class CF965D {
    static int w, l;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextInt();
        l = scanner.nextInt();
        a = new int[w];
        for (int i = 1; i < w; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 1; i < w; i++) {
            a[i] += a[i - 1];
        }
        int ans = (int) 1e9;
        for (int i = l; i < w; i++) {
            ans = Math.min(ans, a[i] - a[i - l]);
        }
        return String.valueOf(ans);
    }
}
/*
D. Single-use Stones
https://codeforces.com/contest/965/problem/D

灵茶の试炼 2022-10-01
题目大意：
输入 w(≤1e5) L(<w) 和一个长为 w-1 的数组 a (0≤a[i]≤1e4，下标从 1 开始)。
有一条宽为 w 的河，青蛙们在位置 0 处，位置 i 处有 a[i] 个石头，位置 w 为河对岸。
青蛙单次跳跃距离不超过 L。每个石头只能被一只青蛙用一次。
输出最多有多少只青蛙能过河。

rating 1900
https://codeforces.com/contest/965/submission/174185143
答案为长为 L 的最小子数组和。
证明：看成是网络流问题，由于最大流等于最小割，得证。
相似题目: 蓝桥杯2022年第十三届省赛真题-青蛙过河
https://www.dotcpp.com/oj/problem2667.html
======

input
10 5
0 0 1 0 2 0 0 1 0
output
3

input
10 3
1 1 1 1 2 1 1 1 1
output
3
 */
