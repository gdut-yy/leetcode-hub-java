package p2000;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2000D {
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
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = scanner.nextInt();
            sum[i] += sum[i - 1];
        }

        String s = scanner.next();
        long ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) != 'L') {
                l++;
            } else if (s.charAt(r) != 'R') {
                r--;
            } else {
                ans += sum[r + 1] - sum[l];
                l++;
                r--;
            }
        }
        out.println(ans);
    }
}
/*
D. Right Left Wrong
https://codeforces.com/contest/2000/problem/D

灵茶の试炼 2025-11-10
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5)，长为 n 的数组 a(1≤a[i]≤1e5)，长为 n 的字符串 s，只包含大写字母 'L' 和 'R'。
每次操作：
选择 a 的一个子数组 [i,j]，满足 s[i] = 'L' 且 s[j] = 'R'。
获得等于子数组 [i,j] 的元素和的分数。
把 s 的子串 [i,j] 中的字符全部改成 '.'。
输出总得分的最大值。

rating 1200
提示：倒着思考，最后一步选的区间是什么？
根据题意，选了区间 [L,R] 后，不能再从 [L,R] 中选择下标作为区间端点。
所以所选区间要么完全无交集，要么一个区间完全包含另一个区间。
一个区间完全包含另一个区间的选法是更优的，这可以让中间的元素被多次选中。
倒着思考，像剥洋葱那样，先选最左边的 L 和最右边的 R 组成的区间，然后再选更内部的，依此类推。
代码 https://codeforces.com/problemset/submission/2000/347638137
代码备份（上面打不开的同学看这个）
======

Input
4
6
3 5 1 4 3 2
LRLLLR
2
2 8
LR
2
3 9
RL
5
1 2 3 4 5
LRLRR
Output
18
10
0
22
 */
