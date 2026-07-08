public class Solution3937 {
    public int minOperations(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;

        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                if (y == x) {
                    continue;
                }
                int[] target = new int[]{x, y};
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    int d = Math.abs(nums[i] % k - target[i % 2]);
                    sum += Math.min(d, k - d); // 直接走到 target[i%2]，或者反向绕一圈到 target[i%2]
                }
                ans = Math.min(ans, sum);
            }
        }

        return ans;
    }
}
/*
3937. 使数组变为模交替数组的最少操作次数 I
https://leetcode.cn/problems/minimum-operations-to-make-array-modulo-alternating-i/description/

第 183 场双周赛 T2。

给你一个整数数组 nums 和一个整数 k 。
在一步操作中，你可以将 nums 中的任意元素 增加 或 减少 1 。
如果存在两个 不同 的整数 x 和 y （0 <= x, y < k）满足以下条件，则称数组为 模交替 数组：
- 对于每个 偶数 下标 i ，nums[i] % k == x
- 对于每个 奇数 下标 i ，nums[i] % k == y
返回使 nums 成为 模交替 数组所需的 最少 操作次数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 10^9
2 <= k <= 100

暴力枚举
时间复杂度 O(n * k^2)。
另有 O(nlogn) 的做法。
 */