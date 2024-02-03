package lq231223;

import java.util.Scanner;

public class LQ231223T4 {
    static int A, B, S, T;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        S = scanner.nextInt();
        T = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = it(T) - it(S - 1);
        return String.valueOf(ans);
    }

    static long it(int t) {
        if (t < 0) return 0;
        long res = 0;
        int p, f;
        for (int i = 1; i <= B; i++) {
            p = A / i;
            f = Math.min(i - 1, t) + 1;
            res += (long) f * p;

            p = A % i;
            res += Math.min(p, t) + 1;
            res--;
        }
        return res;
    }
}
/*
取余【算法赛】

如果暴力双重循环，复杂度为 O(AB)。无法通过此题。
考虑优化，我们枚举 b，然后分段处理 a 的值，将 a 分为 a/b 段，每段中会有 0 ~ b-1 各一个。
我们队每一段处理合法的数量，然后乘以段数。
例如，我们考虑 A = 10, B = 4, S = 1, T = 2
那么我们将 A 分为 4 段 {1,2,3} {4,5,6,7} {8,9,10}。对于取模的值为 {1,2,3} {0,1,2,3} {0,1,2}。
对于每一段求出在 [S,T] 中的个数，然后乘以段数即可。注意处理边界（第一段和最后一段）。
复杂度 O(B)。
Tips：一种更加优雅的方式为，考虑 [0,S-1] 与 [0,T] 的范围，然后相减即可。
 */