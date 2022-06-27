import java.util.ArrayList;
import java.util.List;

public class SolutionI0809 {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        helper(n, n, "", resList);
        return resList;
    }

    private void helper(int left, int right, String parenthesis, List<String> resList) {
        if (left == 0 && right == 0) {
            resList.add(parenthesis);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, parenthesis + "(", resList);
        }
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", resList);
        }
    }
}
/*
面试题 08.09. 括号
https://leetcode.cn/problems/bracket-lcci/

括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
说明：解集不能包含重复的子集。
例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

同: 22. 括号生成
https://leetcode.cn/problems/generate-parentheses/
 */