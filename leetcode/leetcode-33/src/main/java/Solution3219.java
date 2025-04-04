import java.util.ArrayList;
import java.util.List;

public class Solution3219 {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        List<int[]> a = new ArrayList<>();
        for (int v : horizontalCut) a.add(new int[]{v, 0});
        for (int v : verticalCut) a.add(new int[]{v, 1});
        a.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        long ans = 0;
        long[] cnt = {1, 1};
        for (int[] p : a) {
            ans += p[0] * cnt[p[1] ^ 1];
            cnt[p[1]]++;
        }
        return ans;
    }
}
/*
3219. 切蛋糕的最小总开销 II
https://leetcode.cn/problems/minimum-cost-for-cutting-cake-ii/description/

第 406 场周赛 T4。

有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
给你整数 m ，n 和两个数组：
- horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
- verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
1.沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
2.沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
每次操作的开销都为最开始对应切割线的开销，并且不会改变。
请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
提示：
1 <= m, n <= 10^5
horizontalCut.length == m - 1
verticalCut.length == n - 1
1 <= horizontalCut[i], verticalCut[i] <= 10^3

贪心。交换论证法。
赛时一顿 加权贪心。没整出来，但是据说 GPT 可以秒杀该题。本场最终被 unrated。
时间复杂度 O(mlogm + nlogn)。
相似题目: 3273. 对 Bob 造成的最少伤害
https://leetcode.cn/problems/minimum-amount-of-damage-dealt-to-bob/description/
 */