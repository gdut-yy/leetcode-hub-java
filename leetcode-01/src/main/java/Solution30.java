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
https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/


 */