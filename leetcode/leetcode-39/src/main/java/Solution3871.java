public class Solution3871 {
    public long countCommas(long n) {
        long ans = 0;
        long power = 1;
        for (int d = 1; d <= 16; d++) {
            long lower = power;
            long upper = power * 10 - 1;
            if (lower > n) break;
            long last = Math.min(n, upper);
            long c = last - lower + 1;
            if (c > 0) {
                long commas = (d - 1) / 3;
                ans += c * commas;
            }
            power *= 10;
        }
        return ans;
    }
}
/*
3871. 统计范围内的逗号 II
https://leetcode.cn/problems/count-commas-in-range-ii/description/

第 493 场周赛 T2。

给你一个整数 n。
返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
在 标准 格式中：
- 从右边开始，每 三位 数字后插入一个逗号。
- 位数 少于四位 的数字不包含逗号。
提示：
1 <= n <= 10^15

贡献法。
https://chat.deepseek.com/a/chat/s/406e251c-dcaf-4b12-93fe-d46fa59b9958
时间复杂度 O(logn)。
 */