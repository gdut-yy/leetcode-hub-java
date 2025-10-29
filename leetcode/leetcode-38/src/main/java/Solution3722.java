public class Solution3722 {
    public String lexSmallest(String s) {
        int n = s.length();
        String ans = s;
        for (int k = 1; k <= n; k++) {
            String s1 = new StringBuilder(s.substring(0, k)).reverse() + s.substring(k);
            if (s1.compareTo(ans) < 0) ans = s1;
            String s2 = s.substring(0, n - k) + new StringBuilder(s.substring(n - k)).reverse();
            if (s2.compareTo(ans) < 0) ans = s2;
        }
        return ans;
    }
}
/*
3722. 反转后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-reverse/description/

第 168 场双周赛 T1。

给你一个由小写英文字母组成的、长度为 n 的字符串 s。
你 必须执行 恰好 一次操作：选择一个整数 k，满足 1 <= k <= n，然后执行以下两个选项之一：
- 反转 s 的 前 k 个字符，或
- 反转 s 的 后 k 个字符。
返回在 恰好 执行一次此类操作后可以获得的 字典序最小 的字符串。
如果字符串 a 和字符串 b 在第一个不同的位置上，a 中的字母在字母表中比 b 中对应的字母出现得更早，则称字符串 a 字典序小于 字符串 b。如果前 min(a.length, b.length) 个字符都相同，则较短的字符串字典序较小。
提示:
1 <= n == s.length <= 1000
s 由小写英文字母组成。

枚举。
时间复杂度 O(n^2)。
 */