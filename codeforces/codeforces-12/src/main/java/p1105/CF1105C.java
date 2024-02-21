package p1105;

import java.util.Scanner;

public class CF1105C {
    static int n, l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        l--;
        long[] c = {r / 3 - l / 3, (r + 2) / 3 - (l + 2) / 3, (r + 1) / 3 - (l + 1) / 3};
        long[] f = {1, 0, 0};
        while (n-- > 0) {
            f = new long[]{
                    (f[0] * c[0] + f[1] * c[2] + f[2] * c[1]) % MOD,
                    (f[0] * c[1] + f[1] * c[0] + f[2] * c[2]) % MOD,
                    (f[0] * c[2] + f[1] * c[1] + f[2] * c[0]) % MOD,
            };
        }
        return String.valueOf(f[0]);
    }
}
/*
C. Ayoub and Lost Array
https://codeforces.com/contest/1105/problem/C

灵茶の试炼 2022-07-06
题目大意：
输入正整数 n(<=2e5)，l 和 r(1<=l<=r<=1e9)。
求有多少个不同的长为 n 的数组，数组元素值的范围为 [l,r]，且数组元素之和为 3 的倍数。
答案对 1e9+7 取模。

rating 1500
https://codeforces.com/problemset/submission/1105/162950964
定义 f[i][0/1/2] 表示长为 i，元素和为 0/1/2 的数组个数。
枚举第 i 个数所填的数字模 3 的结果，那么 f[i][0] = f[i-1][0]*c[0] + f[i-1][1]*c[2] + f[i-1][2]*c[1]，其余同理。
其中 c[0/1/2] 为 [l,r] 内模 3 余 0/1/2 的数字个数，计算这个可以考虑用 [0,r] 范围内的减去 [0,l-1] 范围内的。
进阶：实现 O(log n) 的做法。
======

input
2 1 3
output
3

input
3 2 2
output
1

input
9 9 99
output
711426616
 */
