public class Solution3407 {
    public boolean hasMatch(String s, String p) {
        String[] sp = p.split("\\*");
        if (sp.length == 0) return true; // p = "*"
        if (sp.length == 1) { // * 在开头或结尾
            return s.contains(sp[0]);
        }
        int i = s.indexOf(sp[0]);
        int j = s.lastIndexOf(sp[1]);
        if (i < 0 || j < 0) return false;
        return i + sp[0].length() <= j;
    }
}
/*
3407. 子字符串匹配模式
https://leetcode.cn/problems/substring-matching-pattern/description/

第 147 场双周赛 T1。

给你一个字符串 s 和一个模式字符串 p ，其中 p 恰好 包含 一个 '*' 符号。
p 中的 '*' 符号可以被替换为零个或多个字符组成的任意字符序列。
如果 p 可以变成 s 的子字符串，那么返回 true ，否则返回 false 。
子字符串 指的是字符串中一段连续 非空 的字符序列。
提示：
1 <= s.length <= 50
1 <= p.length <= 50
s 只包含小写英文字母。
p 只包含小写英文字母和一个 '*' 符号。

库函数 + 分类讨论。
时间复杂度 O(nm)。
 */