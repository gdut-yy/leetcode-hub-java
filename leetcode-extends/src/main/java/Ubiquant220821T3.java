public class Ubiquant220821T3 {
    public int minOperations(int[] numbers) {
        int len = numbers.length;

        // 最小公倍数 lcm
        long lcm = numbers[0];
        for (int i = 1; i < len; i++) {
            long gcd = getGCD(lcm, numbers[i]);
            lcm = lcm / gcd * numbers[i];
        }

        long cnt = 0;
        for (int number : numbers) {
            // 倍数
            long k = lcm / number;
            while (k % 3 == 0) {
                cnt += 1;
                k /= 3;
            }
            while (k % 2 == 0) {
                cnt += 1;
                k /= 2;
            }
            if (k != 1) {
                return -1;
            }
        }
        return (int) cnt;
    }

    private static long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
九坤-03. 数字默契考验
https://leetcode.cn/contest/ubiquant2022/problems/uGuf0v/

某数学兴趣小组有 N 位同学，编号为 0 ~ N-1，老师提议举行一个数字默契小测试：首先每位同学想出一个数字，按同学编号存于数组 numbers。
每位同学可以选择将自己的数字进行放大操作，每次在以下操作中任选一种（放大操作不限次数，可以不操作）：
1.将自己的数字乘以 2
2.将自己的数字乘以 3
若最终所有同学可以通过操作得到相等数字，则返回所有同学的最少操作次数总数；否则请返回 -1。

示例 1：
输入：numbers = [50, 75, 100]
输出：5
解释：
numbers[0] * 2 * 3 = 300 操作两次；
numbers[1] * 2 * 2 = 300 操作两次；
numbers[2] * 3 = 300 操作一次。共计操作五次。

示例 2：
输入：numbers = [10, 14]
输出：-1
解释：无法通过操作得到相同数字。

提示：
1 <= numbers.length <= 10^5
1 <= numbers[i] <= 10^9

求出最小公倍数，除以每个数，如果结果仅含有 2 和 3 的因子，则有解，否则 -1
 */