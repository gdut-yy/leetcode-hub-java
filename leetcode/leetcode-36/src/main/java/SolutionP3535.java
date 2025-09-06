import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3535 {
    public int[] queryConversions(int[][] conversions, int[][] queries) {
        int[] base = baseUnitConversions(conversions);
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int unitA = queries[i][0], unitB = queries[i][1];
            ans[i] = (int) (quickPow(base[unitA], MOD - 2) * base[unitB] % MOD);
        }
        return ans;
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // 3528
    private static final int MOD = (int) (1e9 + 7);
    private List<int[]>[] g; // to, wt
    private int[] ans;

    private int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : conversions) {
            g[e[0]].add(new int[]{e[1], e[2]});
        }

        ans = new int[n];
        dfs(0, 1);
        return ans;
    }

    private void dfs(int x, long mul) {
        ans[x] = (int) mul;
        for (int[] e : g[x]) {
            dfs(e[0], mul * e[1] % MOD);
        }
    }
}
/*
$3535. 单位转换 II
https://leetcode.cn/problems/unit-conversion-ii/description/

有 n 种单位，编号从 0 到 n - 1。
给定一个二维整数数组 conversions，长度为 n - 1，其中 conversions[i] = [sourceUniti, targetUniti, conversionFactori] ，表示一个 sourceUniti 类型的单位等于 conversionFactori 个 targetUniti 类型的单位。
同时给定一个长度为 q 的 2 维整数数组 queries，其中 queries[i] = [unitAi, unitBi]。
返回一个长度为 q 的数组 answer，其中 answer[i] 表示多少个 unitBi 类型的单位等于 1 个 unitAi 类型的单位，并且当 p 和 q 互质的时候可以表示为 p/q。以 pq-1 返回每个 answer[i] 对 10^9 + 7 取模 的值，其中 q-1 表示 q 模 10^9 + 7 的乘法逆元。
提示：
2 <= n <= 10^5
conversions.length == n - 1
0 <= sourceUniti, targetUniti < n
1 <= conversionFactori <= 10^9
1 <= q <= 10^5
queries.length == q
0 <= unitAi, unitBi < n
保证 0 单位可以通过正向或反向转换的组合唯一地转换为任何其他单位。

相似题目: 3528. 单位转换 I
https://leetcode.cn/problems/unit-conversion-i/description/
 */