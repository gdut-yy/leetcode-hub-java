import java.util.Arrays;

public class Solution3517 {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int m = n / 2;
        char[] t = s.substring(0, m).toCharArray();
        Arrays.sort(t);

        StringBuilder ans = new StringBuilder();
        ans.append(t);
        if (n % 2 != 0) {
            ans.append(s.charAt(m));
        }
        ans.append(new StringBuilder(new String(t)).reverse());
        return ans.toString();
    }
}
/*
3517. 最小回文排列 I
https://leetcode.cn/problems/smallest-palindromic-rearrangement-i/description/

第 445 场周赛 T2。

给你一个 回文 字符串 s。
返回 s 的按字典序排列的 最小 回文排列。
如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。
排列 是字符串中所有字符的重排。
如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成。
保证 s 是回文字符串。

排序左半部分
 */