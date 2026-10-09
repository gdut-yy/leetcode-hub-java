public class SolutionP660 {
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
/*
$660. 移除 9
https://leetcode.cn/problems/remove-9/description/

从 1 开始，移除包含数字 9 的所有整数，例如 9，19，29，……
这样就获得了一个新的整数数列：1，2，3，4，5，6，7，8，10，11，……
给你一个整数 n，请你返回新数列中第 n 个数字是多少（下标从 1 开始）。
示例 1：
输入：n = 9
输出：10
示例 2：
输入：n = 10
输出：11
提示：
1 <= n <= 8 * 10^8
 */