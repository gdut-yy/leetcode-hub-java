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

字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

将 s2 首位拼接（s2 + s2），判断是否包含 s1 子串。
 */