package template.seg;

/**
 * 动态开点线段树
 *
 * @see SegTreeUpd_max
 */
public class DynamicSegTreeUpd_max {
    static class Node {
        Node ls, rs;
        long max, lazy;
    }

    static final int N = Integer.MAX_VALUE;
    final Node root = new Node();

    void update(int ql, int qr, int val) {
        this.update(root, 0, N, ql, qr, val);
    }

    void update(Node p, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            p.max = val;
            p.lazy = val;
            return;
        }
        int mid = l + (r - l) / 2;
        pushDown(p);
        if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
        if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
        pushUp(p);
    }

    long getMax(int ql, int qr) {
        return this.getMax(root, 0, N, ql, qr);
    }

    long getMax(Node p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return p.max;
        }
        pushDown(p);
        int mid = l + (r - l) / 2;
        long max = 0;
        if (ql <= mid) max = getMax(p.ls, l, mid, ql, qr);
        if (qr > mid) max = Math.max(max, getMax(p.rs, mid + 1, r, ql, qr));
        return max;
    }

    void pushDown(Node p) {
        if (p.ls == null) p.ls = new Node();
        if (p.rs == null) p.rs = new Node();
        if (p.lazy != 0) {
            p.ls.max = p.lazy;
            p.rs.max = p.lazy;
            p.ls.lazy = p.lazy;
            p.rs.lazy = p.lazy;
            p.lazy = 0;
        }
    }

    void pushUp(Node node) {
        node.max = Math.max(node.ls.max, node.rs.max);
    }
}
