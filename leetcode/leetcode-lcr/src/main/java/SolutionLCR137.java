public class SolutionLCR137 {
    public boolean articleMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
/*
LCR 137. 模糊搜索验证
https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/description/

请设计一个程序来支持用户在文本编辑器中的模糊搜索功能。用户输入内容中可能使用到如下两种通配符：
- '.' 匹配任意单个字符。
- '*' 匹配零个或多个前面的那一个元素。
请返回用户输入内容 input 所有字符是否可以匹配原文字符串 article。
提示：
1 <= article.length <= 20
1 <= input.length <= 20
article 只包含从 a-z 的小写字母。
input 只包含从 a-z 的小写字母，以及字符 . 和 * 。
保证每次出现字符 * 时，前面都匹配到有效的字符

同: 10. 正则表达式匹配
https://leetcode.cn/problems/regular-expression-matching/
 */