import java.util.Arrays;

public class Solution3467 {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int even = 0;
        for (int v : nums) {
            if (v % 2 == 0) even++;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < even; i++) {
            ans[i] = 0;
        }
        return ans;
    }
}
/*
3467. 将数组按照奇偶性转化
https://leetcode.cn/problems/transform-array-by-parity/description/

第 151 场双周赛 T1。

给你一个整数数组 nums。请你按照以下顺序 依次 执行操作，转换 nums：
1.将每个偶数替换为 0。
2.将每个奇数替换为 1。
3.按 非递减 顺序排序修改后的数组。
执行完这些操作后，返回结果数组。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 1000

遍历计数。
时间复杂度 O(n)。
 */