public class Solution400 {
    public int findNthDigit(int n) {
        int[] ant = new int[]{0, 10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890};
        int[] numBegin = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for (int i = ant.length - 1; i >= 0; i--) {
            if (n >= ant[i]) {
                int num = (n - ant[i]) / (i + 1) + numBegin[i];
                int posi = (n - ant[i]) % (i + 1);
                return num % (int) Math.pow(10, i + 1 - posi) / (int) Math.pow(10, i - posi);
            }
        }
        return 0;
    }
}
/*
400. 第 N 位数字
https://leetcode.cn/problems/nth-digit/

在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
注意：n 是正数且在 32 位整数范围内（n < 2^31）。
 */