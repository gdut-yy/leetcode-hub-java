public class Solution4104 {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int lastA = -1;
        int candidate = -1;
        int bestA = -1;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if (ch == 'a') {
                lastA = r;
            } else if (ch == 'b') {
                if (lastA > candidate) {
                    candidate = lastA;
                }
            } else {
                if (candidate > bestA) {
                    bestA = candidate;
                }
            }
            ans += r - bestA;
        }
        return ans;
    }
}
/*
4104. 统计有效子字符串 II
https://leetcode.cn/problems/count-valid-substrings-ii/description/

第 195 场双周赛 T3。

给你一个仅由字符 'a'、'b' 和 'c' 组成的字符串 s。
如果一个字符串不包含 "abc" 作为 子序列 ，那么它被称为 有效的 。
返回 s 中 有效子串 的数量。起始或结束下标不同的子串分别计数。
子串 是字符串内连续的 非空 字符序列。
子序列 是指从另一个字符串中删除一些或不删除字符，且不改变剩余字符顺序所得到的新字符串。
示例 1：
输入： s = "abac"
输出： 9
示例 2：
输入： s = "abc"
输出： 5
示例 3：
输入： s = "ac"
输出： 3
提示：
1 <= s.length <= 10^5
s 仅由字符 'a'、'b' 和 'c' 组成。

维护最近的每种字母的下标。
时间复杂度 O(n)。
 */