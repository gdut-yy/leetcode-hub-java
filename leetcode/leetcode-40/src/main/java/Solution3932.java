public class Solution3932 {
    public int countKthRoots(int l, int r, int k) {
        return f(r, k) - f(l - 1, k);
    }

    private int f(int n, int k) {
        if (n < 0) {
            return 0;
        }
        int x = (int) Math.pow(n, 1.0 / k);
        // 可能 x 的正确值是 6，但算出来的 x = int(5.99999...) = 5
        if (quickPow(x + 1, k) <= n) { // 为避免浮点误差，这里用整数计算 pow
            x++;
        }
        return x + 1;
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }
}
/*
3932. 统计区间内的完全 K 次幂数量
https://leetcode.cn/problems/count-k-th-roots-in-a-range/description/

第 502 场周赛 T2。

给你三个整数 l、r 和 k。
如果存在一个整数 x，使得 y = xk，则称整数 y 为一个 完全 k 次幂。
返回区间 [l, r]（包含两端）内是完全 k 次幂的整数 y 的数量。
提示：
0 <= l <= r <= 10^9
1 <= k <= 30

数学。
时间复杂度 O(logk)。
 */