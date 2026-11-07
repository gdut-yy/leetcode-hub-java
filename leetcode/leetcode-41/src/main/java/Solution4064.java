import java.util.Arrays;

public class Solution4064 {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = prefix[i] + nums[i];
            prefix[i + 1] = ((x % k) + k) % k;
        }

        final int INF = n + 1;
        int[] first = new int[k];
        int[] last = new int[k];
        Arrays.fill(first, INF);
        Arrays.fill(last, -1);
        for (int q = 0; q <= n; q++) {
            int r = prefix[q];
            if (first[r] == INF) {
                first[r] = q;
            }
            last[r] = q;
        }

        int ans = 0;

        for (int r = 0; r < k; r++) {
            if (first[r] != INF && last[r] > first[r]) {
                ans = Math.max(ans, last[r] - first[r]);
            }
        }

        int[] c = new int[n];
        int[] cnt = new int[k];
        for (int i = 0; i < n; i++) {
            int v = ((nums[i] * 2) % k + k) % k;
            c[i] = v;
            cnt[v]++;
        }
        int[][] occ = new int[k][];
        for (int t = 0; t < k; t++) {
            if (cnt[t] > 0) {
                occ[t] = new int[cnt[t]];
            }
        }
        int[] cur = new int[k];
        for (int i = 0; i < n; i++) {
            int t = c[i];
            occ[t][cur[t]++] = i;
        }

        for (int t = 1; t < k; t++) {
            if (cnt[t] == 0) {
                continue;
            }
            int[] positions = occ[t];
            for (int p = 0; p < k; p++) {
                if (first[p] == INF) {
                    continue;
                }
                int r = p + t;
                if (r >= k) {
                    r -= k;
                }
                if (last[r] < 0) {
                    continue;
                }
                int left = first[p];
                int right = last[r];
                if (right <= left) {
                    continue;
                }
                int idx = lowerBound(positions, left);
                if (idx < positions.length && positions[idx] <= right - 1) {
                    ans = Math.max(ans, right - left);
                }
            }
        }
        return ans;
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
4064. 至多一次取反能被 K 整除的最长子数组 II
https://leetcode.cn/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-ii/description/

第 192 场双周赛 T4。

给你一个整数数组 nums 和一个整数 k。
如果一个子数组的和能够被 k 整除，或者在 将该子数组中的一个元素取反 后能使和被 k 整除，则称该子数组是 有效的 。
将一个元素取反意味着将其值 x 替换为 -x。
返回 最长有效子数组的长度 。如果不存在有效的子数组，则返回 0。
子数组 是数组中一个连续且非空的元素序列。
示例 1：
输入： nums = [4,1,2], k = 3
输出： 3
示例 2：
输入： nums = [5,3,4], k = 7
输出： 2
示例 3：
输入： nums = [2,2,5], k = 6
输出： 2
提示：
1 <= nums.length <= 1000
-10^5 <= nums[i] <= 10^5
1 <= k <= 10^5

枚举。
时间复杂度：O(n + k^2 * logn)。
 */