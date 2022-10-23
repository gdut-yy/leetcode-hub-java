public class Hhrc220925T2 {
    public int longestESR(int[] sales) {
        int len = sales.length;

        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + (sales[i] > 8 ? 1 : 0);
        }

        int sum = preSum[len];
        int max = Math.min(len, sum + sum - 1);
        for (int i = max; i >= 0; i -= 2) {
            if (checkMid(preSum, i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean checkMid(int[] preSum, int mid) {
        for (int i = 0; i + mid < preSum.length; i++) {
            // [i, i+mid-1]
            int sum = preSum[i + mid] - preSum[i];
            if (sum + sum >= mid) {
                return true;
            }
        }
        return false;
    }
}
/*
题目-02. 销售出色区间
https://leetcode.cn/contest/hhrc2022/problems/0Wx4Pc/

给你一份销售数量表 sales，上面记录着某一位销售员每天成功推销的产品数目。
我们认为当销售员同一天推销的产品数目大于 8 个的时候，那么这一天就是「成功销售的一天」。
所谓「销售出色区间」，意味在这段时间内，「成功销售的天数」是严格 大于「未成功销售的天数」。
请你返回「销售出色区间」的最大长度。
提示：
1 <= sales.length <= 10^4
0 <= sales[i] <= 16

相似题目: 1124. 表现良好的最长时间段
https://leetcode.cn/problems/longest-well-performing-interval/
 */