package c194;

import java.util.Arrays;
import java.util.Scanner;

public class Abc194_f {
    static final int MOD = (int) (1e9 + 7);
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    static long[][] dp;

    private static String solve() {
        int n = s.length;
        dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = f(0, 0, true, false);
        return String.valueOf(ans);
    }

    static long f(int i, int mask, boolean isLimit, boolean isNum) {
        int c = Integer.bitCount(mask);
        if (c > k) return 0;
        if (i == s.length) {
            return c == k ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][c] != -1) {
            return dp[i][c];
        }
        long ans = 0;
        if (!isNum) {
            ans += f(i + 1, mask, false, false);
        }
        int down = isNum ? 0 : 1;
//        int up = isLimit ? s[i] - '0' : 9;
        int up = 15;
        if (isLimit) {
            if (s[i] <= '9') up = s[i] - '0';
            else up = 10 + s[i] - 'A';
        }
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        }
        ans %= MOD;
        if (!isLimit && isNum) {
            dp[i][c] = ans;
        }
        return ans;
    }
}
/*
F - Digits Paradise in Hexadecimal
https://atcoder.jp/contests/abc194/tasks/abc194_f

灵茶の试炼 2025-02-07
题目大意：
输入长度 ≤2e5 的字符串 s 和整数 k(1≤k≤16)。
s 表示一个十六进制数，无前导零。
在 [1,s] 中，有多少个（无前导零的）十六进制数，恰好包含 k 个不同的数字？这里的数字指 0~9 和 A~F。
答案模 1e9+7。

数位 DP。
考虑把填入的数字用位运算状压成一个 mask，这样我们可以知道有多少个不同数字。
但是 (i, mask) 状态个数太多了，如何简化？
如果后续填入的数字，不受到 s 的约束，那么考虑以下两种情况：
前面填的数字有 1,2,3。
前面填的数字有 2,3,4。
虽然填入的数字不同，但是不同数字的个数是相同的，这意味着后面填【其他数字】的方案数是【等价】的：
前面填的数字有 1,2,3 的情况下，后面填 1，不改变 mask；后面填 4，那么 mask 会多一个比特位。
前面填的数字有 2,3,4 的情况下，后面填 2，不改变 mask；后面填 1，那么 mask 会多一个比特位。
这种 mask【是否改变】，对于这两种情况都是等价的（或者说可以找到一一对应关系）。
所以我们只需要记忆化 (i, mask 中的 1 的个数) 这个状态。
于是状态个数大大减少，总体时间复杂度为 O(nkD)，D=16。
注意前导零影响答案，可以写 isNum 参数，或者根据 mask 是否为 0 来判断。
代码 https://atcoder.jp/contests/abc194/submissions/62208201
======

Input 1
10 1
Output 1
15

Input 2
FF 2
Output 2
225

Input 3
100 2
Output 3
226

Input 4
1A8FD02 4
Output 4
3784674

Input 5
DEADBEEFDEADBEEEEEEEEF 16
Output 5
153954073
 */
