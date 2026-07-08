package p1743;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1743C {
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
        String s = scanner.next();
        int ans = 0, mn = 0;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            if (s.charAt(i) == '1') {
                ans += v;
                mn = Math.min(mn, v);
                if (i == n - 1 || s.charAt(i + 1) == '0') {
                    ans -= mn;
                }
            } else if (i < n - 1 && s.charAt(i + 1) == '1') {
                ans += v;
                mn = v;
            }
        }
        out.println(ans);
    }
}
/*
C. Save the Magazines
https://codeforces.com/contest/1743/problem/C

灵茶の试炼 2026-05-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)、长为 n 的 01 字符串 s、长为 n 的数组 a(1≤a[i]≤1e4)。
有 n 个盒子，第 i 个盒子装有 a[i] 本杂志。
s[i]='1' 的盒子有盖子，s[i]='0' 的盒子没有盖子。
对于每个盖子，你可以将其移动到左侧相邻的盒子（如果有）上，或者不移动。每个盖子只能被移动一次。
输出有盖子的盒子的杂志数量之和的最大值。
押题成功！2026.6.6 双周赛第三题

rating 1100
由于盖子只能左移且只能移动一次，所以每个 0111..11 可以视作一段。
每一段恰好有一个 a[i] 不能选，其余 a[i] 全选，所以贪心地，不选最小的 a[i]。
遍历每个 0111..11 段，累加其中的 a[i]，在遍历到段的末尾时，减去其中最小的 a[i]。
代码 https://codeforces.com/problemset/submission/1743/373988022
代码备份（上面打不开的同学看这个）
======

Input
4
5
01110
10 5 8 9 6
6
011011
20 10 9 30 20 19
4
0000
100 100 100 100
4
0111
5 4 5 1
Output
27
80
0
14
 */
