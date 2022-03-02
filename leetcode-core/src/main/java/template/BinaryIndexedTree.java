package template;

/**
 * 树状数组或二叉索引树（Binary Indexed Tree），又以其发明者命名为 Fenwick 树。
 * 其初衷是解决数据压缩里的累积频率的计算问题，现多用于高效计算数列的前缀和、区间和。
 * <p>
 * 它可以以 O(logn) 的时间得到任意前缀和：
 * 并同时支持在 O(logn) 时间内支持动态单点值的修改。空间复杂度 O(n)。
 */
public class BinaryIndexedTree {
    private final int n;
    private final int[] tree;

    public BinaryIndexedTree(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x) {
        while (x <= n) {
            ++tree[x];
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    /**
     * nums[x] add inc
     */
    public void update(int x, int inc) {
        while (x <= n) {
            tree[x] += inc;
            x += lowbit(x);
        }
    }

    /**
     * 求 nums[i,j] 的累加和
     */
    public int query(int i, int j) {
        return query(j + 1) - query(i);
    }
}
