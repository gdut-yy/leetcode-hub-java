public class Solution3881 {
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

    public int countVisiblePeople(int n, int pos, int k) {
        int left = pos;
        int right = n - 1 - pos;
        long sum = 0;
        int start = Math.max(0, k - right);
        int end = Math.min(left, k);
        for (int i = start; i <= end; i++) {
            sum = (sum + comb(left, i) * comb(right, k - i)) % MOD;
        }
        sum = sum * 2 % MOD;
        return (int) sum;
    }

    public int countVisiblePeople2(int n, int pos, int k) {
        return (int) (comb(n - 1, k) * 2 % MOD);
    }
}
/*
3881. 恰好看到 K 个人的方向选择
https://leetcode.cn/problems/direction-assignments-with-exactly-k-visible-people/description/

第 179 场双周赛 T2。

给你三个整数 n、pos 和 k。
有 n 个人排成一排，下标从 0 到 n - 1。每个人 独立地 选择一个方向：
- 'L'：只对他们 右边 的人 可见
- 'R'：只对他们 左边 的人 可见
位于下标 pos 的人看其他人的方式如下：
- 一个 i < pos 的人可见当且仅当他们选择 'L'。
- 一个 i > pos 的人可见当且仅当他们选择 'R'。
返回可能的方向分配数量，使得位于下标 pos 的人 恰好 看到 k 个人。
由于答案可能很大，请将其对 10^9 + 7 取余 后返回。
提示：
1 <= n <= 10^5
0 <= pos, k <= n - 1

脑筋急转弯，答案与 pos 无关
https://chat.deepseek.com/a/chat/s/f112fba7-8c6a-4dda-8c08-3c7c1cfe05c9
 */