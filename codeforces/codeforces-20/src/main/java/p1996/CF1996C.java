package p1996;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1996C {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static char[] s, t;

    public static void main(String[] args) {
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[][] sum = new int[n + 1][26];
        for (int i = 0; i < s.length; i++) {
            char b = s[i];
            sum[i + 1] = sum[i].clone();
            sum[i + 1][b - 'a']++;
            sum[i + 1][t[i] - 'a']--;
        }


        long[] ans = new long[q];
        for (int qi = 0; qi < q; qi++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long res = 0;
            for (int i = 0; i < 26; i++) {
                res += Math.abs(sum[r][i] - sum[l - 1][i]);
            }
            ans[qi] = res / 2;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C. Sort
https://codeforces.com/contest/1996/problem/C

灵茶の试炼 2025-02-03
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)，q(1≤q≤2e5)，长为 n 的字符串 s，长为 n 的字符串 t，都只包含小写英文字母。
然后输入 q 个询问，每个询问输入两个数 L 和 R，表示下标从 L 到 R 的子串 (1≤L≤R≤n) s[L..R] 和 t[L..R]。
对于每个询问，你可以修改 s[L..R] 中的若干字母，使得 s[L..R] 和 t[L..R] 排序后相等。
输出最小修改次数。
注意：每个询问互相独立。
进阶：值域更大的情况  https://atcoder.jp/contests/abc367/tasks/abc367_f

rating 1200
问题相当于计算这两个子串每种字母个数之差的总和。
由于一次操作可以把 s 中的多余字母变成 t 中的缺失字母，所以总和除以 2 便是答案。
字母个数之差可以用前缀和处理。
代码 https://codeforces.com/contest/1996/submission/301038022
代码备份（洛谷）
======

Input
3
5 3
abcde
edcba
1 5
1 4
3 3
4 2
zzde
azbe
1 3
1 4
6 3
uwuwuw
wuwuwu
2 4
1 3
1 6
Output
0
1
0
2
2
1
1
0
 */
