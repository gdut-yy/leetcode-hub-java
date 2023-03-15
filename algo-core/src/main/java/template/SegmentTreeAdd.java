package template;

/**
 * 线段树
 * Solution2528
 */
public class SegmentTreeAdd {
    private final int N;
    private final long[] sum;
    private final long[] min;
    private final long[] lazy;

    public SegmentTreeAdd(int n) {
        N = n;
        sum = new long[n * 4];
        min = new long[n * 4];
        lazy = new long[n * 4];
    }

    // 区间 [l,r] 置为 val
    public void add(int l, int r, int val) {
        this.add(l, r, val, 1, N, 1);
    }

    // 区间 [l,r] 求和
    public long getSum(int l, int r) {
        return this.getSum(l, r, 1, N, 1);
    }

    // 区间 [l,r] 最大值
    public long getMin(int l, int r) {
        return this.getMin(l, r, 1, N, 1);
    }

    private void add(int l, int r, int val, int s, int t, int p) {
        if (l <= s && t <= r) {
            sum[p] += (t - s + 1L) * val;
            min[p] += val;
            lazy[p] += val;
            return;
        }
        int mid = s + (t - s) / 2;
        pushDown(p, s, t, mid);
        if (l <= mid) {
            add(l, r, val, s, mid, p * 2);
        }
        if (r > mid) {
            add(l, r, val, mid + 1, t, p * 2 + 1);
        }
        pushUp(p);
    }

    private long getSum(int l, int r, int s, int t, int p) {
        if (l <= s && t <= r) {
            return sum[p];
        }
        int mid = s + (t - s) / 2;
        pushDown(p, s, t, mid);
        long sum = 0;
        if (l <= mid) {
            sum = getSum(l, r, s, mid, p * 2);
        }
        if (r > mid) {
            sum += getSum(l, r, mid + 1, t, p * 2 + 1);
        }
        return sum;
    }

    private long getMin(int l, int r, int s, int t, int p) {
        if (l <= s && t <= r) {
            return min[p];
        }
        int mid = s + (t - s) / 2;
        pushDown(p, s, t, mid);
        long min = Long.MAX_VALUE;
        if (l <= mid) {
            min = getMin(l, r, s, mid, p * 2);
        }
        if (r > mid) {
            min = Math.min(min, getMin(l, r, mid + 1, t, p * 2 + 1));
        }
        return min;
    }

    private void pushDown(int p, int s, int t, int mid) {
        if (lazy[p] > 0) {
            sum[p * 2] += lazy[p] * (mid - s + 1L);
            sum[p * 2 + 1] += lazy[p] * (t - mid);
            min[p * 2] += lazy[p];
            min[p * 2 + 1] += lazy[p];
            lazy[p * 2] += lazy[p];
            lazy[p * 2 + 1] += lazy[p];
            lazy[p] = 0;
        }
    }

    private void pushUp(int p) {
        sum[p] = sum[p * 2] + sum[p * 2 + 1];
        min[p] = Math.min(min[p * 2], min[p * 2 + 1]);
    }
}