import java.util.ArrayList;
import java.util.List;

public class Solution3757 {
    private static final int MOD = (int) (1e9 + 7);

    public int countEffective(int[] nums) {
        int n = nums.length;
        int totalOR = 0;
        for (int num : nums) {
            totalOR |= num;
        }
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((totalOR >> i & 1) == 1) {
                bits.add(i);
            }
        }
        int k = bits.size();
        if (k == 0) {
            return 0;
        }
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            int m = 0;
            for (int j = 0; j < k; j++) {
                int bit = bits.get(j);
                if ((nums[i] >> bit & 1) == 1) {
                    m |= (1 << j);
                }
            }
            mask[i] = m;
        }
        int[] F = new int[1 << k];
        for (int i = 0; i < n; i++) {
            F[mask[i]]++;
        }
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < (1 << k); i++) {
                if ((i >> j & 1) == 1) {
                    F[i] += F[i ^ (1 << j)];
                }
            }
        }
        long ans = 0;
        int full = (1 << k) - 1;
        for (int J = 1; J <= full; J++) {
            int T = full ^ J;
            int cntJ = Integer.bitCount(J);
            long term = quickPow(2, F[T]);
            if (cntJ % 2 == 1) {
                ans = (ans + term) % MOD;
            } else {
                ans = (ans - term) % MOD;
            }
        }
        ans = (ans % MOD + MOD) % MOD;
        return (int) ans;
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
3757. 有效子序列的数量
https://leetcode.cn/problems/number-of-effective-subsequences/description/

第 477 场周赛 T4。

给你一个整数数组 nums。
数组的 强度 定义为数组中所有元素的 按位或 (Bitwise OR)  。
如果移除某个 子序列 会使剩余数组的 强度严格减少 ，那么该子序列被称为 有效子序列 。
返回数组中 有效子序列 的数量。由于答案可能很大，请返回结果对 109 + 7 取模后的值。
子序列 是一个 非空 数组，它是由另一个数组删除一些（或不删除任何）元素，并且不改变剩余元素的相对顺序得到的。
空数组的按位或为 0。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

SOS DP。
https://chat.deepseek.com/a/chat/s/5663b32f-b8ba-47b2-9c15-1bd4d59fbde2
关键在于理解移除子序列后剩余数组的按位或必须严格小于原数组的按位或。这等价于子序列必须至少包含一个在某个位上所有为1的元素，使得移除后该位在剩余数组中不再为1。
关键观察：利用容斥原理和状态动态规划（SOS DP）来高效计算满足条件的子序列数量。具体步骤包括：
计算原数组的按位或（totalOR）。
识别totalOR中所有为1的位（集合S）。
为每个数组元素构建掩码，表示其在S中哪些位为1。
使用SOS DP统计每个子集掩码的出现次数。
应用容斥原理计算有效子序列的数量。
 */