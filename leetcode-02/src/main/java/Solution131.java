import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    /**
     * 剑指 Offer II 086. 分割回文子字符串
     * https://leetcode-cn.com/problems/M99OJA/
     */
    public String[][] partition(String s) {
        List<List<String>> resList = partition131(s);
        // List<List<String>> 转 String[][]
        int resM = resList.size();
        String[][] res = new String[resM][];
        for (int i = 0; i < resM; i++) {
            int resN = resList.get(i).size();
            res[i] = new String[resN];
            for (int j = 0; j < resN; j++) {
                res[i][j] = resList.get(i).get(j);
            }
        }
        return res;
    }

    /**
     * 131. 分割回文串
     * https://leetcode-cn.com/problems/palindrome-partitioning/
     */
    public List<List<String>> partition131(String s) {
        List<List<String>> resList = new ArrayList<>();
        helper(s, 0, new LinkedList<>(), resList);
        return resList;
    }

    private void helper(String s, int start, LinkedList<String> subStrings, List<List<String>> resList) {
        if (start == s.length()) {
            resList.add(new ArrayList<>(subStrings));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPal(s, start, i)) {
                subStrings.add(s.substring(start, i + 1));
                helper(s, i + 1, subStrings, resList);
                subStrings.removeLast();
            }

        }
    }

    private boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
/*
131. 分割回文串
https://leetcode-cn.com/problems/palindrome-partitioning/

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。

回溯法。
 */