package template;

/**
 * 线段树
 * 线段树可以在 O(logn) 的时间复杂度内实现单点修改、区间修改、区间查询（区间求和，求区间最大值，求区间最小值）等操作。
 * https://oi-wiki.org/ds/seg/
 * <p>
 * 空间复杂度 O(4n)
 */
public class SegmentTree {
    private final int[] nums;
    private final int[] tree;
    private final int[] lazy;

    public SegmentTree(int[] nums) {
        int N = nums.length;
        this.nums = nums;
        tree = new int[N * 4];
        lazy = new int[N * 4];

        build(1, N, 1);
    }

    private void build(int s, int t, int p) {
        // 对 [s,t] 区间建立线段树,当前根的编号为 p
        if (s == t) {
            tree[p] = nums[s - 1];
            return;
        }
        int m = s + ((t - s) >> 1);
        // 移位运算符的优先级小于加减法，所以加上括号
        // 如果写成 (s + t) >> 1 可能会超出 int 范围
        build(s, m, p * 2);
        build(m + 1, t, p * 2 + 1);
        // 递归对左右区间建树
        tree[p] = tree[p * 2] + tree[(p * 2) + 1];
    }

    // [l,r] 范围置为 c
    public void update(int l, int r, int c, int s, int t, int p) {
        if (l <= s && t <= r) {
            tree[p] = (t - s + 1) * c;
            lazy[p] = c;
            return;
        }
        int m = s + ((t - s) >> 1);
        if (lazy[p] > 0) {
            tree[p * 2] = lazy[p] * (m - s + 1);
            tree[p * 2 + 1] = lazy[p] * (t - m);
            lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
            lazy[p] = 0;
        }
        if (l <= m) {
            update(l, r, c, s, m, p * 2);
        }
        if (r > m) {
            update(l, r, c, m + 1, t, p * 2 + 1);
        }
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    // [l,r] 范围求和
    public int getsum(int l, int r, int s, int t, int p) {
        if (l <= s && t <= r) {
            return tree[p];
        }
        int m = s + ((t - s) >> 1);
        if (lazy[p] > 0) {
            tree[p * 2] = lazy[p] * (m - s + 1);
            tree[p * 2 + 1] = lazy[p] * (t - m);
            lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
            lazy[p] = 0;
        }
        int sum = 0;
        if (l <= m) {
            sum = getsum(l, r, s, m, p * 2);
        }
        if (r > m) {
            sum += getsum(l, r, m + 1, t, p * 2 + 1);
        }
        return sum;
    }
}
