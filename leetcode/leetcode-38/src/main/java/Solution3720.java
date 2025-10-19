public class Solution3720 {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        String res = dfs(0, cnt, target, "");
        return res == null ? "" : res;
    }

    private String dfs(int pos, int[] cnt, String target, String cur) {
        if (pos == target.length()) {
            if (cur.compareTo(target) > 0) {
                return cur;
            }
            return null;
        }

        String candidate1 = null;
        for (char c = (char) (target.charAt(pos) + 1); c <= 'z'; c++) {
            if (cnt[c - 'a'] > 0) {
                StringBuilder rest = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('a' + j);
                    int count = cnt[j];
                    if (ch == c) {
                        count--;
                    }
                    rest.append(String.valueOf(ch).repeat(Math.max(0, count)));
                }
                candidate1 = cur + c + rest;
                break;
            }
        }

        String candidate2 = null;
        char t = target.charAt(pos);
        if (cnt[t - 'a'] > 0) {
            cnt[t - 'a']--;
            candidate2 = dfs(pos + 1, cnt, target, cur + t);
            cnt[t - 'a']++;
        }

        return candidate2 != null ? candidate2 : candidate1;
    }
}
/*
3720. 大于 target 的最小字典序排列
https://leetcode.cn/problems/lexicographically-smallest-permutation-greater-than-target/description/

第 472 场周赛 T3。

给你两个长度均为 n 且仅由小写英文字母组成的字符串 s 和 target。
返回 s 的 字典序最小的排列，要求该排列 严格 大于 target。如果 s 不存在任何字典序严格大于 target 的排列，则返回一个空字符串。
如果两个长度相同的字符串 a 和 b 在它们首次出现不同字符的位置上，字符串 a 对应的字母在字母表中出现在 b 对应字母的 后面 ，则字符串 a 字典序严格大于 字符串 b。
排列 是字符串中所有字符的一种重新排列。
提示:
1 <= s.length == target.length <= 300
s 和 target 仅由小写英文字母组成。

逐位确定法。
https://yuanbao.tencent.com/chat/naQivTmsDa/b68853e0-e6b3-4fdc-a1f3-1ba37fab5f88
时间复杂度 O(26n)。
 */