public class Solution476 {
    public int findComplement(int num) {
        String binNum = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : binNum.toCharArray()) {
            if (ch == '1') {
                stringBuilder.append('0');
            } else {
                stringBuilder.append("1");
            }
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
/*
476. 数字的补数
https://leetcode-cn.com/problems/number-complement/

给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。

Integer.toBinaryString(int i)
Integer.parseInt(String s, int radix)

同: 1009. 十进制整数的反码
https://leetcode-cn.com/problems/complement-of-base-10-integer/
 */