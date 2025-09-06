import java.util.HashMap;
import java.util.Map;

public class SolutionP3416 {
    private static final int MOD = (int) (1e9 + 7);

    public int subsequencesWithMiddleMode(int[] nums) {
        long n = nums.length;
        long ans = n * (n - 1) % MOD
                * (n - 2) % MOD
                * (n - 3) % MOD
                * (n - 4) % MOD
                * quickPow(120, MOD - 2) % MOD; // 所有方案数
        Map<Integer, Integer> suf = new HashMap<>();
        for (int x : nums) {
            suf.merge(x, 1, Integer::sum); // suf[x]++
        }
        Map<Integer, Integer> pre = new HashMap<>(suf.size()); // 预分配空间

        long cp = 0, cs = 0, ps = 0, p2s = 0, ps2 = 0;
        for (int c : suf.values()) {
            cs += comb2(c);
        }

        // 枚举 x，作为子序列正中间的数
        for (int left = 0; left < n - 2; left++) {
            int x = nums[left];
            suf.merge(x, -1, Integer::sum); // suf[x]--

            long px = pre.getOrDefault(x, 0);
            long sx = suf.get(x);

            cs -= sx;
            ps -= px;
            p2s -= px * px;
            ps2 -= (sx * 2 + 1) * px;

            long right = n - 1 - left;
            ans -= comb2(left - px) * comb2(right - sx) % MOD;
            ans -= (cp - comb2(px)) * sx * (right - sx) % MOD;
            ans -= (cs - comb2(sx)) * px * (left - px) % MOD;
            ans -= ((ps - px * sx) * (right - sx) - (ps2 - px * sx * sx)) * px % MOD;
            ans -= ((ps - px * sx) * (left - px) - (p2s - px * px * sx)) * sx % MOD;

            cp += px;
            ps += sx;
            ps2 += sx * sx;
            p2s += (px * 2 + 1) * sx;

            pre.merge(x, 1, Integer::sum); // pre[x]++
        }
        ans = (ans % MOD + MOD) % MOD;
        return (int) ans;
    }

    private long comb2(long num) {
        return num * (num - 1) / 2;
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
$3416. 唯一中间众数子序列 II
https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-ii/description/

给你一个整数数组 nums ，请你求出 nums 中大小为 5 的 子序列 的数目，它是 唯一中间众数序列 。
由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
众数 指的是一个数字序列中出现次数 最多 的元素。
如果一个数字序列众数只有一个，我们称这个序列有 唯一众数 。
一个大小为 5 的数字序列 seq ，如果它中间的数字（seq[2]）是唯一众数，那么称它是 唯一中间众数 序列。
提示：
5 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

需注意大数乘法溢出。
https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-i/solutions/3026877/zheng-nan-ze-fan-fen-lei-tao-lun-qian-ho-f7cd/
时间复杂度 O(n)。
相似题目: 3395. 唯一中间众数子序列 I
https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-i/description/
 */