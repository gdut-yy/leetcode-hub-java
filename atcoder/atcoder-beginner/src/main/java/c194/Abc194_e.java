package c194;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc194_e {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i < m) {
                cnt[a[i]]++;
            }
        }
        int ans = 0;
        while (cnt[ans] > 0) {
            ans++;
        }
        for (int i = m; i < n; i++) {
            cnt[a[i]]++;
            int w = a[i - m];
            cnt[w]--;
            if (cnt[w] == 0 && w < ans) {
                ans = w;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Mex Min
https://atcoder.jp/contests/abc194/tasks/abc194_e

灵茶の试炼 2023-09-06
题目大意：
输入 n m(1≤m≤n≤1.5e6) 和长为 n 的数组 a(0≤a[i]<n)。
定义 mex(b) 为不在数组 b 中的最小非负整数。
遍历 a 的所有长为 m 的连续子数组 b，输出 mex(b) 的最小值。

方法一：通用的做法是值域树状数组二分。（留给大家思考）
方法二：更巧妙的做法。
提示 1：先把前 m 个数的 mex 算出来，答案至多是它。
提示 2：我们只需要知道最小的 mex 是多少，因此当一个数滑出窗口时，只要窗口内没有这个数，那么就用这个数更新答案的最小值。
https://atcoder.jp/contests/abc194/submissions/45036824
======

Input 1
3 2
0 0 1
Output 1
1

Input 2
3 2
1 1 1
Output 2
0

Input 3
3 2
0 1 0
Output 3
2

Input 4
7 3
0 0 1 2 0 1 0
Output 4
2
 */