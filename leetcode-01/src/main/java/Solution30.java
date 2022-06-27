import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resList = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return resList;
        }
        // 统计
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }

        int wordsM = words.length;
        int wordsN = words[0].length();
        int totalLen = wordsM * wordsN;
        for (int i = 0; i < s.length() - totalLen + 1; i++) {
            String tmp = s.substring(i, i + totalLen);
            Map<String, Integer> tmpMap = new HashMap<>();
            for (int j = 0; j < totalLen; j += wordsN) {
                String word = tmp.substring(j, j + wordsN);
                tmpMap.put(word, tmpMap.getOrDefault(word, 0) + 1);
            }
            if (cntMap.equals(tmpMap)) {
                resList.add(i);
            }
        }
        return resList;
    }
}
/*
30. 串联所有单词的子串
https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

给定一个字符串 s 和一些 长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

因为长度相同的单词 words，所以子串长度是定值 words.length * words[i].length
枚举这个定制长度的子串，再利用 HashMap 进行判等
 */