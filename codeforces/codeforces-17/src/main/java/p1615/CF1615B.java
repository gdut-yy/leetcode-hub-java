package p1615;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1615B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(solve(l, r));
        }
    }

    static int L = 1;
    static int R = 200000;
    // 2^18 = 262144 > 2*10^5
    static int K = 18;
    static int[][] preBitwiseSum;


    private static String solve(int l, int r) {
        // "前缀和"
        if (preBitwiseSum == null) {
            preBitwiseSum = new int[R + 2][K + 1];
            for (int i = L; i <= R; i++) {
                for (int k = 0; k <= K; k++) {
                    preBitwiseSum[i + 1][k] = preBitwiseSum[i][k];
                    if (((i >> k) & 1) == 1) {
                        preBitwiseSum[i + 1][k] += 1;
                    }
                }
            }
        }
        // 2^18 = 262144
        int[] cntBit = new int[K + 1];
        for (int k = 0; k <= K; k++) {
            cntBit[k] = preBitwiseSum[r + 1][k] - preBitwiseSum[l][k];
        }
//        for (int i = l; i <= r; i++) {
//            for (int k = 0; k < 19; k++) {
//                if (((i >> k) & 1) == 1) {
//                    cntBit[k]++;
//                }
//            }
//        }
        int n = r - l + 1;
        int max = 0;
        for (int k = 0; k <= K; k++) {
            max = Math.max(max, cntBit[k]);
        }
        return String.valueOf(n - max);
    }
}
/*
B. And It's Non-Zero
https://codeforces.com/contest/1615/problem/B

题目大意：
给出整数 l,r。表示 [l,r] 的整数，求要使数组的按位与非零，能删除的最小元素数是多少？

贪心。按位与非零，则至少保证二进制某一位全为 1，总数减去二进制位最多 1 的数量即可。
由于 1 <= t <= 10^4, 1 <= l <= r <= 2*10^5, 直接暴力会 TLE。需要用 "前缀和" 思想进行预处理优化。
======

input
5
1 2
2 8
4 5
1 5
100000 200000

output
1
3
0
2
31072
 */