public class SolutionO62 {
    public int lastRemaining(int n, int m) {
        return josephus(n, m);
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
剑指 Offer 62. 圆圈中最后剩下的数字
https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/

0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

约瑟夫环。
相似题目: 1823. 找出游戏的获胜者
https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
注意 0 ~ n-1 与 1~n 的差异
 */