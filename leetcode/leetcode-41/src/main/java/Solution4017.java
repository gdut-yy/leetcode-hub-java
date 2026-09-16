public class Solution4017 {
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int cnt1 = 0;
        for (int[] q : queries) {
            cnt1 += 2 - q[0];
        }

        int n = nums.length;
        SegmentTree t = new SegmentTree(nums);
        long[] ans = new long[cnt1];
        int k = 0;
        for (int[] q : queries) {
            if (q[0] == 1) {
                ans[k++] = t.query(q[1], q[2]);
                continue;
            }
            int i = q[1];
            nums[i] = q[2];
            for (int j = Math.max(i - 1, 1); j <= Math.min(i + 1, n - 2); j++) {
                // 注：这里可以优化一下，如果更新前后 hasPeak 不变，则不调用 t.update
                boolean hasPeak = nums[j - 1] < nums[j] && nums[j] > nums[j + 1];
                t.update(j, hasPeak);
            }
        }
        return ans;
    }

    static class SegmentTree {
        private record Data(long cnt, int pre, int suf, int len, boolean hasPeak) {
        }

        private final int n;
        private final Data[] tree;

        private Data mergeData(Data a, Data b) {
            long cnt = a.cnt + b.cnt + (long) a.len * b.len - (long) a.suf * b.pre;
            int pre = a.hasPeak ? a.pre : a.len + b.pre;
            int suf = b.hasPeak ? b.suf : b.len + a.suf;
            return new Data(cnt, pre, suf, a.len + b.len, a.hasPeak || b.hasPeak);
        }

        public SegmentTree(int[] a) {
            n = a.length;
            tree = new Data[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            build(a, 1, 0, n - 1);
        }

        public void update(int i, boolean hasPeak) {
            update(1, 0, n - 1, i, hasPeak);
        }

        public long query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr).cnt;
        }

        private void maintain(int node) {
            tree[node] = mergeData(tree[node * 2], tree[node * 2 + 1]);
        }

        private void build(int[] a, int node, int l, int r) {
            if (l == r) { // 叶子
                boolean hasPeak = 0 < l && l < n - 1 && a[l - 1] < a[l] && a[l] > a[l + 1];
                tree[node] = new Data(0, 1, 1, 1, hasPeak); // 初始化叶节点的值
                return;
            }
            int m = (l + r) >>> 1;
            build(a, node * 2, l, m); // 初始化左子树
            build(a, node * 2 + 1, m + 1, r); // 初始化右子树
            maintain(node);
        }

        private void update(int node, int l, int r, int i, boolean hasPeak) {
            if (l == r) { // 叶子（到达目标）
                Data d = tree[node];
                tree[node] = new Data(d.cnt, d.pre, d.suf, d.len, hasPeak);
                return;
            }
            int m = (l + r) >>> 1;
            if (i <= m) { // i 在左子树
                update(node * 2, l, m, i, hasPeak);
            } else { // i 在右子树
                update(node * 2 + 1, m + 1, r, i, hasPeak);
            }
            maintain(node);
        }

        private Data query(int node, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) { // 当前子树完全在 [ql, qr] 内
                return tree[node];
            }
            int m = (l + r) >>> 1;
            if (qr <= m) { // [ql, qr] 与右子树无交集，仅需递归左子树
                return query(node * 2, l, m, ql, qr);
            }
            if (ql > m) { // [ql, qr] 与左子树无交集，仅需递归右子树
                return query(node * 2 + 1, m + 1, r, ql, qr);
            }
            // [ql, qr] 与左右子树均有交集，分别递归，然后合并结果
            Data lRes = query(node * 2, l, m, ql, qr);
            Data rRes = query(node * 2 + 1, m + 1, r, ql, qr);
            return mergeData(lRes, rRes);
        }
    }
}
/*
4017. 数组中的峰值 II
https://leetcode.cn/problems/peaks-in-array-ii/description/

第 514 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个二维整数数组 queries。
如果满足以下条件，子数组 nums[i..j] 被称为 峰值子数组：
- 其长度 至少 为 3。
- 存在一个下标 k 使得 i < k < j 且：
  - nums[k] > nums[k - 1]
  - nums[k] > nums[k + 1]
你需要处理以下两种类型的查询：
- [1, li, ri]：计算完全包含在 nums[li..ri] 中的 峰值子数组 的数量。
- [2, indexi, vali]：将 nums[indexi] 更新为 vali。此更新适用于所有后续查询。
返回一个数组 answer，其中 answer[i] 是按出现顺序排列的第 i 个类型 1 查询的答案。
子数组 是数组中连续的 非空 元素序列。
提示：
3 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i] = [1, li, ri] 或 queries[i] = [2, indexi, vali]
0 <= li < ri <= n - 1
0 <= indexi <= n - 1
0 <= vali <= 10^5

用分治思考，用线段树维护
https://leetcode.cn/problems/peaks-in-array-ii/solutions/4009084/yong-fen-zhi-si-kao-yong-xian-duan-shu-w-2b40/
 */