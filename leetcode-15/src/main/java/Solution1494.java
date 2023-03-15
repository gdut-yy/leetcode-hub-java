import java.util.Arrays;

public class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for (int[] relation : relations) {
            // 1. 因为点编号是1到n,所以对应于0到n-1的数组，映射位置应为 i-1
            // 2. 使用状压代表课程先修
            pre[relation[1] - 1] |= 1 << (relation[0] - 1);
        }

        int max = 1 << n;
        int[] dp = new int[max];
        Arrays.fill(dp, n);
        dp[0] = 0;
        // 3. 枚举学习课程的已经学习情况
        for (int learned = 0; learned < max; learned++) {
            // 4. 枚举当前学习情况，后续可学习的可能情况
            int waitStudy = 0;
            for (int i = 0; i < n; i++) {
                if ((pre[i] & learned) == pre[i]) {
                    waitStudy |= 1 << i;
                }
            }
            // 细节1. 枚举可学课程需要排除已学课程
            waitStudy = waitStudy & (~learned);
            // 5. 枚举当前1的位置的子集（包含自身），然后用 当前课程= (当前课程-1)&所有可学课程,这种方式，循环找到所有课程枚举子集
            for (int learnTerm = waitStudy; learnTerm > 0; learnTerm = (learnTerm - 1) & waitStudy) {
                // 细节2. 枚举选择的本轮课程需要排除掉一轮学习可能超过最大目标课程的情况
                if (Integer.bitCount(learnTerm) > k) {
                    continue;
                }
                dp[learned | learnTerm] = Math.min(dp[learned | learnTerm], dp[learned] + 1);
            }
        }
        return dp[max - 1];
    }
}
/*
1494. 并行课程 II
https://leetcode.cn/problems/parallel-courses-ii/

给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 dependencies 中， dependencies[i] = [xi, yi]  表示一个先修课的关系，
也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
提示：
1 <= n <= 15
1 <= k <= n
0 <= dependencies.length <= n * (n-1) / 2
dependencies[i].length == 2
1 <= xi, yi <= n
xi != yi
所有先修关系都是不同的，也就是说 dependencies[i] != dependencies[j] 。
题目输入的图是个有向无环图。

【钰娘娘】1494. 并行课程 II 拓扑反例+状态压缩动态规划
https://leetcode.cn/problems/parallel-courses-ii/solution/yu-niang-niang-1494-bing-xing-ke-cheng-i-duny/
 */