public class SolutionI0104 {
    public boolean canPermutePalindrome(String s) {
        long mask = 0;
        for (char c : s.toCharArray()) {
            int j = c - 'a';
            mask ^= 1L << j;
        }
        return Long.bitCount(mask) <= 1;
    }
}
/*
面试题 01.04. 回文排列
https://leetcode.cn/problems/palindrome-permutation-lcci/

给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

位运算。^ 性质。
 */