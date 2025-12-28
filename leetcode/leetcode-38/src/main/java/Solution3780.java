import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3780 {
    public int maximumSum(int[] nums) {
        List<Integer>[] groups = new ArrayList[3];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (int v : nums) groups[v % 3].add(v);
        for (int i = 0; i < 3; i++) groups[i].sort(Collections.reverseOrder());

        int ans = 0;
        // 0
        if (groups[0].size() >= 3) {
            int sum = groups[0].get(0) + groups[0].get(1) + groups[0].get(2);
            ans = Math.max(ans, sum);
        }
        // 1
        if (groups[1].size() >= 3) {
            int sum = groups[1].get(0) + groups[1].get(1) + groups[1].get(2);
            ans = Math.max(ans, sum);
        }
        // 2
        if (groups[2].size() >= 3) {
            int sum = groups[2].get(0) + groups[2].get(1) + groups[2].get(2);
            ans = Math.max(ans, sum);
        }
        // 0、1、2
        if (!groups[0].isEmpty() && !groups[1].isEmpty() && !groups[2].isEmpty()) {
            int sum = groups[0].get(0) + groups[1].get(0) + groups[2].get(0);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
3780. 能被 3 整除的三元组最大和
https://leetcode.cn/problems/maximum-sum-of-three-numbers-divisible-by-three/description/

第 172 场双周赛 T2。

给你一个整数数组 nums。
你的任务是从 nums 中选择 恰好三个 整数，使得它们的和能被 3 整除。
返回这类三元组可能产生的 最大 和。如果不存在这样的三元组，返回 0。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

按余数分组，每组保留最大的三个数 后 分类讨论。
时间复杂度 O(nlogn)。
 */