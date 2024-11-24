package p1267;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1267L {
    static int n, m, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(s);

        int p = 0, i0 = 0;
        char[][] ans = new char[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = i0; i < k; i++) { // 第 j 列从第 i0 行开始填
                ans[i][j] = s[p];
                if (i > i0 && s[p] != s[p - 1]) {
                    i0 = i;
                }
                p++;
            }
        }

        for (char[] t : ans) {
            for (int j = 0; j < m; j++) {
                if (t[j] == 0) { // 剩余没填的字母
                    t[j] = s[p];
                    p++;
                }
            }
        }

        return Arrays.stream(ans).map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
L. Lexicography
https://codeforces.com/contest/1267/problem/L

灵茶の试炼 2024-02-15
题目大意：
输入 n(1≤n≤1000) m(1≤m≤1000) k(1≤k≤n) 和 nm 个小写字母。
用这 nm 个字母，构造 n 个长为 m 的字符串，这 n 个字符串需要按照字典序从小到大排列。
最小化第 k 个字符串的字典序。
输出这 n 个字符串。

rating 1800
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1267l
======

input
3 2 2
abcdef
output
af
bc
ed

input
2 3 1
abcabc
output
aab
bcc
 */
