import java.util.HashSet;
import java.util.Set;

public class Solution3396 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) break;
            set.add(nums[i]);
        }
        return ((n - set.size()) + 2) / 3;
    }
}
/*
3396. 使数组元素互不相同所需的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

第 429 场周赛 T1。

给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
- 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

后往前枚举，数组元素互不相同 的长度 L。则要删去 n-L。
答案为 ceil( (n-L) / 3 )
 */