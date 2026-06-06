public class Solution3908 {
    public boolean validDigit(int n, int x) {
        String strN = String.valueOf(n);
        String strX = String.valueOf(x);
        return !strN.startsWith(strX) && strN.contains(strX);
    }
}
/*
3908. 有效数字整数
https://leetcode.cn/problems/valid-digit-number/description/

第 181 场双周赛 T1。

给你一个整数 n 和一个数字 x。
如果一个数字满足以下条件，则认为它是 有效 的：
- 它包含 至少一个 数字 x，并且
- 它 不以 数字 x 开头。
如果 n 是 有效 的，请返回 true，否则返回 false。
提示：
0 <= n <= 10^5
0 <= x <= 9

字符串 + 库函数。
 */