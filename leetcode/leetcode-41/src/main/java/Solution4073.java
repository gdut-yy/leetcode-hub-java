public class Solution4073 {
    private static final int MOD = (int) (1e99 + 7);

    public int countGoodStrings(long n) {
        long[][] m = {
                {1, 1},
                {1, 0},
        };
        long[][] f1 = {{2}, {0}}; // 这里初始化成 2，就不用把答案乘以 2 了
        long[][] fn = powMul(m, n - 1, f1);
        return (int) fn[0][0];
    }

    // a^n * f
    private long[][] powMul(long[][] a, long n, long[][] f) {
        long[][] res = f;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = mul(a, res);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }

    // 返回矩阵 a 和矩阵 b 相乘的结果
    private long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[i].length; k++) {
                if (a[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < b[k].length; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }
}
/*
4073. 统计好字符串数目
https://leetcode.cn/problems/count-good-strings/description/

第 522 场周赛 T4。

给你一个整数 n。
如果一个字符串仅由字符 'a' 和 'b' 组成，且满足以下条件之一，则该字符串被认为是 好的 ：
- 它只包含 一种 字符，且其长度为 奇数 。
- 它可以写成 s = s1 + s2 的形式，其中 s1 和 s2 是 非空的好 字符串，且 s1 的最后一个字符与 s2 的第一个字符不同。
返回长度为 n 的 好的 字符串的数量，模 109 + 7。
这里，+ 表示字符串拼接。
示例 1：
输入： n = 4
输出： 6
示例 2：
输入： n = 3
输出： 4
示例 3：
输入： n = 2
输出： 2
提示：
1 <= n <= 10^15

斐波那契数列 + 矩阵快速幂
https://leetcode.cn/problems/count-good-strings/solutions/4038387/fei-bo-na-qi-shu-lie-ju-zhen-kuai-su-mi-yvn8b/
 */