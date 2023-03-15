import java.util.ArrayList;
import java.util.List;

public class Solution2338 {
    // https://leetcode.cn/problems/count-the-number-of-ideal-arrays/solution/shu-lun-zu-he-shu-xue-zuo-fa-by-endlessc-iouh/
    // Prime omega function
    // https://en.wikipedia.org/wiki/Prime_omega_function
    private static final int MOD = (int) (1e9 + 7);
    private static final int MX = (int) 1e4 + 1;
    private static final int MX_K = 13; // 至多 13 个质因数
    private static final List[] ks = new List[MX]; // ks[x] 为 x 分解质因数后，每个质因数的个数列表
    private static final int[][] c = new int[MX + MX_K][MX_K + 1]; // 组合数

    static {
        for (var i = 1; i < MX; i++) {
            ks[i] = new ArrayList<Integer>();
            int x = i;
            for (var p = 2; p * p <= x; ++p) {
                if (x % p == 0) {
                    int k = 1;
                    for (x /= p; x % p == 0; x /= p) {
                        ++k;
                    }
                    ks[i].add(k);
                }
            }
            if (x > 1) {
                ks[i].add(1);
            }
        }

        c[0][0] = 1;
        for (var i = 1; i < MX + MX_K; i++) {
            c[i][0] = 1;
            for (var j = 1; j <= Math.min(i, MX_K); j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0L;
        for (var x = 1; x <= maxValue; x++) {
            var mul = 1L;
            for (var k : ks[x]) {
                mul = mul * c[n + (int) k - 1][(int) k] % MOD;
            }
            ans += mul;
        }
        return (int) (ans % MOD);
    }
}
/*
2338. 统计理想数组的数目
https://leetcode.cn/problems/count-the-number-of-ideal-arrays/

第 301 场周赛 T4。

给你两个整数 n 和 maxValue ，用于描述一个 理想数组 。
对于下标从 0 开始、长度为 n 的整数数组 arr ，如果满足以下条件，则认为该数组是一个 理想数组 ：
- 每个 arr[i] 都是从 1 到 maxValue 范围内的一个值，其中 0 <= i < n 。
- 每个 arr[i] 都可以被 arr[i - 1] 整除，其中 0 < i < n 。
返回长度为 n 的 不同 理想数组的数目。由于答案可能很大，返回对 10^9 + 7 取余的结果。
提示：
2 <= n <= 10^4
1 <= maxValue <= 10^4
 */