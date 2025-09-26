public class Solution3685 {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] ans = new boolean[n];
        int[] cnt = new int[n + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] suf = new int[n + 2];
        suf[n] = 0;
        for (int i = n - 1; i >= 1; i--) {
            suf[i] = suf[i + 1] + cnt[i + 1];
        }
        boolean[] f = new boolean[k + 1];
        f[0] = true;
        int maxX = Math.min(n, k);
        for (int x = 1; x <= maxX; x++) {
            int c = cnt[x];
            if (c > 0) {
                int num = c;
                int power = 1;
                while (power <= num) {
                    int s = power;
                    int total = s * x;
                    if (total <= k) {
                        for (int j = k; j >= total; j--) {
                            if (f[j - total]) {
                                f[j] = true;
                            }
                        }
                    }
                    num -= s;
                    power <<= 1;
                }
                if (num > 0) {
                    int total = num * x;
                    if (total <= k) {
                        for (int j = k; j >= total; j--) {
                            if (f[j - total]) {
                                f[j] = true;
                            }
                        }
                    }
                }
            }
            int m = suf[x];
            int maxT = Math.min(m, k / x);
            boolean found = false;
            for (int t = 0; t <= maxT; t++) {
                int remain = k - t * x;
                if (remain < 0) {
                    break;
                }
                if (f[remain]) {
                    found = true;
                    break;
                }
            }
            ans[x - 1] = found;
        }
        for (int x = maxX + 1; x <= n; x++) {
            ans[x - 1] = f[k];
        }
        return ans;
    }
}
/*
3685. 含上限元素的子序列和
https://leetcode.cn/problems/subsequence-sum-after-capping-elements/description/

第 467 场周赛 T3。

给你一个大小为 n 的整数数组 nums 和一个正整数 k。
通过将每个元素 nums[i] 替换为 min(nums[i], x)，可以得到一个由值 x 限制（capped）的数组。
对于从 1 到 n 的每个整数 x，确定是否可以从由 x 限制的数组中选择一个 子序列，使所选元素的和 恰好 为 k。
返回一个下标从 0 开始的布尔数组 answer，其大小为 n，其中 answer[i] 为 true 表示当 x = i + 1 时可以选出满足要求的子序列；否则为 false。
子序列 是一个从数组中通过删除一些或不删除任何元素（且不改变剩余元素顺序）派生出来的 非空 数组。
提示：
1 <= n == nums.length <= 4000
1 <= nums[i] <= n
1 <= k <= 4000

https://yuanbao.tencent.com/chat/naQivTmsDa/46fb2110-a302-44b3-b5eb-f5c9f557ebef
 */