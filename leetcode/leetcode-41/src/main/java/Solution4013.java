import java.util.Arrays;

public class Solution4013 {
    private int[] O;
    private int[] idxW;
    private int m;
    private int[] bit;

    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        O = new int[n + 1];
        long[] w = new long[n + 1];
        for (int i = 0; i < n; i++) {
            O[i + 1] = O[i];
            w[i + 1] = w[i];
            if ((nums[i] & 1) == 0) {
                w[i + 1] += b;
            } else {
                O[i + 1]++;
                w[i + 1] -= a;
            }
        }

        long[] sorted = w.clone();
        Arrays.sort(sorted);
        long[] uniq = new long[n + 1];
        int u = 0;
        uniq[0] = sorted[0];
        for (int i = 1; i <= n; i++) {
            if (sorted[i] != sorted[i - 1]) uniq[++u] = sorted[i];
        }
        m = u + 1;

        idxW = new int[n + 1];
        for (int i = 0; i <= n; i++) idxW[i] = rank(uniq, w[i]);
        bit = new int[m + 2];
        return cdq(0, n);
    }

    private int rank(long[] uniq, long w) {
        int lo = 0, hi = m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (uniq[mid] == w) return mid + 1;
            else if (uniq[mid] < w) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    private void add(int i, int delta) {
        for (; i <= m; i += i & (-i)) bit[i] += delta;
    }

    private int sum(int i) {
        int s = 0;
        for (; i > 0; i -= i & (-i)) s += bit[i];
        return s;
    }

    private long cdq(int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = (lo + hi) >>> 1;
        long res = cdq(lo, mid) + cdq(mid + 1, hi);

        int nl = mid - lo + 1, nr = hi - mid;
        Integer[] L = new Integer[nl];
        Integer[] R = new Integer[nr];
        for (int i = 0; i < nl; i++) L[i] = lo + i;
        for (int i = 0; i < nr; i++) R[i] = mid + 1 + i;
        Arrays.sort(L, (p, q) -> Integer.compare(O[p], O[q]));
        Arrays.sort(R, (p, q) -> Integer.compare(O[p], O[q]));

        int p = 0;
        for (int r : R) {
            while (p < nl && O[L[p]] < O[r]) {
                add(idxW[L[p]], 1);
                p++;
            }
            res += p - sum(idxW[r] - 1);
        }
        for (int i = 0; i < p; i++) add(idxW[L[i]], -1);
        return res;
    }
}
/*
4013. 按奇偶比统计子数组 II
https://leetcode.cn/problems/count-subarrays-with-even-odd-ratio-ii/description/

第 513 场周赛 T4。

给你一个整数数组 nums，以及两个整数 a 和 b。
对于一个 子数组 ，定义：
- x 表示其中偶数元素的数量。
- y 表示其中奇数元素的数量。
子数组中偶数与奇数的比例定义为 x / y，其中该比例按照精确的有理数值进行比较。
如果一个子数组满足以下条件，则称其为 有效子数组 ：
- y > 0，并且
- x / y <= a / b。
返回 nums 中有效子数组的数量。
子数组 是数组中一个连续的 非空 元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= a, b <= 10^9

CDQ 分治。
 */