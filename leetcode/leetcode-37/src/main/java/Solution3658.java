public class Solution3658 {
    public int gcdOfOddEvenSums(int n) {
        long sumOdd = 0, sumEven = 0;
        int odd = 1, even = 2;
        for (int i = 0; i < n; i++) {
            sumOdd += odd;
            sumEven += even;
            odd += 2;
            even += 2;
        }
        return (int) getGCD(sumOdd, sumEven);
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3658. 奇数和与偶数和的最大公约数
https://leetcode.cn/problems/gcd-of-odd-and-even-sums/description/

第 464 场周赛 T1。

给你一个整数 n。请你计算以下两个值的 最大公约数（GCD）：
- sumOdd：前 n 个奇数的总和。
- sumEven：前 n 个偶数的总和。
返回 sumOdd 和 sumEven 的 GCD。
提示：
1 <= n <= 1000

模拟 / 数学。
sumOdd = n^2
sumEven = n(n+1)
最大公约数为 n。
时间复杂度 O(1)。
 */