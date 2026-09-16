import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4031 {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        long prev = (long) lower - 1;
        for (int num : nums) {
            if (num > upper) break;
            if (num == prev + 1) {
                prev = num;
            } else if (num > prev + 1) {
                ans.add(List.of((int) prev + 1, num - 1));
                prev = num;
            }
        }
        if (prev < upper) {
            ans.add(List.of((int) prev + 1, upper));
        }
        return ans;
    }
}
/*
4031. 找到所有数组中消失的数字 II
https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array-ii/description/

第 516 场周赛 T2。

给你一个整数数组 nums，以及两个整数 lower 和 upper。
如果一个整数位于区间 [lower, upper] 内（包含两个端点），但没有出现在 nums 中，则称其为 缺失整数 。
返回一个二维整数数组，其中每个元素的形式为 [start, end]，表示一段由缺失整数组成的 连续区间 。请按 递增 顺序返回这些区间。如果不存在缺失整数，则返回空数组。
注意：连续的缺失整数应合并为同一个区间。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= lower <= upper <= 10^5

排序 + 遍历。
时间复杂度 O(nlogn)。
 */