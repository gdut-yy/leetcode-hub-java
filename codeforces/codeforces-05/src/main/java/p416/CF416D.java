package p416;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF416D {
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
            a[i] = scanner.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; ) {
            ans++;
            int st = i;
            long x0 = -1, y0 = -1;
            long k = (long) 2e9;
            long expY = 0;
            for (; i < n; i++) {
                int y = a[i];
                expY += k;
                if (k < 2e9) {
                    if (expY < 1 || y > 0 && y != expY) {
                        break;
                    }
                    continue;
                }
                if (y < 0) {
                    continue;
                }
                if (x0 < 0) {
                    x0 = i;
                    y0 = y;
                    continue;
                }
                long dx = i - x0, dy = y - y0;
                k = dy / dx;
                if (dy % dx != 0 || y - (i - st) * k < 1) {
                    break;
                }
                expY = y;
            }
        }
        out.println(ans);
    }
}
/*
D. Population Size
https://codeforces.com/contest/416/problem/D

灵茶の试炼 2025-07-03
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a，其中 a[i] 要么是 -1，要么在 [1,1e9] 中。
你需要把 a 中的每个 -1 分别替换成任意正整数。
替换后，把 a 分割成若干连续段，要求每一段都是等差数列。
注：长为 1 的段一定是等差数列。
输出最少分多少段。

rating 2400
非常适合分组循环的一题。用分组循环写，这题思维难度会小很多。
（分组循环的讲解和题目见 题单 第六章）
问题相当于给你坐标系上的一些点 (i, a[i])，用最少的直线经过这些点。
a[i]=-1 可以理解成，横坐标（下标）为整数时，纵坐标必须是正整数。纵坐标不能 <= 0，也不能是小数。
分组循环的每一段如何处理？
首先记录段的开始位置 st。
不断往后找：
1. 找到第一个点，记录下来。
2. 找到第二个点，判断：
2.1. 与第一个点连线的斜率 k 必须是整数。如果不是整数，则中间的点会存在小数。
2.2. 连线延伸到开始位置 st，对应的纵坐标必须 > 0。
如果不满足 2.1 或者 2.2，则退出内层循环。当前点 (i, a[i]) 作为下一段的第一个点。（之前的 -1 全部变成第一个点的纵坐标）
3. 后续判断，只需比较目标值 expY 与实际值 y=a[i] 是否相等。目标值 expY 可以从第二个点的纵坐标开始，每次循环增加 k。
注意，如果目标值 <= 0，则退出内层循环。
注意用 long long。
代码 https://codeforces.com/problemset/submission/416/325952366
代码备份（Ubuntu Pastebin）
======

Input
9
8 6 4 2 1 4 7 10 2
Output
3

Input
9
-1 6 -1 2 -1 4 7 -1 2
Output
3

Input
5
-1 -1 -1 -1 -1
Output
1

Input
7
-1 -1 4 5 1 2 3
Output
2
 */
