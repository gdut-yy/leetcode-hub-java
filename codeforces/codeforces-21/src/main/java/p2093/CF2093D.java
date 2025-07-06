package p2093;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2093D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            long x = scanner.nextLong() - 1;
            if ("->".equals(op)) {
                int y = scanner.nextInt() - 1;

                long ans = 1;
                int u = 0, d = 1 << n, l = 0, r = 1 << n;
                for (long s = 1L << (n * 2 - 2); s > 0; s >>= 2) {
                    int xm = (u + d) / 2, ym = (l + r) / 2;
                    if (x < xm && y < ym) {
                        d = xm;
                        r = ym;
                    } else if (x >= xm && y >= ym) {
                        ans += s;
                        u = xm;
                        l = ym;
                    } else if (x >= xm && y < ym) {
                        ans += s * 2;
                        u = xm;
                        r = ym;
                    } else {
                        ans += s * 3;
                        d = xm;
                        l = ym;
                    }
                }
                out.println(ans);
            } else {
                int u = 0, d = 1 << n, l = 0, r = 1 << n;
                for (long s = 1L << (n * 2 - 2); s > 0; s >>= 2) {
                    int xm = (u + d) / 2, ym = (l + r) / 2;
                    if (x < s) {
                        d = xm;
                        r = ym;
                    } else if (x < s * 2) {
                        x -= s;
                        u = xm;
                        l = ym;
                    } else if (x < s * 3) {
                        x -= s * 2;
                        u = xm;
                        r = ym;
                    } else {
                        x -= s * 3;
                        d = xm;
                        l = ym;
                    }
                }
                out.println((u + 1) + " " + (l + 1));
            }
        }
    }
}
/*
D. Skibidi Table
https://codeforces.com/contest/2093/problem/D

灵茶の试炼 2025-05-06
题目大意：
输入 T(≤10) 表示 T 组数据。所有数据的 q 之和 ≤2e4。
每组数据输入 n(1≤n≤30)。
同 周赛第二题，你需要在一个 2^n * 2^n 大小的网格中填数字，顺序是左上 - 右下 - 左下 - 右上。
输入 q(1≤q≤2e4) 和 q 个询问，格式如下：
"-> x y"：输出 x 行 y 列所填数字是多少。
"<- d"：输出数字 d 所在行列编号。
行列编号从 1 开始，所填数字从 1 开始。

rating 1400
先把周赛那题做了。
方法一：沿用周赛的思路，迭代做法 https://codeforces.com/contest/2093/submission/318444945
方法二：位运算 https://codeforces.com/contest/2093/submission/318446885
方法三：更紧凑的位运算 https://codeforces.com/contest/2093/submission/318447849
代码备份（洛谷）三合一 https://www.luogu.com.cn/paste/gde5b9ci
相似题目: 3537. 填充特殊网格
https://leetcode.cn/problems/fill-a-speci al-grid/description/
======

Input
2
2
5
-> 4 3
<- 15
<- 4
-> 3 1
-> 1 3
1
8
-> 1 1
-> 1 2
-> 2 1
-> 2 2
<- 1
<- 2
<- 3
<- 4
Output
7
2 3
1 2
9
13
1
4
3
2
1 1
2 2
2 1
1 2
 */
