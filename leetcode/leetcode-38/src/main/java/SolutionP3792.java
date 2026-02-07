public class SolutionP3792 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumOfBlocks(int n) {
        long ans = 0;
        int begin = 1;
        for (int i = 1; i < n + 1; i++) {
            long m = 1;
            for (int j = begin; j < begin + i; j++) {
                m = m * j % MOD;
            }
            ans += m;
            begin += i;
        }
        ans %= MOD;
        return (int) ans;
    }
}
/*
$3792. 递增乘积块之和
https://leetcode.cn/problems/sum-of-increasing-product-blocks/description/

给定一个整数 n。
一个序列的形成如下：
- 第 1 块包含 1。
- 第 2 块包含 2 * 3。
- 第 i 块是之后 i 个连续整数的乘积。
令 F(n) 为前 n 块之和。
返回一个整数表示 F(n) 模上 10^9 + 7。
提示：
1 <= n <= 1000

暴力。
https://leetcode.cn/problems/sum-of-increasing-product-blocks/solutions/3868189/on2-bao-li-by-endlesscheng-duji/
时间复杂度 O(n^2)。
 */