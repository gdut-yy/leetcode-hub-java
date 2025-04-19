import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Solution3501 {
    private record Pair(int l, int r) { // 左闭右开
    }

    private static class SparseTable {
        private final int[][] st;

        SparseTable(List<Pair> a) {
            int n = a.size() - 1;
            int sz = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[n][sz];
            for (int i = 0; i < n; i++) {
                st[i][0] = a.get(i).r - a.get(i).l + a.get(i + 1).r - a.get(i + 1).l;
            }
            for (int j = 1; j < sz; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        // 查询区间最大值，[l,r) 左闭右开
        int query(int l, int r) {
            if (l >= r) {
                return 0;
            }
            int k = 32 - Integer.numberOfLeadingZeros(r - l) - 1;
            return Math.max(st[l][k], st[r - (1 << k)][k]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String S, int[][] queries) {
        char[] s = S.toCharArray();
        int n = s.length;
        int total1 = 0;
        List<Pair> a = new ArrayList<>();
        a.add(new Pair(-1, -1)); // 哨兵
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s[i] != s[i + 1]) {
                if (s[i] == '1') {
                    total1 += i - start + 1;
                } else {
                    a.add(new Pair(start, i + 1)); // 左闭右开
                }
                start = i + 1;
            }
        }
        a.add(new Pair(n + 1, n + 1)); // 哨兵

        SparseTable st = new SparseTable(a);
        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int ql = query[0];
            int qr = query[1] + 1; // 左闭右开

            // 找第一个区间，左端点 >= ql
            // 找最后一个区间，右端点 <= qr
            // a 中没有重复的区间左右端点，可以直接用库函数二分
//            int i = Collections.binarySearch(a, new Pair(ql, 0), (p, q) -> p.l - q.l);
//            if (i < 0) i = ~i;
//            int j = Collections.binarySearch(a, new Pair(0, qr + 1), (p, q) -> p.r - q.r);
//            if (j < 0) j = ~j;
//            j--;
            int i = sortSearch(a.size(), m -> a.get(m).l >= ql);
            int j = sortSearch(a.size(), m -> a.get(m).r >= qr + 1) - 1;

            int mx = 0;
            if (i <= j) { // [ql,qr) 中有完整的区间
                int full = st.query(i, j); // 相邻完整区间的长度之和的最大值
                int sl = merge(a.get(i - 1).r - ql, a.get(i).r - a.get(i).l); // 残缺区间 i-1 + 完整区间 i
                int sr = merge(qr - a.get(j + 1).l, a.get(j).r - a.get(j).l); // 残缺区间 j+1 + 完整区间 j
                mx = Math.max(full, Math.max(sl, sr));
            } else if (i == j + 1) { // [ql,qr) 中有两个相邻的残缺区间
                mx = merge(a.get(i - 1).r - ql, qr - a.get(j + 1).l); // 残缺区间 i-1 + 残缺区间 j+1
            }
            ans.add(total1 + mx);
        }
        return ans;
    }

    private int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int merge(int x, int y) {
        return x > 0 && y > 0 ? x + y : 0;
    }
}
/*
3501. 操作后最大活跃区段数 II
https://leetcode.cn/problems/maximize-active-section-with-trade-ii/description/

第 153 场双周赛 T4。

给你一个长度为 n 的二进制字符串 s ，其中：
- '1' 表示一个 活跃 区域。
- '0' 表示一个 非活跃 区域。
你最多可以进行一次 操作 来最大化 s 中活跃区间的数量。在一次操作中，你可以：
将一个被 '0' 包围的连续 '1' 区域转换为全 '0'。
然后，将一个被 '1' 包围的连续 '0' 区域转换为全 '1'。
此外，你还有一个 二维数组 queries，其中 queries[i] = [li, ri] 表示子字符串 s[li...ri]。
对于每个查询，确定在对子字符串 s[li...ri] 进行最优交换后，字符串 s 中 可能的最大 活跃区间数。
返回一个数组 answer，其中 answer[i] 是 queries[i] 的结果。
注意
对于每个查询，仅对 s[li...ri] 处理时，将其看作是在两端都加上一个 '1' 后的字符串，形成 t = '1' + s[li...ri] + '1'。这些额外的 '1' 不会对最终的活跃区间数有贡献。
各个查询相互独立。
提示：
1 <= n == s.length <= 10^5
1 <= queries.length <= 10^5
s[i] 只有 '0' 或 '1'。
queries[i] = [li, ri]
0 <= li <= ri < n

区间最大值 + 分类讨论
时间复杂度 O(nlogn + qlogn)。
rating 3025 (clist.by)
 */