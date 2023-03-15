import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionI1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String orderStr = new String(chars);
            List<String> list = groupMap.getOrDefault(orderStr, new ArrayList<>());
            list.add(str);
            groupMap.put(orderStr, list);
        }
        return new ArrayList<>(groupMap.values());
    }
}
/*
面试题 10.02. 变位词组
https://leetcode.cn/problems/group-anagrams-lcci/

编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

同: 49. 字母异位词分组
https://leetcode.cn/problems/group-anagrams/
 */