import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cntMap1 = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            cntMap1.put(ch, cntMap1.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> cntMap2 = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            cntMap2.put(ch, cntMap2.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : cntMap1.entrySet()) {
            char key = entry.getKey();
            if (!cntMap2.containsKey(key) || cntMap2.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
/*
383. 赎金信
https://leetcode.cn/problems/ransom-note/

给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

HashMap 统计频次即可。
 */