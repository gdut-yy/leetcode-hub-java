package template.seg;

/**
 * ST 表
 * https://oi-wiki.org/ds/sparse-table/
 */
public class SparseTable {
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
