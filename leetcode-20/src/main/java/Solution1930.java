import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1930 {
    public int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> curList = cntMap.getOrDefault(s.charAt(i), new ArrayList<>());
            curList.add(i);
            cntMap.put(s.charAt(i), curList);
        }
        Set<String> ansSet = new HashSet<>();
        for (Map.Entry<Character, List<Integer>> entry : cntMap.entrySet()) {
            Character curChar = entry.getKey();
            List<Integer> curList = entry.getValue();
            int curSize = curList.size();
            if (curSize >= 2) {
                int left = curList.get(0);
                int right = curList.get(curSize - 1);
                // 枚举
                for (int i = left + 1; i < right; i++) {
                    String curStr = "" + curChar + s.charAt(i) + curChar;
                    ansSet.add(curStr);
                }
            }
        }
        return ansSet.size();
    }
}
/*
1930. 长度为 3 的不同回文子序列
https://leetcode-cn.com/problems/unique-length-3-palindromic-subsequences/

第 249 场周赛 T2。
使用 Map 记录 26 个字母每个字母的下标（只用到了第一次出现下标和最后一次出现下标）
然后在下标区间枚举，用 Set 去重即可。
注意用 String.format 拼接 curStr 会超时（可能字符串隐式转换效率更高？）
 */