public class Solution3503 {
    public int longestPalindrome(String s, String t) {
        int n = s.length();
        int m = t.length();

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j < n; j++) {
                String sub1 = s.substring(i, j + 1);

                for (int a = 0; a < m; a++) {
                    for (int b = a - 1; b < m; b++) {
                        String sub2 = t.substring(a, b + 1);

                        String ss = sub1 + sub2;
                        if (ss.length() > ans && isPal(ss)) {
                            ans = ss.length();
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPal(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}
/*
3503. 子字符串连接后的最长回文串 I
https://leetcode.cn/problems/longest-palindrome-after-substring-concatenation-i/description/

第 443 场周赛 T2。

给你两个字符串 s 和 t。
你可以从 s 中选择一个子串（可以为空）以及从 t 中选择一个子串（可以为空），然后将它们 按顺序 连接，得到一个新的字符串。
返回可以由上述方法构造出的 最长 回文串的长度。
回文串 是指正着读和反着读都相同的字符串。
子字符串 是指字符串中的一个连续字符序列。
提示：
1 <= s.length, t.length <= 30
s 和 t 仅由小写英文字母组成。

暴力做法：四层循环。
时间复杂度 O(n^5)。
相似题目: 3504. 子字符串连接后的最长回文串 II
https://leetcode.cn/problems/longest-palindrome-after-substring-concatenation-ii/description/
 */