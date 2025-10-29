package p2052;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2052F {
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
        char[] s = scanner.next().toCharArray();
        char[] t = scanner.next().toCharArray();

        int[][] f = new int[n + 1][3];
        f[0][0] = 1;
        for (int i = 0; i < s.length; i++) {
            char v = s[i];
            char w = t[i];
            if (v == '.' && w == '.') {
                f[i + 1][0] = f[i][0];
                if (i > 0 && s[i - 1] == '.' && t[i - 1] == '.') {
                    f[i + 1][0] = Math.min(f[i + 1][0] + f[i - 1][0], 2);
                }
                f[i + 1][1] = f[i][2];
                f[i + 1][2] = f[i][1];
            } else if (v == '.' && w == '#') {
                f[i + 1][0] = f[i][1];
                f[i + 1][1] = f[i][0];
            } else if (v == '#' && w == '.') {
                f[i + 1][0] = f[i][2];
                f[i + 1][2] = f[i][0];
            } else {
                f[i + 1][0] = f[i][0];
            }
        }
        String[] ans = {"None", "Unique", "Multiple"};
        out.println(ans[f[n][0]]);
    }
}
/*
F. Fix Flooded Floor
https://codeforces.com/contest/2052/problem/F

灵茶の试炼 2025-07-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 2 行 n 列的网格图，只包含点号和 # 号。
你需要用 1x2 的木板，把网格图中的点号全部铺满，木板不能重叠，不能覆盖在 # 号上。
有多少种铺设方案？
如果方案数为 0，输出 None。
如果方案数为 1，输出 Unique。
如果方案数大于 1，输出 Multiple。

rating 1700
状态机 DP。
f[i][0/1/2] 表示修复前 i 列的木板，前 i-1 列已修复，第 i 列的木板为 0=已修复，1=第一行未修复第二行修复，2=第一行修复第二行未修复。
转移方程见代码。
初始值 f[0][0]=1，空视作已修复。
答案为 f[n][0]。0=None，1=Unique，2=Multiple。
代码 https://codeforces.com/contest/2052/submission/331028665
代码备份（Ubuntu Pastebin）
======

Input
4
10
#.......##
##..#.##..
6
...#..
..#...
8
........
........
3
###
###
Output
Unique
None
Multiple
Unique
 */
