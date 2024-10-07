public class SolutionI0506 {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
/*
面试题 05.06. 整数转换
https://leetcode.cn/problems/convert-integer-lcci/description/

整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
提示:
A，B范围在[-2147483648, 2147483647]之间
 */