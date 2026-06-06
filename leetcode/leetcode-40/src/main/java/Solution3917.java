public class Solution3917 {
    static class V1 {
        public int[] countOppositeParity(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((nums[i] & 1) != (nums[j] & 1)) ans[i]++;
                }
            }
            return ans;
        }
    }

    // 枚举左，维护右 O(n)
    static class V2 {
        public int[] countOppositeParity(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            int[] cnt = new int[2];
            for (int i = n - 1; i >= 0; i--) {
                int x = nums[i] & 1; // x 的奇偶性
                ans[i] = cnt[x ^ 1]; // 查询右侧奇偶性不等于 x（即 x^1）的元素个数
                cnt[x]++;
            }
            return ans;
        }
    }
}
/*
3917. 统计下标的相反奇偶性得分
https://leetcode.cn/problems/count-indices-with-opposite-parity/description/

第 500 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
下标 i 的 分数 定义为满足以下条件的下标 j 的数量：
- i < j < n，并且
- nums[i] 和 nums[j] 的奇偶性不同（一个为偶数，另一个为奇数）。
返回一个长度为 n 的整数数组 answer，其中 answer[i] 表示下标 i 的分数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

暴力枚举。
时间复杂度 O(n^2)。
 */