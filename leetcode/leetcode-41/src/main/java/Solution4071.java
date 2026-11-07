public class Solution4071 {
    public int minRotations(int n, String s) {
        int base = 0;
        int mn = 0;
        char pre = '0';
        char end = s.charAt(n - 1);
        for (char cur : s.toCharArray()) {
            int op = dis(pre, cur);
            base += op;
            mn = Math.min(mn, dis(pre, end) - op);
            pre = cur;
        }
        return base + mn;
    }

    // 指针从数字 x 旋转到数字 y 的最少旋转次数
    private int dis(char x, char y) {
        int d = Math.abs(x - y);
        return Math.min(d, 10 - d);
    }
}
/*
4071. 拨号的最少旋转次数 II
https://leetcode.cn/problems/minimum-rotations-to-dial-a-number-ii/description/

第 522 场周赛 T2。

给你一个整数 n 和一个长度为 n、由数字组成的字符串 s。
拨号盘上的数字 0 到 9 按顺序排列，且拨号盘是环形的，因此 0 和 9 相邻。指针最初指向 0。
要按顺序拨出 s 中的每个数字，需要旋转指针，直到它指向该数字。每次旋转都会将指针移动到一个相邻的数字，你可以向任一方向旋转。如果指针已经指向要拨出的数字，则无需旋转。
在拨号之前，你可以执行以下操作至多一次：
- 选择一个满足 0 <= k < n 的下标 k，并反转后缀 s[k..n - 1]。
通过最优地选择是否执行该操作以及反转哪个后缀，返回拨出操作后的字符串所需的最少总旋转次数。
字符串的后缀是从字符串中的任意位置开始、延伸到字符串末尾的连续字符序列。
示例 1：
输入： n = 4, s = "1502"
输出： 9
示例 2：
输入： n = 4, s = "2916"
输出： 12
示例 3：
输入： n = 4, s = "4219"
输出： 6
提示：
1 <= n == s.length <= 10^5
s 仅由数字 '0' 到 '9' 组成

计算增量。
时间复杂度 O(n)。
 */