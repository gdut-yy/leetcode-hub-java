public class SolutionLCR163 {
    public int findKthNumber(int k) {
        int[] ant = new int[]{0, 10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890};
        int[] numBegin = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for (int i = ant.length - 1; i >= 0; i--) {
            if (k >= ant[i]) {
                int num = (k - ant[i]) / (i + 1) + numBegin[i];
                int posi = (k - ant[i]) % (i + 1);
                return num % (int) Math.pow(10, i + 1 - posi) / (int) Math.pow(10, i - posi);
            }
        }
        return 0;
    }
}
/*
LCR 163. 找到第 k 位数字
https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/

某班级学号记录系统发生错乱，原整数学号序列 [0,1,2,3,4,...] 分隔符丢失后变为 01234... 的字符序列。请实现一个函数返回该字符序列中的第 k 位数字。
提示：
0 <= k < 2^31

同: 400. 第 N 位数字
https://leetcode.cn/problems/nth-digit/
 */