package p1165;

import java.util.Arrays;
import java.util.Scanner;

public class CF1165E {
    static int n;
    static long[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MOD = 998244353;

    private static String solve() {
        for (int i = 0; i < n; i++) {
            a[i] *= (long) (n - i) * (i + 1);
        }
        reverseSort(a);
        Arrays.sort(b);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + a[i] % MOD * b[i]) % MOD;
        }
        return String.valueOf(ans);
    }

    static void reverseSort(long[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            long tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
E. Two Arrays and Sum of Functions
https://codeforces.com/contest/1165/problem/E

灵茶の试炼 2024-05-15
题目大意：
输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b，元素范围在 [1,1e6]。
定义 c[i] = a[i] * b[i]。
定义 S 为 c 的所有非空连续子数组的元素和的和。
你可以重排数组 b。
输出 S 的最小值，模 998244353。
注意，你需要最小化的是 S，然后再取模，不是最小化取模后的值。
变形：改成一棵树，a[i] 为点权，定义 S 为所有简单路径点权和的和。

rating 1600
贡献法。
对于 a[i] 来说（i 从 0 开始），它左边有 i+1 个子数组左端点，右边有 n-i 个子数组右端点。
根据乘法原理，a[i] 在 (i+1) * (n-i) 个子数组中。
那么把 a[i] *= (i+1) * (n-i)，然后从大到小排序。
b 从小到大排序。
根据排序不等式，sum(a[i] * b[i]) 是所有排列中最小的。
请使用 64 位整数计算。
注意 a[i] *= (i+1) * (n-i) 后会变的很大，在计算 sum 时，要对 a[i] 取模（先排序，再取模）。
https://codeforces.com/contest/1165/submission/260005400
======

Input
5
1 8 7 2 4
9 7 2 9 3
Output
646

Input
1
1000000
1000000
Output
757402647

Input
2
1 3
4 2
Output
20
 */
