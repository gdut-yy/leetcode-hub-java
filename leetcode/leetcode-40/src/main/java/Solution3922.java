public class Solution3922 {
    public int minFlips(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int c0 = 0;
        for (char ch : s) c0 += '1' - ch;
        int c1 = n - c0 - 1;

        if (s[0] == '1' && s[n - 1] == '1') {
            c1--;
        }
        return Math.min(c0, Math.max(c1, 0));
    }
}
/*
3922. 使二进制字符串连贯的最少翻转次数
https://leetcode.cn/problems/minimum-flips-to-make-binary-string-coherent/description/

第 182 场双周赛 T2。

给你一个二进制字符串 s。
如果一个字符串 不 包含 "011" 或 "110" 作为 子序列，则认为该字符串是 连贯的 。
在一次操作中，你可以 翻转  s 中的任意字符（'0' 变为 '1'，或 '1' 变为 '0'）。
返回一个整数，表示使 s 连贯所需的 最少 操作次数。
提示：
1 <= s.length <= 10^5
s[i] 是 '0' 或 '1'。

分类讨论。
情况一：把 s 中的 0 全变成 1，没有 0
情况二：s[0]=0 或者 s[n−1]=0，那么 s 不能有超过一个 1，操作 max(n−c0−1,0) 次
情况三：如果 s[0]=s[n−1]=1，可以保留 2 个 1，其余 1 全变成 0，操作 max(n−c0−2,0) 次
时间复杂度 O(n)。
 */