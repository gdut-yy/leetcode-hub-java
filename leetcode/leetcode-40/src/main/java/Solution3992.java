public class Solution3992 {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == y) sb.insert(0, c);
            else sb.append(c);
        }
        return sb.toString();
    }
}
/*
3992. 重新排列字符串以避免字符对
https://leetcode.cn/problems/rearrange-string-to-avoid-character-pair/description/

第 187 场双周赛 T1。

给你一个字符串 s 和两个 不同 的小写英文字母 x 和 y。
重新排列 s 中的字符来构造一个新的字符串 t，使得：
- t 是 s 的一个 排列。
- 在 t 中，所有 y 都必须在所有 x 之前。
返回 任意 一个有效的字符串 t。
排列 是对一个字符串中所有字符的重新排列。
提示：
1 <= s.length <= 100
s 仅由小写英文字母组成。
x 和 y 都是小写英文字母。
x != y

模拟。
 */