public class Solution3612 {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!ans.isEmpty()) ans.deleteCharAt(ans.length() - 1);
            } else if (c == '#') {
                ans.append(ans);
            } else if (c == '%') {
                ans.reverse();
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
/*
3612. 用特殊操作处理字符串 I
https://leetcode.cn/problems/process-string-with-special-operations-i/description/

第 458 场周赛 T1。

给你一个字符串 s，它由小写英文字母和特殊字符：*、# 和 % 组成。
请根据以下规则从左到右处理 s 中的字符，构造一个新的字符串 result：
- 如果字符是 小写 英文字母，则将其添加到 result 中。
- 字符 '*' 会 删除 result 中的最后一个字符（如果存在）。
- 字符 '#' 会 复制 当前的 result 并 追加 到其自身后面。
- 字符 '%' 会 反转 当前的 result。
在处理完 s 中的所有字符后，返回最终的字符串 result。
提示:
1 <= s.length <= 20
s 只包含小写英文字母和特殊字符 *、# 和 %。

中国时间 2025-07-13 周日 10:30
佛山。
模拟。
 */