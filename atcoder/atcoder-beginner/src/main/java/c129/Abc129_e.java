package c129;

import java.util.Scanner;

public class Abc129_e {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve1());
    }

    static final int MOD = (int) (1e9 + 7);

    // 写法一
    private static String solve() {
        int n = s.length;
        long ans = 0;
        long pow2 = 1;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ans = (ans + pow2 * quickPow(3, n - 1 - i)) % MOD;
                pow2 = pow2 * 2 % MOD;
            }
        }
        ans = (ans + pow2) % MOD;
        return String.valueOf(ans);
    }

    // 写法二
    private static String solve1() {
        int inv3 = 333333336;
        long ans = 0;
        long pow2 = 1;
        long pow3 = quickPow(3, s.length);
        for (char b : s) {
            pow3 = pow3 * inv3 % MOD;
            if (b == '1') {
                ans = (ans + pow2 * pow3) % MOD;
                pow2 = pow2 * 2 % MOD;
            }
        }
        ans = (ans + pow2) % MOD;
        return String.valueOf(ans);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
E - Sum Equals Xor
https://atcoder.jp/contests/abc129/tasks/abc129_e

灵茶の试炼 2025-02-06
题目大意：
输入一个长度至多为 1e5+1 的二进制字符串 s，不含前导零。
把 s 当作一个二进制数。
输出有多少对非负整数 (a,b)，满足 a + b <= s 且 a + b = a XOR b。
答案模 1e9+7。

a + b = a XOR b 意味着加法不能有进位，也就是同一个比特位不能都是 1。
下面以 s=100100 为例。
对于最高位的 s[0]=1，如果 a+b 在这一位是 0，那么对于 a+b 来说，右边的每个比特位可以填 0 也可以填 1。也就是 a+b = 0xxxxx。
对于 a 和 b，在 x 填什么，有三种情况：都是 0，一个是 0 另一个是 1。
由于每一位互相独立，有 pow(3, n-1-i) 种方案（其中 n 是 s 的长度，i=0）。
对于另一个 s[3]=1，同理，如果 a+b 在这一位是 0，那么对于 a+b 来说，右边的每个比特位可以填 0 也可以填 1。也就是 a+b = 1000xx。
对于 a 和 b，在 x 填什么，有三种情况：都是 0，一个是 0 另一个是 1。
再算上前面的 s[0]=1 这一位，a 和 b 必须一个是 0 另一个 1，所以有 pow(2, pre1) * pow(3, n-1-i) 种方案（其中 pre1=1，i=3）。
最后算上 a+b 恰好等于 s 的情况，有 pow(2, cnt1) 种方案（其中 cnt1 是 s 中的 1 的个数）。
计算 pow 用快速幂。
写法一 O(nlogn) 11ms https://atcoder.jp/contests/abc129/submissions/62011579
写法二 O(n) 3ms https://atcoder.jp/contests/abc129/submissions/62011640
======

Input 1
10
Output 1
5

Input 2
1111111111111111111
Output 2
162261460
 */
