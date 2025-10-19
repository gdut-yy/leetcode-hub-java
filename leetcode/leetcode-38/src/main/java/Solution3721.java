import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3721 {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n + 1); // 注意不能初始化为 n
        seg.build(new int[n], 1, 0, n - 1);

        Map<Integer, Integer> last = new HashMap<>();
        int ans = 0;
        int curSum = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            int v = x % 2 > 0 ? 1 : -1;
            if (!last.containsKey(x)) {
                curSum += v;
                seg.update(i, n, v);
            } else {
                int j = last.get(x);
                seg.update(j, i - 1, -v);
            }
            last.put(x, i);

            int j = seg.findFirst(0, i - 1, curSum);
            if (j >= 0) {
                ans = Math.max(ans, i - j);
            }
        }
        return ans;
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            int mx, mn, lazy;

            public Info(int mx, int mn, int lazy) {
                this.mx = mx;
                this.mn = mn;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int mx = Math.max(a.mx, b.mx);
            int mn = Math.min(a.mn, b.mn);
            return new Info(mx, mn, 0);
        }

        void _do(int p, int qv) {
            info[p].mx += qv;
            info[p].mn += qv;
            info[p].lazy += qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.setAll(info, e -> new Info(0, 0, 0));
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
//                info[p] = new Info(0, 0, 0);
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

        // 用 f 更新 [ql, qr] 中的每个 a[i]
        // 0 <= ql <= qr <= n-1
        // 时间复杂度 O(log n)
        public void update(int ql, int qr, int f) {
            modify(1, 0, n - 1, ql, qr, f);
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

        // 查询 [ql,qr] 内第一个等于 target 的元素下标
        // 找不到返回 -1
        // 0 <= ql <= qr <= n-1
        // 时间复杂度 O(log n)
        public int findFirst(int ql, int qr, int target) {
            return findFirst(1, 0, n - 1, ql, qr, target);
        }

        private int findFirst(int node, int l, int r, int ql, int qr, int target) {
            if (l > qr || r < ql || target < info[node].mn || target > info[node].mx) {
                return -1;
            }
            if (l == r) {
                return l;
            }
            spread(node);
            int m = (l + r) / 2;
            int idx = findFirst(node * 2, l, m, ql, qr, target);
            if (idx < 0) {
                idx = findFirst(node * 2 + 1, m + 1, r, ql, qr, target);
            }
            return idx;
        }
    }
}
/*
3721. 最长平衡子数组 II
https://leetcode.cn/problems/longest-balanced-subarray-ii/description/

第 472 场周赛 T4。

给你一个整数数组 nums。
如果子数组中 不同偶数 的数量等于 不同奇数 的数量，则称该 子数组 是 平衡的 。
返回 最长 平衡子数组的长度。
子数组 是数组中连续且 非空 的一段元素序列。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

HH 项链 trick。
https://leetcode.cn/problems/longest-balanced-subarray-ii/solutions/3809924/fen-kuai-wei-hu-qian-zhui-he-pythonjavac-rt79/
把偶数视作 −1，奇数视作 1，遍历过的星号视作 0.
由于 a 中元素只有 −1,0,1，所以 sum 数组相邻元素之差 ≤1。这意味着，设 min 和 max 分别为区间的最小值和最大值，只要 sum[i] 在 [min,max] 范围中，区间就一定存在等于 sum[i] 的数。
用 Lazy 线段树维护区间最小值、区间最大值、区间加的 Lazy tag。
时间复杂度 O(nlogn)。
相似题目: 525. 连续数组
https://leetcode.cn/problems/contiguous-array/
rating 2746 (clist.by)
 */