import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), str2.charAt(i));
                set.add(str2.charAt(i));
            } else if (map.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
        }
        return set.size() < 26;
    }
}
/*
$1153. 字符串转化
https://leetcode.cn/problems/string-transforms-into-another-string/

给出两个长度相同的字符串 str1 和 str2。请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化 后变成字符串 str2。
每一次转化时，你可以将 str1 中出现的 所有 相同字母变成其他 任何 小写英文字母。
只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 true 。
提示：
1 <= str1.length == str2.length <= 10^4
str1 和 str2 中都只会出现小写英文字母

当 str1 中某两个下标 i 和 j 字符相同时，那么 str2 中这个两个下标的字符也必须相同
 */