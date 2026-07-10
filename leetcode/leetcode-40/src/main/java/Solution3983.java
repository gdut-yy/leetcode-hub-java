public class Solution3983 {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[] pre = new int[n + 1];
        pre[0] = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            while (j < m && t.charAt(j) != s.charAt(i - 1)) {
                j++;
            }
            if (j < m) {
                j++;
                pre[i] = j;
            } else {
                pre[i] = m + 1;
            }
        }

        int[] suf = new int[n + 1];
        suf[n] = m;
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && t.charAt(j) != s.charAt(i)) {
                j--;
            }
            if (j >= 0) {
                suf[i] = j;
                j--;
            } else {
                suf[i] = -1;
            }
        }
        if (pre[n] <= m) {
            return true;
        }
        for (int k = 0; k < n; k++) {
            if (pre[k] <= m && suf[k + 1] >= 0 && pre[k] < suf[k + 1]) {
                return true;
            }
        }
        return false;
    }
}
/*
3983. 一次替换后的子序列
https://leetcode.cn/problems/subsequence-after-one-replacement/description/

第 509 场周赛 T2。

给你两个由小写英文字母组成的字符串 s 和 t。
你最多可以选择 s 中的一个下标，并将该下标处的字符 替换 为任意小写英文字母。
如果可以使 s 成为 t 的一个 子序列，则返回 true；否则返回 false。
子序列 是指通过删除另一个字符串中的某些字符或不删除任何字符，并且不改变剩余字符相对顺序后得到的字符串。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 仅由小写英文字母组成。

前后缀分解。
时间复杂度 O(n+m)。
 */
