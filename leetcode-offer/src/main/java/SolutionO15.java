public class SolutionO15 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
/*
剑指 Offer 15. 二进制中1的个数
https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/

编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。

同: 191. 位1的个数
https://leetcode-cn.com/problems/number-of-1-bits/
 */