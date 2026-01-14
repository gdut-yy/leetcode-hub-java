public class Solution3794 {
    public String reversePrefix(String s, int k) {
        return new StringBuilder(s.substring(0, k)).reverse() + s.substring(k);
    }
}
/*
3794. 反转字符串前缀
https://leetcode.cn/problems/reverse-string-prefix/description/

第 173 场双周赛 T1。

给你一个字符串 s 和一个整数 k。
反转 s 的前 k 个字符，并返回结果字符串。
提示:
1 <= s.length <= 100
s 仅由小写英文字母组成。
1 <= k <= s.length

库函数模拟。
时间复杂度 O(n)。
 */