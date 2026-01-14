public class Solution3798 {
    public String largestEven(String s) {
        StringBuilder ans = new StringBuilder(s);
        while (!ans.isEmpty() && ans.charAt(ans.length() - 1) == '1') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}
/*
3798. 最大的偶数
https://leetcode.cn/problems/largest-even-number/description/

第 483 场周赛 T1。

给你一个仅由字符'1'和'2'组成的字符串s。
你可以删除字符串s中的任意数量的字符，但必须保持剩余字符的顺序不变。
返回可以表示 偶数 整数的 最大结果字符串 。如果不存在这样的字符串，则返回空字符串""。
提示：
1 <= s.length <= 100
s 仅由字符 '1' 和 '2' 组成。

删除末尾的 1。
时间复杂度 O(n)。
 */