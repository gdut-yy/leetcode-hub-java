import java.util.Arrays;

public class Solution3934 {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        SuffixArray sufArr = new SuffixArray(nums);
        int[] sa = sufArr.sa0;
        int[] height = sufArr.height0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            // 对于后缀 nums[sa[i]:]，其长为 uniqueLength 的前缀是唯一的
            int h = height[i];
            int uniqueLength = h + 1;
            if (i < n - 1) uniqueLength = Math.max(h, height[i + 1]) + 1;
            // 注意 uniqueLength 不能超过后缀 nums[sa[i]:] 的长度
            if (uniqueLength <= n - sa[i]) {
                ans = Math.min(ans, uniqueLength);
            }
        }
        return ans;
    }

    static class SuffixArray {
        int[] data;
        int[] rk, old_rk, sa, id, cnt;
        int[] sa0, height0, rk0;

        public SuffixArray(int[] S) {
            data = S;
            int n = S.length, p;
            int m = 0;
            for (int x : S) m = Math.max(m, x);
            m = Math.max(m, 1);
            rk = new int[n * 2 + 1];
            old_rk = new int[n * 2 + 1];
            id = new int[n + 1];
            cnt = new int[Math.max(n + 1, m + 1)];
            sa = new int[n + 1];
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) s[i] = S[i - 1];
            for (int i = 1; i <= n; i++) cnt[rk[i] = s[i]]++;
            for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
            for (int i = n; i >= 1; i--) sa[cnt[rk[i]]--] = i;
            for (int w = 1; ; w <<= 1, m = p) {
                int cur = 0;
                for (int i = n - w + 1; i <= n; i++) id[++cur] = i;
                for (int i = 1; i <= n; i++) {
                    if (sa[i] > w) id[++cur] = sa[i] - w;
                }
                Arrays.fill(cnt, 0);
                for (int i = 1; i <= n; i++) cnt[rk[i]]++;
                for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
                for (int i = n; i >= 1; i--) sa[cnt[rk[id[i]]]--] = id[i];
                p = 0;
                System.arraycopy(rk, 0, old_rk, 0, old_rk.length);
                for (int i = 1; i <= n; i++) {
                    if (old_rk[sa[i]] == old_rk[sa[i - 1]] && old_rk[sa[i] + w] == old_rk[sa[i - 1] + w]) {
                        rk[sa[i]] = p;
                    } else rk[sa[i]] = ++p;
                }
                if (p == n) break;
            }
            sa0 = new int[n];
            for (int i = 0; i < n; i++) sa0[i] = sa[i + 1] - 1;
            rk0 = new int[n];
            for (int i = 0; i < n; i++) rk0[i] = rk[i + 1] - 1;
            height0 = new int[n + 1];
            int k = 0;
            for (int i = 1; i <= n; i++) {
                if (rk[i] == 1) continue;
                if (k > 0) --k;
                int j = sa[rk[i] - 1];
                while (i + k <= n && j + k <= n && s[i + k] == s[j + k]) k++;
                height0[rk[i] - 1] = k;
            }
        }
    }
}
/*
3934. 最短唯一子数组
https://leetcode.cn/problems/smallest-unique-subarray/description/

第 502 场周赛 T4。

给你一个整数数组 nums 。
找出 nums 中与其他任何 子数组 均 不 相同 的 子数组 的 最小 长度。
返回一个整数，表示此类 子数组 的 最小可能长度 。
子数组 是数组中的一个连续的非空元素序列。
如果两个 子数组 具有相同的长度，并且对应位置的元素也相同，则认为这两个 子数组 是相同的。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

后缀数组
https://leetcode.cn/problems/smallest-unique-subarray/solutions/3969717/on-hou-zhui-shu-zu-by-endlesscheng-la59/
 */