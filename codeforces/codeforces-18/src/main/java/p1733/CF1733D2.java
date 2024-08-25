package p1733;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1733D2 {
    static int n, x, y;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[i] != t[i]) {
                a.add(i);
            }
        }
        int m = a.size();
        if (m % 2 == 1) {
            return "-1";
        }

        long ans;
        if (m == 0 || y <= x) {
            if (m == 2 && a.get(0) + 1 == a.get(1)) {
                ans = Math.min(y * 2L, x);
            } else {
                ans = m / 2L * y;
            }
        } else {
            long f = 0, g = y;
            for (int i = 1; i < m; i++) {
                long _f = f;
                f = g;
                g = Math.min(g + y, _f + (a.get(i) - a.get(i - 1)) * 2L * x);
            }
            ans = g / 2;
        }
        return String.valueOf(ans);
    }
}
/*
D2. Zero-One (Hard Version)
https://codeforces.com/contest/1733/problem/D2

灵茶の试炼 2023-01-04
题目大意：
输入 t(≤1000) 表示 t 组数据，每组数据输入 n(5≤n≤5000) x y(1~1e9) 和两个长为 n 的二进制数 s 和 t。
所有数据的 n 之和不超过 5000。
每次操作你可以把 s 的两个比特位翻转（0 变 1，1 变 0），如果两个比特位相邻，则代价为 x，否则为 y。
输出把 s 变成 t 的最小代价，如果无法做到，输出 -1。
进阶：你能做到 O(n) 时间复杂度吗？
相似题目: 2896. 执行操作使两个字符串相等
https://leetcode.cn/problems/apply-operations-to-make-two-strings-equal/description/

rating 2000
O(n)：https://codeforces.com/problemset/submission/1733/187727396
空间优化：https://codeforces.com/problemset/submission/1733/187727663
我的题解，欢迎点赞：https://www.luogu.com.cn/blog/endlesscheng/solution-cf1733d2
======

input
6
5 8 9
01001
00101
6 2 11
000001
100000
5 7 2
01000
11011
7 8 3
0111001
0100001
6 3 4
010001
101000
5 10 1
01100
01100
output
8
10
-1
6
7
0
 */
