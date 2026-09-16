public class Solution4000 {
    public int largestInteger(int n, int s) {
        if (s > n * 9) {
            return -1;
        }

        int ans = (int) Math.pow(10, s / 9) - 1; // 填 9
        if (s % 9 > 0) {
            ans = ans * 10 + s % 9; // 填 s%9
            n--;
        }
        return ans * (int) Math.pow(10, n - s / 9); // 填 0
    }
}
/*
4000. 给定数位和的最大整数
https://leetcode.cn/problems/largest-integer-with-given-digit-sum/description/

第 512 场周赛 T1。

给你两个非负整数 n 和 s。
返回满足下述条件的 最大 整数：
- 最多有 n 位数字。
- 其各位数字之和等于 s 。
如果不存在这样的整数，则返回 -1。
提示：
1 <= n <= 5
0 <= s <= 100

中国时间 2026-07-26 周日 10:30
深圳。07-24 发烧。
数学。
时间复杂度 O(1)。
 */