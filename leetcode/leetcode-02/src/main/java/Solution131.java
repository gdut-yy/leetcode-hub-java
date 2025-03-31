import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    // 剑指 Offer II 086. 分割回文子字符串
    // https://leetcode.cn/problems/M99OJA/
    public String[][] partition(String s) {
        V1 sol = new V1();
        List<List<String>> res = sol.partition(s);
        return res.stream().map(row -> row.toArray(String[]::new)).toArray(String[][]::new);
    }

    static class V1 {
        String s;
        List<List<String>> ans;

        public List<List<String>> partition(String s) {
            this.s = s;
            ans = new ArrayList<>();
            backtrack(0, new ArrayList<>());
            return ans;
        }

        // 考虑 s[i] ~ s[n-1] 怎么分割
        private void backtrack(int i, List<String> path) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (isPal(i, j)) {
                    path.add(s.substring(i, j + 1));
                    backtrack(j + 1, path);
                    path.removeLast();
                }
            }
        }

        private boolean isPal(int l, int r) {
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) return false;
            }
            return true;
        }
    }
}
/*
131. 分割回文串
https://leetcode.cn/problems/palindrome-partitioning/

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。
提示：
1 <= s.length <= 16
s 仅由小写英文字母组成

回溯法。
 */