import java.math.BigInteger;

public class Solution43 {
    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
}
/*
43. 字符串相乘
https://leetcode-cn.com/problems/multiply-strings/

朴素乘法 或者 BigInteger
（实际工程中意义不大）
 */