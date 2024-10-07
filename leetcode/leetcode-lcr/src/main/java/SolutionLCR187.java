public class SolutionLCR187 {
    public int iceBreakingGame(int num, int target) {
        return josephus(num, target);
    }

    // [0, n-1] 编号
    // k 较小 n 较大时。时间复杂度 O(klogn)
    private int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k == 1) {
            return n - 1;
        }
        if (k > n) {
            return (josephus(n - 1, k) + k) % n;  // 线性算法
        }
        int res = josephus(n - n / k, k);
        res -= n % k;
        if (res < 0) {
            res += n;  // mod n
        } else {
            res += res / (k - 1);  // 还原位置
        }
        return res;
    }
}
/*
LCR 187. 破冰游戏
https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/

社团共有 num 位成员参与破冰游戏，编号为 0 ~ num-1。成员们按照编号顺序围绕圆桌而坐。社长抽取一个数字 target，从 0 号成员起开始计数，排在第 target 位的成员离开圆桌，且成员离开后从下一个成员开始计数。请返回游戏结束时最后一位成员的编号。
提示：
1 <= num <= 10^5
1 <= target <= 10^6

约瑟夫环。
注意 0 ~ n-1 与 1~n 的差异
相似题目: 1823. 找出游戏的获胜者
https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */