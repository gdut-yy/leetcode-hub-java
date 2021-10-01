import java.util.HashMap;
import java.util.Map;

public class SolutionI0104 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        int cntOdd = 0;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                cntOdd++;
            }
        }
        return cntOdd <= 1;
    }
}
/*
面试题 01.04. 回文排列
https://leetcode-cn.com/problems/palindrome-permutation-lcci/

给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

HashMap 统计频次，字符频次为奇数次的至多只能为 1 次。
 */