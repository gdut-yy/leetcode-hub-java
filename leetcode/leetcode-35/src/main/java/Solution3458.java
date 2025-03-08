import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3458 {
    public boolean maxSubstringLength(String s, int k) {
        if (k == 0) return true;

        int[][] ranges = new int[26][2];
        for (char c = 'a'; c <= 'z'; c++) {
            int l = s.indexOf(c);
            int r = s.lastIndexOf(c);
            ranges[c - 'a'] = new int[]{l, r};
        }
        List<int[]> seg = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int[] pi = ranges[i];
            if (pi[0] == -1) continue;
            for (int j = pi[0]; j <= pi[1]; j++) {
                int[] pj = ranges[s.charAt(j) - 'a'];
                if (pi[0] <= pj[0] && pj[1] <= pi[1]) continue;
                pi[0] = Math.min(pi[0], pj[0]);
                pi[1] = Math.max(pi[1], pj[1]);
                j = pi[0];
            }
            seg.add(pi);
        }

        // 按右端点排序
        seg.sort(Comparator.comparingInt(o -> o[1]));
        List<String> ans = new ArrayList<>();
        int pre_r = -1;
        for (int[] p : seg) {
            int l = p[0], r = p[1];
            if (l >= pre_r) {
                ans.add(s.substring(p[0], p[1] + 1));
                pre_r = r;
            }
        }

        if (ans.size() == 1) {
            if (ans.get(0).length() == s.length()) return false;
        }
        return ans.size() >= k;
    }
}
/*
3458. 选择 K 个互不重叠的特殊子字符串
https://leetcode.cn/problems/select-k-disjoint-special-substrings/description/

第 437 场周赛 T3。

给你一个长度为 n 的字符串 s 和一个整数 k，判断是否可以选择 k 个互不重叠的 特殊子字符串 。
特殊子字符串 是满足以下条件的子字符串：
- 子字符串中的任何字符都不应该出现在字符串其余部分中。
- 子字符串不能是整个字符串 s。
注意：所有 k 个子字符串必须是互不重叠的，即它们不能有任何重叠部分。
如果可以选择 k 个这样的互不重叠的特殊子字符串，则返回 true；否则返回 false。
子字符串 是字符串中的连续、非空字符序列。
提示：
2 <= n == s.length <= 5 * 10^4
0 <= k <= 26
s 仅由小写英文字母组成。

相似题目: 1520. 最多的不重叠子字符串
https://leetcode.cn/problems/maximum-number-of-non-overlapping-substrings/description/
 */