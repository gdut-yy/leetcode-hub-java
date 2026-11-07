public class Solution4061 {
    public int minQueenMoves(int[] source, int[] target) {
        int sx = source[0], sy = source[1];
        int tx = target[0], ty = target[1];
        if (sx == tx && sy == ty) {
            return 0;
        }
        if (sx - sy == tx - ty || sx + sy == tx + ty || sx == tx || sy == ty) {
            return 1;
        }
        return 2;
    }
}
/*
4061. 皇后到达目标格子的最少移动步数
https://leetcode.cn/problems/minimum-queen-moves-to-reach-target/description/

第 192 场双周赛 T1。

一个 8 x 8 的空棋盘，其行和列的下标从 1 开始。
给你一个数组 source = [sr, sc] 表示 皇后 的初始位置，以及一个数组 target = [tr, tc] 表示目标位置。
在一步移动中，皇后可以在棋盘范围内，沿着单条 行 、 列 或 对角线 移动一个或多个方格。
返回皇后移动到 恰好 落在 target 位置所需的 最小 移动次数。
示例 1：
输入： source = [8,1], target = [1,8]
输出： 1
示例 2：
输入： source = [4,2], target = [1,3]
输出： 2
示例 3：
输入： source = [1,1], target = [1,1]
输出： 0
提示：
source == [sr, sc]
target == [tr, tc]
1 <= sr, sc, tr, tc <= 8

分类讨论。
时间复杂度 O(1)。
相似题目: 4034. 象到达目标格子的最少移动步数
https://leetcode.cn/problems/minimum-bishop-moves-to-reach-target/description/
 */