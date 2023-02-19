public class Solution2565 {
    public int minimumScore(String s, String t) {
        int n = s.length();
        int m = t.length();

        // pre[i] = x 表示 t 前缀长度为 i 时，s 需要至少前缀长度 x 匹配
        int[] pre = new int[m + 1];
        pre[0] = 0;
        int j = 1;
        // s[j] t[i]
        for (int i = 1; i <= m; i++) {
            while (j <= n && s.charAt(j - 1) != t.charAt(i - 1)) {
                j++;
            }
            if (j <= n) {
                pre[i] = j++;
            } else {
                pre[i] = n + 1;
            }
        }

        // suf[i] = x 表示 t 后缀长度为 i 时，s 需要至少后缀长度 x 匹配
        int[] suf = new int[m + 1];
//        suf[0] = 0;
        suf[m] = 0;
        j = 1;
        for (int i = 1; i <= m; i++) {
            while (j <= n && s.charAt(n - j) != t.charAt(m - i)) {
                j++;
            }
            if (j <= n) {
//                suf[i] = j++;
                suf[m - i] = j++;
            } else {
//                suf[i] = n + 1;
                suf[m - i] = n + 1;
            }
        }

        // 二分删除长度
        int left = 0;
        int right = m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(n, m, pre, suf, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int n, int m, int[] pre, int[] suf, int mid) {
        for (int i = 0; i + mid <= m; i++) {
            if (pre[i] + suf[i + mid] <= n) {
                return true;
            }
        }
        return false;
    }
}
/*
2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/

第 332 场周赛 T4。

给你两个字符串 s 和 t 。
你可以从字符串 t 中删除任意数目的字符。
如果没有从字符串 t 中删除字符，那么得分为 0 ，否则：
- 令 left 为删除字符中的最小下标。
- 令 right 为删除字符中的最大下标。
字符串的得分为 right - left + 1 。
请你返回使 t 成为 s 子序列的最小得分。
一个字符串的 子序列 是从原字符串中删除一些字符后（也可以一个也不删除），剩余字符不改变顺序得到的字符串。（比方说 "ace" 是 "abcde" 的子序列，但是 "aec" 不是）。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 都只包含小写英文字母。

前后缀分解 + 二分（感觉比双指针好理解）
相似题目: 2484. 统计回文子序列数目
https://leetcode.cn/problems/count-palindromic-subsequences/
2552. 统计上升四元组
https://leetcode.cn/problems/count-increasing-quadruplets/
D - Match or Not
https://atcoder.jp/contests/abc287/tasks/abc287_d
 */