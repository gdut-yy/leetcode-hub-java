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
    private final int[] sum;
    private final int[] lazy;

    public SegmentTree(int[] nums) {
        int N = nums.length;
        this.nums = nums;
        sum = new int[N * 4];
        lazy = new int[N * 4];

        build(1, N, 1);
    }

    private void build(int s, int t, int p) {
        // 对 [s,t] 区间建立线段树,当前根的编号为 p
        if (s == t) {
            sum[p] = nums[s - 1];
            return;
        }
        int mid = s + (t - s) / 2;
        // 移位运算符的优先级小于加减法，所以加上括号
        // 如果写成 (s + t) >> 1 可能会超出 int 范围
        build(s, mid, p * 2);
        build(mid + 1, t, p * 2 + 1);
        // 递归对左右区间建树
        sum[p] = sum[p * 2] + sum[(p * 2) + 1];
    }

    // 区间修改，将 [l,r] 置为 val
    // 函数入口: update(l, r, val, 1, n, 1)
    public void update(int l, int r, int val, int s, int t, int p) {
        if (l <= s && t <= r) {
            sum[p] = (t - s + 1) * val;
            lazy[p] = val;
            return;
        }
        int mid = s + (t - s) / 2;
        // pushDown
        if (lazy[p] > 0) {
            sum[p * 2] = lazy[p] * (mid - s + 1);
            sum[p * 2 + 1] = lazy[p] * (t - mid);
            lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
            lazy[p] = 0;
        }
        if (l <= mid) {
            update(l, r, val, s, mid, p * 2);
        }
        if (r > mid) {
            update(l, r, val, mid + 1, t, p * 2 + 1);
        }
        sum[p] = sum[p * 2] + sum[p * 2 + 1];
    }

    // 区间修改，[l,r] 增加 inc
    // 函数入口: add(l, r, inc, 1, n, 1)
    public void add(int l, int r, int inc, int s, int t, int p) {
        if (l <= s && t <= r) {
            sum[p] += (t - s + 1) * inc;
            lazy[p] += inc;
            return;
        }
        int mid = s + (t - s) / 2;
        // pushDown
        if (lazy[p] > 0) {
            sum[p * 2] += lazy[p] * (mid - s + 1);
            sum[p * 2 + 1] += lazy[p] * (t - mid);
            lazy[p * 2] += lazy[p];
            lazy[p * 2 + 1] += lazy[p];
            lazy[p] = 0;
        }
        if (l <= mid) {
            add(l, r, inc, s, mid, p * 2);
        }
        if (r > mid) {
            add(l, r, inc, mid + 1, t, p * 2 + 1);
        }
        sum[p] = sum[p * 2] + sum[p * 2 + 1];
    }

    // 区间查询，求 [l,r] 范围最大值
    // 函数入口: getSum(l, r, 1, n, 1)
    public int getSum(int l, int r, int s, int t, int p) {
        if (l <= s && t <= r) {
            return sum[p];
        }
        int mid = s + (t - s) / 2;
        // pushDown
//        if (lazy[p] > 0) {
//            sum[p * 2] += lazy[p] * (mid - s + 1);
//            sum[p * 2 + 1] += lazy[p] * (t - mid);
//            lazy[p * 2] += lazy[p];
//            lazy[p * 2 + 1] += lazy[p];
//            lazy[p] = 0;
//        }
        int sum = 0;
        if (l <= mid) {
            sum = getSum(l, r, s, mid, p * 2);
        }
        if (r > mid) {
            sum += getSum(l, r, mid + 1, t, p * 2 + 1);
        }
        return sum;
    }
}
