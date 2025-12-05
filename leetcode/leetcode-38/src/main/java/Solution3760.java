import java.util.HashSet;
import java.util.Set;

public class Solution3760 {
    public int maxDistinct(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
/*
3760. 不同首字母的子字符串数目
https://leetcode.cn/problems/maximum-substrings-with-distinct-start/description/

第 478 场周赛 T2。

给你一个由小写英文字母组成的字符串 s。
返回一个整数，表示可以将 s 划分为子字符串的最大数量，使得每个 子字符串 都以一个 不同 字符开头（即，任意两个子字符串的首字符不能相同）。
子字符串 是字符串中一个连续、非空字符序列。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成。

脑筋急转弯。
时间复杂度 O(n)。
 */