public class Solution4008 {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];
        for (int[] b : boosts) {
            diff[b[0]] += b[2];
            diff[b[1] + 1] -= b[2];
        }
        long[] bonus = new long[n];
        long acc = 0;
        for (int i = 0; i < n; i++) {
            acc += diff[i];
            bonus[i] = acc;
        }

        long lo = 0, hi = 0, sum = 0;
        for (int m : monsters) {
            sum += m;
            hi = Math.max(hi, sum);
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (feasible(mid, monsters, bonus)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean feasible(long s, int[] monsters, long[] bonus) {
        long cur = s;
        for (int i = 0; i < monsters.length; i++) {
            if (cur + bonus[i] < monsters[i]) return false;
            cur = Math.max(0, cur - monsters[i]);
        }
        return true;
    }
}
/*
4008. 击败所有怪物的最小初始强度
https://leetcode.cn/problems/minimum-initial-strength-to-defeat-all-monsters/description/

第 188 场双周赛 T3。

给你一个整数数组 monsters，其中 monsters[i] 表示第 i 个怪物的强度。
同时给你一个二维整数数组 boosts，其中 boosts[i] = [li, ri, vi] 表示与下标在 [li, ri] 范围内的任意怪物战斗时，你的 临时加成 会增加 vi。加成范围可能会重叠，所有适用的加成值将被相加。
你以一个 非负 初始强度开始，并从左到右依次与怪物战斗。
对于下标为 i 的每个怪物：
- 令 bonus 为适用于怪物 i 的所有加成值之 和。
- 只有你的当前强度加上 bonus 至少 为 monsters[i] 时，你才能击败该怪物。
- 击败怪物后，你的当前强度会减少 monsters[i]。如果强度变为 负数，则将其设置为 0。
返回击败所有怪物所需的 最小 初始强度。
注意：临时加成仅用于确定是否可以击败当前怪物。它不会以其他方式改变你的当前强度。
提示：
1 <= monsters.length <= 5 * 10^4
1 <= monsters[i] <= 10^9
0 <= boosts.length <= 5 * 10^4
boosts[i] == [li, ri, vi]
0 <= li <= ri < monsters.length
1 <= vi <= 10^9

二分答案。
 */