import java.util.HashMap;
import java.util.Map;

public class SolutionO67 {
    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUMBER = "in_number";
    private static final String END = "end";

    private static final Map<String, String[]> TRANSFER;

    static {
        TRANSFER = new HashMap<>();
        TRANSFER.put(START, new String[]{START, SIGNED, IN_NUMBER, END});
        TRANSFER.put(SIGNED, new String[]{END, END, IN_NUMBER, END});
        TRANSFER.put(IN_NUMBER, new String[]{END, END, IN_NUMBER, END});
        TRANSFER.put(END, new String[]{END, END, END, END});
    }

    private int sign = 1;
    private long ans = 0;
    private String state = START;

    public int strToInt(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            get(str.charAt(i));
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
剑指 Offer 67. 把字符串转换成整数
https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/

写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

同: 8. 字符串转换整数 (atoi)
https://leetcode.cn/problems/string-to-integer-atoi/
 */