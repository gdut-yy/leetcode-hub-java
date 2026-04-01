import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3878 {
    public long countGoodSubarrays(int[] nums) {
        List<int[]> orLeft = new ArrayList<>(); // (子数组或值，最小左端点)
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            last.put(x, i);

            // 计算以 i 为右端点的子数组或值
            for (int[] p : orLeft) {
                p[0] |= x; // **根据题目修改**
            }
            // x 单独一个数作为子数组
            orLeft.add(new int[]{x, i});

            // 原地去重（相同或值只保留最左边的）
            // 原理见力扣 26. 删除有序数组中的重复项
            int m = 1;
            for (int j = 1; j < orLeft.size(); j++) {
                if (orLeft.get(j)[0] != orLeft.get(j - 1)[0]) {
                    orLeft.set(m++, orLeft.get(j));
                }
            }
            orLeft.subList(m, orLeft.size()).clear();

            for (int k = 0; k < m; k++) {
                int orVal = orLeft.get(k)[0];
                int left = orLeft.get(k)[1];
                int right = k < m - 1 ? orLeft.get(k + 1)[1] - 1 : i;
                // 对于左端点在 [left, right]，右端点为 i 的子数组，OR 值都是 orVal
                int j = last.getOrDefault(orVal, -1);
                if (j >= left) {
                    ans += Math.min(right, j) - left + 1;
                }
            }
        }

        return ans;
    }
}
/*
3878. 统计好子数组
https://leetcode.cn/problems/count-good-subarrays/description/

第 494 场周赛 T4。

给你一个整数数组 nums。
如果一个 子数组 中所有元素的 按位或 等于该子数组中 至少出现一次 的元素，则称其为 好 子数组。
返回 nums 中好子数组的数量。
子数组 是数组中一段连续的 非空 元素序列。
这里，两个整数 a 和 b 的按位或表示为 a | b。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

LogTrick。
时间复杂度 O(nlogU)。
 */