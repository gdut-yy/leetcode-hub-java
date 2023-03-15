public class Tianchi221022T4 {
    public int brilliantSurprise(int[][] present, int limit) {
        int[] f = new int[limit + 1];
        int sumN = 0;
        for (int[] pres : present) {
            int n = pres.length;
            for (int i = 1; i < n; i++) {
                // 前缀和
                pres[i] = pres[i] + pres[i - 1];
            }
            // 优化：j 从前 i 个栈的大小之和开始枚举（不超过 k）
            sumN = Math.min(sumN + n, limit);
            for (int j = sumN; j > 0; j--) {
                for (int w = 0; w < Math.min(n, j); w++) {
                    // w 从 0 开始，物品体积为 w+1
                    f[j] = Math.max(f[j], f[j - w - 1] + pres[w]);
                }
            }
        }
        return f[limit];
    }
}
/*
221021天池-04. 意外惊喜
https://leetcode.cn/contest/tianchi2022/problems/tRZfIV/

某电商平台举办了一个用户抽奖活动，奖池中共有若干个礼包，每个礼包中包含一些礼物。 present[i][j] 表示第 i 个礼包第 j 件礼（下标从 0 开始）物的价值。抽奖规则如下：
- 每个礼包中的礼物摆放是有顺序的，你必须从第 0 件礼物开始打开；
- 对于同一个礼包中的礼物，必须在打开该礼包的第 i 个礼物之后，才能打开第 i+1 个礼物；
- 每个礼物包中的礼物价值 非严格递增。
参加活动的用户总共可以打开礼物 limit 次，请返回用户能够获得的 最大 礼物价值总和。
示例 1：
输入: present = [[1,2],[2,3],[3,4]], limit = 3
输出: 9
解释：最佳的方案为：
第 1 次拿走第 3 个礼包中的第 1 个礼物，得到价值 3；
第 2 次拿走第 3 个礼包中的第 2 个礼物，得到价值 4；
第 3 次拿走第 2 个礼物包的第 1 个礼物，得到价值 2；
返回打开的礼物价值总和 3 + 4 + 2 = 9
示例 2：
输入: present = [[1,2,100],[4,5],[3,4]], limit = 4
输出: 107
解释：最佳的方案为：
第 1 次拿走第 1 个礼包中的第 1 个礼物，得到价值 1；
第 2 次拿走第 1 个礼包中的第 2 个礼物，得到价值 2；
第 3 次拿走第 1 个礼物包的第 3 个礼物，得到价值 100；
第 4 次拿走第 2 个礼物包的第 1 个礼物，得到价值 4；
返回打开的礼物价值总和 107
提示：
1 <= present.length <= 2000
1 <= present[i].length <= 1000
1 <= present[i][j] <= present[i][j+1] <= 10^5
1 <= limit <= 1000

本题如果直接套用 2218 题代码会 TLE
注意关键条件 "每个礼物包中的礼物价值 非严格递增。" 等价于最多只有一个数组未选完。
同: http://codeforces.com/contest/1442/problem/D
相似题目: 2218. 从栈中取出 K 个硬币的最大面值和
https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/
 */