import java.util.HashMap;
import java.util.Map;

public class SolutionO20 {
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        // 起始的空格（初始状态）
        Map<CharType, State> initialMap = new HashMap<>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        // 符号位
        Map<CharType, State> intSignMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        // 整数部分（接受状态）
        Map<CharType, State> integerMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);

        // 左侧有整数的小数点（接受状态）
        Map<CharType, State> pointMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        // 左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
        Map<CharType, State> pointWithoutIntMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        // 小数部分（接受状态）
        Map<CharType, State> fractionMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        // 字符 e
        Map<CharType, State> expMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        // 指数部分的符号位
        Map<CharType, State> expSignMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        // 指数部分的整数部分（接受状态）
        Map<CharType, State> expNumberMap = new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        // 末尾的空格（接受状态）
        Map<CharType, State> endMap = new HashMap<>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
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

}
/*
剑指 Offer 20. 表示数值的字符串
https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/

确定有限状态自动机（DFA）
官方题解: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/biao-shi-shu-zhi-de-zi-fu-chuan-by-leetcode-soluti/

时间复杂度 O(n)
空间复杂度 O(1)
 */