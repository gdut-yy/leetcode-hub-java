public class SfTech220619T2 {
    public int minRemainingSpace(int[] N, int V) {
        // 0-1 背包
        int[] f = new int[V + 1];
        for (int wi : N) {
            for (int j = V; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + wi);
            }
        }
        return V - f[V];
    }
}
/*
顺丰02. 小哥派件装载问题
https://leetcode.cn/contest/sf-tech/problems/cINqyA/

问题
快递小哥每天都需要揽件并骑电瓶车派送快递，假设电瓶车快递箱容量为V，小哥需要派送n个快递，每个快递都有一定的体积大小。
要求在需要派送的n个快递中，任取若干个快递装放入快递箱，不能溢出，使快递箱的剩余空间最小。
输入：
n个快递的体积数组:N[]，
电瓶车快递箱容量:V
返回：
尽量装满快递后，快递箱剩余的最小容量
示例1
输入：N = [8, 1, 12, 7, 9, 7], V = 11
输出：1
解释：快递箱容量V为11，物品体积数组N为[8, 1, 12, 7, 9, 7],最优解为取体积为
1的快递和体积为9的快递,即快递箱剩余最小空间为 11-(1+9)=1
示例2
输入：N = [8, 2, 12, 7, 9, 7], V = 11
输出：0
解释：11-(2+9) = 0
示例3
输入：N = [8, 2, 12, 7, 9, 7], V = 100
输出：55
解释：100-(8+2+12+7+9+7) = 55
示例4
输入：N = [8, 19, 18,23,16,20], V = 5
输出：5
解释：由于快递箱不能溢出，没有体积小于5的快递，所以快递箱剩余最小空间为5
提示
0 < N.length ≤ 30
0 < N[i] < 2000
V为整数：0 ≤ V ≤ 2000

0-1 背包
 */