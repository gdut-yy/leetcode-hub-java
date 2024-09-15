public class SolutionP1271 {
    public String toHexspeak(String num) {
        num = Long.toString(Long.parseLong(num), 16).toUpperCase()
                .replace("0", "O")
                .replace("1", "I");
        for (char ch : num.toCharArray()) {
            if (!"ABCDEFIO".contains(String.valueOf(ch))) {
                return "ERROR";
            }
        }
        return num;
    }
}
/*
$1271. 十六进制魔术数字
https://leetcode.cn/problems/hexspeak/

你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1  变成字母 I 。
如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。
给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。
示例 1：
输入：num = "257"
输出："IOI"
解释：257 的十六进制表示是 101 。
示例 2：
输入：num = "3"
输出："ERROR"
提示：
1 <= N <= 10^12
给定字符串不会有前导 0 。
结果中的所有字母都应该是大写字母。

模拟
 */