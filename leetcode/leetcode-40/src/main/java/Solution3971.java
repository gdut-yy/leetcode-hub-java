public class Solution3971 {
    private static final int MOD = (int) (1e9 + 7);
    private static final long INV2 = (MOD + 1) / 2;

    public int maxTotalValue(int[] value, int[] decay, int m) {
        int n = value.length;
        long totalPositive = 0;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = (int) Math.min((long) (value[i] + decay[i] - 1) / decay[i], m);
            totalPositive += count[i];
            if (totalPositive > m) totalPositive = m + 1;
        }
        if (m >= totalPositive) {
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = (ans + sumK(value[i], decay[i], count[i])) % MOD;
            }
            return (int) ans;
        }
        int maxVal = 0;
        for (int v : value) maxVal = Math.max(maxVal, v);
        long lo = 0, hi = maxVal;
        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;
            long cnt = countGE(value, decay, mid, m);
            if (cnt >= m) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        long T = lo;
        long totalSum = 0;
        long taken = 0;
        for (int i = 0; i < n; i++) {
            if (value[i] < T) continue;
            long ki = (value[i] - T) / decay[i] + 1;
            if (ki > count[i]) ki = count[i];
            long s = sumK(value[i], decay[i], ki);
            totalSum = (totalSum + s) % MOD;
            taken += ki;
        }
        if (taken > m) {
            long excess = taken - m;
            totalSum = (totalSum - (excess % MOD) * (T % MOD) % MOD + MOD) % MOD;
        }
        return (int) totalSum;
    }

    private long sumK(long v, long d, long k) {
        long part1 = (k % MOD) * (v % MOD) % MOD;
        long part2 = (d % MOD) * (k % MOD) % MOD * ((k - 1) % MOD) % MOD * INV2 % MOD;
        return (part1 - part2 + MOD) % MOD;
    }

    private long countGE(int[] value, int[] decay, long T, int m) {
        long cnt = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] >= T) {
                long ki = (value[i] - T) / decay[i] + 1;
                cnt += ki;
                if (cnt > m) return m + 1;
            }
        }
        return cnt;
    }
}
/*
3971. 最大总价值
https://leetcode.cn/problems/maximum-total-value/description/

第 507 场周赛 T4。

给你两个整数数组 value 和 decay，以及一个整数 m。
- value[i] 表示下标 i 的初始价值。
- decay[i] 表示每次选择下标 i 后，该下标的价值会减少的数值。
你可以多次 选择 任意下标。所有下标的总选择次数不得超过 m。
如果重复选择下标 i，第 t 次（从 1 开始计数）获得的价值为 value[i] - decay[i] * (t - 1)。
返回你能够获得的 最大 总价值。由于答案可能很大，请返回其对 10^9 + 7 取模后的结果。
提示：
1 <= value.length == decay.length <= 10^5
1 <= value[i], decay[i] <= 10^9
1 <= m <= 10^9

二分第 m 大价值。
 */