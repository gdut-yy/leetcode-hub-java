import java.util.Arrays;

public class Solution3869 {
    // 9*15=135
    private static final boolean[] GOOD = new boolean[136];

    static {
        for (int i = 0; i <= 135; i++) {
            GOOD[i] = isStrictMonotonic(i);
        }
    }

    private static boolean isStrictMonotonic(int x) {
        if (x < 10) return true;
        String s = Integer.toString(x);
        boolean inc = true, dec = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) inc = false;
            if (s.charAt(i) >= s.charAt(i - 1)) dec = false;
        }
        return inc || dec;
    }

    public long countFancy(long l, long r) {
        return countUpTo(r) - countUpTo(l - 1);
    }

    private int[] digits;
    private long[][][][][] memo;

    private long countUpTo(long n) {
        if (n < 0) return 0;
        String s = Long.toString(n);
        int len = s.length();
        digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        memo = new long[len][2][10][4][136];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int t = 0; t < 4; t++) {
                        Arrays.fill(memo[i][j][k][t], -1L);
                    }
                }
            }
        }
        return dfs(0, 1, 0, 0, 0, 0);
    }

    private long dfs(int pos, int tight, int started, int prev, int trend, int sum) {
        if (pos == digits.length) {
            return (trend != 3 || GOOD[sum]) ? 1L : 0L;
        }
        if (tight == 0 && memo[pos][started][prev][trend][sum] != -1) {
            return memo[pos][started][prev][trend][sum];
        }
        int maxDigit = (tight == 1) ? digits[pos] : 9;
        long res = 0;
        for (int d = 0; d <= maxDigit; d++) {
            int newStarted;
            int newPrev;
            int newTrend = trend;
            int newSum;
            if (started == 0) {
                if (d == 0) {
                    newStarted = 0;
                    newPrev = 0;
                    newTrend = 0;
                    newSum = sum;
                } else {
                    newStarted = 1;
                    newPrev = d;
                    newTrend = 0;
                    newSum = sum + d;
                }
            } else {
                newStarted = 1;
                newSum = sum + d;
                if (trend != 3) {
                    if (d == prev) {
                        newTrend = 3;
                    } else if (d > prev) {
                        if (trend == 0) newTrend = 1;
                        else if (trend == 2) newTrend = 3;
                    } else {
                        if (trend == 0) newTrend = 2;
                        else if (trend == 1) newTrend = 3;
                    }
                }
                newPrev = d;
            }
            int newTight = (tight == 1 && d == maxDigit) ? 1 : 0;
            res += dfs(pos + 1, newTight, newStarted, newPrev, newTrend, newSum);
        }
        if (tight == 0) {
            memo[pos][started][prev][trend][sum] = res;
        }
        return res;
    }
}
/*
3869. 统计区间内奇妙数的数目
https://leetcode.cn/problems/count-fancy-numbers-in-a-range/description/

第 178 场双周赛 T4。

给你两个整数 l 和 r。
如果一个整数的数位形成一个 严格单调 序列，即数位是 严格递增 或 严格递减 的，那么这个整数被称为 好数。所有一位数都被认为是好数。
如果一个整数是好数，或者它的 数位和 是好数，那么这个整数被称为 奇妙数。
返回一个整数，表示在区间 [l, r]（包含边界）内的奇妙数的数量。
如果一个序列中的每个元素都 严格大于 其前一个元素（如果存在），则该序列被称为 严格递增。
如果一个序列中的每个元素都 严格小于 其前一个元素（如果存在），则该序列被称为 严格递减。
提示：
1 <= l <= r <= 10^15

数位 DP。
https://chat.deepseek.com/a/chat/s/7de7793e-8888-4932-a9e7-9ff43c930398
 */