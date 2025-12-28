import java.util.Arrays;

public class Solution3768 {
    public long minInversionCount(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[m++] = sorted[i];
            }
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
        }

        BIT tr = new BIT(m);
        long invCount = 0;
        for (int i = 0; i < k; i++) {
            int r = rank[i];
            invCount += i - tr.query(r);
            tr.add(r, 1);
        }
        long ans = invCount;
        for (int l = 0; l < n - k; l++) {
            int r = l + k - 1;
            int rankL = rank[l];
            int leftCount = tr.query(rankL - 1);
            invCount -= leftCount;
            tr.add(rankL, -1);
            int rankR1 = rank[r + 1];
            int rightCount = tr.query(rankR1);
            int greater = (k - 1) - rightCount;
            invCount += greater;
            tr.add(rankR1, 1);
            ans = Math.min(ans, invCount);
        }
        return ans;
    }

    // 树状数组
    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
3768. 固定长度子数组中的最小逆序对数目
https://leetcode.cn/problems/minimum-inversion-count-in-subarrays-of-fixed-length/description/

第 171 场双周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
逆序对 是指 nums 中满足 i < j 且 nums[i] > nums[j] 的一对下标 (i, j)。
子数组 的 逆序对数量 是指该子数组内逆序对的个数。
返回 nums 中所有长度为 k 的 子数组 中的 最小 逆序对数量。
子数组 是数组中一个连续的非空元素序列。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= n

定长滑窗 + 离散化 + 树状数组。
https://chat.deepseek.com/a/chat/s/fb9a5518-f08e-4bf1-a4de-6599528a97f0
时间复杂度 O(nlogn)。
 */