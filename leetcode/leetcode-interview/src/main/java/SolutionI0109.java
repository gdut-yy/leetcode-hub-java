public class SolutionI0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String doubleS2 = s2 + s2;
        return doubleS2.contains(s1);
    }
}
/*
面试题 01.09. 字符串轮转

字符串轮转。给定两个字符串 s1 和 s2，请编写代码检查 s2 是否为 s1 旋转而成（比如，waterbottle 是 erbottlewat 旋转后的字符串）。
提示：
字符串长度在[0, 100000]范围内。
说明:
你能只调用一次检查子串的方法吗？

将 s2 首尾拼接（s2 + s2），然后判断是否包含 s1 子串。
 */