public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int len = position.length;
        // 统计奇偶数个数，返回较少值
        int oddCnt = 0;
        for (int pos : position) {
            if (pos % 2 == 1) {
                oddCnt++;
            }
        }
        return Math.min(oddCnt, len - oddCnt);
    }
}
/*
1217. 玩筹码
https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/

第 157 场周赛 T1。

数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
最开始的时候，同一位置上也可能放着两个或者更多的筹码。
返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。

贪心。由于 向左或者右移动 2 个单位，代价为 0。因此只需考虑 是 奇数向偶数移动 还是 偶数向奇数移动 即可。取二者最小值。
 */