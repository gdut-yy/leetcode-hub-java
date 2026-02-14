import java.util.HashMap;
import java.util.Map;

public class Solution3811 {
    private static final int MOD = (int) (1e9 + 7);

    public int alternatingXOR(int[] nums, int target1, int target2) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i - 1];
        }

        Map<Integer, Long> sumF = new HashMap<>();
        Map<Integer, Long> sumG = new HashMap<>();
        sumF.put(0, 0L);
        sumG.put(0, 0L);
        long fi = 0, gi = 0;
        for (int i = 1; i <= n; i++) {
            int pre = prefix[i];
            fi = 0;
            if (pre == target1) {
                fi = 1;
            }
            int key1 = pre ^ target1;
            fi = (fi + sumG.getOrDefault(key1, 0L)) % MOD;
            int key2 = pre ^ target2;
            gi = sumF.getOrDefault(key2, 0L) % MOD;

            sumF.put(pre, (sumF.getOrDefault(pre, 0L) + fi) % MOD);
            sumG.put(pre, (sumG.getOrDefault(pre, 0L) + gi) % MOD);
        }
        return (int) ((fi + gi) % MOD);
    }
}
/*
3811. 交替按位异或分割的数目
https://leetcode.cn/problems/number-of-alternating-xor-partitions/description/

第 174 场双周赛 T3。

给你一个整数数组 nums 以及两个 互不相同 的整数 target1 和 target2。
nums 的一个 分割 是指将其划分为一个或多个 连续且非空 的块，这些块在不重叠的情况下覆盖整个数组。
如果一个分割中各块元素的 按位异或 结果在 target1 和 target2 之间 交替 出现，且以 target1 开始，则称该分割是 有效的。
形式上，对于块 b1, b2, ... ：
- XOR(b1) = target1
- XOR(b2) = target2（如果存在）
- XOR(b3) = target1，以此类推。
返回 nums 的有效分割方案数，结果对 10^9 + 7 取余。
注意： 如果单个块的 按位异或 结果等于 target1，则该分割也是有效的。
提示：
1 <= nums.length <= 10^5
0 <= nums[i], target1, target2 <= 10^5
target1 != target2

合法子序列 DP + 状态机 DP。
时间复杂度 O(n)。
rating 2100 (clist.by)
 */