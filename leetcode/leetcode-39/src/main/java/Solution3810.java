import java.util.HashSet;
import java.util.Set;

public class Solution3810 {
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                set.add(nums[i]);
            }
        }
        return set.size();
    }
}
/*
3810. 变成目标数组的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-reach-target-array/description/

第 174 场双周赛 T2。

给你两个长度为 n 的整数数组 nums 和 target，其中 nums[i] 是下标 i 处的当前值，而 target[i] 是下标 i 处的期望值。
你可以执行以下操作任意次数（包括零次）：
- 选择一个整数值 x
- 找到所有 极大连续段，使得 nums[i] == x（如果一个段在保持所有值等于 x 的情况下无法向左或向右延伸，则该段是 极大 的）
- 对于每个这样的段 [l, r]，同时 进行更新：
  - nums[l] = target[l], nums[l + 1] = target[l + 1], ..., nums[r] = target[r]
返回使 nums 等于 target 所需的 最小 操作次数。
提示：
1 <= n == nums.length == target.length <= 10^5
1 <= nums[i], target[i] <= 10^5

脑筋急转弯。
时间复杂度 O(n)。
 */