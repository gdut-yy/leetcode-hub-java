import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculate(num2, num1, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
/*
150. 逆波兰表达式求值
https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/

后缀表达式又叫逆波兰式 (Reverse Polish Notation, RPN)
时间复杂度 O(n)
空间复杂度 O(n)
 */