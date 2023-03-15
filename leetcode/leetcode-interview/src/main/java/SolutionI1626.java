import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionI1626 {
    public int calculate(String s) {
        int len = s.length();

        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
/*
面试题 16.26. 计算器
https://leetcode.cn/problems/calculator-lcci/

给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。整数除法仅保留整数部分。
说明：
你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

相似题目: 227. 基本计算器 II
https://leetcode.cn/problems/basic-calculator-ii/
 */