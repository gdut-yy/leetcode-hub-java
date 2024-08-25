package p480;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF480C {
    static int n, a, b, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        if (a > b) {
            a = n + 1 - a;
            b = n + 1 - b;
        }
        int[] f = new int[b];
        f[a] = 1;
        int[] s = new int[b + 1];
        while (k > 0) {
            for (int i = 0; i < b; i++) {
                s[i + 1] = (s[i] + f[i]) % MOD;
            }
            for (int y = 1; y < b; y++) {
                f[y] = (s[y + (b - y - 1) / 2 + 1] - f[y]) % MOD;
            }
            k--;
        }

        long ans = 0;
        for (int v : f) {
            ans += v;
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
C. Riding in a Lift
https://codeforces.com/contest/480/problem/C

灵茶の试炼 2023-06-08
題目大意：
输入整数 n a b k (2≤n≤5000, 1≤k≤5000, 1≤a,b≤n, a≠b)。
你需要从数轴上的 a 出发，移动恰好 k 次。
从整数 x 移动到整数 y，必须满足以下所有要求：
1. 1≤y≤n
2. y≠x
3. y≠b
4. |x-y|<|x-b|
输出不同移动方案的个数，模 1e9+7。

rating 1900
https://codeforces.com/contest/479/submission/208670481
前缀和优化 DP。
为方便计算，如果 a>b，根据对称性调整为 a=n+1-a，b=n+1-b。这样可以保证 a<b。
定义 f[i][j] 表示 i 次移动后，移动到 j 的方案数。f[0][a] = 1。1≤j<b。
考虑从位置 x 转移过来：
如果 x<j，可以移动到 j。
如果 x>j，根据要求 4，解不等式得 x≤j+floor((b-y-1)/2)。
所以 f[i][j] = f[i-1][1] + ... + f[i-1][j+floor((b-y-1)/2)] - f[i-1][j]。
最后的减法是因为要求 2。
答案为 sum(f[k][j])。
用前缀和优化即可做到 O(kb) 的时间复杂度。
代码实现时，f 的第一个维度可以优化掉。
相似题目: 1977. 划分数字的方案数
https://leetcode.cn/problems/number-of-ways-to-separate-numbers/
2327. 知道秘密的人数
https://leetcode.cn/problems/number-of-people-aware-of-a-secret/
2463. 最小移动总距离
https://leetcode.cn/problems/minimum-total-distance-traveled/
2478. 完美分割的方案数
https://leetcode.cn/problems/number-of-beautiful-partitions/
======

input
5 2 4 1
output
2

input
5 2 4 2
output
2

input
5 3 4 1
output
0

2222 1206 1425 2222
402572650
 */
