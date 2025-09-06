import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3669 {
    private static final int MX = (int) (1e5 + 5);
    private static final List<Integer>[] divisors = new ArrayList[MX];

    static {
        // 预处理每个数的因子
        Arrays.setAll(divisors, e -> new ArrayList<>());
        for (int i = 1; i < MX; i++) {
            for (int j = i; j < MX; j += i) { // 枚举 i 的倍数 j
                divisors[j].add(i); // i 是 j 的因子
            }
        }
    }

    public int[] minDifference(int n, int k) {
        int[] path = new int[k];
        dfs(k - 1, n, Integer.MAX_VALUE, 0, path);
        return ans;
    }

    private int minDiff = Integer.MAX_VALUE;
    private int[] ans;

    private void dfs(int i, int n, int mn, int mx, int[] path) {
        if (i == 0) {
            int d = Math.max(mx, n) - Math.min(mn, n); // 最后一个数是 n
            if (d < minDiff) {
                minDiff = d;
                path[i] = n;
                ans = path.clone();
            }
            return;
        }
        for (int d : divisors[n]) { // 枚举 x 的因子
            path[i] = d; // 直接覆盖，无需恢复现场
            dfs(i - 1, n / d, Math.min(mn, d), Math.max(mx, d), path);
        }
    }
}
/*
3669. K 因数分解
https://leetcode.cn/problems/balanced-k-factor-decomposition/description/

第 465 场周赛 T2。

给你两个整数 n 和 k，将数字 n 恰好分割成 k 个正整数，使得这些整数的 乘积 等于 n。
返回一个分割方案，使得这些数字中 最大值 和 最小值 之间的 差值 最小化。结果可以以 任意顺序 返回。
提示：
4 <= n <= 10^5
2 <= k <= 5
k 严格小于 n 的正因数的总数。

暴搜。
时间复杂度 O(D^k)。其中 D <= 128。测试表明，当 n=90720，k=5 时节点个数达到最大，为 254816。
 */