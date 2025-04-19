import java.util.Arrays;
import java.util.TreeMap;

public class Solution3505 {
    private int n, x, k;
    private long[] minCosts;
    private long[][] memo;

    public long minOperations(int[] nums, int x, int k) {
        this.n = nums.length;
        this.x = x;
        this.k = k;
        MultiSets multiSets = new MultiSets(x, x / 2 + 1);
        for (int i = 0; i < x; i++) {
            multiSets.add(nums[i]);
        }
        minCosts = new long[n - x + 1];
        long median = multiSets.xMap.firstKey();
        long minCost = multiSets.sumX - median * multiSets.xsz
                + median * multiSets.ysz - multiSets.sumY;
        minCosts[0] = minCost;
        for (int i = x; i < n; i++) {
            multiSets.add(nums[i]);
            multiSets.del(nums[i - x]);

            median = multiSets.xMap.firstKey();
            minCost = multiSets.sumX - median * multiSets.xsz
                    + median * multiSets.ysz - multiSets.sumY;
            minCosts[i - x + 1] = minCost;
        }

        memo = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    // 前 i 个，选了 j 个
    private long dfs(int i, int j) {
        if (i == n) {
            if (j == k) return 0;
            return Long.MAX_VALUE / 2;
        }
        if (memo[i][j] != -1) return memo[i][j];
        long res = dfs(i + 1, j); // 不选
        if (i + x <= n && j + 1 <= k) { // 选
            res = Math.min(res, dfs(i + x, j + 1) + minCosts[i]);
        }
        return memo[i][j] = res;
    }

    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;
        long sumX, sumY, tot;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
            sumX = 0;
            sumY = 0;
        }

        private void add(int v) {
            yInsertV(v);
            balance();
            tot += v;
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
            tot -= v;
        }

        private void balance() {
            if (xsz + ysz < n) return;
            while (xsz < k) {
                int iy = yMap.lastKey();
                yEraseV(iy);
                xInsertV(iy);
            }
            if (xsz == 0 || ysz == 0) return;
            while (true) {
                int ix = xMap.firstKey();
                int iy = yMap.lastKey();
                if (ix >= iy) break;
                xEraseV(ix);
                yEraseV(iy);
                xInsertV(iy);
                yInsertV(ix);
            }
        }

        private void xInsertV(int v) {
            xMap.merge(v, 1, Integer::sum);
            xsz++;
            sumX += v;
        }

        private void yInsertV(int v) {
            yMap.merge(v, 1, Integer::sum);
            ysz++;
            sumY += v;
        }

        private void xEraseV(int v) {
            if (xMap.merge(v, -1, Integer::sum) == 0) xMap.remove(v);
            xsz--;
            sumX -= v;
        }

        private void yEraseV(int v) {
            if (yMap.merge(v, -1, Integer::sum) == 0) yMap.remove(v);
            ysz--;
            sumY -= v;
        }
    }
}
/*
3505. 使 K 个子数组内元素相等的最少操作数
https://leetcode.cn/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/description/

第 443 场周赛 T4。

给你一个整数数组 nums 和两个整数 x 和 k。你可以执行以下操作任意次（包括零次）：
- 将 nums 中的任意一个元素加 1 或减 1。
返回为了使 nums 中 至少 包含 k 个长度 恰好 为 x 的不重叠子数组（每个子数组中的所有元素都相等）所需要的 最少 操作数。
子数组 是数组中连续、非空的一段元素。
提示：
2 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6
2 <= x <= nums.length
1 <= k <= 15
2 <= k * x <= nums.length

滑动窗口中位数 + 距离和 + 划分型 DP。
中位数要用 对顶堆/双平衡树 来求。
相似题目: 3473. 长度至少为 M 的 K 个子数组之和
https://leetcode.cn/problems/sum-of-k-subarrays-with-length-at-least-m/description/
3077. K 个不相交子数组的最大能量值
https://leetcode.cn/problems/maximum-strength-of-k-disjoint-subarrays/description/
2968. 执行操作使频率分数最大
https://leetcode.cn/problems/apply-operations-to-maximize-frequency-score/description/
3086. 拾起 K 个 1 需要的最少行动次数
https://leetcode.cn/problems/minimum-moves-to-pick-k-ones/description/
rating 2544 (clist.by)
 */