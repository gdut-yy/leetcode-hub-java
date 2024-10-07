import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SolutionLCR138 {
    public boolean validNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        // 起始的空格（初始状态）
        Map<CharType, State> initialMap = new HashMap<>();
        initialMap.put(CharType.CHAR_SPACE, State.STATE_INITIAL);
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);

        transfer.put(State.STATE_INITIAL, initialMap);

        // 符号位
        Map<CharType, State> intSignMap = new HashMap<>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);

        transfer.put(State.STATE_INT_SIGN, intSignMap);

        // 整数部分（接受状态）
        Map<CharType, State> integerMap = new HashMap<>();
        integerMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        integerMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        integerMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        integerMap.put(CharType.CHAR_SPACE, State.STATE_END);

        transfer.put(State.STATE_INTEGER, integerMap);

        // 左侧有整数的小数点（接受状态）
        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        pointMap.put(CharType.CHAR_SPACE, State.STATE_END);

        transfer.put(State.STATE_POINT, pointMap);

        // 左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);

        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        // 小数部分（接受状态）
        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_SPACE, State.STATE_END);

        transfer.put(State.STATE_FRACTION, fractionMap);

        // 字符 e
        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);

        transfer.put(State.STATE_EXP, expMap);

        // 指数部分的符号位
        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);

        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        // 指数部分的整数部分（接受状态）
        Map<CharType, State> expNumberMap = new HashMap<>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expNumberMap.put(CharType.CHAR_SPACE, State.STATE_END);

        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        // 末尾的空格（接受状态）
        Map<CharType, State> endMap = new HashMap<>();
        endMap.put(CharType.CHAR_SPACE, State.STATE_END);

        transfer.put(State.STATE_END, endMap);

        // 确定有限状态自动机（DFA）
        int length = s.length();
        State state = State.STATE_INITIAL;
        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER
                || state == State.STATE_END;
    }

    private CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    private enum State {
        // 起始的空格（初始状态）
        STATE_INITIAL,
        // 符号位
        STATE_INT_SIGN,
        // 整数部分（接受状态）
        STATE_INTEGER,
        // 左侧有整数的小数点（接受状态）
        STATE_POINT,
        // 左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
        STATE_POINT_WITHOUT_INT,
        // 小数部分（接受状态）
        STATE_FRACTION,
        // 字符 e
        STATE_EXP,
        // 指数部分的符号位
        STATE_EXP_SIGN,
        // 指数部分的整数部分（接受状态）
        STATE_EXP_NUMBER,
        // 末尾的空格（接受状态）
        STATE_END
    }

    private enum CharType {
        // 数字
        CHAR_NUMBER,
        // 小数点
        CHAR_POINT,
        // 空格
        CHAR_SPACE,
        // 字符 e
        CHAR_EXP,
        // +/- 号
        CHAR_SIGN,

        // 非法状态
        CHAR_ILLEGAL
    }

    private static final Pattern PATTERN = Pattern.compile("^\\s*[+-]?((\\d*\\.?\\d+)|(\\d+\\.?))([eE][+-]?\\d+)?\\s*$");

    /**
     * 正则表达式
     */
    public boolean validNumber2(String s) {
        return PATTERN.matcher(s).matches();
    }
}
/*
LCR 138. 有效数字
https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/

有效数字（按顺序）可以分成以下几个部分：
1.若干空格
2.一个 小数 或者 整数
3.（可选）一个 'e' 或 'E' ，后面跟着一个 整数
4.若干空格
小数（按顺序）可以分成以下几个部分：
1.（可选）一个符号字符（'+' 或 '-'）
2.下述格式之一：
  1.至少一位数字，后面跟着一个点 '.'
  2.至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
  3.一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：
1.（可选）一个符号字符（'+' 或 '-'）
2.至少一位数字
部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
提示：
1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。

确定有限状态自动机（DFA）
官方题解: https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/biao-shi-shu-zhi-de-zi-fu-chuan-by-leetcode-soluti/
时间复杂度 O(n)
 */