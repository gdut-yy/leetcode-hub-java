import java.util.Arrays;

public class Solution214 {
    public String shortestPalindrome(String s) {
        int n = s.length();

        int[] fail = new int[n];
        Arrays.fill(fail, -1);

        for (int i = 1; i < n; i++) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                best++;
            }
        }
        String add = (best == n - 1) ? "" : s.substring(best + 1);
        StringBuilder stringBuilder = new StringBuilder(add).reverse();
        stringBuilder.append(s);
        return stringBuilder.toString();
    }
}
/*
214. 最短回文串
https://leetcode-cn.com/problems/shortest-palindrome/

给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
提示：
0 <= s.length <= 5 * 10^4
s 仅由小写英文字母组成

KMP
将字符串 s 翻转拼接在开头的做法时间复杂度 O(n^2)，TLE
官方题解: https://leetcode-cn.com/problems/shortest-palindrome/solution/zui-duan-hui-wen-chuan-by-leetcode-solution/
 */