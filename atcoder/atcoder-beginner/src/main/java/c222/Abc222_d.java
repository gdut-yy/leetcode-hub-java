package c222;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc222_d {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[][] f = new long[n][3001];
        for (int j = a[0]; j <= b[0]; j++) {
            f[0][j] = j - a[0] + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = a[i]; j <= b[i]; j++) {
                // max(j-1, 0) 是防止 j=0 时产生 -1 下标
                f[i][j] = (f[i][Math.max(j - 1, 0)] + f[i - 1][Math.min(j, b[i - 1])]) % MOD;
            }
        }
        return String.valueOf(f[n - 1][b[n - 1]]);
    }
}
/*
D - Between Two Arrays
https://atcoder.jp/contests/abc222/tasks/abc222_d

灵茶の试炼 2023-10-03
题目大意：
输入 n(1≤n≤3000) 和两个长为 n 的数组 a b，元素范围在 [0,3000]，且均为递增数组（允许有相同元素）。
构造递增数组 c（允许有相同元素），满足 a[i]<=c[i]<=b[i]。
输出你能构造多少个不同的 c，模 998244353。

有两种定义 DP 的方式。
定义 f[i][j] 表示考虑前 i 个数，其中第 i 个数填 j 的方案数
那么有 f[i][j] = f[i-1][0] + f[i-1][1] + ... + f[i-1][min(j, b[i-1])]
这可以用前缀和优化。
这启发我们，也可以直接定义 f[i][j] 表示考虑前 i 个数，其中第 i 个数填的数 <=j 的方案数。
考虑第 i 个数是否要填 j：
- 不填，那就是第 i 个数填的数 <=j-1 的方案数，即 f[i][j] = f[i][j-1]。
- 填，那么第 i-1 个数至多为 j，即 f[i][j] = f[i-1][min(j, b[i-1])]。
则有 f[i][j] = f[i][j-1] + f[i-1][min(j, b[i-1])]。
初始值 f[0][j] = j-a[0]+1，其中 a[0]<=j<=b[0]。
答案为 f[n-1][b[n-1]]。
https://atcoder.jp/contests/abc222/submissions/46028545
======

Input 1
2
1 1
2 3
Output 1
5

Input 2
3
2 2 2
2 2 2
Output 2
1

Input 3
10
1 2 3 4 5 6 7 8 9 10
1 4 9 16 25 36 49 64 81 100
Output 3
978222082
 */