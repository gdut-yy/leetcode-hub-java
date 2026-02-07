import java.util.Arrays;

public class SolutionP3656 {
    public boolean simpleGraphExists(int[] degrees) {
        long sum = Arrays.stream(degrees).sum();
        if (sum % 2 != 0) return false;

        int n = degrees.length;
        Arrays.sort(degrees);
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + degrees[i];
        }
        long sumTopK = 0;
        for (int k = 1; k <= n; k++) {
            sumTopK += degrees[n - k];
            int maxIdx = lowerBound(degrees, k + 1, n - k) - 1;
            if (sumTopK > (long) k * (k - 1) + ps[maxIdx + 1] + (long) k * (n - k - maxIdx - 1)) {
                return false;
            }
        }
        return true;
    }

    // [l, r)
    private int lowerBound(int[] a, int key, int r) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
$3656. 判断是否存在简单图
https://leetcode.cn/problems/determine-if-a-simple-graph-exists/description/

给定一个整数数组 degrees，其中 degrees[i] 表示第 i 个顶点的期望度数。
你的任务是确定是否存在一个 恰好 具有这些顶点度数的 无向简单 图。
一个 简单 图没有自环或同一对顶点之间的平行边。
如果存在这样的图，返回 true，否则返回 false。
提示：
1 <= n == degrees.length <= 10^5
0 <= degrees[i] <= n - 1

Erdős–Gallai 定理
https://leetcode.cn/problems/determine-if-a-simple-graph-exists/solutions/3761951/3656-pan-duan-shi-fou-cun-zai-jian-dan-t-594k/
时间复杂度 O(nlogn)。
 */