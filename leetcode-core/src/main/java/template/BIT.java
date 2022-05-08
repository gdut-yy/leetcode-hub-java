package template;

/**
 * 树状数组
 * https://oi-wiki.org/ds/fenwick/
 * 二叉索引树（Binary Indexed Tree），又以其发明者命名为 Fenwick 树。
 * 其初衷是解决数据压缩里的累积频率的计算问题，现多用于高效计算数列的前缀和、区间和。
 * <p>
 * 它可以以 O(logn) 的时间得到任意前缀和：
 * 并同时支持在 O(logn) 时间内支持动态单点值的修改。空间复杂度 O(n)。
 */
public class BIT {
    private final int N;
    private final int[] tree;

    // O(n) 建树
    public BIT(int[] nums) {
        this.N = nums.length;
        this.tree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] += nums[i - 1];
            int j = i + lowbit(i);
            if (j <= N) {
                tree[j] += tree[i];
            }
        }
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    // nums[x] add k
    public void add(int x, int k) {
        while (x <= N) {
            tree[x] += k;
            x += lowbit(x);
        }
    }

    // nums [1,x] 的和
    public int getsum(int x) {
        int ans = 0;
        while (x >= 1) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    // nums [l,r] 的和
    public int getsum(int l, int r) {
        return getsum(r + 1) - getsum(l);
    }
}
