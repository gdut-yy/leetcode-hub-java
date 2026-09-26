public class Hust10242023T4 {
    private static final int MOD = 998244353;

    /**
     * 对于一个长度为 n 的前缀 a：
     * 扩展 b 的长度为 2n-1，偶数下标固定为 a[i]，奇数下标（n-1 个）可任填。
     * b 的排序中间数 = 1 当且仅当 b 中 1 的个数 >= n，否则为 0。
     * 记 c = 前缀中 1 的个数：
     * 若 a[n-1] == '1'：美丽扩展数 = sum_{i=0}^{c-1} C(n-1, i) = G(n)
     * 若 a[n-1] == '0'：美丽扩展数 = 2^(n-1) - G(n)
     * 其中 G(n) = sum_{i=0}^{c_n-1} C(n-1, i)，c_n 为前 n 个字符中 1 的个数。
     * <p>
     * 利用 C(m, i) = C(m-1, i) + C(m-1, i-1) 可得递推（m = n-2）：
     * 下一位为 '1'：G(n) = 2 * G(n-1) + C(m, c_{n-1})
     * 下一位为 '0'：G(n) = 2 * G(n-1) - C(m, c_{n-1} - 1)
     * 组合数用阶乘 + 逆元 O(1) 计算，整体时间 O(n)。
     */
    public int beautifulString(String s) {
        int n = s.length();

        long ans = 0;
        long g = 0;
        int ones = 0;
        long pow2 = 1; // 2^(n-1)
        for (int idx = 0; idx < n; idx++) {
            int len = idx + 1;
            if (len == 1) {
                if (s.charAt(0) == '1') {
                    ones = 1;
                    g = 1;
                } else {
                    ones = 0;
                    g = 0;
                }
            } else {
                int m = len - 2;
                if (s.charAt(idx) == '1') {
                    g = (2 * g + comb(m, ones)) % MOD;
                    ones++;
                } else {
                    g = (2 * g - comb(m, ones - 1) + MOD) % MOD;
                }
            }

            long a;
            if (s.charAt(idx) == '1') {
                a = g;
            } else {
                a = (pow2 - g + MOD) % MOD;
            }
            ans = (ans + a) % MOD;
            pow2 = pow2 * 2 % MOD;
        }
        return (int) ans;
    }

    static int MX = (int) 2e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

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
Q4. 美丽字符串
https://leetcode.cn/contest/hust_1024_2023/problems/yH1vqC/

一个二进制字符串是由 0 和 1 组成的字符串。如果一个长度为 m（m 为奇数）的二进制字符串 s 满足 最后一位数字 与 s 的「排序中间数」相同，那么它就是美丽的。如 11001 是美丽的，而 11100 不是美丽的。
注：「排序中间数」指将二进制各数位按升序排列后，中间的数字。例如，11001 升序排列后为 [0,0,1,1,1]，中间的数字 1 即为排序中间数。
对于一个长度为 n 的二进制字符串 a 和一个长度为 2*n − 1 的二进制字符串 b，如果对于所有 i（下标从 0 开始） ，都有 b[2*i] == a[i]，那么称 b 是 a 的扩展。例如，
1001011 和 1101001 都是字符串 1001 的扩展。
给定一个长度为 n 的二进制字符串 s，请返回 s 所有前缀的美丽扩展的个数之和。
由于答案可能很大，你只需要求出它模 998244353 的结果。
示例 1：
输入：s = "11" 输出：3 解释：前缀 1，美丽的扩展有 1 ，共 1 个。 对于前缀 11，其扩展有 101 和 111， 101 的最后一位数字为 1，将 101 各位数升序排序后为 [0,1,1]，排序中间数为 1，二者相同，为美丽字符串； 111 的最后一位数字为 1，将 111 各位数升序排序后为 [1,1,1]，排序中间数为 1，二者相同，为美丽字符串； 共有 3 种满足条件的扩展，返回 3
示例 2：
输入：s = "01001" 输出：17 解释：
对于前缀 0，美丽的扩展有 0，共 1 个。
对于前缀 01，美丽的扩展有 011，共 1 个。
对于前缀 010，美丽的扩展有 00100, 00110, 01100，共 3 个。
对于前缀 0100，美丽的扩展有 0010000, 0010010, 0011000, 0011010, 0110000, 0110010, 0111000，共 7 个。
对于前缀 01001，美丽的扩展有 011101011, 001101011, 011001011, 011100011, 011101001，的个数是 5。 所以答案是 17。
提示：
1 <= s.length <= 2*10^5
s 仅包含 0 和 1
 */
