import java.util.Arrays;

public class Solution4055 {
    // 2^17 - 1
    private static final long MASK = 131071L;
    private int[] unique;
    private int[] rank;
    private int u;
    private int[] bit;
    private int[] ver;
    private int stamp;

    public int shadowPairs(int[] nums) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || copy[i] != copy[i - 1]) {
                copy[cnt++] = copy[i];
            }
        }
        unique = Arrays.copyOf(copy, cnt);
        u = cnt;
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = lowerCount(nums[i]);
        }
        bit = new int[u + 1];
        ver = new int[u + 1];
        stamp = 0;
        return (int) solve(0, n - 1);
    }

    private long solve(int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = (lo + hi) >>> 1;
        return solve(lo, mid) + solve(mid + 1, hi) + cross(lo, mid, hi);
    }

    private long cross(int lo, int mid, int hi) {
        int m = mid - lo + 1;
        int r = hi - mid;

        int[] xr = new int[m];
        int[] yr = new int[m];
        stamp++;
        for (int i = mid; i >= lo; i--) {
            int ri = rank[i];
            xr[i - lo] = ri;
            int c = prefix(ri + 1);
            yr[i - lo] = (c < m - (i - lo) - 1) ? kth(c + 1) - 1 : u;
            add(ri + 1);
        }

        int[] hr = new int[r];
        int[] br = new int[r];
        stamp++;
        for (int j = mid + 1; j <= hi; j++) {
            int rj = rank[j];
            br[j - mid - 1] = rj;
            int c = prefix(rj);
            hr[j - mid - 1] = (c == 0) ? 0 : kth(c) - 1;
            add(rj + 1);
        }

        long[] pk = new long[m];
        for (int i = 0; i < m; i++) {
            pk[i] = ((long) yr[i] << 17) | i;
        }
        Arrays.sort(pk);

        long[] qk = new long[r];
        for (int i = 0; i < r; i++) {
            qk[i] = ((long) br[i] << 17) | i;
        }
        Arrays.sort(qk);

        stamp++;
        long count = 0;
        int ptr = m - 1;
        for (int qi = r - 1; qi >= 0; qi--) {
            int q = (int) (qk[qi] & MASK);
            int rj = br[q];
            while (ptr >= 0 && yr[(int) (pk[ptr] & MASK)] >= rj) {
                int idx = (int) (pk[ptr] & MASK);
                add(xr[idx] + 1);
                ptr--;
            }
            count += prefix(rj) - prefix(hr[q]);
        }
        return count;
    }

    private int lowerCount(int t) {
        int lo = 0, hi = u;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (unique[mid] < t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private void add(int pos) {
        for (; pos <= u; pos += pos & (-pos)) {
            if (ver[pos] != stamp) {
                ver[pos] = stamp;
                bit[pos] = 0;
            }
            bit[pos]++;
        }
    }

    private int prefix(int pos) {
        int s = 0;
        for (; pos > 0; pos -= pos & (-pos)) {
            if (ver[pos] == stamp) {
                s += bit[pos];
            }
        }
        return s;
    }

    private int kth(int k) {
        int pos = 0;
        for (int step = Integer.highestOneBit(u); step != 0; step >>= 1) {
            int next = pos + step;
            if (next <= u) {
                int val = (ver[next] == stamp) ? bit[next] : 0;
                if (val < k) {
                    pos = next;
                    k -= val;
                }
            }
        }
        return pos + 1;
    }
}
/*
4055. 统计影子数对 II
https://leetcode.cn/problems/count-shadow-pairs-ii/description/

第 519 场周赛 T4。

给你一个长度为 n 的整数数组 nums。
如果一对下标 (i, j) 满足以下所有条件，则称其为一个影子对：
- 0 <= i < j < n
- nums[i] < nums[j]
- 不存在下标 k，使得 i < k < j 且 nums[i] < nums[k] < nums[j]。
返回影子对的总数。
提示：
3 <= n == nums.length <= 5 * 10^4
1 <= nums[i] <= 10^9

分治 + 三维偏序（树状数组离线）
时间复杂度 O(nlogn * logn)。
 */