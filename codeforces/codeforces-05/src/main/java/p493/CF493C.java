package p493;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF493C {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt() << 1;
        }

        int m = scanner.nextInt();
        int[] newA = new int[n + m];
        System.arraycopy(a, 0, newA, 0, n);

        for (int i = 0; i < m; i++) {
            int d = scanner.nextInt();
            newA[n + i] = (d << 1) | 1;
        }

        Arrays.sort(newA);

        int[] s = {n * 3, m * 3};
        int ans0 = s[0], ans1 = s[1];

        for (int i = 0; i < newA.length; i++) {
            int v = newA[i];
            s[v & 1]--;

            if (i == newA.length - 1 || (v >> 1) != (newA[i + 1] >> 1)) {
                if (s[0] - s[1] > ans0 - ans1) {
                    ans0 = s[0];
                    ans1 = s[1];
                }
            }
        }

        out.println(ans0 + ":" + ans1);
    }
}
/*
C. Vasya and Basketball
https://codeforces.com/contest/493/problem/C

灵茶の试炼 2025-11-12
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e9)。
输入 m(1≤m≤2e5) 和长为 m 的数组 b(1≤b[i]≤2e9)。
a 和 b 表示两支篮球队 A 和 B 投篮时到篮筐的距离列表。
设三分线到篮筐的距离为 d。
如果投篮距离 > d 则得到 3 分，否则得到 2 分。
你可以指定 d 的值。
最大化 A 队得分 - B 队得分。
如果有多种方案，最大化 A 队得分。
输出格式 scoreA:scoreB。

rating 1600
先假设 d=0，两个队伍的得分分别为 3n 和 3m。
然后不断移动 d = a[i] 或者 b[i]（把 a 和 b 混在一起从小到大排序）。
同时修改队伍得分，更新答案的最大值。
对于同一个队伍的连续相同距离，要把这段距离都处理完了再更新答案。
代码 https://codeforces.com/contest/4·93/submission/345962494
代码备份（上面打不开的同学看这个）
======

Input
3
1 2 3
2
5 6
Output
9:6

Input
5
6 7 8 9 10
5
1 2 3 4 5
Output
15:10
 */
