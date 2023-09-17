package c288;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc288_f {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long f = 0, sumF = 1;
        for (int i = 0; i < n; i++) {
            f = (f * 10 + sumF * (s[i] - '0')) % MOD;
            sumF += f;
        }
        return String.valueOf(f);
    }
}
/*
F - Integer Division
https://atcoder.jp/contests/abc288/tasks/abc288_f

灵茶の试炼 2023-08-04
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数字 s，保证 s 不含 0。
把 s 分割成若干段，得分为每一段的乘积。特别地，如果不分割，则得分为 s。
输出所有分割方案的得分之和，模 998244353。
注：一共有 2^(n-1) 种分割方案。

https://atcoder.jp/contests/abc288/submissions/44204756
提示 1：从划分型 DP 入手，你能否找到一个规模更小的子问题？
例如 s=1234，如果最后一段为 34，那么得分为 12*34+1*2*34 = (12+1*2)*34。
注意 12+1*2 是 12 的所有划分的得分之和。
由此可见，枚举出最后一段后，我们可以把问题变成一个规模更小的子问题。
提示 2：定义 f[i] 表示分割前 i 个数字的得分之和（i 从 1 开始）
f[0] = 0
f[i] = val(1,i) + f[1]*val(2,i) + f[2]*val(3,i) + ... + f[i-1]*val(i,i)
其中 val(j,i) 表示 s[j] 到 s[i] 这一段对应的数字。
但这样写是 O(n^2) 的。
提示 3：观察 f[i-1] 的转移方程与 f[i] 的转移方程的差异。
提示 4：val(j,i) = val(j,i-1) * 10 + (s[i] - '0')
根据这一式子可以得到
f[i] = f[i-1] * 10 + (1+f[1]+f[2]+...+f[i-1]) * (s[i] - '0')
所以再用一个变量 sumF 表示 1+f[1]+f[2]+...+f[i-1]，就可以 O(1) 地从 f[i-1] 算出 f[i] 了。
======

Input 1
3
234
Output 1
418

Input 2
4
5915
Output 2
17800

Input 3
9
998244353
Output 3
258280134
 */