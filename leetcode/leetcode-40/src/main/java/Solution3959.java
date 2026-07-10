public class Solution3959 {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;
        while (n > 0) {
            int d = n % 10;
            digitSum += d;
            squareSum += d * d;
            n /= 10;
        }
        return squareSum - digitSum >= 50;
    }
}
/*
3959. 判定好整数
https://leetcode.cn/problems/check-good-integer/description/

第 506 场周赛 T1。

给你一个正整数 n。
令 digitSum 表示 n 的各位数字之和，令 squareSum 表示 n 的各位数字平方之和。
如果一个整数满足 squareSum - digitSum >= 50，则称它是 好整数 。
如果 n 是好整数，返回 true；否则，返回 false。
提示：
1 <= n <= 10^9

模拟。
时间复杂度 O(logn)。
 */