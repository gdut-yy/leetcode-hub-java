package lq231111;

import java.util.Scanner;

public class LQ231111T6 {
    static long N, K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            N = scanner.nextLong();
            K = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long left = 1;
        long right = 2 * N;

        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (calc(mid) > K) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        long n = left - 1;

        long C = K - (calc(n) - 1);
        if (n <= N) {
            return C + " " + (n + 1 - C);
        }
        return (n - N + C) + " " + (n + 1 - (n - N + C));
    }

    static long calc(long mid) {
        mid = mid - 1;
        if (mid <= N) {
            return mid + mid * (mid - 1) / 2 + 1;
        }
        return N + N * (N - 1) / 2 + ((N - 1) * (mid - N) - (mid - N) * (mid - N - 1) / 2) + 1;
    }
}
/*
鲜花之海【算法赛】

数学 + 二分
菱形数组
---
按 i+j 来分组，N=4
(1,1)
(1,2),(2,1)
(1,3),(2,2),(3,1)
(1,4),(2,3),(3,2),(4,1)
(2,4),(3,3),(4,2)
(3,4),(4,3)
(4,4)
---
求解第 k 个二元组行号：
n 为行号
n<=N 时，n + n(n-1)/2
n>N 时，N + N(N-1)/2 + (N-1)(n-N) - (n-N)(n-N-1)/2
 */
