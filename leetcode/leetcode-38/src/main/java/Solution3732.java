import java.util.Arrays;

public class Solution3732 {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        long[] abs = new long[n];
        for (int i = 0; i < n; i++) abs[i] = Math.abs(nums[i]);
        Arrays.sort(abs);

        return 100000L * abs[n - 1] * abs[n - 2];
    }
}
/*
3732. 一次替换后的三元素最大乘积
https://leetcode.cn/problems/maximum-product-of-three-elements-after-one-replacement/description/

第 474 场周赛 T2。

给你一个整数数组 nums。
你 必须 将数组中的 恰好一个 元素替换为范围 [-105, 105]（包含边界）内的 任意 整数。
在进行这一替换操作后，请确定从修改后的数组中选择 任意三个互不相同的下标 对应的元素所能得到的 最大乘积 。
返回一个整数，表示可以达到的 最大乘积 。
提示：
3 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

求绝对值前二大。无论正负，第三个数都能调整乘积为正，且第三个数取 1e5
时间复杂度 O(nlogn)。
 */