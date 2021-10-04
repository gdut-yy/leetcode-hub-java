import java.util.HashMap;
import java.util.Map;

public class Solution266 {
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
266. 回文排列
https://leetcode-cn.com/problems/palindrome-permutation/

给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
输入: "code"
输出: false
 */