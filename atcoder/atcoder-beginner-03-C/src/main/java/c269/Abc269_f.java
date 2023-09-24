package c269;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc269_f {
    static int n, m, q;
    static int[][] r1r2c1c2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        r1r2c1c2 = new int[q][4];
        for (int i = 0; i < q; i++) {
            r1r2c1c2[i][0] = scanner.nextInt();
            r1r2c1c2[i][1] = scanner.nextInt();
            r1r2c1c2[i][2] = scanner.nextInt();
            r1r2c1c2[i][3] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int mod = 998244353;
    private static final int mod2 = (mod + 1) / 2;

    private static String solve() {
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int r1 = r1r2c1c2[i][0];
            int r2 = r1r2c1c2[i][1];
            int c1 = r1r2c1c2[i][2];
            int c2 = r1r2c1c2[i][3];
            long res = f(r2, c2) - f(r2, c1 - 1) - f(r1 - 1, c2) + f(r1 - 1, c1 - 1);
            ans[i] = (res % mod + mod) * mod2 % mod;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static long f(long x, long y) {
        long s = (y + y % 2 + ((x - 1) & ~1) * m) % mod * ((y + 1) / 2) % mod * ((x + 1) / 2);
        long s2 = ((y & ~1) + 2 + (x & ~1) * m) % mod * (y / 2) % mod * (x / 2);
        return s + s2;
    }
}
/*
F - Numbered Checker
https://atcoder.jp/contests/abc269/tasks/abc269_f

灵茶の试炼 2022-12-26
题目大意：
输入 n m (≤1e9) q(≤2e5)。表示一个 n 行 m 列的矩阵。
第 i 行第 j 列的元素为 (i-1)*m+j，但是如果 i+j 是奇数，则该元素为 0。
输入 q 个询问，每个询问输入 r1 r2 c1 c2。
对每个询问，输出所有在第 r1~r2 行 c1~c2 列的元素之和，模 998244353。

https://atcoder.jp/contests/abc269/submissions/37478697
用二维前缀和简化计算。
推公式。
======

Input 1
5 4
6
1 3 2 4
1 5 1 1
5 5 1 4
4 4 2 2
5 5 4 4
1 5 1 4
Output 1
28
27
36
14
0
104

Input 2
1000000000 1000000000
3
1000000000 1000000000 1000000000 1000000000
165997482 306594988 719483261 992306147
1 1000000000 1 1000000000
Output 2
716070898
240994972
536839100

Input 3
999999999 999999999
3
999999999 999999999 999999999 999999999
216499784 840031647 84657913 415448790
1 999999999 1 999999999
Output 3
712559605
648737448
540261130
 */