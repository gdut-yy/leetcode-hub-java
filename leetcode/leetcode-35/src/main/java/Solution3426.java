public class Solution3426 {
    public int distanceSum(int m, int n, int k) {
        long ans = (m * n * (m * ((long) n * n - 1) + n * ((long) m * m - 1))) / 6 % MOD * comb(m * n - 2, k - 2) % MOD;
        return (int) ans;
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 1e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
3426. 所有安放棋子方案的曼哈顿距离
https://leetcode.cn/problems/manhattan-distances-of-all-arrangements-of-pieces/description/

第 148 场双周赛 T4。

给你三个整数 m ，n 和 k 。
给你一个大小为 m x n 的矩形格子，它包含 k 个没有差别的棋子。请你返回所有放置棋子的 合法方案 中，每对棋子之间的曼哈顿距离之和。
一个 合法方案 指的是将所有 k 个棋子都放在格子中且一个格子里 至多 只有一个棋子。
由于答案可能很大， 请你将它对 10^9 + 7 取余 后返回。
两个格子 (xi, yi) 和 (xj, yj) 的曼哈顿距离定义为 |xi - xj| + |yi - yj| 。
提示：
1 <= m, n <= 10^5
2 <= m * n <= 10^5
2 <= k <= m * n

贡献法。
https://leetcode.cn/problems/manhattan-distances-of-all-arrangements-of-pieces/solutions/3051398/gong-xian-fa-yu-chu-li-hou-o1pythonjavac-2hgt/
最终答案为 \binom{mn-2}{k-2} \left (m^2  \binom{n+1}{3}  + n^2\binom{m+1}{3} \right )
组合数的 苏联记法 与 美式记法。
rating 2738 (clist.by)
 */