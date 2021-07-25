import java.util.Arrays;

public class Solution1922 {
    public int countGoodNumbers(long n) {
        int mod = 1000000007;
        long pow = n / 2;
        if (n % 2 == 1L) {
            // 奇数
            return (int) (5 * fastPower(20, pow, mod) % mod);
        } else {
            // 偶数
            return (int) (fastPower(20, pow, mod) % mod);
        }
    }

    public long fastPower(long x, long pow, int mod) {
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

    /**
     * 打表
     */
    public static void main(String[] args) {
        int[] cnt = new int[10];
        for (int i = 0; i < 10000000; i++) {
            String numStr = String.valueOf(i);
            if (isGoodNum(numStr)) {
                cnt[numStr.length()]++;
            }
        }
        System.out.println(Arrays.toString(cnt));
    }

    /**
     * 打表
     */
    private static boolean isGoodNum(String numStr) {
        for (int i = 0; i < numStr.length(); i++) {
            boolean goodNum;
            if (i % 2 == 0) {
                // 偶数
                goodNum = numStr.charAt(i) == '0' || numStr.charAt(i) == '2' || numStr.charAt(i) == '4' || numStr.charAt(i) == '6' || numStr.charAt(i) == '8';
            } else {
                // 奇数
                goodNum = numStr.charAt(i) == '2' || numStr.charAt(i) == '3' || numStr.charAt(i) == '5' || numStr.charAt(i) == '7';
            }
            if (!goodNum) {
                return false;
            }
        }
        return true;
    }
}
/*
1922. 统计好数字的数目
https://leetcode-cn.com/problems/count-good-numbers/

第 248 场周赛 T3。
找规律 + 快速幂
打表找规律，一开始求出 n = 4 结果是 320，随后发现题目注明 “可能包含前导 0”，那就很简单了：
奇数: (5^(pow+1) * 4^pow) % mod == (5 * 20^pow) % mod
偶数: (5^pow * 4^pow) % mod == (20^pow) % mod
由于 pow 能达到 10^15，会溢出，快速幂中需要每步取模
快速幂推导过程可参考 https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 */