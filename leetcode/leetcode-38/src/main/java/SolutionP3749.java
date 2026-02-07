import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP3749 {
    private String s;
    private int[] p;

    public long evaluateExpression(String expression) {
        this.s = expression;
        int n = s.length();
        p = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char x = expression.charAt(i);
            if (x == '(') {
                st.push(i);
            } else if (x == ')') {
                p[st.pop()] = i;
            }
        }
        return dfs(0, n - 1)[0];
    }

    private long[] dfs(int l, int r) {
        if (!Character.isLetter(s.charAt(l))) {
            long a = 0;
            int sign = 1;
            if (s.charAt(l) == '-') {
                sign = -1;
                l++;
            }
            while (l <= r && Character.isDigit(s.charAt(l))) {
                a = a * 10 + (s.charAt(l) - '0');
                l++;
            }
            if (l < r) {
                return new long[]{a * sign, dfs(l + 1, r)[0]};
            }
            return new long[]{a * sign};
        }

        String op = s.substring(l, l + 3);
        if (p[l + 3] == r) {
            long[] dfs = dfs(l + 4, r - 1);
            long a = dfs[0], b = dfs[1];
            if (op.equals("add")) {
                return new long[]{a + b};
            } else if (op.equals("sub")) {
                return new long[]{a - b};
            } else if (op.equals("mul")) {
                return new long[]{a * b};
            } else if (op.equals("div")) {
                return new long[]{a / b};
            }
        }
        return new long[]{dfs(l, p[l + 3])[0], dfs(p[l + 3] + 2, r)[0]};
    }
}
/*
$3749. 计算有效表达式
https://leetcode.cn/problems/evaluate-valid-expressions/description/

给你一个字符串 expression 表示以简化形式嵌套的数学表达式。
有效 表达式要么是一个整数 字面量，要么符合 op(a,b) 格式，其中：
- op 是 "add"，"sub"，"mul"，"div" 中的一个。
- a 和 b 都是有效表达式。
运算符 定义如下：
- add(a,b) = a + b
- sub(a,b) = a - b
- mul(a,b) = a * b
- div(a,b) = a / b
返回一个整数，表示在完全计算表达式后的结果。
提示：
1 <= expression.length <= 10^5
有效表达式 expression 由数字、逗号、括号、减号 '-' 和小写字符串 "add"，"sub"，"mul"，"div" 组成。
所有中间结果都位于长整型的范围内。
所有除法运算结果都是整数值。

预处理括号对应关系
https://leetcode.cn/problems/evaluate-valid-expressions/solutions/3834017/yu-chu-li-gua-hao-dui-ying-guan-xi-by-13-pgrk/
 */