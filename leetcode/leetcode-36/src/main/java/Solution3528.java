import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3528 {
    private static final int MOD = (int) (1e9 + 7);
    private List<int[]>[] g; // to, wt
    private int[] ans;

    public int[] baseUnitConversions(int[][] conversions) {
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
3528. 单位转换 I
https://leetcode.cn/problems/unit-conversion-i/description/

第 155 场双周赛 T2。

有 n 种单位，编号从 0 到 n - 1。给你一个二维整数数组 conversions，长度为 n - 1，其中 conversions[i] = [sourceUniti, targetUniti, conversionFactori] ，表示一个 sourceUniti 类型的单位等于 conversionFactori 个 targetUniti 类型的单位。
请你返回一个长度为 n 的数组 baseUnitConversion，其中 baseUnitConversion[i] 表示 一个 0 类型单位等于多少个 i 类型单位。由于结果可能很大，请返回每个 baseUnitConversion[i] 对 10^9 + 7 取模后的值。
提示：
2 <= n <= 10^5
conversions.length == n - 1
0 <= sourceUniti, targetUniti < n
1 <= conversionFactori <= 10^9
保证单位 0 可以通过 唯一 的转换路径（不需要反向转换）转换为任何其他单位。

建图后 DFS。
时间复杂度 O(n)。
相似题目: $3535. 单位转换 II
https://leetcode.cn/problems/unit-conversion-ii/description/
 */