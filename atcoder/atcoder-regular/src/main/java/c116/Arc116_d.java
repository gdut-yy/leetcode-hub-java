package c116;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc116_d {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] c = new long[n + 1];
        c[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                c[j] = (c[j] + c[j - 1]) % MOD;
            }
        }
        long[] f = new long[m + 1];
        f[0] = 1;
        for (int i = 2; i <= m; i += 2) {
            for (int j = 0; j <= i && j <= n; j += 2) {
                f[i] = (f[i] + f[(i - j) / 2] * c[j]) % MOD;
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
D - I Wanna Win The Game
https://atcoder.jp/contests/arc116/tasks/arc116_d

灵茶の试炼 2022-12-01
题目大意：
输入 n(≤5000) 和 m (≤5000)。
你需要计算满足如下要求的数组个数：
1. 包含 n 个非负整数；
2. 所有数的和为 m；
3. 所有数的异或和为 0。
输出这样的数组个数，模 998244353。

https://atcoder.jp/contests/arc116/submissions/36899692
定义 f(i) 表示元素和为 i 时的答案。由于异或和为 0，i 必须是偶数。
考虑这 n 个数的二进制的最低位有 j 个 1，从 n 个数中选，那么方案数是 C(n,j)，这里 j=0,2,4,...
除去最低位后，其余位数的元素和等于 i-j。为了缩小问题的规模，我们可以把所有数位右移，即考虑 f((i-j)/2)。
那么 f(i) = ∑f((i-j)/2) * C(n,j),    j=0,2,4,...
上面说的是记忆化搜索，你可以可以看成是递推式。
f[0]=1，答案为 f[m]。
计算组合数，可以用递推，也可以用逆元。
由于只用到第 n 行，递推的写法可以用滚动数组优化。
======

Input 1
5 20
Output 1
475

Input 2
10 5
Output 2
0

Input 3
3141 2718
Output 3
371899128
 */