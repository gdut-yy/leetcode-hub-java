import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 剑指 Offer II 032. 有效的变位词
//        if (s.equals(t)) {
//            return false;
//        }

        Map<Character, Integer> sCntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            sCntMap.put(ch, sCntMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!sCntMap.containsKey(ch) || sCntMap.get(ch) == 0) {
                return false;
            }
            sCntMap.put(ch, sCntMap.get(ch) - 1);
        }
        return true;
    }
}
/*
242. 有效的字母异位词
https://leetcode-cn.com/problems/valid-anagram/

进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
使用 HashMap 统计频次

注意差异: 剑指 Offer II 032. 有效的变位词 https://leetcode-cn.com/problems/dKk3P7/
要求字符顺序不完全相同
 */