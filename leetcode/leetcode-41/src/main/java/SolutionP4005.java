import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP4005 {
    // https://leetcode.cn/problems/minimum-operations-to-make-array-equal-iii/solutions/4032252/fu-za-du-wei-on-log-n-log-mde-jie-fa-zhi-t0as/
    public long minOperations(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int v : nums) {
            counter.merge(v, 1, Integer::sum);
        }
        List<int[]> numCounted = new ArrayList<>(counter.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toList());
        numCounted.sort(Comparator.comparingInt(x -> x[0]));
        int M = numCounted.size();
        if (M == 1) {
            return 0;
        }
        // Find dominated numbers: count(A) > count((A/2, 2A)) / 2
        long ans = nums.length;
        int left = 0;
        int right = 0;
        long s = 0;
        for (int i = 0; i < M; i++) {
            int k = numCounted.get(i)[0];
            int c = numCounted.get(i)[1];
            while (right < M && numCounted.get(right)[0] < 2 * k) {
                s += numCounted.get(right)[1];
                right++;
            }
            while (numCounted.get(left)[0] * 2 <= k) {
                s -= numCounted.get(left)[1];
                left++;
            }
            if (k != 1 && (long) c * 2 > s) {
                long ans2 = 0;
                for (int[] e : numCounted) {
                    int k2 = e[0];
                    int c2 = e[1];
                    ans2 += (long) (2 - (k2 % k == 0 ? 1 : 0) - (k % k2 == 0 ? 1 : 0)) * c2;
                }
                ans = Math.min(ans, ans2);
            }
        }
        return ans;
    }
}
/*
$4005. 使数组中所有元素相等的最小操作数 III
https://leetcode.cn/problems/minimum-operations-to-make-array-equal-iii/description/

给定一个整数数组 nums。
在一次操作中，你可以选择任意元素 nums[i]，并执行以下操作之一：
乘法：将 nums[i] 乘以一个整数 k，其中 k >= 2。
除法：将 nums[i] 除以一个整数 k，其中 2 <= k < nums[i]，并且要求 nums[i] 可以被 k 整除。
返回使 nums 中所有元素 相等 所需的 最少操作次数。
示例 1：
输入： nums = [6,12,8]
输出： 3
示例 2：
输入： nums = [5,15,20]
输出： 2
示例 3：
输入： nums = [7,7,7]
输出： 0
约束条件：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
 */