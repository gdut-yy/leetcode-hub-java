package p2122;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF2122C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = i + 1;
        }
        Arrays.sort(a, Comparator.comparingInt(p -> p[0]));
        Arrays.sort(a, 0, n / 2, Comparator.comparingInt(p -> p[1]));
        Arrays.sort(a, n / 2, n, (p, q) -> q[1] - p[1]);
        for (int i = 0; i < n / 2; i++) {
            out.println(a[i][2] + " " + a[n / 2 + i][2]);
        }
    }
}
/*
C. Manhattan Pairs
https://codeforces.com/contest/2122/problem/C

灵茶の试炼 2026-03-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入偶数 n(2≤n≤2e5) 和 n 个二维坐标点 (x, y)，范围 [-1e6,1e6]。
这 n 个点两两一对，可以得到 n/2 个点对。
对于每个点对 ((x1, y1), (x2, y2))，计算曼哈顿距离，即 |x1 - x2| + |y1 - y2|。
你需要最大化这 n/2 个曼哈顿距离之和。
输出 n/2 行，每行两个下标，表示点对。下标从 1 到 n。

rating 1700
答案的理论上界是多少？
x 和 y 独立计算，把最大的 n/2 个 x 与最小的 n/2 个 x 相减，把最大的 n/2 个 y 与最小的 n/2 个 y 相减。
下面证明，这个上界是可以取到的。
把这 n 个点分成四类，填入四个象限：
A：(+,+)，即横坐标是前 n/2 大的 x，纵坐标是前 n/2 大的 y。
B：(-,+)，即横坐标是前 n/2 小的 x，纵坐标是前 n/2 大的 y。
C：(-,-)，即横坐标是前 n/2 小的 x，纵坐标是前 n/2 小的 y。
D：(+,-)，即横坐标是前 n/2 大的 x，纵坐标是前 n/2 小的 y。
（推荐读者把这个图画出来，方便理解下面的过程）
由于 |A| + |B| = n/2（前 n/2 大的 y），|A| + |D| = n/2（前 n/2 大的 x），所以 |A| + |B| = |A| + |D|，得 |B| = |D|，这两个集合中的点可以一一对应。
又由于 |B| + |C| = n/2（前 n/2 小的 x），所以 |A| + |B| = |B| + |C|，得 |A| = |C|，这两个集合中的点可以一一对应。
综上，我们可以把最大的 n/2 个 x 与最小的 n/2 个 x 相减，把最大的 n/2 个 y 与最小的 n/2 个 y 相减。
代码实现时，可以这样做：
设这 n 个点在数组 a 中。
把 a 按照 x 从小到大排序。
把 a 的前 n/2 个数按照 y 从小到大排序。
把 a 的后 n/2 个数按照 y 从大到小排序。
把 a[i] 和 a[n/2 + i] 配对。
由于 |C| = |A| 且 |B| = |D|，所以配对的两个点，要么一个在 C 另一个在 A（小 y 与大 y 配对），要么一个在 B 另一个在 D（大 y 与小 y 配对）。
代码 https://codeforces.com/problemset/submission/2122/365160686
代码备份（上面打不开的同学看这个）
======

Input
2
4
1 1
3 0
4 2
3 4
10
-1 -1
-1 2
-2 -2
-2 0
0 2
2 -3
-4 -4
-4 -2
0 1
-4 -2
Output
4 1
2 3
8 1
9 10
7 5
2 3
6 4
 */
