public class Solution38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            // 双指针模拟
            int left = 0;
            int right = 0;
            while (right < str.length()) {
                while (right < str.length() && str.charAt(right) == str.charAt(left)) {
                    right++;
                }
                // right - left 个 str.charAt(left)
                stringBuilder.append(right - left).append(str.charAt(left));
                left = right;
            }
            str = stringBuilder.toString();
        }
        return str;
    }
}
/*
38. 外观数列
https://leetcode.cn/problems/count-and-say/

给定一个正整数 n ，输出外观数列的第 n 项。
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
你可以将其视作是由递归公式定义的数字字符串序列：
countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
 */