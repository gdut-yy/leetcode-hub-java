import java.util.HashMap;
import java.util.Map;

public class Solution1897 {
    public boolean makeEqual(String[] words) {
        int len = words.length;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % len != 0) {
                return false;
            }
        }
        return true;
    }
}
/*
1897. 重新分配字符使所有字符串都相等
https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal/

第 245 场周赛 T1。
各个小写英文字母的总数能整除数组长度即可。
 */
