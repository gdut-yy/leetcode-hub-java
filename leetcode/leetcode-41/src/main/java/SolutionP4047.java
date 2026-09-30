import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolutionP4047 {
    // https://leetcode.cn/problems/minimum-operations-to-make-xor-of-all-elements-zero/solutions/4025681/01bei-bao-14xing-python4047-minimum-oper-gb7k/
    private static final int INF = Integer.MAX_VALUE / 2;

    public int minOperations(int[] nums) {
        // 统计每个不同值的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        // 特殊情形：数组中所有值都相同且出现次数为奇数
        if (cnt.size() == 1 && cnt.get(nums[0]) % 2 == 1) {
            return -1;
        }
        // mx 为大于最大值的下一个 2 的幂，状态范围为 [0, mx)
        int max = Collections.max(cnt.keySet());
        int mx = 1 << (32 - Integer.numberOfLeadingZeros(max));
        // s[t] = 得到异或值 t 所需的最少操作次数；s[0] = 0
        int[] s = new int[mx];
        Arrays.fill(s, INF);
        s[0] = 0;

        // 需要的目标异或值：出现次数为奇数的值全部异或起来
        int ms = 0;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int v = e.getKey();
            int c = e.getValue();
            if (c % 2 == 1) {
                ms ^= v;
            }
            // 0/1 背包：每个值可选或不选，一次操作 = 把一个元素改成某个值
            int[] ps = s.clone();
            for (int t = 1; t < mx; t++) {
                ps[t] = Math.min(ps[t], s[t ^ v] + 1);
            }
            s = ps;
        }
        int x = s[ms];
        return x >= nums.length ? -1 : x;
    }
}
/*
$4047. 使所有元素的异或为零所需的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-make-xor-of-all-elements-zero/description/

给你一个由 正整数 组成的整数数组 nums。
你可以执行以下 操作 任意次：
- 选择两个 不同的 下标 i 和 j，满足 nums[i] != nums[j]，并将 nums[i] 或 nums[j] 中的一个替换为 nums[i] ^ nums[j]，其中 ^ 表示 按位异或。
返回使 nums 中所有元素的 按位异或 结果等于 0 所需的 最少 操作次数。如果无法做到，返回 -1。
示例 1：
输入： nums = [8,1,4,8,2]
输出： 3
示例 2：
输入： nums = [1,2,3]
输出： 0
示例 3：
输入： nums = [1,2,4]
输出： -1
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 2000
 */