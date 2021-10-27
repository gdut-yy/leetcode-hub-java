import java.util.HashMap;
import java.util.Map;

public class Solution387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (cntMap.getOrDefault(s.charAt(i), 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}
/*
387. 字符串中的第一个唯一字符
https://leetcode-cn.com/problems/first-unique-character-in-a-string/

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */