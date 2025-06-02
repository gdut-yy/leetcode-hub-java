public class Solution3561 {
    public String resultingString(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!ans.isEmpty() && (Math.abs(ans.charAt(ans.length() - 1) - c) == 1 || Math.abs(ans.charAt(ans.length() - 1) - c) == 25)) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
/*
3561. 移除相邻字符
https://leetcode.cn/problems/resulting-string-after-adjacent-removals/description/

第 451 场周赛 T2。

给你一个由小写英文字母组成的字符串 s。
你 必须 在字符串 s 中至少存在两个 连续 字符时，反复执行以下操作：
- 移除字符串中 最左边 的一对按照字母表 连续 的相邻字符（无论是按顺序还是逆序，例如 'a' 和 'b'，或 'b' 和 'a'）。
- 将剩余字符向左移动以填补空隙。
当无法再执行任何操作时，返回最终的字符串。
注意：字母表是循环的，因此 'a' 和 'z' 也视为连续。
提示:
1 <= s.length <= 10^5
s 仅由小写英文字母组成。

栈模拟。
 */