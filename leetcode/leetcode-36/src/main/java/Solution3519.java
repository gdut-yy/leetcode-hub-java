import java.math.BigInteger;
import java.util.Arrays;

public class Solution3519 {
    public int countNumbers(String l, String r, int b) {
        this.b = b;
        long ansL = count(new BigInteger(l).subtract(BigInteger.ONE).toString());
        long ansR = count(r);
        long ans = (ansR - ansL + MOD) % MOD;
        return (int) ans;
    }

    private static final int MOD = (int) (1e9 + 7);
    private char[] s;
    private long[][] dp;
    private int b;

    private long count(String num) {
        s = new BigInteger(num).toString(b).toCharArray();
        int n = s.length;
        dp = new long[n][b];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private long f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][pre] != -1) {
            return dp[i][pre];
        }
        long ans = 0;
        if (!isNum) {
            ans += f(i + 1, pre, false, false);
        }
        int down = isNum ? 0 : 1;
        down = Math.max(down, pre);
        int up = isLimit ? s[i] - '0' : b - 1;
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, d, isLimit && d == up, true);
        }
        ans %= MOD;
        if (!isLimit && isNum) {
            dp[i][pre] = ans;
        }
        return ans;
    }
}
/*
3519. 统计逐位非递减的整数
https://leetcode.cn/problems/count-numbers-with-non-decreasing-digits/description/

第 445 场周赛 T4。

给你两个以字符串形式表示的整数 l 和 r，以及一个整数 b。返回在区间 [l, r] （闭区间）内，以 b 进制表示时，其每一位数字为 非递减 顺序的整数个数。
整数逐位 非递减 需要满足：当按从左到右（从最高有效位到最低有效位）读取时，每一位数字都大于或等于前一位数字。
由于答案可能非常大，请返回对 10^9 + 7 取余 后的结果。
提示：
1 <= l.length <= r.length <= 100
2 <= b <= 10
l 和 r 仅由数字（0-9）组成。
l 表示的值小于或等于 r 表示的值。
l 和 r 不包含前导零。

数位 DP。
rating 2268 (clist.by)
 */