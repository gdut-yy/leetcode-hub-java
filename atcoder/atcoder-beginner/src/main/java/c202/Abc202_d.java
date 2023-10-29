package c202;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc202_d {
    static int a, b;
    static long k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextLong();
        System.out.println(solve());
    }

    private static final int mx = 61;
    private static final long[][] C = new long[mx][mx];

    static {
        for (int i = 0; i < mx; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    private static String solve() {
        char[] ans = new char[a + b];
        Arrays.fill(ans, 'a');
        for (int i = 0; i < ans.length; i++) {
            if (k > C[a + b - 1][b]) {
                k -= C[a + b - 1][b];
                ans[i] = 'b';
                b--;
            } else {
                a--;
            }
        }
        return new String(ans);
    }
}
/*
D - aab aba baa
https://atcoder.jp/contests/abc202/tasks/abc202_d

灵茶の试炼 2023-09-26
题目大意：
输入 A B(1≤A,B≤30) K。
在所有由恰好 A 个 'a' 和恰好 B 个 'b' 组成的字符串中，输出字典序第 K 小的字符串。
例如 K=1 表示字典序最小的字符串。
K 的范围保证有解。

如果第一个字母是 'b'，那么 K 至少要是多少？
=> 第一个字母填 'a' 一共有多少种方案？
=> C(a+b-1, b)
=> 如果 K > C(a+b-1, b)，那么第一个字母一定是 'b'
依此类推。
https://atcoder.jp/contests/abc202/submissions/45501705
======

Input 1
2 2 4
Output 1
baab

Input 2
30 30 118264581564861424
Output 2
bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */