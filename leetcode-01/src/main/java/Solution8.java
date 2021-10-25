import java.util.HashMap;
import java.util.Map;

public class Solution8 {
    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUMBER = "in_number";
    private static final String END = "end";

    private static final Map<String, String[]> TRANSFER = new HashMap<>() {{
        put(START, new String[]{START, SIGNED, IN_NUMBER, END});
        put(SIGNED, new String[]{END, END, IN_NUMBER, END});
        put(IN_NUMBER, new String[]{END, END, IN_NUMBER, END});
        put(END, new String[]{END, END, END, END});
    }};

    private int sign = 1;
    private long ans = 0;
    private String state = START;

    public int myAtoi(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            get(s.charAt(i));
        }
        return (int) (sign * ans);
    }

    private void get(char ch) {
        state = TRANSFER.get(state)[getCol(ch)];
        if (IN_NUMBER.equals(state)) {
            ans = ans * 10 + ch - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if (SIGNED.equals(state)) {
            sign = ch == '+' ? 1 : -1;
        }
    }

    private int getCol(char ch) {
        if (ch == ' ') {
            return 0;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (Character.isDigit(ch)) {
            return 2;
        }
        return 3;
    }
}
/*
8. 字符串转换整数 (atoi)
https://leetcode-cn.com/problems/string-to-integer-atoi/

自动机。
时间复杂度 O(n)
空间复杂度 O(1)
 */