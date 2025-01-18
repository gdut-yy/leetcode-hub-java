package p213;

import java.util.Arrays;
import java.util.Scanner;

public class CF213B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);
    static final int mx = 101;
    static final long[][] C;

    static {
        C = new long[mx][mx];
        for (int i = 0; i < mx; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
    }

    static long[][] memo;

    private static String solve() {
        memo = new long[n + 1][10];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dfs(i, 0);
        }
        return String.valueOf(ans % MOD);
    }

    static long dfs(int i, int j) {
        if (j == 9) {
            if (i < a[9]) {
                return 0;
            }
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int i2 = i;
        if (j == 0) {
            i2--;
        }
        long res = 0;
        for (int k = a[j]; k <= i; k++) {
            res = (res + dfs(i - k, j + 1) * C[i2][k]) % MOD;
        }
        return memo[i][j] = res;
    }
}
/*
B. Numbers
https://codeforces.com/contest/213/problem/B

灵茶の试炼 2024-09-05
题目大意：
输入 n(1≤n≤100) 和长为 10 的数组 a(0≤a[i]≤100)。
有多少个长度为至多为 n 的正整数，无前导零，且数字 0~9 分别至少出现 a[0],a[1],...,a[9] 次？
答案模 1e9+7。

rating 1900
假设构造的数字长度为 10。
考虑以下两种填法：
从 10 个位置选 2 个位置填 1，然后从剩下 8 个位置选 3 个位置填 2，此时还剩下 5 个位置可以填数字。
从 10 个位置选 3 个位置填 1，然后从剩下 7 个位置选 2 个位置填 2，此时还剩下 5 个位置可以填数字。
对于剩下的位置来说，我们并不关心之前填的数字具体是怎么填的。
这样就找到了重叠子问题，可以用 DP 解决。
定义 dfs(i,j) 表示现在还有 i 个位置是空的（可以填数字），还剩下 j,j+1,...,9 这些数字没有填，这种情况下的方案数。
枚举填 k=a[j],a[j]+1,...,i 个 j。
如果 j>0，有 C(i,k) 种填法。
如果 j=0，由于不能有前导零，有 C(i-1,k) 种填法。
所以 dfs(i,j) = ∑dfs(i-k,j+1) * C(i-[j==0],k)，其中 k=a[j],a[j]+1,...,i。
递归边界：dfs(i,9) = [i>=a[9]]。
答案：dfs(1,0) + dfs(2,0) + ... + dfs(n,0)。注意题目是长度【至多】为 n。
记忆化搜索 https://codeforces.com/problemset/submission/213/279781360
递推（空间压缩） https://codeforces.com/problemset/submission/213/279782166
======

Input
1
0 0 0 0 0 0 0 0 0 1
Output
1

Input
2
1 1 0 0 0 0 0 0 0 0
Output
1

Input
3
1 1 0 0 0 0 0 0 0 0
Output
36
 */
