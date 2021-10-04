import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                stack.push(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            cnt = (cnt + 1) % k;
            if (!stack.isEmpty() && cnt == 0) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.reverse().toString().toUpperCase(Locale.ROOT);
    }
}
/*
482. 密钥格式化
https://leetcode-cn.com/problems/license-key-formatting/

模拟。
 */