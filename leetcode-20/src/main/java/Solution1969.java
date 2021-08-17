public class Solution1969 {
    public int minNonZeroProduct(int p) {
        // 打表
        int[] res = {
                1,
                6,
                1512,
                581202553,
                202795991,
                57405498,
                316555604,
                9253531,
                857438053,
                586669277,
                647824153,
                93512543,
                391630296,
                187678728,
                431467833,
                539112180,
                368376380,
                150112795,
                484576688,
                212293935,
                828477683,
                106294648,
                618323081,
                186692306,
                513022074,
                109245444,
                821184946,
                2043018,
                26450314,
                945196305,
                138191773,
                505517599,
                861896614,
                640964173,
                112322054,
                217659727,
                680742062,
                673217940,
                945471045,
                554966674,
                190830260,
                403329489,
                305023508,
                229675479,
                865308368,
                689473871,
                161536946,
                99452142,
                720364340,
                172386396,
                198445540,
                265347860,
                504260931,
                247773741,
                65332879,
                891336224,
                221172799,
                643213635,
                926891661,
                813987236
        };
        return res[p - 1];
    }

    /**
     * 打表 数论：
     * (a * b) % p = ((a % p) * (b % p)) % p
     * (a^b) % p = ((a % p)^b) % p
     */
    public static void main(String[] args) {
        int mod = 1000000007;
        for (int i = 1; i <= 60; i++) {
            // 2^p-1
            long max = (1L << i) - 1L;
            // 2^p-2
            long diff = max - 1L;
            // 2^(p-1)-1
            long powers = diff >> 1;

            // (2^p-2)^(2^(p-1)-1)
            long res = fastPower(diff, powers, mod);

            res = (res % mod + mod) % mod;
            max = (max % mod + mod) % mod;

            // (2^p-1)*(2^p-2)^(2^(p-1)-1)
            res *= max;

            res = (res % mod + mod) % mod;
            System.out.println(res + ",");
        }
    }

    public static long fastPower(long x, long pow, int mod) {
        // 取模
        x %= mod;
        long ans = 1;
        while (pow > 0) {
            if (pow % 2 == 1) {
                ans *= x;
                // 取模
                ans %= mod;
            }
            x *= x;
            // 取模
            x %= mod;
            pow /= 2;
        }
        return ans;
    }
}
/*
1969. 数组元素的最小非零乘积
https://leetcode-cn.com/problems/minimum-non-zero-product-of-the-array-elements/

第 254 场周赛 T3。
找规律不难。res[p - 1] = (2^p-1)*(2^p-2)^(2^(p-1)-1)
然后需用到快速幂和数论模运算知识。注意 java 取模为负数时的处理方法。
类似于 1922. 统计好数字的数目 https://leetcode-cn.com/problems/count-good-numbers/
 */