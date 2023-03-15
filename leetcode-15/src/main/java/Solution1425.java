import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int ans = nums[0];
        for (int i = 1; i < n; ++i) {
            // 如果队首的 j 与 i 的差值大于 k，则不满足要求，弹出
            while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.removeFirst();
            }
            // 此时队首的 j 即为最优的 j 值
            f[i] = Math.max(f[deque.peekFirst()], 0) + nums[i];
            ans = Math.max(ans, f[i]);
            // 维护队列的单调性，不断从队尾弹出元素
            while (!deque.isEmpty() && f[i] >= f[deque.peekLast()]) {
                deque.removeLast();
            }
            // 将 i 作为之后的新 j 值放入队尾
            deque.addLast(i);
        }
        return ans;
    }
}
/*
1425. 带限制的子序列和
https://leetcode.cn/problems/constrained-subsequence-sum/

给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
提示：
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
 */