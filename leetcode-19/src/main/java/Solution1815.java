public class Solution1815 {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        for (int x : groups) {
            cnt[x % batchSize]++;
        }

        int all = 1;
        for (int i = 1; i < batchSize; i++) {
            all *= cnt[i] + 1;
        }

        int[] f = new int[all];
        f[0] = 0;
        for (int state = 1; state < all; state++) {
            // 这里令 sum = batchSize 后续避免负数取模问题
            int sum = batchSize;
            for (int num = 1, t = state; num < batchSize; t /= cnt[num] + 1, ++num) {
                sum += num * (t % (cnt[num] + 1));
            }
            for (int num = 1, t = state, w = 1; num < batchSize; t /= cnt[num] + 1, w *= cnt[num] + 1, ++num) {
                if (t % (cnt[num] + 1) != 0) {
                    f[state] = Math.max(f[state], f[state - w] + (((sum - num) % batchSize == 0) ? 1 : 0));
                }
            }
        }
        return f[all - 1] + cnt[0];
    }
}
/*
1815. 得到新鲜甜甜圈的最多组数
https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/

有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，之前 所有 甜甜圈都必须已经全部销售完毕。
给你一个整数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
提示：
1 <= batchSize <= 9
1 <= groups.length <= 30
1 <= groups[i] <= 10^9

动态规划
https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/solution/cong-zui-zhi-jie-de-fang-fa-kai-shi-yi-b-x729/
相似题目: 343. 整数拆分
https://leetcode.cn/problems/integer-break/
 */