public class Solution3723 {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 1 || sum > 9 * num) {
            return "";
        }
        int k = Math.min(num, sum / 9);
        int r = sum - 9 * k;
        char[] ans = new char[num];
        for (int i = 0; i < k; i++) {
            ans[i] = '9';
        }
        if (r > 0) {
            ans[k] = (char) ('0' + r);
            for (int i = k + 1; i < num; i++) {
                ans[i] = '0';
            }
        } else {
            for (int i = k; i < num; i++) {
                ans[i] = '0';
            }
        }
        return new String(ans);
    }
}
/*
3723. 数位平方和的最大值
https://leetcode.cn/problems/maximize-sum-of-squares-of-digits/description/

第 168 场双周赛 T2。

给你两个 正 整数 num 和 sum。
如果一个正整数 n 满足以下两个条件，则称其为 好整数 ：
- n 的位数 恰好 为 num。
- n 的各位数字之和 恰好 为 sum。
一个 好整数 n 的 分数 定义为 n 的各位数字的平方和。
返回一个 字符串 ，表示能获得 最大分数 的 好整数 n。如果有多个可能的整数，返回 最大 的那个。如果不存在这样的整数，返回一个空字符串。
提示:
1 <= num <= 2 * 10^5
1 <= sum <= 2 * 10^6

贪心。
时间复杂度 O(n)。
 */