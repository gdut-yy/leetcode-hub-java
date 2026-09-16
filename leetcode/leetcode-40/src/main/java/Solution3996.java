public class Solution3996 {
    public boolean canReach(int[] start, int[] target) {
        return Math.abs(target[0] + target[1] - start[0] - start[1]) % 2 == 0;
    }
}
/*
3996. 偶数次骑士移动
https://leetcode.cn/problems/even-number-of-knight-moves/description/

第 511 场周赛 T1。

给你两个整数数组 start 和 target，每个数组的形式均为 [x, y]，表示标准 8 x 8 国际象棋棋盘上的一个格子。
如果骑士可以用 偶数 次移动从 start 到达 target，则返回 true；否则返回 false。
注意：骑士的一次合法移动是：沿一个方向移动两格，再沿与其垂直的方向移动一格。下图展示了骑士从一个格子出发时所有 8 种可能的移动方式。
提示：
start.length == target.length == 2
0 <= start[i], target[i] <= 7

判断奇偶性。
时间复杂度 O(1)。
 */