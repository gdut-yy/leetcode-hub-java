public class SolutionO44 {
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
剑指 Offer 44. 数字序列中某一位的数字
https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。
限制：
0 <= n < 2^31

同: 400. 第 N 位数字
https://leetcode.cn/problems/nth-digit/
 */