import java.util.HashMap;
import java.util.Map;

public class SolutionP3773 {
    public int maxSameLengthRuns(String S) {
        Map<Integer, Integer> cntMp = new HashMap<>();
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            int c = 1;
            for (; i + 1 < s.length && s[i] == s[i + 1]; i++) {
                c++;
            }
            cntMp.merge(c, 1, Integer::sum);
        }
        return cntMp.values().stream().max(Integer::compareTo).orElseThrow();
    }
}
/*
$3773. 最大等长连续字符组
https://leetcode.cn/problems/maximum-number-of-equal-length-runs/description/

给定一个由小写英文字母组成的字符串 s。
s 中的一个 连续字符组 是一个由无法再扩展的 相同 字符组成的 子串。例如，"hello" 中的连续字符组是 "h"，"e"，"ll" 和 "o"。
你可以 选择 s 中 相同 长度的字符组。
返回一个整数，表示你可以在 s 中选择的最多连续字符组。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

分组循环。
时间复杂度 O(n)。
 */