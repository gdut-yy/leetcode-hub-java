public class Solution3525 {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        InfoSegmentTree seg = new InfoSegmentTree(n, k);
        seg.build(nums, 1, 0, n - 1);

        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int[] p = queries[qi];
            seg.modify(1, 0, n - 1, p[0], p[1]);
            int x = p[3];
            ans[qi] = seg.query(1, 0, n - 1, p[2], n - 1).cnt[x];
        }
        return ans;
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Info {
            int mul; // 整个区间 [l,r] 的元素积模 k 的结果。这可以用左右子树的 mul 相乘模 k 得到。
            int[] cnt; // 其中 cnt[x] 表示在左端点为 l，右端点为 l,l+1,l+2,…,r 的子数组中，元素积模 k 等于 x 的子数组的个数。计算规则就是上文的分治。

            public Info(int mul, int[] cnt) {
                this.mul = mul;
                this.cnt = cnt;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int[] cnt = a.cnt.clone();
            for (int rx = 0; rx < k; rx++) {
                cnt[a.mul * rx % k] += b.cnt[rx];
            }
            return new Info(a.mul * b.mul % k, cnt);
        }

        Info newData(int val) {
            int mul = val % k;
            int[] cnt = new int[k];
            cnt[mul] = 1;
            return new Info(mul, cnt);
        }

        int n;
        Info[] info;
        int k;

        public InfoSegmentTree(int n, int k) {
            this.n = n;
            info = new Info[4 * n];
            this.k = k;
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = newData(A[l]);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p, l, r);
        }

        void maintain(int p, int l, int r) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void modify(int p, int l, int r, int i, int qv) {
            if (l == r) {
                info[p] = newData(qv);
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) modify(p << 1, l, m, i, qv);
            else modify(p << 1 | 1, m + 1, r, i, qv);
            maintain(p, l, r);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }
}
/*
3525. 求出数组的 X 值 II
https://leetcode.cn/problems/find-x-value-of-array-ii/description/

第 446 场周赛 T4。

给你一个由 正整数 组成的数组 nums 和一个 正整数 k。同时给你一个二维数组 queries，其中 queries[i] = [indexi, valuei, starti, xi]。
你可以对 nums 执行 一次 操作，移除 nums 的任意 后缀 ，使得 nums 仍然非空。
给定一个 x，nums 的 x值 定义为执行以上操作后剩余元素的 乘积 除以 k 的 余数 为 x 的方案数。
对于 queries 中的每个查询，你需要执行以下操作，然后确定 xi 对应的 nums 的 x值：
- 将 nums[indexi] 更新为 valuei。仅这个更改在接下来的所有查询中保留。
- 移除 前缀 nums[0..(starti - 1)]（nums[0..(-1)] 表示 空前缀 ）。
返回一个长度为 queries.length 的数组 result，其中 result[i] 是第 i 个查询的答案。
数组的一个 前缀 是从数组开始位置到任意位置的子数组。
数组的一个 后缀 是从数组中任意位置开始直到结束的子数组。
子数组 是数组中一段连续的元素序列。
注意：操作中所选的前缀或后缀可以是 空的 。
注意：x值在本题中与问题 I 有不同的定义。
提示：
1 <= nums[i] <= 10^9
1 <= nums.length <= 10^5
1 <= k <= 5
1 <= queries.length <= 2 * 10^4
queries[i] == [indexi, valuei, starti, xi]
0 <= indexi <= nums.length - 1
1 <= valuei <= 10^9
0 <= starti <= nums.length - 1
0 <= xi <= k - 1

注意本题的子数组和上一题不一样，本题只能移除后缀。
https://leetcode.cn/problems/find-x-value-of-array-ii/solutions/3656583/dan-dian-xiu-gai-xian-duan-shu-by-endles-i3jy/
时间复杂度 O((n+qlogn)k)。
rating 2647 (clist.by)
 */