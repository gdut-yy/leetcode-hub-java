public class Solution3388 {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        // lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共前缀
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (nums[i] == nums[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        int ans = 0;
        // 枚举前两个子数组的右端点
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j + 1 < n; j++) {
                int len1 = i + 1, len2 = j - i, len3 = n - 1 - j;
                // 判断子数组 1 是不是子数组 2 的前缀，以及子数组 2 是不是子数组 3 的前缀
                if ((len1 <= len2 && lcp[0][i + 1] >= len1) || (len2 <= len3 && lcp[i + 1][j + 1] >= len2)) {
                    ans++;
                }
            }
        return ans;
    }
}
/*
3388. 统计数组中的美丽分割
https://leetcode.cn/problems/count-beautiful-splits-in-an-array/description/

第 428 场周赛 T3。

给你一个整数数组 nums 。
如果数组 nums 的一个分割满足以下条件，我们称它是一个 美丽 分割：
1.数组 nums 分为三段 非空子数组：nums1 ，nums2 和 nums3 ，三个数组 nums1 ，nums2 和 nums3 按顺序连接可以得到 nums 。
2.子数组 nums1 是子数组 nums2 的前缀 或者 nums2 是 nums3 的前缀。
请你返回满足以上条件的分割 数目 。
子数组 指的是一个数组里一段连续 非空 的元素。
前缀 指的是一个数组从头开始到中间某个元素结束的子数组。
提示：
1 <= nums.length <= 5000
0 <= nums[i] <= 50

相似题目: 718. 最长重复子数组
https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
rating 2342 (clist.by)
 */