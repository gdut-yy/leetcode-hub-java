public class Solution4030 {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            String binaryString = Integer.toBinaryString(c);
            binaryString = "0".repeat(8 - binaryString.length()) + binaryString;
            sb.append(binaryString);
        }
        return isPal(sb.toString());
    }

    private boolean isPal(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
/*
4030. 判断 ASCII 值回文
https://leetcode.cn/problems/check-ascii-palindromic/description/

第 516 场周赛 T1。

给你一个由小写英文字母组成的字符串 s。
将 s 中的每个字符替换为其 ASCII 值对应的 8 位二进制表示，包括前导零，并保持字符原有顺序，从而构造一个二进制字符串。
如果得到的二进制字符串是一个 回文串 ，则返回 true；否则返回 false。
二进制字符串 是指仅由字符 '0' 和 '1' 组成的字符串。
回文串 是指正着读和反着读都相同的字符串。
提示：
1 <= s.length <= 100
s 仅由小写英文字母组成。

模拟。
时间复杂度 O(n)。
 */