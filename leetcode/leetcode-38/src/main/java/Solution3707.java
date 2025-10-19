import java.util.HashSet;
import java.util.Set;

public class Solution3707 {
    public boolean scoreBalance(String s) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'a' + 1;
            set.add(sum);
        }
        return sum % 2 == 0 && set.contains(sum / 2);
    }
}
/*
3707. 相等子字符串分数
https://leetcode.cn/problems/equal-score-substrings/description/

第 167 场双周赛 T1。

给你一个由小写英文字母组成的字符串 s。
一个字符串的 得分 是其字符在字母表中的位置之和，其中 'a' = 1，'b' = 2，...，'z' = 26。
请你判断是否存在一个下标 i，使得该字符串可以被拆分成两个 非空子字符串 s[0..i] 和 s[(i + 1)..(n - 1)]，且它们的得分 相等 。
如果存在这样的拆分，则返回 true，否则返回 false。
一个 子字符串 是字符串中 非空 的连续字符序列。
提示:
2 <= s.length <= 100
s 由小写英文字母组成。

注意不能 sum += c-'a'。还要判断 sum 的奇偶，不能直接除 2。
时间复杂度 O(n)。
 */