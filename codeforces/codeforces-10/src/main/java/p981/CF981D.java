package p981;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF981D {
    static int n, k;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }

        long ans = 0;
        // for i := bits.Len64(uint64(sum[n])) - 1; i >= 0; i-- {
        for (int i = Long.toBinaryString(sum[n]).length() - 1; i >= 0; i--) {
            long bit = 1L << i;
            long target = ans | bit;
            boolean[] f = new boolean[n + 1];
            f[0] = true;
            for (int j = 0; j < k; j++) {
                for (int r = n; r > 0; r--) {
                    f[r] = false;
                    for (int l = 0; l < r; l++) {
                        if (f[l] && ((sum[r] - sum[l]) & target) == target) {
                            f[r] = true;
                            break;
                        }
                    }
                }
                f[0] = false;
            }
            if (f[n]) {
                ans = target;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Bookshelves
https://codeforces.com/contest/981/problem/D

灵茶の试炼 2023-07-13
题目大意：
输入 n k(1≤k≤n≤50) 和长为 n 的数组 a(0<a[i]<2^50)。
把 a 划分成恰好 k 个非空连续子数组。
把第 i 个子数组记作 b[i]。
最大化 sum(b[0]) AND sum(b[1]) AND ... AND sum(b[k-1])。
这里 AND 表示按位与。

https://codeforces.com/contest/981/submission/213277313
涉及到二进制的题目，其中一种思路是拆位。
设最高位为 m。
第 m 位能不能是 1？如果能，那么答案至少是 1<<m。
怎么判断？标准的划分型 DP，定义 f[i][r] 表示 a[0] 到 a[r-1] 能否分成 i 段，且每一段的第 m 位都是 1。
设 target = 1<<m，有
f[i][r] |= f[i-1][l] && ((sum[r] - sum[l]) & target) == target
其中 sum[0] = 0, sum[i] = a[0] + ... + a[i-1]
初始值 f[0][0] = true，如果最后 f[k][n] = true 则说明第 m 位可以是 1。
然后继续判断，第 m-1 位能不能是 1？第 m-2 位能不能是 1？……
注意如果第 m 位是 1，那么在判断其余位的时候，要带着第 m 位是 1 一块判断。
======

input
10 4
9 14 28 1 7 13 15 29 2 31
output
24

input
7 3
3 14 15 92 65 35 89
output
64
 */
