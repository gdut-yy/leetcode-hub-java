public class SolutionLCP02 {
    public int[] fraction(int[] cont) {
        int len = cont.length;

        int molecular = 1;
        int denominator = cont[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            molecular += cont[i] * denominator;
            int gcd = getGCD(molecular, denominator);
            molecular /= gcd;
            denominator /= gcd;
            // swap
            int tmp = molecular;
            molecular = denominator;
            denominator = tmp;
        }
        return new int[]{denominator, molecular};
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
LCP 02. 分式化简
https://leetcode.cn/problems/deep-dark-fraction/

有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
限制：
cont[i] >= 0
1 <= cont的长度 <= 10
cont最后一个元素不等于0
答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。

gcd 模拟。
 */