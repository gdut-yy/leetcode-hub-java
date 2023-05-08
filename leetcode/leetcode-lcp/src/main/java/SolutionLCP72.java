public class SolutionLCP72 {
    private int halfN;

    public int[] supplyWagon(int[] supplies) {
        halfN = supplies.length / 2;
        return dfs(supplies);
    }

    private int[] dfs(int[] cur) {
        int n = cur.length;
        if (n <= halfN) {
            return cur;
        }
        int minI = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < n; i++) {
            if (minSum > cur[i] + cur[i + 1]) {
                minSum = cur[i] + cur[i + 1];
                minI = i;
            }
        }
        int[] next = new int[n - 1];
        for (int i = 0; i <= minI; i++) {
            next[i] = cur[i];
        }
        for (int i = minI; i < n - 1; i++) {
            next[i] += cur[i + 1];
        }
        return dfs(next);
    }
}
/*
LCP 72. 补给马车
https://leetcode.cn/problems/hqCnmP/

LCCUP'23 春季个人赛 T1。

远征队即将开启未知的冒险之旅，不过在此之前，将对补给车队进行最后的检查。supplies[i] 表示编号为 i 的补给马车装载的物资数量。
考虑到车队过长容易被野兽偷袭，他们决定将车队的长度变为原来的一半（向下取整），计划为：
- 找出车队中 物资之和最小 两辆 相邻 马车，将它们车辆的物资整合为一辆。若存在多组物资之和相同的马车，则取编号最小的两辆马车进行整合；
- 重复上述操作直到车队长度符合要求。
请返回车队长度符合要求后，物资的分布情况。
解释：
2 <= supplies.length <= 1000
1 <= supplies[i] <= 1000

模拟。
 */