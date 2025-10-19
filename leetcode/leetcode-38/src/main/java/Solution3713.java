public class Solution3713 {
    public int longestBalanced(String s) {
        int n = s.length();
        int[][] ps = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i].clone();
            int c = s.charAt(i) - 'a';
            ps[i + 1][c] = ps[i][c] + 1;
        }

        int ans = 1;
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                boolean flag = true;
                int same = -1;
                for (int c = 0; c < 26; c++) {
                    int d = ps[r + 1][c] - ps[l][c];
                    if (d == 0) continue;
                    if (same == -1) same = d;
                    else if (d != same) flag = false;
                }
                if (flag) ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
/*
3713. 最长的平衡子串 I
https://leetcode.cn/problems/longest-balanced-substring-i/description/

第 471 场周赛 T2。

给你一个由小写英文字母组成的字符串 s。
如果一个 子串 中所有 不同 字符出现的次数都 相同 ，则称该子串为 平衡 子串。
请返回 s 的 最长平衡子串 的 长度 。
子串 是字符串中连续的、非空 的字符序列。
提示：
1 <= s.length <= 1000
s 仅由小写英文字母组成。

维护 26 个前缀和。
时间复杂度 O(26n)。
 */