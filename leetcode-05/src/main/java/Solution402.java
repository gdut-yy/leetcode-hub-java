import java.util.ArrayDeque;
import java.util.Deque;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        // stack => String
        StringBuilder stringBuilder = new StringBuilder();
        // 前导 0
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char ch = stack.removeLast();
            if (ch == '0') {
                if (!leadingZero) {
                    stringBuilder.append(ch);
                }
            } else {
                stringBuilder.append(ch);
                leadingZero = false;
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
/*
402. 移掉 K 位数字
https://leetcode.cn/problems/remove-k-digits/

给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
提示：
1 <= k <= num.length <= 10^5
num 仅由若干位数字（0 - 9）组成
除了 0 本身之外，num 不含任何前导零

单调栈。
 */