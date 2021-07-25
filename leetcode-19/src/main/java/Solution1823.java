public class Solution1823 {
    public int findTheWinner(int n, int k) {
        // 约瑟夫环（n 个人，数到 m 的人出局）
        // joseph(n, m) = (joseph(n - 1, m) + m - 1) % n
        // 当 n = 1 时，joseph(n, m) = 1
        // + m - 1 是因为下一个需要往后移 m 位，同时减去已出局的 1 人
        // % n 是因为需要避免数组越界
        if (n == 1) {
            return 1;
        }
        // + 1 因为题目从 1 到 n 编号
        return (findTheWinner(n - 1, k) + k - 1) % n + 1;
    }
}
/*
1823. 找出游戏的获胜者
https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/

第 236 场周赛 T2。
经典问题-约瑟夫环
 */