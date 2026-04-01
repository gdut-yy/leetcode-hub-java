import java.util.Arrays;

public class Solution3848 {
    private static final int[] fac;
//    private static final int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    static {
        fac = new int[10];
        Arrays.fill(fac, 1);
        for (int i = 1; i < 10; i++) {
            fac[i] = fac[i - 1] * i;
        }
    }

    public boolean isDigitorialPermutation(int n) {
        int sumFac = 0;
        int[] cnt = new int[10];
        for (; n > 0; n /= 10) {
            int d = n % 10;
            sumFac += fac[d];
            cnt[d]++;
        }

        for (; sumFac > 0; sumFac /= 10) {
            cnt[sumFac % 10]--;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
/*
3848. 阶数数字排列
https://leetcode.cn/problems/check-digitorial-permutation/description/

第 490 场周赛 T2。

给你一个整数 n。
如果一个数字的所有位数的 阶乘 之和 等于 数字本身，则称其为 阶数数字（digitorial）。
判断是否存在 n 的 任意排列（包括原始顺序），可以形成一个 阶数数字。
如果存在这样的 排列，返回 true；否则，返回 false。
注意：
- 非负整数 x 的 阶乘（记作 x!）是所有小于或等于 x 的正整数的 乘积，且 0! = 1。
- 排列 是一个数字所有位数的重新排列，且不能以零开头。任何以零开头的排列都是无效的。
提示：
1 <= n <= 10^9

无论如何排列 n 中的数位，这些数位的阶乘之和是不变的。
时间复杂度 O(logn+D)。其中 D=10。
 */