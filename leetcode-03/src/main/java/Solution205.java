import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // 记录 s.charAt(i) 与 t.charAt(i) 的映射关系
        Map<Character, Character> kvMap = new HashMap<>();
        // 记录 t.charAt(i) 是否被映射过
        Set<Character> singleSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            // t.charAt(i) 未被映射过，则添加映射
            if (!kvMap.containsKey(key) && !singleSet.contains(value)) {
                kvMap.put(key, value);
                singleSet.add(value);
            } else {
                if (!kvMap.containsKey(key) || (kvMap.get(key) != value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
205. 同构字符串
https://leetcode-cn.com/problems/isomorphic-strings/

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 */