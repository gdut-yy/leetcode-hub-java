import java.util.ArrayList;
import java.util.List;

public class SolutionP3874 {
    public long validSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kk = k + 1; // 窗口限制（k+1）
        // has 记录峰值下标，首尾各加哨兵 -1 和 n
        List<Integer> has = new ArrayList<>();
        has.add(-1);
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                has.add(i);
            }
        }
        has.add(n);
        // 每个峰值作为唯一峰值的子数组数 = 左侧可选长度 * 右侧可选长度
        long ans = 0;
        for (int i = 1; i < has.size() - 1; i++) {
            ans += (long) Math.min(kk, has.get(i) - has.get(i - 1))
                    * Math.min(kk, has.get(i + 1) - has.get(i));
        }
        return ans;
    }
}
/*
$3874. 具有恰好一个峰值的有效子数组
https://leetcode.cn/problems/valid-subarrays-with-exactly-one-peak/description/

给定一个长度为 n 的整数数组 nums 和一个整数 k。
下标 i 是 峰值 的条件为：
- 0 < i < n - 1
- nums[i] > nums[i - 1] 且 nums[i] > nums[i + 1]
一个子数组 [l, r] 是 有效 的条件是：
- 它 恰好有一个 nums 中下标 i 处的峰值
- i - l <= k 且 r - i <= k
返回一个整数，表示 nums 中 有效子数组 的数量。
子数组 是数组中的连续 非空 元素序列。
示例 1：
输入：nums = [1,3,2], k = 1
输出：4
示例 2：
输入：nums = [7,8,9], k = 2
输出：0
示例 3：
输入：nums = [4,3,5,1], k = 2
输出：6
提示：
1 <= n == nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
1 <= k <= n
 */