public class Solution3771 {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + damage[i];
        }

        long sumIdx = 0;
        for (int i = 1; i <= n; i++) {
            long threshold = (long) requirement[i - 1] + ps[i] - hp;
            int idx = lowerBound(ps, 0, i, threshold);
            sumIdx += idx;
        }

        long total = (long) n * (n + 1) / 2;
        return total - sumIdx;
    }

    private int lowerBound(long[] arr, int l, int r, long key) {
        int lo = l, hi = r;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] >= key) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
/*
3771. 探索地牢的得分
https://leetcode.cn/problems/total-score-of-dungeon-runs/description/

第 479 场周赛 T3。

给你一个 正整数 hp 和两个 正整数 数组 damage 和 requirement，数组下标从 1 开始。
有一个地牢，里面有 n 个陷阱房间，编号从 1 到 n。进入编号为 i 的房间会使你的生命值减少 damage[i]。减少后，如果你的剩余生命值至少为 requirement[i]，你可以从该房间获得 1 分。
定义 score(j) 为从房间 j 开始，依次进入房间 j, j + 1, ..., n 时可以获得的总分。
返回整数 score(1) + score(2) + ... + score(n)，即从所有起始房间计算的分数总和。
注意： 你不能跳过房间。即使你的生命值降为非正数，你仍然可以继续进入房间。
提示：
1 <= hp <= 10^9
1 <= n == damage.length == requirement.length <= 10^5
1 <= damage[i], requirement[i] <= 10^4

前缀和 + 二分查找。
https://yuanbao.tencent.com/chat/naQivTmsDa/6851f747-42d3-49cb-9f85-7c766d690c3c
时间复杂度 O(nlogn)。
 */