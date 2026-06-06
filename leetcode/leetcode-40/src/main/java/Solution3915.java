public class Solution3915 {
    public long maxAlternatingSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
        }
        int MAX = maxVal;

        FenwickTree bitDown = new FenwickTree(MAX);
        FenwickTree bitUpRev = new FenwickTree(MAX);

        long[] up = new long[n];
        long[] down = new long[n];
        long ans = 0;

        int cur = 0;
        for (int i = 0; i < n; i++) {
            while (cur <= i - k) {
                bitDown.update(nums[cur], down[cur]);
                int rev = MAX - nums[cur] + 1;
                bitUpRev.update(rev, up[cur]);
                cur++;
            }

            long bestDown = (nums[i] > 1) ? bitDown.query(nums[i] - 1) : 0;
            int revQuery = MAX - nums[i];
            long bestUp = (revQuery > 0) ? bitUpRev.query(revQuery) : 0;

            up[i] = nums[i];
            down[i] = nums[i];
            if (bestDown > 0) {
                up[i] = Math.max(up[i], bestDown + nums[i]);
            }
            if (bestUp > 0) {
                down[i] = Math.max(down[i], bestUp + nums[i]);
            }
            ans = Math.max(ans, Math.max(up[i], down[i]));
        }

        return ans;
    }

    static class FenwickTree {
        long[] tree;
        int n;

        FenwickTree(int size) {
            n = size;
            tree = new long[n + 2];
        }

        void update(int idx, long val) {
            while (idx <= n) {
                if (val > tree[idx]) {
                    tree[idx] = val;
                }
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            if (idx <= 0) return 0;
            long res = 0;
            while (idx > 0) {
                if (tree[idx] > res) {
                    res = tree[idx];
                }
                idx -= idx & -idx;
            }
            return res;
        }
    }
}
/*
3915. 距离至少为 K 的交替子序列的最大和
https://leetcode.cn/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/description/

第 499 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
选择一个下标满足 0 <= i1 < i2 < ... < im < n 的 子序列，并满足：
- 对于每个 1 <= t < m，都有 it+1 - it >= k。
- 所选的值构成一个 严格交替 序列。换句话说，满足以下两种形式之一：
  - nums[i1] < nums[i2] > nums[i3] < ...，或
  - nums[i1] > nums[i2] < nums[i3] > ...
长度为 1 的 子序列 也被认为符合 严格交替 。一个 有效 子序列的得分为其所选元素值的 总和。
返回一个整数，表示有效子序列可能取得的 最大得分。
子序列 是指通过删除原数组中的某些元素或不删除任何元素，并且不改变剩余元素相对顺序后得到的数组。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= n

值域树状数组优化状态机 DP。
https://chat.deepseek.com/a/chat/s/3ec4c9fc-f29e-417a-bd5e-bb8ebf87777e
时间复杂度 O(nlogn)。
 */