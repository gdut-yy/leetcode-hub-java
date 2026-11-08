import java.util.ArrayList;
import java.util.List;

public class Solution4106 {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n = s1.length();
        List<List<String>> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
                continue;
            }
            int st = i;
            for (; i < n && s1.charAt(i) != s2.charAt(i); i++) {
            }
            ans.add(List.of(s1.substring(st, i), s2.substring(st, i)));
        }
        return ans;
    }
}
/*
4106. 找出两个字符串的不匹配片段
https://leetcode.cn/problems/find-mismatched-segments-between-two-strings/description/

第 527 场周赛 T1。

给你两个长度相同的字符串 s1 和 s2。
不匹配片段 是一个 极大连续 下标区间，其中每个下标处 s1 和 s2 的字符都不相同。
返回一个二维数组，其中包含每个不匹配片段对应的 [sub1, sub2]，sub1 和 sub2 分别是 s1 和 s2 中对应的 子字符串。请按片段起始下标的 递增 顺序返回。如果没有不匹配片段，则返回一个空数组。
子字符串 是字符串中一个连续的 非空 字符序列。
示例 1：
输入： s1 = "earth", s2 = "empty"
输出： [["ar","mp"],["h","y"]]
示例 2：
输入： s1 = "action", s2 = "nation"
输出： [["ac","na"]]
示例 3：
输入： s1 = "hot", s2 = "hot"
输出： []
提示：
1 <= s1.length == s2.length <= 100
s1 和 s2 仅由小写英文字母组成。

分组循环。
时间复杂度 O(n)。
 */