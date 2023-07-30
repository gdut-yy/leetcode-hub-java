package p414;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF414B {
    static int u, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        u = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int[] f = new int[u + 1];
        f[1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = u; j > 0; j--) {
                for (int k = j * 2; k <= u; k += j) {
                    f[k] = (f[k] + f[j]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int v : f) {
            ans = (ans + v) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
B. Mashmokh and ACM
https://codeforces.com/contest/414/problem/B

灵茶の试炼 2023-06-05
題目大意：
输入 u n(1≤u,n≤2000)。
输出有多少个长为 n 的数组 a，满足：
1. 1≤a[1]≤a[2]≤...≤a[n]≤u。
2. a[i] 整除 a[i+1]（或者说 a[i] 是 a[i+1] 的因子）。
答案模 1e9+7。

https://codeforces.com/contest/414/submission/208165638
枚举 a[1]，那么 a[2] 只能是 a[1] 的倍数，依此类推。
比如 1,3,6 或者 2,2,6。有多种方式可以到达同一个数字 6，说明可以用动态规划优化。
定义 f[i][j] 表示前 i 个数，末尾为 j 的方案数。
枚举因子效率有点差，不妨改为枚举倍数。
那么 f[i][k] += f[i-1][j]，这里 k 为 j 的倍数。
f[1][i] = 1。
答案为 sum(f[n][i])。
时间复杂度 O(nulogu)。
======

input
3 2
output
5

input
6 4
output
39

input
2 1
output
2
 */
