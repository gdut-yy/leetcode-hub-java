import java.util.HashSet;
import java.util.Set;

public class Solution3779 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) break;
            set.add(nums[i]);
        }
        return (i + 1 + 2) / 3;
    }
}
/*
3779. 得到互不相同元素的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-have-distinct-elements/description/

第 172 场双周赛 T1。

给你一个整数数组 nums。
在一次操作中，你需要移除当前数组的 前三个元素。如果剩余元素少于三个，则移除 所有 剩余元素。
重复此操作，直到数组为空或不包含任何重复元素为止。
返回一个整数，表示所需的操作次数。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

倒着找互不相同元素的下标，下标前的数均可删除。答案为 ceil(cnt/3)
时间复杂度 O(n)。
同: 3396. 使数组元素互不相同所需的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
 */