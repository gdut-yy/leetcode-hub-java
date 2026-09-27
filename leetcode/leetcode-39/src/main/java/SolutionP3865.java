import java.util.Arrays;
import java.util.List;
import java.util.stream.Gatherers;

public class SolutionP3865 {
    public int[] reverseSubarrays(int[] nums, int k) {
        int windowSize = nums.length / k;
        return Arrays.stream(nums)
                .boxed()
                .gather(Gatherers.windowFixed(windowSize))
                .map(List::reversed)
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
/*
$3865. 反转 K 个子数组
https://leetcode.cn/problems/reverse-k-subarrays/description/

给定一个长度为 n 的整数数组 nums 和一个整数 k。
你必须将数组 划分 为 k 个长度 相等 的连续子数组，并 反转 每个子数组。
保证 n 能被 k 整除。
返回上述操作后的结果数组。
示例 1：
输入：nums = [1,2,4,3,5,6], k = 3
输出：[2,1,3,4,6,5]
示例 2：
输入：nums = [5,4,4,2], k = 1
输出：[2,4,4,5]
提示：
1 <= n == nums.length <= 1000
1 <= nums[i] <= 1000
1 <= k <= n
n 能被 k 整除。
 */