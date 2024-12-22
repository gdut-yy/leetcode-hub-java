package p115;

import java.util.Scanner;

public class CF115B {
    static int n, m;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int cur = 0;
        int down = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = a[i];

            int l = s.indexOf('W');
            if (l < 0) {
                continue;
            }
            down = i;
            int r = s.lastIndexOf('W');
            if (i % 2 == 0) {
                if (cur <= l) {
                    ans += r - cur;
                } else {
                    ans += cur - l + r - l;
                }
                cur = r;
            } else {
                if (cur >= r) {
                    ans += cur - l;
                } else {
                    ans += r - cur + r - l;
                }
                cur = l;
            }
        }
        return String.valueOf(ans + down);
    }
}
/*
B. Lawnmower
https://codeforces.com/contest/115/problem/B

灵茶の试炼 2024-09-03
题目大意：
输入 n m(1≤n,m≤150) 和 n 行 m 列的网格图，每个格子要么是 G，要么是 W。
W 表示杂草。
你推着割草机，从左上角出发，目标是清除所有的杂草。
一开始你面朝右边。
你可以：
1. 如果你面朝右边，那么可以往右移动一步。
2. 如果你面朝左边，那么可以往左移动一步。
3. 往下移动一步，并改变朝向。
清除所有的杂草，最少需要移动多少步？

rating 1500
计算最后一个包含 W 的行，这样可以算出往下走的步数。
下面只讨论往左往右走的步数。
设 l 和 r 分别为该行第一个 W 和最后一个 W 的列号。
如果现在面朝右，且在第 cur 列，分类讨论：
1. 如果 cur <= l，那么只需往右移动到 r，答案增加 r - cur。
2. 如果 cur > l，那么在上一排需要先向左移动到 l，再在当前排向右移动到 r，答案增加 (cur - l) + (r - l)。
对于现在面朝左的情况同理。
最后加上往下走的步数。
代码 https://codeforces.com/contest/115/submission/277979151
======

Input
4 5
GWGGW
GGWGG
GWGGG
WGGGG
Output
11

Input
3 3
GWW
WWW
WWG
Output
7

Input
1 1
G
Output
0
 */