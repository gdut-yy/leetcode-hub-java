import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1896 {
    // p: 将当前表达式变为 0 的最小操作次数
    // q: 将当前表达式变为 1 的最小操作次数
    record State(int p, int q) {
    }

    // https://leetcode.cn/problems/minimum-cost-to-change-the-final-value-of-expression/solutions/825396/zhan-dong-tai-gui-hua-by-lucifer1004-7bsn/
    public int minOperationsToFlip(String expression) {
        Deque<State> states = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (c == '0' || c == '1' || c == ')') {
                if (c == '0') {
                    states.push(new State(0, 1));
                } else if (c == '1') {
                    states.push(new State(1, 0));
                } else { // c == ')'
                    ops.pop(); // 弹出对应的 '('
                }

                // 检查并计算栈顶的操作符（非 '('）
                if (!ops.isEmpty() && ops.peek() != '(') {
                    char op = ops.pop();
                    State pop2 = states.pop(), pop1 = states.pop();
                    int p2 = pop2.p, q2 = pop2.q;
                    int p1 = pop1.p, q1 = pop1.q;
                    int p, q;
                    if (op == '&') {
                        p = Math.min(p1, p2);
                        q = Math.min(q1 + q2, 1 + Math.min(q1, q2));
                    } else { // op == '|'
                        p = Math.min(p1 + p2, 1 + Math.min(p1, p2));
                        q = Math.min(q1, q2);
                    }
                    states.push(new State(p, q));
                }
            } else { // c 是 '('、'&' 或 '|'
                ops.push(c);
            }
        }
        State peek = states.peek();
        return Math.max(peek.p, peek.q);
    }
}
/*
1896. 反转表达式值的最少操作次数
https://leetcode.cn/problems/minimum-cost-to-change-the-final-value-of-expression/description/

给你一个 有效的 布尔表达式，用字符串 expression 表示。这个字符串包含字符 '1'，'0'，'&'（按位 与 运算），'|'（按位 或 运算），'(' 和 ')' 。
- 比方说，"()1|1" 和 "(1)&()" 不是有效 布尔表达式。而 "1"， "(((1))|(0))" 和 "1|(0&(1))" 是 有效 布尔表达式。
你的目标是将布尔表达式的 值 反转 （也就是将 0 变为 1 ，或者将 1 变为 0），请你返回达成目标需要的 最少操作 次数。
- 比方说，如果表达式 expression = "1|1|(0&0)&1" ，它的 值 为 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1 。我们想要执行操作将 新的 表达式的值变成 0 。
可执行的 操作 如下：
- 将一个 '1' 变成一个 '0' 。
- 将一个 '0' 变成一个 '1' 。
- 将一个 '&' 变成一个 '|' 。
- 将一个 '|' 变成一个 '&' 。
注意：'&' 的 运算优先级 与 '|' 相同 。计算表达式时，括号优先级 最高 ，然后按照 从左到右 的顺序运算。
提示：
1 <= expression.length <= 10^5
expression 只包含 '1'，'0'，'&'，'|'，'(' 和 ')'
所有括号都有与之匹配的对应括号。
不会有空的括号（也就是说 "()" 不是 expression 的子字符串）。

栈+动态规划 https://leetcode.cn/problems/minimum-cost-to-change-the-final-value-of-expression/solutions/825396/zhan-dong-tai-gui-hua-by-lucifer1004-7bsn/
时间复杂度 O(n)。
相似题目: $2313. 二叉树中得到结果所需的最少翻转次数
https://leetcode.cn/problems/minimum-flips-in-binary-tree-to-get-result/description/
 */