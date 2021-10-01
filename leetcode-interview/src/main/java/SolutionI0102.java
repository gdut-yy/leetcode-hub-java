import java.util.HashMap;
import java.util.Map;

public class SolutionI0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> cntMap1 = new HashMap<>();
        Map<Character, Integer> cntMap2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            cntMap1.put(ch, cntMap1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            cntMap2.put(ch, cntMap2.getOrDefault(ch, 0) + 1);
        }
        return cntMap1.equals(cntMap2);
    }
}
/*
面试题 01.02. 判定是否互为字符重排
https://leetcode-cn.com/problems/check-permutation-lcci/

给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

HashMap 统计频次，判等。
 */