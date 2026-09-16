public class Solution4037 {
    private int[][] st;
    private int[] lg;
    private int n;

    public int maxValidSplits(int[] nums) {
        n = nums.length;
        int K = 32 - Integer.numberOfLeadingZeros(Math.max(1, n));
        st = new int[K][n];
        for (int i = 0; i < n; i++) st[0][i] = nums[i];
        for (int k = 1; k < K; k++) {
            int half = 1 << (k - 1);
            int len = 1 << k;
            for (int i = 0; i + len <= n; i++) {
                st[k][i] = gcd(st[k - 1][i], st[k - 1][i + half]);
            }
        }
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) lg[i] = lg[i >> 1] + 1;

        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) pre[i] = gcd(pre[i - 1], nums[i]);
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) suf[i] = gcd(suf[i + 1], nums[i]);
        int G0 = pre[n - 1];

        int best = 0;
        int p0 = 0;
        while (pre[p0] != G0) p0++;
        int k20 = n - 1;
        while (suf[k20] != G0) k20--;
        best = Math.max(best, k20 - p0);

        for (int j = 0; j < n; j++) {
            int G = gcd(j > 0 ? pre[j - 1] : 0, j + 1 < n ? suf[j + 1] : 0);
            int m = n - 1;
            int lo = 0, hi = m - 1;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (prefixGcd(j, mid) <= G) hi = mid;
                else lo = mid + 1;
            }
            int p = lo;
            lo = 0;
            hi = m - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                if (suffixGcd(j, mid) <= G) lo = mid;
                else hi = mid - 1;
            }
            int k2 = lo;
            best = Math.max(best, k2 - p);
        }
        return best;
    }

    private int prefixGcd(int j, int t) {
        if (t < j) return rangeGcd(0, t);
        return gcd(rangeGcd(0, j - 1), rangeGcd(j + 1, t + 1));
    }

    private int suffixGcd(int j, int k) {
        if (k > j) return rangeGcd(k + 1, n - 1);
        return gcd(rangeGcd(k, j - 1), rangeGcd(j + 1, n - 1));
    }

    private int rangeGcd(int l, int r) {
        if (l > r) return 0;
        int len = r - l + 1;
        int k = lg[len];
        return gcd(st[k][l], st[k][r - (1 << k) + 1]);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
/*
4037. 最多有效分割位置 II
https://leetcode.cn/problems/maximum-valid-split-positions-ii/description/

第 190 场双周赛 T4。

给你一个整数数组 nums。
你可以从 nums 中移除 至多一个 元素。记 arr 为按原始顺序保留其余元素后得到的数组，m 为其长度。
如果 arr 的 分割位置 i 满足以下条件，则称其为 有效的 ：
- 0 <= i < m - 1，且
- gcd(arr[0..i]) == gcd(arr[i + 1..m - 1])。
长度为 1 的数组没有有效的分割位置。
arr 的 得分 是有效分割位置的数量。
返回 arr 的 最大可能得分 。
gcd(a) 表示数组 a 中所有元素的最大公约数。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

前后缀分解。
 */