package template;

public class BIT {
    int n;
    int[] tree;

    public BIT(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    int lb(int x) {
        return x & -x;
    }

    void add(int pos, int val) {
        for (; pos <= n; pos += lb(pos)) tree[pos] += val;
    }

    int query(int pos) {
        int ret = 0;
        for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
        return ret;
    }
}
