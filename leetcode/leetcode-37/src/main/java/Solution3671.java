import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3671 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MAX = (int) (7e4 + 5);
    private static final List<Integer>[] divisors = new ArrayList[MAX];

    static {
        // 预处理每个数的因子
        Arrays.setAll(divisors, e -> new ArrayList<>());
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) { // 枚举 i 的倍数 j
                divisors[j].add(i); // i 是 j 的因子
            }
        }
    }

    public int totalBeauty(int[] nums) {
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }

        List<Integer>[] groups = new ArrayList[m + 1];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (int x : nums) {
            for (int d : divisors[x]) {
                groups[d].add(x);
            }
        }

        BIT t = new BIT(m);
        int[] f = new int[m + 1];
        long ans = 0;
        for (int i = m; i > 0; i--) {
            long res = countIncreasingSubsequence(groups[i], t);
            // 倍数容斥
            for (int j = i * 2; j <= m; j += i) {
                res -= f[j];
            }
            res %= MOD;
            f[i] = (int) res;
            // 注意 |f[i]| * i < MOD * (m / i) * i = MOD * m
            // m 个 MOD * m 相加，至多为 MOD * m * m，不会超过 64 位整数最大值
            ans += res * i;
        }
        // 保证结果非负
        return (int) ((ans % MOD + MOD) % MOD);
    }

    // 计算 b 的严格递增子序列的个数
    private long countIncreasingSubsequence(List<Integer> b, BIT t) {
        t.reset();
        long res = 0;
        for (int x : b) {
            // cnt 表示以 x 结尾的严格递增子序列的个数
            int cnt = (int) (t.pre(x - 1) + 1); // +1 是因为 x 可以一个数组成一个子序列
            res += cnt;
            t.add(x, cnt); // 更新以 x 结尾的严格递增子序列的个数
        }
        return res;
    }

    static class BIT {
        int n;
        long[] tree;
        int[] time;
        int now;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
            time = new int[n + 1];
            now = 0;
        }

        // 重置树状数组（懒重置）
        public void reset() {
            now++;
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, long val) {
            for (; pos <= n; pos += lb(pos)) {
                if (time[pos] < now) {
                    time[pos] = now;
                    tree[pos] = 0; // 懒重置
                }
                tree[pos] += val;
                tree[pos] %= MOD;
            }
        }

        long pre(int pos) {
            long ret = 0;
            for (; pos > 0; pos -= lb(pos)) {
                if (time[pos] == now) {
                    ret += tree[pos];
                }
            }
            return ret % MOD;
        }
    }
}
/*
3671. 子序列美丽值求和
https://leetcode.cn/problems/sum-of-beautiful-subsequences/description/

第 465 场周赛 T4。

给你一个长度为 n 的整数数组 nums。
对于每个 正整数 g，定义 g 的 美丽值 为 g 与 nums 中符合要求的子序列数量的乘积，子序列需要 严格递增 且最大公约数（GCD）恰好为 g 。
请返回所有正整数 g 的 美丽值 之和。
由于答案可能非常大，请返回结果对 10^9 + 7 取模后的值。
子序列 是一个 非空 数组，可以通过从另一个数组中删除某些元素（或不删除任何元素）而保持剩余元素顺序不变得到。
提示：
1 <= n == nums.length <= 10^4
1 <= nums[i] <= 7 × 10^4

懒初始化树状数组。
https://leetcode.cn/problems/sum-of-beautiful-subsequences/solutions/3768197/bei-shu-rong-chi-zhi-yu-shu-zhuang-shu-z-rs5w/
时间复杂度 O(DnlogU + UlogU)，其中 n 是 nums 的长度，U=max(nums)≤7×10^4，D≤120 为单个数的最大因子个数。
rating 2675 (clist.by)
 */