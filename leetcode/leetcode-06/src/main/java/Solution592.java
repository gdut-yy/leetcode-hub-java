public class Solution592 {
    public String fractionAddition(String expression) {
        expression = expression.replace("-", "+-");
        if (expression.startsWith("+-")) {
            expression = expression.substring(1);
        }
        String[] strs = expression.split("\\+");
        // 分子 分母
        long a = 0;
        long b = 1;
        for (String str : strs) {
            String[] ss = str.split("/");
            long c = Long.parseLong(ss[0]);
            long d = (ss.length == 1) ? 1 : Long.parseLong(ss[1]);

            // a/b + c/d = (ad+bc) / bd
            long numerator = a * d + b * c;
            long denominator = b * d;
            long gcd = getGCD(numerator, denominator);
            a = numerator / gcd;
            b = denominator / gcd;
        }
        if (b < 0) {
            return "-" + a + "/" + -b;
        }
        return a + "/" + b;
    }

    private long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
592. 分数加减运算
https://leetcode.cn/problems/fraction-addition-and-subtraction/

给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
提示:
输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
输入的分数个数范围是 [1,10]。
最终结果的分子与分母保证是 32 位整数范围内的有效整数。

分式加减，a/b + c/d = (ad+bc) / bd
负号前补正号
 */