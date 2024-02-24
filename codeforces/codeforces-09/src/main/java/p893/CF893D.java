package p893;

import java.util.Scanner;

public class CF893D {
    static int n, d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int low = 0, up = 0;
        for (int v : a) {
            if (v == 0) {
                if (up < 0) {
                    ans++;
                    low = 0;
                    up = d;
                } else if (low < 0) {
                    low = 0;
                }
            } else {
                low += v;
                if (low > d) {
                    return "-1";
                }
                up += v;
                if (up > d) {
                    up = d;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Credit Card
https://codeforces.com/contest/893/problem/D

灵茶の试炼 2022-05-03
题目大意：
你有一张奇怪的信用卡，初始金额为 0。
每天早上你可以去银行给卡充任意金额的钱。（也可以不去）
给你一个长度为 n(<=1e5) 的数组，第 i 天晚上会发生如下情况：（-1e4<=a[i]<=1e4）
如果 a[i]>0，卡里的钱自动增加 a[i]
如果 a[i]<0，卡里的钱自动减少 |a[i]|（卡里的钱可以为负的）
如果 a[i]=0，银行会查询卡里的余额，如果此时卡里的钱为负则会冻结信用卡。
并且，在任意时刻，卡里的钱都不能超过 d(1<=d<=1e9)。
为了不让卡被冻结，请问你至少要去银行几次（给卡充钱）？
如果无论如何卡里的钱都会超过 d，则输出 -1。

rating 1900
两种做法：
方法一：如果 a[i]=0 的时候钱 <0，那么一定要去银行了，不妨贪心地充尽可能多的钱，同时保证后续的增减不会超过 d
这就需要计算出 a[i] 的后缀和的最大值，充钱是不能超过这个最大值的
群友代码 https://codeforces.com/contest/893/submission/155822611
方法二：上下界分析法。
提示 1：在尽量少地去银行充钱的前提下，考虑卡里的钱最少和最多是多少。
做法：
设下界为 low，上界为 up，初始均为 0（因为还没去过银行充钱）
当 a[i]≠0 时则 low+=a[i] up+=a[i]
加完了如果 low>d 则输出 -1，如果 up>d 则将 up 置为 d
当 a[i]=0 时，如果 up < 0 那肯定要充钱了，充钱后 low=0 up=d
如果 low<0 则将 low 置为 0
群主代码 https://codeforces.com/contest/893/submission/141785970
======

input
5 10
-1 5 0 -5 3
output
0

input
3 4
-10 0 20
output
-1

input
5 10
-5 0 10 -11 0
output
2
 */
