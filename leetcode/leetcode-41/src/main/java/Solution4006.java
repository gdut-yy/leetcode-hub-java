public class Solution4006 {
    public int countValidPrefixes(String s) {
        int sum = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') sum++;
            else sum--;
            if (Math.abs(sum) <= 1) ans++;
        }
        return ans;
    }
}
/*
4006. 统计有效前缀数目
https://leetcode.cn/problems/count-valid-prefixes/description/

第 188 场双周赛 T1。

给你一个 二进制 字符串 s。
如果 s 的某个 前缀 的字符可以重新排列成一个 交替 字符串，那么该前缀被认为是 有效 的。
返回 s 中有效前缀的数量。
二进制 字符串是仅由 '0' 和 '1' 组成的字符串。
字符串的 前缀 是指从字符串的开头开始并延伸到其内任意点的 子字符串。
子字符串 是字符串中连续且 非空 的字符序列。
如果一个字符串中没有两个相邻字符相等，那么它被认为是 交替 的。
提示：
1 <= s.length <= 100
s 仅由 '0' 和 '1' 组成。

一次遍历。
时间复杂度 O(n)。
 */