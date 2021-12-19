import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution241 {
    private final Map<String, List<Integer>> cacheMap = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> resList = new ArrayList<>();
        if (expression == null || expression.length() == 0) {
            return resList;
        }
        // cache
        if (cacheMap.containsKey(expression)) {
            return cacheMap.get(expression);
        }
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (int left : leftList) {
                    for (int right : rightList) {
                        if (ch == '+') {
                            resList.add(left + right);
                        } else if (ch == '-') {
                            resList.add(left - right);
                        } else {
                            resList.add(left * right);
                        }
                    }
                }
            }
        }
        // 不含 +/-/*
        if (resList.isEmpty()) {
            resList.add(Integer.parseInt(expression));
        }
        // cache
        cacheMap.putIfAbsent(expression, resList);
        return resList;
    }
}
/*
241. 为运算表达式设计优先级
https://leetcode-cn.com/problems/different-ways-to-add-parentheses/

给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
有效的运算符号包含 +, - 以及 * 。
示例 1:
输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2

分治法
trick：使用 HashMap 做 cache 可以缩短程序运行时间。
执行结果：通过
执行用时：1 ms, 在所有 Java 提交中击败了99.56%的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了92.52%的用户
通过测试用例：25 / 25
 */