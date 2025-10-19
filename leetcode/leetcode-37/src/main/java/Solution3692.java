import java.util.HashMap;
import java.util.Map;

public class Solution3692 {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }

        Map<Integer, StringBuilder> group = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            Integer val = entry.getValue();
            group.computeIfAbsent(val, e -> new StringBuilder()).append(entry.getKey());
        }
        int freq = 0;
        String ans = "";
        for (Map.Entry<Integer, StringBuilder> entry : group.entrySet()) {
            if (entry.getValue().length() > ans.length() ||
                    entry.getValue().length() == ans.length() && entry.getKey() > freq) {
                ans = entry.getValue().toString();
                freq = entry.getKey();
            }
        }
        return ans;
    }
}
/*
3692. 众数频率字符
https://leetcode.cn/problems/majority-frequency-characters/description/

第 166 场双周赛 T1。

给你一个由小写英文字母组成的字符串 s。
对于一个值 k，频率组 是在 s 中恰好出现 k 次的字符集合。
众数频率组 是包含 不同 字符数量最多的频率组。
返回一个字符串，包含众数频率组中的所有字符，字符的顺序 不限 。如果两个或多个频率组的大小并列最大，则选择其频率 k 较大 的那个组。
提示:
1 <= s.length <= 100
s 只包含小写英文字母。

哈希表分组。
时间复杂度 O(n)。
 */