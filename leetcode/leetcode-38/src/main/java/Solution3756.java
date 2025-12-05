import java.util.Arrays;

public class Solution3756 {
    static final int MOD = (int) (1e9 + 7);
    static final int MAX_N = (int) (1e5 + 1);
    static long[] pow10;

    static {
        pow10 = new long[MAX_N];
        Arrays.fill(pow10, 1);
        for (int i = 1; i < MAX_N; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] ps_nonzero = new int[n + 1]; // 非零数字个数
        long[] ps_sum = new long[n + 1]; // 数字和
        long[] ps_x = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            ps_nonzero[i + 1] = ps_nonzero[i] + (d != 0 ? 1 : 0);
            ps_sum[i + 1] = (ps_sum[i] + d) % MOD;
            ps_x[i + 1] = d != 0 ? (ps_x[i] * 10 + d) % MOD : ps_x[i];
        }

        int[] ans = new int[queries.length];
        int j = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int len = ps_nonzero[r + 1] - ps_nonzero[l];
            long x = ps_x[r + 1] - ps_x[l] * pow10[len] % MOD + MOD;
            ans[j++] = (int) (x * (ps_sum[r + 1] - ps_sum[l]) % MOD);
        }
        return ans;
    }
}
/*
3756. 连接非零数字并乘以其数字和 II
https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/description/

第 477 场周赛 T3。

给你一个长度为 m 的字符串 s，其中仅包含数字。另给你一个二维整数数组 queries，其中 queries[i] = [li, ri]。
对于每个 queries[i]，提取 子串 s[li..ri]，然后执行以下操作：
- 将子串中所有 非零数字 按照原始顺序连接起来，形成一个新的整数 x。如果没有非零数字，则 x = 0。
- 令 sum 为 x 中所有数字的 数字和 。答案为 x * sum。
返回一个整数数组 answer，其中 answer[i] 是第 i 个查询的答案。
由于答案可能非常大，请返回其对 10^9 + 7 取余数的结果。
子串 是字符串中的一个连续、非空 字符序列。
提示：
1 <= m == s.length <= 10^5
s 仅由数字组成。
1 <= queries.length <= 10^5
queries[i] = [li, ri]
0 <= li <= ri < m

前缀和。
时间复杂度 O(n+q)。
 */