import java.util.ArrayList;
import java.util.List;

public class Solution3912 {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        L[0] = nums[0];
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], nums[i]);
        }
        int[] R = new int[n];
        R[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], nums[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) ans.add(nums[i]);
            else if (L[i - 1] < nums[i] || nums[i] > R[i + 1]) ans.add(nums[i]);
        }
        return ans;
    }
}
/*
3912. 数组中的有效元素
https://leetcode.cn/problems/valid-elements-in-an-array/description/

第 499 场周赛 T1。

给你一个整数数组 nums。
如果元素 nums[i] 满足以下 至少一个 条件，则认为它是 有效 元素：
- 它 严格大于 其左侧的所有元素。
- 它 严格大于 其右侧的所有元素。
第一个元素和最后一个元素始终有效。
返回所有有效元素组成的数组，顺序与它们在 nums 中出现的顺序相同。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

前后缀分解。
时间复杂度 O(n)。
 */