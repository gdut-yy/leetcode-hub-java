import java.util.Arrays;

public class Solution3557 {
    public int maxSubstrings(String word) {
        char[] s = word.toCharArray();
        int n = s.length;
        int ans = 0;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            int ch = s[i] - 'a';
            if (pos[ch] == -1) {
                pos[ch] = i;
            } else if (i - pos[ch] > 2) {
                ans++;
                Arrays.fill(pos, -1);
            }
        }
        return ans;
    }
}
/*
3557. 不相交子字符串的最大数量
https://leetcode.cn/problems/find-maximum-number-of-non-intersecting-substrings/description/

第 157 场双周赛 T2。

给你一个字符串 word。
返回以 首尾字母相同 且 长度至少为 4 的 不相交子字符串 的最大数量。
子字符串 是字符串中连续的 非空 字符序列。
提示：
1 <= word.length <= 2 * 10^5
word 仅由小写英文字母组成。

划分型贪心。
时间复杂度 O(26n)。
 */