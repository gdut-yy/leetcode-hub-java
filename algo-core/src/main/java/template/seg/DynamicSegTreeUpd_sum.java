package template.seg;

/**
 * 动态开点线段树
 *
 * @see SegTreeUpd_sum
 */
public class DynamicSegTreeUpd_sum {
    static final int N = Integer.MAX_VALUE;
    final Node root = new Node();

    private static class Node {
        Node ls, rs;
        long sum, lazy;
    }

    void update(int ql, int qr, int val) {
        this.update(root, 0, N, ql, qr, val);
    }

    void update(Node p, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            p.sum = (r - l + 1L) * val;
            p.lazy = val;
            return;
        }
        pushDown(p, l, r);
        int mid = l + (r - l) / 2;
        if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
        if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
        pushUp(p);
    }

    long getSum(int ql, int qr) {
        return this.getSum(root, 0, N, ql, qr);
    }

    long getSum(Node p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return p.sum;
        }
        pushDown(p, l, r);
        int mid = l + (r - l) / 2;
        long sum = 0;
        if (ql <= mid) sum = getSum(p.ls, l, mid, ql, qr);
        if (qr > mid) sum += getSum(p.rs, mid + 1, r, ql, qr);
        return sum;
    }

    void pushDown(Node p, int l, int r) {
        if (p.ls == null) p.ls = new Node();
        if (p.rs == null) p.rs = new Node();
        if (p.lazy != 0) {
            int mid = l + (r - l) / 2;
            p.ls.sum = p.lazy * (mid - l + 1L);
            p.rs.sum = p.lazy * (r - mid);
            p.ls.lazy = p.lazy;
            p.rs.lazy = p.lazy;
            p.lazy = 0;
        }
    }

    void pushUp(Node p) {
        p.sum = p.ls.sum + p.rs.sum;
    }
}
