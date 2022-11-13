import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution791 {
    public String customSortString(String order, String s) {
        int len = s.length();
        // 预处理
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean[] used = new boolean[len];
        for (char ch : order.toCharArray()) {
            for (int id : map.getOrDefault(ch, new ArrayList<>())) {
                used[id] = true;
                stringBuilder.append(s.charAt(id));
            }
        }
        // 不是按顺序出现的，所以它可以在返回的字符串中的任何位置。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
/*
791. 自定义字符串排序
https://leetcode.cn/problems/custom-sort-string/

给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
返回 满足这个性质的 s 的任意排列 。
提示:
1 <= order.length <= 26
1 <= s.length <= 200
order 和 s 由小写英文字母组成
order 中的所有字符都 不同

模拟。
时间复杂度 O(n)
 */