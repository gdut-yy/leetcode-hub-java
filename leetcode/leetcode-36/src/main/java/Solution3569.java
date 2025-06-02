import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution3569 {
    static final int MAX_N = (int) 1e5;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MAX_N; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    public int[] maximumCount(int[] nums, int[][] queries) {
        int n = nums.length;
        Map<Integer, TreeSet<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (!np[x]) {
                pos.computeIfAbsent(x, k -> new TreeSet<>()).add(i);
            }
        }

        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n);
//        seg.build(new int[n], 1, 0, n - 1);
        for (TreeSet<Integer> s : pos.values()) {
            if (s.size() > 1) {
                seg.modify(1, 0, n - 1, s.first(), s.last(), 1);
            }
        }

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int[] q = queries[qi];
            int i = q[0];
            int v = q[1];
            int old = nums[i];
            nums[i] = v;

            // 处理旧值
            if (!np[old]) {
                TreeSet<Integer> s = pos.get(old);
                if (s.size() > 1) {
                    seg.modify(1, 0, n - 1, s.first(), s.last(), -1);
                }
                s.remove(i);
                if (s.size() > 1) {
                    seg.modify(1, 0, n - 1, s.first(), s.last(), 1);
                } else if (s.isEmpty()) {
                    pos.remove(old);
                }
            }

            // 处理新值
            if (!np[v]) {
                TreeSet<Integer> s = pos.computeIfAbsent(v, k -> new TreeSet<>());
                if (s.size() > 1) {
                    seg.modify(1, 0, n - 1, s.first(), s.last(), -1);
                }
                s.add(i);
                if (s.size() > 1) {
                    seg.modify(1, 0, n - 1, s.first(), s.last(), 1);
                }
            }

            // 整个数组的不同质数个数 + 切一刀的最大额外收益
            ans[qi] = pos.size() + seg.query(1, 0, n - 1, 0, n - 1).mx;
        }
        return ans;
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            int mx, lazy; // 区间加一、区间最大值

            public Info(int mx, int lazy) {
                this.mx = mx;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int mx = Math.max(a.mx, b.mx);
            return new Info(mx, 0);
        }

        void _do(int p, int qv) {
            info[p].mx += qv;
            info[p].lazy += qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.setAll(info, e -> new Info(0, 0));
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(0, 0);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void spread(int p) {
            if (info[p].lazy == 0) return;
            _do(p << 1, info[p].lazy);
            _do(p << 1 | 1, info[p].lazy);
            info[p].lazy = 0;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, qv);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }
}
/*
3569. 分割数组后不同质数的最大数目
https://leetcode.cn/problems/maximize-count-of-distinct-primes-after-split/description/

第 452 场周赛 T4。

给你一个长度为 'n' 的整数数组 nums，以及一个二维整数数组 queries，其中 queries[i] = [idx, val]。
对于每个查询：
1.更新 nums[idx] = val。
2.选择一个满足 1 <= k < n 的整数 k ，将数组分为非空前缀 nums[0..k-1] 和后缀 nums[k..n-1]，使得每部分中 不同 质数的数量之和 最大 。
注意：每次查询对数组的更改将持续到后续的查询中。
返回一个数组，包含每个查询的结果，按给定的顺序排列。
质数是大于 1 的自然数，只有 1 和它本身两个因数。
提示：
2 <= n == nums.length <= 5 * 10^4
1 <= queries.length <= 5 * 10^4
1 <= nums[i] <= 10^5
0 <= queries[i][0] < nums.length
1 <= queries[i][1] <= 10^5

Lazy 线段树 + 有序集合
https://leetcode.cn/problems/maximize-count-of-distinct-primes-after-split/solutions/3690759/xian-duan-shu-you-xu-ji-he-by-endlessche-j3nm/
转化非常巧妙！！
rating 2543 (clist.by)
 */