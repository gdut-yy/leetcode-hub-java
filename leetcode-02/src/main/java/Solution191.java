public class Solution191 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
/*
191. 位1的个数
https://leetcode-cn.com/problems/number-of-1-bits/

编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
输入：00000000000000000000000000001011
输出：3
 */
