import java.util.Arrays;

public class Solution4054 {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        int[] stack = new int[n];
        int top = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (top > 0 && nums[stack[top - 1]] >= nums[i]) {
                top--;
            }
            nextSmaller[i] = (top == 0) ? n : stack[top - 1];
            stack[top++] = i;
        }
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (a, b) -> Integer.compare(nums[b], nums[a]));

        int[] bit = new int[n + 1];
        long ans = 0;
        int ptr = 0;
        for (int idx = 0; idx < n; idx++) {
            int i = ids[idx];
            while (ptr < n && nums[ids[ptr]] > nums[i]) {
                add(bit, ids[ptr] + 1, n);
                ptr++;
            }
            int l = i + 1;
            int r = nextSmaller[i] - 1;
            if (l <= r) {
                ans += query(bit, r + 1) - query(bit, l);
            }
        }
        return ans;
    }

    private void add(int[] bit, int pos, int n) {
        for (; pos <= n; pos += pos & (-pos)) {
            bit[pos]++;
        }
    }

    private int query(int[] bit, int pos) {
        int sum = 0;
        for (; pos > 0; pos -= pos & (-pos)) {
            sum += bit[pos];
        }
        return sum;
    }
}
/*
4054. 统计影子数对 I
https://leetcode.cn/problems/count-shadow-pairs-i/description/

第 519 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
如果一对下标 (i, j) 满足以下所有条件，则称其为一个影子对 ：
- 0 <= i < j < n
- nums[i] < nums[j]
- 不存在 下标 k，使得 i < k < j 且 nums[k] < nums[i] < nums[j]。
返回 影子对 的总数。
提示：
3 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9

单调栈 + 排序 + 树状数组。
时间复杂度 O(nlogn)。
 */