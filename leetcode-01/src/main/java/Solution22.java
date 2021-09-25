import java.util.ArrayList;
import java.util.List;

public class Solution22 {
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
22. 括号生成
https://leetcode-cn.com/problems/generate-parentheses/

回溯法。
 */