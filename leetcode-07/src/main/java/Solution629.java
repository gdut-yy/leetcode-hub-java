public class Solution629 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MAX_N = 1005;

    public int kInversePairs(int n, int k) {
        // f[i][j] 表示我们使用数字 [1,i] 的排列构成长度为 i 的数组，并且恰好包含 j 个逆序对的方案数
        // f[i][j] = f[i][j−1] − f[i−1][j−i] + f[i−1][j]
        int[] f = new int[MAX_N];
        int[] pre = new int[MAX_N];
        for (int i = 1; i <= n; i++) {
            f[1] = 1;
            for (int j = 2; j <= k + 1; j++) {
                f[j] = (pre[j] - pre[Math.max(0, j - i)] + MOD) % MOD;
            }
            for (int j = 1; j <= k + 1; j++) {
                pre[j] = (pre[j - 1] + f[j]) % MOD;
            }
        }
        return f[k + 1];
    }
}
/*
629. K个逆序对数组
https://leetcode.cn/problems/k-inverse-pairs-array/

给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
由于答案可能很大，只需要返回 答案 mod 10^9 + 7 的值。
说明:
1. n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。

动态规划。
https://leetcode.cn/problems/k-inverse-pairs-array/solution/dong-tai-gui-hua-qian-zhui-he-you-hua-by-28eb/
时间复杂度 O(nk)
空间复杂度 O(k)
 */