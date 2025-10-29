package p2112;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2112C {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long ans = 0;
        for (int i = 2; i < n; i++) {
            int tar = Math.max(a[i], a[n - 1] - a[i]);
            int l = 0, r = i - 1;
            while (l < r) {
                if (a[l] + a[r] > tar) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        out.println(ans);
    }
}
/*
C. Coloring Game
https://codeforces.com/contest/2112/problem/C

灵茶の试炼 2025-08-18
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤5e3。
每组数据输入 n(3≤n≤5e3) 和长为 n 的递增数组 a(1≤a[i]≤1e5)。
一开始有 n 个无色球，第 i 个球上的数字为 a[i]。
Alice 选 3 个球涂成红色，然后 Bob 选 1 个球（可以是红色）涂成蓝色。
注：上述过程只执行一轮。
要求无论 Bob 怎么操作，都有红色球元素和 > 蓝色球的元素值。
问：Alice 有多少种不同的涂色方案。即涂成红色的下标三元组 (i,j,k) 的数量，其中 i<j<k。

rating 1300
设 Alice 选的三个数为 x,y,z。
如果 Bob 选 a[n-1]，那么需要满足 x+y+z > a[n-1]，即 x+y > a[n-1]-z。
否则 Bob 选 z 比选 x,y 好，需要满足 x+y > z。
谁大选谁，问题变成 x+y > max(z, a[n-1]-z) 的方案数。
这是经典的两数之和问题，用相向双指针解决。
见 LC2824. 统计和小于目标的下标对数目。
注：翻看代码发现一众红黑写的都是 for + for + while 的双指针。
代码 https://codeforces.com/problemset/submission/2112/333994551
代码备份（上面打不开的同学看这个）
======

Input
6
3
1 2 3
4
1 1 2 4
5
7 7 7 7 7
5
1 1 2 2 4
6
2 3 3 4 5 5
5
1 1 1 1 3
Output
0
0
10
2
16
0
 */
