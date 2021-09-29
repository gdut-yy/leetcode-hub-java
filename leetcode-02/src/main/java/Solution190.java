public class Solution190 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
/*
190. 颠倒二进制位
https://leetcode-cn.com/problems/reverse-bits/

颠倒给定的 32 位无符号整数的二进制位。
输入：n = 00000010100101000001111010011100
输出：964176192 (00111001011110000010100101000000)
 */