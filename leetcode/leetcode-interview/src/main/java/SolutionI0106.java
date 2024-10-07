public class SolutionI0106 {
    public String compressString(String S) {
        int n = S.length();
        if (n == 0) return "";

        // 双指针
        int left = 0;
        int right = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (left < n && right < n) {
            if (S.charAt(left) == S.charAt(right)) {
                cnt++;
                right++;
            } else {
                sb.append(S.charAt(left)).append(cnt);
                cnt = 0;
                left = right;
            }
        }
        sb.append(S.charAt(left)).append(cnt);
        String compressString = sb.toString();
        return (n <= compressString.length()) ? S : compressString;
    }
}
/*
面试题 01.06. 字符串压缩
https://leetcode.cn/problems/compress-string-lcci/

字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

StringBuilder 模拟压缩后的字符串。双指针。
 */