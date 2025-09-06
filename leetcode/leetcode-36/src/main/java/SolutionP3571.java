public class SolutionP3571 {
    public String shortestSuperstring(String s1, String s2) {
        if (s1.length() < s2.length()) return shortestSuperstring(s2, s1);
        if (s1.contains(s2)) return s1;
        int m = s2.length();
        for (int L = m - 1; L >= 1; L--) { // 由大到小枚举重叠长度
            if (s1.endsWith(s2.substring(0, L))) {
                return s1 + s2.substring(L);
            }
            if (s2.endsWith(s1.substring(0, L))) {
                return s2 + s1.substring(L);
            }
        }
        return s1 + s2;
    }
}
/*
$3571. 最短超级串 II
https://leetcode.cn/problems/find-the-shortest-superstring-ii/description/

给定 两 个字符串，s1 和 s2。返回同时包含 s1 和 s2 作为子串的 最短 字符串。如果有多个合法的答案，返回任意一个。
子串 是字符串中连续的字符序列。
提示：
1 <= s1.length <= 100
1 <= s2.length <= 100
s1 和 s2 只包含小写英文字母。

由大到小枚举重叠长度。
时间复杂度 O(mn)。
 */