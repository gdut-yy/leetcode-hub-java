package template;

public class DynamicSegTreeAdd {
    private static final int N = Integer.MAX_VALUE;
    private final Node root = new Node();

    private static class Node {
        Node ls, rs;
        long sum, max, lazy;
    }

    // 区间 [l,r] 置为 val
    public void add(int l, int r, int val) {
        this.add(l, r, val, 0, N, root);
    }

    // 区间 [l,r] 求和
    public long getSum(int l, int r) {
        return this.getSum(l, r, 0, N, root);
    }

    // 区间 [l,r] 最大值
    public long getMax(int l, int r) {
        return this.getMax(l, r, 0, N, root);
    }

    private void add(int l, int r, int val, int s, int t, Node node) {
        if (l <= s && t <= r) {
            node.sum += (t - s + 1L) * val;
            node.max += val;
            node.lazy += val;
            return;
        }
        int mid = s + (t - s) / 2;
        pushDown(node, s, t, mid);
        if (l <= mid) {
            add(l, r, val, s, mid, node.ls);
        }
        if (r > mid) {
            add(l, r, val, mid + 1, t, node.rs);
        }
        pushUp(node);
    }

    private long getSum(int l, int r, int s, int t, Node node) {
        if (l <= s && t <= r) {
            return node.sum;
        }
        int mid = s + (t - s) / 2;
        pushDown(node, s, t, mid);
        long sum = 0;
        if (l <= mid) {
            sum = getSum(l, r, s, mid, node.ls);
        }
        if (r > mid) {
            sum += getSum(l, r, mid + 1, t, node.rs);
        }
        return sum;
    }

    private long getMax(int l, int r, int s, int t, Node node) {
        if (l <= s && t <= r) {
            return node.max;
        }
        int mid = s + (t - s) / 2;
        pushDown(node, s, t, mid);
        long max = 0;
        if (l <= mid) {
            max = getMax(l, r, s, mid, node.ls);
        }
        if (r > mid) {
            max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
        }
        return max;
    }

    private void pushDown(Node node, int s, int t, int mid) {
        if (node.ls == null) {
            node.ls = new Node();
        }
        if (node.rs == null) {
            node.rs = new Node();
        }
        if (node.lazy > 0) {
            node.ls.sum += node.lazy * (mid - s + 1L);
            node.rs.sum += node.lazy * (t - mid);
            node.ls.max += node.lazy;
            node.rs.max += node.lazy;
            node.ls.lazy += node.lazy;
            node.rs.lazy += node.lazy;
            node.lazy = 0;
        }
    }

    private void pushUp(Node node) {
        node.sum = node.ls.sum + node.rs.sum;
        node.max = Math.max(node.ls.max, node.rs.max);
    }
}
