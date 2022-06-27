public class Solution96 {
    public int numTrees(int n) {
        // 状态定义
        // dp[i] 长度为 i 的序列能构成的不同二叉搜索树的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
/*
96. 不同的二叉搜索树
https://leetcode.cn/problems/unique-binary-search-trees/

给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

动态规划/卡塔兰数
定义两个函数：
G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
状态转移：
G(0)=1,G(1)=1
F(i,n)=G(i−1)*G(n−i)
 */