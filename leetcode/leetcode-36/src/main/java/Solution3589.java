import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3589 {
    static final int MAX_N = (int) 1e5;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MAX_N; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    public int primeSubarray(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        Deque<Integer> maxQ = new ArrayDeque<>(); // maxQ.getFirst() 为区间内最大值下标
        Deque<Integer> minQ = new ArrayDeque<>(); // minQ.getFirst() 为区间内最小值下标

        // 上上个质数位置 last2
        int last = -1, last2 = -1;
        while (r < n) {
            if (!np[nums[r]]) {
                // 1、入
                last2 = last;
                last = r;

                // 这里加不加 = 都可以
                while (!maxQ.isEmpty() && nums[r] > nums[maxQ.getLast()]) maxQ.removeLast();
                maxQ.addLast(r);
                while (!minQ.isEmpty() && nums[r] < nums[minQ.getLast()]) minQ.removeLast();
                minQ.addLast(r);

                while (!maxQ.isEmpty() && !minQ.isEmpty()
                        && nums[maxQ.getFirst()] - nums[minQ.getFirst()] > k) {
                    if (maxQ.getFirst() <= l) maxQ.removeFirst();
                    if (minQ.getFirst() <= l) minQ.removeFirst();
                    l++;
                }
            }
            // 3、更新答案。当右端点固定时，左端点合法范围 [l, last2]
            ans += last2 - l + 1;
            r++;
        }
        return ans;
    }
}
/*
3589. 计数质数间隔平衡子数组
https://leetcode.cn/problems/count-prime-gap-balanced-subarrays/description/

第 159 场双周赛 T3。

给定一个整数数组 nums 和一个整数 k。
子数组 被称为 质数间隔平衡，如果：
- 其包含 至少两个质数，并且
- 该 子数组 中 最大 和 最小 质数的差小于或等于 k。
返回 nums 中质数间隔平衡子数组的数量。
注意：
- 子数组 是数组中连续的 非空 元素序列。
- 质数是大于 1 的自然数，它只有两个因数，即 1 和它本身。
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 5 * 10^4
0 <= k <= 5 * 10^4

预处理质数 + 滑动窗口最大值最小值。
时间复杂度 O(n)。
相似题目: 1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
3578. 统计极差最大为 K 的分割方式数
https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k/description/
rating 2198 (clist.by)
 */