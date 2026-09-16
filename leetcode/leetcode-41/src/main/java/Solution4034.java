public class Solution4034 {
    public int minBishopMoves(int[] source, int[] target) {
        int sx = source[0], sy = source[1];
        int tx = target[0], ty = target[1];
        if (sx == tx && sy == ty) {
            return 0;
        }
        if ((sx + sy) % 2 != (tx + ty) % 2) {
            return -1;
        }
        if (sx - sy == tx - ty || sx + sy == tx + ty) {
            return 1;
        }
        return 2;
    }
}
/*
4034. 象到达目标格子的最少移动步数
https://leetcode.cn/problems/minimum-bishop-moves-to-reach-target/description/

第 190 场双周赛 T1。

给你一个 8 x 8 的棋盘，行和列的下标从 1 开始。
给你一个数组 source = [sr, sc]，表示 象 的起始位置，以及一个数组 target = [tr, tc]。在一步移动中，象可以在棋盘范围内沿着单个 对角线 方向移动任意数量的格子。
返回象 恰好 到达 target 位置所需的 最少 移动次数。如果它永远无法到达 target，则返回 -1。
提示：
source.length == target.length == 2
1 <= sr, sc, tr, tc <= 8
source != target

分类讨论。
时间复杂度 O(1)。
 */