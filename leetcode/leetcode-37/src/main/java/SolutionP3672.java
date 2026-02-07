import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionP3672 {
    public long modeWeight(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        // 大顶堆
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // 1. 右进
            mp.merge(nums[r], 1, Integer::sum);
            maxH.offer(new int[]{nums[r], mp.get(nums[r])});
            // 2.不满足窗口大小，继续
            if (r < k - 1) continue;
            // 3. 更新
            // 因为左出并没有实际出，需要过滤一下和map保存不一致的值
            while (mp.get(maxH.peek()[0]) != maxH.peek()[1]) maxH.poll();
            ans += (long) maxH.peek()[0] * (long) maxH.peek()[1];
            // 4. 左出
            maxH.offer(new int[]{nums[l], mp.get(nums[l]) - 1});
            mp.merge(nums[l], -1, Integer::sum);
            l++;
        }
        return ans;
    }
}
/*
$3672. 子数组中加权众数的总和
https://leetcode.cn/problems/sum-of-weighted-modes-in-subarrays/description/

给定一个整数数组 nums 和一个整数 k。
对于每个长度为 k 的 子数组：
- 众数 mode 是指 出现频率最高 的元素。如果有多个众数，取其中 最小 的那个元素。
- 权重 定义为 mode * frequency(mode)。
返回长度为 k 的所有 子数组 的权重之 和。
注意：
- 子数组 是数组中连续的 非空 元素序列。
- 元素 x 的 频率 是它在数组中出现的次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= nums.length

滑动窗口 + 大顶堆。
时间复杂度 O(nlogn)。
 */