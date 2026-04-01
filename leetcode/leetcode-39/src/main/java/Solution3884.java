public class Solution3884 {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(n - 1 - i)) return i;
        }
        return -1;
    }
}
/*
3884. 双端字符匹配
https://leetcode.cn/problems/first-matching-character-from-both-ends/description/

第 495 场周赛 T1。

给你一个长度为 n 的字符串 s，其中只包含小写英文字母。
返回最小的下标 i，使得 s[i] == s[n - i - 1]。
如果不存在这样的下标，返回 -1。
提示：
1 <= n == s.length <= 100
s 仅包含小写英文字母。

遍历。
时间复杂度 O(n)。
 */