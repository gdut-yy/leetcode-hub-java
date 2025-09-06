public class SolutionP3460 {
    public int longestCommonPrefix(String s, String t) {
        int ans = 0;
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        boolean canJump = true;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                ans++;
                i++;
                j++;
            } else if (canJump) {
                i++;
                canJump = false;
            } else {
                break;
            }
        }
        return ans;
    }
}
/*
$3460. 最多删除一次后的最长公共前缀
https://leetcode.cn/problems/longest-common-prefix-after-at-most-one-removal/description/

给定两个字符串 s 和 t。
返回从 s 最多 删除一个字母后，s 和 t 的 最长公共 前缀 的 长度。
注意：可以保留 s 而不做任何删除。
提示：
1 <= s.length <= 10^5
1 <= t.length <= 10^5
s 和 t 只包含小写英文字母。

双指针。
时间复杂度 O(n + m)。
 */