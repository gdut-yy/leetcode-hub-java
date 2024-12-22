package p1227;

import java.util.Arrays;
import java.util.Scanner;

public class CF1227G {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = i;
        }
        System.out.println(solve());
    }

    // https://codeforces.com/contest/1261/submission/107536774
    private static String solve() {
        Arrays.sort(a, 1, n + 1, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int[][] ans = new int[n + 2][n + 1];
        for (int i = 1; i <= n; ++i) {
            int x = a[i][0];
            for (int j = i; j <= n + 1; ++j) {
                ans[j][a[i][1]] = (x > 0) ? 1 : 0;
                --x;
            }
            for (int j = 1; j < i; ++j) {
                ans[j][a[i][1]] = (x > 0) ? 1 : 0;
                --x;
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(n + 1).append(System.lineSeparator());
        for (int i = 1; i <= n + 1; ++i) {
            for (int j = 1; j <= n; ++j) {
                output.append(ans[i][j]);
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
/*
G. Not Same
https://codeforces.com/contest/1227/problem/G

灵茶の试炼 2024-08-23
题目大意：
输入 n(1≤n≤1e3) 和长为 n 的数组 a(1≤a[i]≤n)。
你需要执行如下操作至多 n+1 次：
选择 a 的一个子序列，把子序列中的元素全部减一。
假设你操作了 k 次，这 k 个子序列，对应的下标集合必须互不相同。
你需要把所有 a[i] 都变成 0。
输出操作次数，和具体操作方案。
用长为 n 的 01 字符串 s 表示具体操作方案，s[i]=1 表示 a[i] 在子序列中。

rating 2600
由于已经有写得很好的题解了，我就不重复造轮子了。
题解 https://www.luogu.com.cn/article/hin4feij
======

Input
5
5 5 5 5 5
Output
6
11111
01111
10111
11011
11101
11110

Input
5
5 1 1 1 1
Output
5
11000
10000
10100
10010
10001

Input
5
4 1 5 3 4
Output
5
11111
10111
10101
00111
10100
 */
