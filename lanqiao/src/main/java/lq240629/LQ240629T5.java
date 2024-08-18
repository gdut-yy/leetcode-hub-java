package lq240629;

import java.util.Scanner;

public class LQ240629T5 {
    static int n, q;
    static long[] v;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        v = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            v[i] = scanner.nextInt();
            v[i] += v[i - 1];
        }
        SparseTable st = new SparseTable(v);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            long ans = 0;
            if (b < c) {
                ans += v[c - 1] - v[b];
            }
            long lv = v[b] - st.query_min(a - 1, b - 1);
            long rv = st.query_max(c, d) - v[c - 1];
            output.append((ans + lv + rv)).append(System.lineSeparator());
        }
        System.out.println(output);
    }

    private static String solve() {
        return "";
    }

    static class SparseTable {
        long[][] mx, mi;
        int[] logTable;

        public SparseTable(long[] arr) {
            int n = arr.length;
            int maxLog = log2(n) + 1;
            mx = new long[n][maxLog];
            mi = new long[n][maxLog];
            logTable = new int[n + 1];
            // 预处理对数表
            for (int i = 2; i <= n; ++i) {
                logTable[i] = logTable[i / 2] + 1;
            }
            // 初始化 ST 表
            for (int i = 0; i < n; ++i) {
                mx[i][0] = arr[i];
                mi[i][0] = arr[i];
            }
            // 动态规划填充表
            for (int j = 1; (1 << j) <= n; ++j) {
                for (int i = 0; i + (1 << j) <= n; ++i) {
                    mx[i][j] = Math.max(mx[i][j - 1], mx[i + (1 << (j - 1))][j - 1]);
                    mi[i][j] = Math.min(mi[i][j - 1], mi[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        // ceil(log2(x)) = 32 - numberOfLeadingZeros(x - 1)
        int log2(long x) {
            return 64 - Long.numberOfLeadingZeros(x - 1);
        }

        long query_max(int l, int r) {
            int j = logTable[r - l + 1];
            return Math.max(mx[l][j], mx[r - (1 << j) + 1][j]);
        }

        long query_min(int l, int r) {
            int j = logTable[r - l + 1];
            return Math.min(mi[l][j], mi[r - (1 << j) + 1][j]);
        }
    }
}
/*
龙骑士军团【算法赛】

首选得到原数组的前缀和数组 s。
对于一次查询 a,b,c,d，区间 [b+1, c-1] 的和是一定会被选上的，我们可以通过 s_{c-1} - s_b 快速计算得到。
接下来我们需要从区间 [a, b] 和 [c, d] 分别选一段后缀和一段前缀和。
- 假设从区间 [a, b] 选择了一个点 x，即答案贡献增加 s_b - s_{x-1}。
- 假设从区间 [c, d] 选择了一个点 y，即答案贡献增加 s_y - s_{c-1}。
显然从贪心考虑，我们希望最小化 s_{x-1} 和最大化 s_y，使用一个可支持查询区间静态最大值的数据结构即可。
 */