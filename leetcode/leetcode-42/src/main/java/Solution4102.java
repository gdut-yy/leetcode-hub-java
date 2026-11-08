public class Solution4102 {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (r >= 2 && s.charAt(r - 2) == 'a'
                    && s.charAt(r - 1) == 'b' && s.charAt(r) == 'c') {
                l = r - 1;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
/*
4102. 统计有效子字符串 I
https://leetcode.cn/problems/count-valid-substrings-i/description/

第 195 场双周赛 T1。

给你一个仅由字符 'a'、'b' 和 'c' 组成的字符串 s。
如果一个字符串不包含 "abc" 作为 子串 ，那么它被称为 有效的 。
返回 s 中 有效子串 的数量。起始或结束下标不同的子串分别计数。
子串 是字符串内连续的 非空 字符序列。
示例 1：
输入： s = "abac"
输出： 10
示例 2：
输入： s = "abc"
输出： 5
示例 3：
输入： s = "ac"
输出： 3
提示：
1 <= s.length <= 10^5
s 仅由字符 'a'、'b' 和 'c' 组成。

枚举右维护左。
时间复杂度 O(n)。
 */