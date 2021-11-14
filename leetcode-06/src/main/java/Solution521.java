public class Solution521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
/*
521. 最长特殊序列 Ⅰ
https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/

给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。

如果两个字符串相同，则没有特殊子序列，返回 -1
否则，长的字符串一定不会是短字符串的子序列，返回 长的字符串 的长度。
 */