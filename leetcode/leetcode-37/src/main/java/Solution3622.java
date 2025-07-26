public class Solution3622 {
    public boolean checkDivisibility(int n) {
        return n % (digitSum(n) + digitProd(n)) == 0;
    }

    private int digitProd(int x) {
        int res = 1;
        while (x > 0) {
            res *= x % 10;
            x /= 10;
        }
        return res;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
/*
3622. 判断整除性
https://leetcode.cn/problems/check-divisibility-by-digit-sum-and-product/description/

第 459 场周赛 T1。

给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除：
- n 的 数字和（即其各个位数之和）。
- n 的 数字积（即其各个位数之积）。
如果 n 能被该和整除，返回 true；否则，返回 false。
提示：
1 <= n <= 10^6

中国时间 2025-07-20 周日 10:30
上海。
模拟。
 */