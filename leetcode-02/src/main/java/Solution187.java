import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resList = new ArrayList<>();
        int len = s.length();
        if (len < 10) {
            return resList;
        }
        Map<String, Integer> cntMap = new HashMap<>();
        for (int i = 0; i <= len - 10; i++) {
            String str = s.substring(i, i + 10);
            cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
            if (cntMap.get(str) == 2) {
                resList.add(str);
            }
        }
        return resList;
    }
}
/*
187. 重复的DNA序列
https://leetcode-cn.com/problems/repeated-dna-sequences/

所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

HashMap 统计频次即可。
 */