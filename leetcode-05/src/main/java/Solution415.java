import java.math.BigInteger;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }
}
/*
415. 字符串相加
https://leetcode-cn.com/problems/add-strings/

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。

竖式加法。
 */