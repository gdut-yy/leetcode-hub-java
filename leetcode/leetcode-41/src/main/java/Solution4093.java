import java.util.Arrays;

public class Solution4093 {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            char[] c = String.valueOf(nums[i]).toCharArray();
            Arrays.sort(c);
            b[i] = Long.parseLong(new StringBuilder(new String(c)).reverse().toString());
        }

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;

        long ans = 0;
        Arrays.sort(ids, (o1, o2) -> Long.compare(b[o2] - nums[o2], b[o1] - nums[o1]));
        for (int i = 0; i < k; i++) {
            int j = ids[i];
            if (b[j] >= nums[j]) ans += b[j];
            else ans += nums[j];
        }
        for (int i = k; i < n; i++) {
            int j = ids[i];
            ans += nums[j];
        }
        return ans;
    }
}
/*
4093. 至多 K 次数字重排后的最大和
https://leetcode.cn/problems/maximize-sum-after-at-most-k-digit-rearrangements/description/

第 525 场周赛 T2。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
在一次操作中，你可以选择 nums 中的任意一个元素，并以任意顺序重新排列其十进制数字，组成一个新的整数。
返回在执行至多 k 次操作后，数组元素之和的最大值。
示例 1：
输入： nums = [123,45], k = 1
输出： 366
示例 2：
输入： nums = [102,90,14], k = 2
输出： 341
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= n

贪心。
 */