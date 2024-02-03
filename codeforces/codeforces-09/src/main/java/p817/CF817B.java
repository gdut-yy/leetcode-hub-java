package p817;

import java.util.Arrays;
import java.util.Scanner;

public class CF817B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        // C_{r}^{n}
        int r0 = 0, n0 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == a[2]) {
                r0++;
                if (i < 3) n0++;
            }
        }

        long ans = comb(r0, n0);
        return String.valueOf(ans);
    }

    static long comb(int r, int n) {
        n = Math.min(r - n, n);
        if (n == 0) return 1;
        long res = 1;
        for (int i = 0; i < n; i++) res *= r - i;
        for (int i = 1; i <= n; i++) res /= i;
        return res;
    }
}
/*
B. Makes And The Product
https://codeforces.com/contest/817/problem/B

灵茶の试炼 2023-12-26
题目大意：
输入 n(3≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出使 a[i]*a[j]*a[k] 最小且 i<j<k 的 (i,j,k) 三元组个数。
进阶：如果有负数要怎么做？

rating 1500
统计每个数的出现次数：
把最小的数的出现次数记作 c0，次小的数的出现次数记作 c1，第三小的数的出现次数记作 c2。
1. 如果 c0 >= 3，那么答案 = C(c0,3) = c0*(c0-1)*(c0-2)/6
2. 如果 c0 = 2，那么答案 = c1
3. 如果 c0 = 1 且 c1 >= 2，那么答案 = C(c1,2) = c1*(c1-1)
4. 否则答案 = c2
https://codeforces.com/contest/817/submission/238896643
======

input
4
1 1 1 1
output
4

input
5
1 3 2 3 4
output
2

input
6
1 3 3 1 3 2
output
1
 */
