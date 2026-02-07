import java.util.Arrays;

public class SolutionP3763 {
    public long maxSum(int[] nums, int[] threshold) {
        int n = nums.length;
        int[][] t = new int[n][2];
        for (int i = 0; i < n; i++) {
            t[i][0] = threshold[i];
            t[i][1] = -nums[i];
        }
        Arrays.sort(t, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (t[i][0] > i + 1) return ans;
            ans -= t[i][1];
        }
        return ans;
    }
}
/*
$3763. 带阈值约束的最大总和
https://leetcode.cn/problems/maximum-total-sum-with-threshold-constraints/description/

给定两个整数数组 nums 和 threshold，长度都是 n。
从 step = 1 开始，重复执行下面操作：
- 找到一个 未使用 的下标 i 使得 threshold[i] <= step。
  - 如果没有这样的下标存在，流程结束。
- 将 nums[i] 加到你的累计总和中。
- 将索引 i 标记为已使用，并将 step 增加 1。
返回通过选择索引来获得的 最大总和。
提示：
n == nums.length == threshold.length
1 <= n <= 10^5
1 <= nums[i] <= 10^9
1 <= threshold[i] <= n

贪心。
https://leetcode.cn/problems/maximum-total-sum-with-threshold-constraints/solutions/3846011/tan-xin-by-serene-torvalds38a-auv6/
时间复杂度 O(nlogn)。
 */