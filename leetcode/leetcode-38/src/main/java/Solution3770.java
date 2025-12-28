public class Solution3770 {
    static final int MAX_N = (int) 5e5 + 5;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (np[i]) continue;
            for (int j = i * i; j <= MAX_N; j += i) np[j] = true;
        }
    }

    public int largestPrime(int n) {
        int ans = 0;
        int sum = 0;
        for (int p = 2; p <= MAX_N; p++) {
            if (np[p]) continue;
            sum += p;
            if (sum > n) {
                break;
            }
            if (!np[sum]) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
/*
3770. 可表示为连续质数和的最大质数
https://leetcode.cn/problems/largest-prime-from-consecutive-prime-sum/description/

第 479 场周赛 T2。

给你一个整数 n。
返回小于或等于 n 的最大质数，该质数可以表示为从 2 开始的一个或多个 连续质数 之和。如果不存在这样的质数，则返回 0。
质数是大于 1 的自然数，且只有两个因数：1 和它本身。
提示：
1 <= n <= 5 * 10^5

预处理质数。枚举。
https://yuanbao.tencent.com/chat/naQivTmsDa/60a64965-1275-4f0b-8c82-0aa49bc018cf
时间复杂度 O(n)。
 */