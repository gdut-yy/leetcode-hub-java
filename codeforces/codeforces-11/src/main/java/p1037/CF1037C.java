package p1037;

import java.util.Scanner;

public class CF1037C {
    static int n;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int preI = -2;
        for (int i = 0; i < n; i++) {
            if (s[i] == t[i]) continue;
            if (preI == i - 1 && s[i] != s[preI]) {
                preI = -2;
            } else {
                ans++;
                preI = i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Equalize
https://codeforces.com/contest/1037/problem/C

灵茶の试炼 2024-07-29
题目大意：
输入 n(1≤n≤1e6) 和两个长为 n 的 01 字符串 s 和 t。
有两种操作，每种操作都可以执行任意次。
1. 交换 s[i] 和 s[j]，代价为 |i-j|。
2. 翻转 s[i]，即 0 变为 1，1 变为 0，代价为 1。
输出把 s 变成 t 的最小总代价。

rating 1300
核心思路：如果 s 的两个相邻位置都要改，且 s[i-1] != s[i]，那么使用操作一互换更好，否则使用操作二翻转更好。
例如
s=000111
t=111000
s 的每个位置都需要改，其中 s[2]=0 和 s[3]=1 可以使用操作一互换，其余用操作二更好。
代码中使用 preI 表示上一个 s[i] != t[i] 的下标，初始值为 -2。
如果 preI = i-1 且 s[i] != s[preI]，那么本次操作可以免费（因为操作一可以改两个相邻位置），然后把 preI 重置为 -2。
代码 https://codeforces.com/problemset/submission/1037/272049303
======

Input
3
100
001
Output
2

Input
4
0101
0011
Output
1
 */
