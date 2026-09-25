public class ZjFuture220708T2 {
    public int minSwaps(int[] chess) {
        int len = chess.length;

        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + chess[i];
        }

        // 1 的个数
        int k = preSum[len];

        int min = Integer.MAX_VALUE;
        for (int i = k; i <= len; i++) {
            min = Math.min(min, k - (preSum[i] - preSum[i - k]));
        }
        return min;
    }
}
/*
zj-future02. 黑白棋游戏
https://leetcode.cn/contest/zj-future2022/problems/GVbKaI/

现有一个黑白棋游戏，初始时给出一排棋子，记作数组 chess，其中白色棋子记作 0，黑色棋子记作 1。用户可以每次交换 任意位置 的两颗棋子的位置。
为了使得所有黑色棋子相连，请返回最少需要交换多少次。
示例 1:
输入: chess = [1,0,1,0,1,0]
输出: 1
解释:
有四种可能的方法可以把所有的 1 组合在一起：
[1,1,1,0,0,0]，交换 1 次；
[0,1,1,1,0,0]，交换 2 次；
[0,0,1,1,1,0]，交换 1 次；
[0,0,0,1,1,1]，交换 2 次。
所以最少的交换次数为 1。
示例  2:
输入：chess = [0,0,0,1,0]
输出：0
解释：
由于数组中只有一个 1，所以不需要交换。
示例 3:
输入：chess = [1,1,0,1,0,1,0,0,1,0,1]
输出：2
解释：
最佳方案为 [1,1,1,1,1,1,0,0,0,0,0]，
因此返回最少交换 2 次
提示:
1 <= chess.length <= 10^5
chess[i] == 0 或 1.

同: $1151. 最少交换次数来组合所有的 1
https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together/
 */