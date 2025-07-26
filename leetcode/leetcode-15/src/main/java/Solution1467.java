import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1467 {
    // 2ms
    // https://leetcode.cn/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/solutions/1/python3-by-qin-qi-shu-hua-2-9ylo/
    static class V1 {
        private static final int MX = 50;
        private static final long[][] C = new long[MX][MX];

        static {
            // 预处理组合数
            for (int i = 0; i < MX; i++) {
                C[i][0] = C[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        private int s, n;
        private int[] balls;
        private long[][][] memo;

        public double getProbability(int[] balls) {
            s = Arrays.stream(balls).sum(); // 球总数
            n = balls.length; // 颜色总数
            this.balls = balls;

            memo = new long[n][s][n * 2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            long res = dfs(0, 0, 0);
            return (double) res / C[s][s / 2];
        }

        private long dfs(int i, int c, int t) {
            if (i == n) { // 如果颜色选完了
                return (t == 0 && c == s / 2) ? 1 : 0; // 选了1/2的球数量且颜色无变化
            }
            if (memo[i][c][t + n] != -1) return memo[i][c][t + n];
            // 不选和全选组合数都为1，直接相加即可，需要更新颜色变化
            long res = dfs(i + 1, c, t + 1) + dfs(i + 1, c + balls[i], t - 1);
            for (int j = 1; j < balls[i]; j++) { // 其他情况，颜色无变化
                res += dfs(i + 1, c + j, t) * C[balls[i]][j];
            }
            return memo[i][c][t + n] = res;
        }
    }

    // 871ms
    // 【小羊肖恩】为什么不试试直接暴力呢？ https://leetcode.cn/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/solutions/1815926/by-yawn_sean-mg1n/
    static class V2 {
        private int[] balls;
        private double ans, tmp;

        public double getProbability(int[] balls) {
            this.balls = balls;
            ans = 0.0;
            tmp = 0.0;
            dfs(0, new ArrayList<>(), new ArrayList<>());
            return ans / tmp;
        }

        private void dfs(int idx, List<Integer> tmp1, List<Integer> tmp2) {
            if (idx == balls.length) {
                int sum1 = sum(tmp1), sum2 = sum(tmp2);
                if (sum1 == sum2) {
                    long methods = getRes(tmp1);
                    int count0_1 = count0(tmp1), count0_2 = count0(tmp2);
                    if (count0_1 == count0_2) {
                        ans += methods;
                    }
                    tmp += methods;
                }
                return;
            }
            for (int i = 0; i <= balls[idx]; i++) {
                tmp1.add(i);
                tmp2.add(balls[idx] - i);
                dfs(idx + 1, tmp1, tmp2);
                tmp1.removeLast();
                tmp2.removeLast();
            }
        }

        private int sum(List<Integer> a) {
            int res = 0;
            for (Integer v : a) res += v;
            return res;
        }

        private int count0(List<Integer> a) {
            int res = 0;
            for (Integer v : a) if (v == 0) res++;
            return res;
        }

        private long getRes(List<Integer> lst) {
            long res = 1;
            for (int i = 0; i < lst.size(); i++) {
                int x = lst.get(i), y = balls[i];
                res *= comb[y][x];
            }
            return res;
        }

        private final long[][] comb = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
                {1, 5, 10, 10, 5, 1},
                {1, 6, 15, 20, 15, 6, 1}
        };
    }
}
/*
1467. 两个盒子中球的颜色数相同的概率
https://leetcode.cn/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/description/

桌面上有 2n 个颜色不完全相同的球，球的颜色共有 k 种。给你一个大小为 k 的整数数组 balls ，其中 balls[i] 是颜色为 i 的球的数量。
所有的球都已经 随机打乱顺序 ，前 n 个球放入第一个盒子，后 n 个球放入另一个盒子（请认真阅读示例 2 的解释部分）。
注意：这两个盒子是不同的。例如，两个球颜色分别为 a 和 b，盒子分别为 [] 和 ()，那么 [a] (b) 和 [b] (a) 这两种分配方式是不同的（请认真阅读示例的解释部分）。
请返回「两个盒子中球的颜色数相同」的情况的概率。答案与真实值误差在 10^-5 以内，则被视为正确答案
提示：
1 <= balls.length <= 8
1 <= balls[i] <= 6
sum(balls) 是偶数

记忆化搜索。
 */