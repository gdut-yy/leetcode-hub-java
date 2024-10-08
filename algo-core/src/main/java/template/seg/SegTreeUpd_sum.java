package template.seg;

/**
 * 线段树
 * 线段树可以在 O(logn) 的时间复杂度内实现单点修改、区间修改、区间查询（区间求和，求区间最大值，求区间最小值）等操作。
 * https://oi-wiki.org/ds/seg/
 * 空间复杂度 O(4n)
 */
public class SegTreeUpd_sum {
    int n;
    long[] tree, lazy;
    int[] nums;

    public SegTreeUpd_sum(int[] nums) {
        this.n = nums.length;
        this.tree = new long[4 * n];
        this.lazy = new long[4 * n];

        this.nums = nums;
        build(1, 1, n);
    }

    void build(int p, int l, int r) {
        if (l == r) {
            tree[p] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(p << 1, l, mid);
        build(p << 1 | 1, mid + 1, r);
        pushUp(p);
    }

    void update(int ql, int qr, int val) {
        update(1, 1, n, ql, qr, val);
    }

    void update(int p, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            tree[p] = (r - l + 1L) * val;
            lazy[p] = val;
            return;
        }
        pushDown(p, l, r);
        int mid = l + (r - l) / 2;
        if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
        if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
        pushUp(p);
    }

    long getSum(int ql, int qr) {
        return getSum(1, 1, n, ql, qr);
    }

    long getSum(int p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[p];
        }
        pushDown(p, l, r);
        int mid = l + (r - l) / 2;
        long sum = 0;
        if (ql <= mid) sum += getSum(p << 1, l, mid, ql, qr);
        if (qr > mid) sum += getSum(p << 1 | 1, mid + 1, r, ql, qr);
        return sum;
    }

    void pushDown(int p, int l, int r) {
        if (lazy[p] != 0) {
            int mid = l + (r - l) / 2;
            tree[p << 1] = lazy[p] * (mid - l + 1);
            tree[p << 1 | 1] = lazy[p] * (r - mid);
            lazy[p << 1] = lazy[p];
            lazy[p << 1 | 1] = lazy[p];
            lazy[p] = 0;
        }
    }

    void pushUp(int p) {
        tree[p] = tree[p << 1] + tree[p << 1 | 1];
    }
}
