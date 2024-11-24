package p1365;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CF1365C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[n];
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[a[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            int p = pos[b[i]];
            if (p < i) {
                p += n;
            }
            cnt[p - i]++;
        }
        int ans = Arrays.stream(cnt).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
C. Rotation Matching
https://codeforces.com/contest/1365/problem/C

灵茶の试炼 2024-04-29
题目大意：
输入 n(1≤n≤2e5) 和两个 1~n 的排列 a b。
你可以对 a 或 b 执行任意次循环右移或循环左移。
输出操作后，最多有多少个 a[i] = b[i]。
注：把 [1,2,3,4] 循环右移一次，得 [4,1,2,3]。

rating 1400
循环左移 1 次相当于循环右移 n-1 次，所以只用考虑把排列 b 循环右移。
对于一个数 v，设其在 a b 中的下标分别为 i 和 j。
如果 i > j，那么 b 循环右移 i-j 次就可以让两个 v 对齐。
如果 i < j，那么 b 循环右移 i-j+n 次就可以让两个 v 对齐。
对于 1~n 中的每个数，统计需要循环右移多少次，统计次数的个数，记到 cnt 数组中。
答案即 max(cnt)。
https://codeforces.com/contest/1365/submission/258625382
======

Input
5
1 2 3 4 5
2 3 4 5 1
Output
5

Input
5
5 4 3 2 1
1 2 3 4 5
Output
1

Input
4
1 3 2 4
4 2 3 1
Output
2
 */
