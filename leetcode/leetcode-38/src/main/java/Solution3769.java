import java.util.Arrays;

public class Solution3769 {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.reverse(nums[i]) >>> Integer.numberOfLeadingZeros(nums[i]);
        }
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> {
            if (b[o1] != b[o2]) return Integer.compare(b[o1], b[o2]);
            return Integer.compare(nums[o1], nums[o2]);
        });

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[ids[i]];
        }
        return ans;
    }
}
/*
3769. 二进制反射排序
https://leetcode.cn/problems/sort-integers-by-binary-reflection/description/

第 479 场周赛 T1。

给你一个整数数组 nums。
二进制反射 是对一个 正整数 的二进制表示按顺序反转（忽略前导零）后，将反转得到的二进制数转为十进制的结果。
请按每个元素的二进制反射值的 升序 对数组进行排序。如果两个不同的数字具有相同的二进制反射值，则 较小 的原始数字应排在前面。
返回排序后的数组。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 10^9

自定义排序。下标辅助排序。
时间复杂度 O(nlogn)。
 */