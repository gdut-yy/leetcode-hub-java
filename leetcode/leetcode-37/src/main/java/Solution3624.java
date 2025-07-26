import java.util.Arrays;

public class Solution3624 {
    public int[] popcountDepth(long[] nums, long[][] queries) {
        int n = nums.length;
        BIT[] f = new BIT[6];
        Arrays.setAll(f, e -> new BIT(n + 1));

        for (int i = 0; i < n; i++) {
            update(i, nums[i], 1, f); // 添加
        }

        int ansSize = 0;
        for (long[] q : queries) {
            ansSize += q[0] == 1 ? 1 : 0;
        }

        int[] ans = new int[ansSize];
        int idx = 0;
        for (long[] q : queries) {
            if (q[0] == 1) {
                ans[idx++] = f[(int) q[3]].query((int) q[1] + 1, (int) q[2] + 1);
            } else {
                int i = (int) q[1];
                update(i, nums[i], -1, f); // 撤销旧的
                nums[i] = q[2];
                update(i, nums[i], 1, f); // 添加新的
            }
        }
        return ans;
    }

    private void update(int i, long x, int delta, BIT[] f) {
        int d = popDepth(x);
        f[d].add(i + 1, delta);
    }

    // 不写记忆化，直接迭代
    private int popDepth(long x) {
        int res = 0;
        while (x > 1) {
            res++;
            x = Long.bitCount(x);
        }
        return res;
    }

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

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        int query(int l, int r) {
            return pre(r) - pre(l - 1);
        }
    }
}
/*
3624. 位计数深度为 K 的整数数目 II
https://leetcode.cn/problems/number-of-integers-with-popcount-depth-equal-to-k-ii/description/

第 459 场周赛 T3。

给你一个整数数组 nums。
对于任意正整数 x，定义以下序列：
- p0 = x
- pi+1 = popcount(pi)，对于所有 i >= 0，其中 popcount(y) 表示整数 y 的二进制表示中 1 的个数。
这个序列最终会收敛到值 1。
popcount-depth（位计数深度）定义为满足 pd = 1 的最小整数 d >= 0。
例如，当 x = 7（二进制表示为 "111"）时，该序列为：7 → 3 → 2 → 1，因此 7 的 popcount-depth 为 3。
此外，给定一个二维整数数组 queries，其中每个 queries[i] 可以是以下两种类型之一：
- [1, l, r, k] - 计算在区间 [l, r] 中，满足 nums[j] 的 popcount-depth 等于 k 的索引 j 的数量。
- [2, idx, val] - 将 nums[idx] 更新为 val。
返回一个整数数组 answer，其中 answer[i] 表示第 i 个类型为 [1, l, r, k] 的查询的结果。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^15
1 <= queries.length <= 10^5
queries[i].length == 3 或 4
queries[i] == [1, l, r, k] 或
queries[i] == [2, idx, val]
0 <= l <= r <= n - 1
0 <= k <= 5
0 <= idx <= n - 1
1 <= val <= 10^15

6 个树状数组 https://leetcode.cn/problems/number-of-integers-with-popcount-depth-equal-to-k-ii/solutions/3728547/6-ge-shu-zhuang-shu-zu-pythonjavacgo-by-klqxt/
rating 2100 (clist.by)
 */