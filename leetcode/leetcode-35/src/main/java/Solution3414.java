import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Solution3414 {
    // T4 1235
    record Tuple(int l, int r, int weight, int i) {
    }

    record Pair(long sum, List<Integer> id) {
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Tuple[] a = new Tuple[n];
        for (int i = 0; i < n; i++) {
            List<Integer> p = intervals.get(i);
            int l = p.get(0), r = p.get(1), wt = p.get(2);
            a[i] = new Tuple(l, r, wt, i);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o.r));

        Pair[][] f = new Pair[n + 1][5];
        for (int i = 0; i < n + 1; i++) {
            Arrays.setAll(f[i], e -> new Pair(0, new ArrayList<>()));
        }
        for (int i = 0; i < n; i++) {
            Tuple t = a[i];
            int k = sortSearch(i, (k0) -> a[k0].r >= t.l);
            for (int j = 1; j < 5; j++) {
                long s1 = f[i][j].sum;
                long s2 = f[k][j - 1].sum + t.weight;
                if (s1 > s2) {
                    f[i + 1][j] = f[i][j];
                    continue;
                }
                List<Integer> newId = new ArrayList<>(f[k][j - 1].id);
                newId.add(t.i);
                Collections.sort(newId);
                if (s1 == s2 && compareLists(f[i][j].id, newId) < 0) {
                    newId = f[i][j].id;
                }
                f[i + 1][j] = new Pair(s2, newId);
            }
        }
        return f[n][4].id.stream().mapToInt(v -> v).toArray();
    }

    // func Search(n int, f func(int) bool) int { ... }
    private int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 比较两个 List 的字典序
    private int compareLists(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return a.size() - b.size();
    }
}
/*
3414. 不重叠区间的最大得分
https://leetcode.cn/problems/maximum-score-of-non-overlapping-intervals/description/

第 431 场周赛 T4。

给你一个二维整数数组 intervals，其中 intervals[i] = [li, ri, weighti]。区间 i 的起点为 li，终点为 ri，权重为 weighti。你最多可以选择 4 个互不重叠 的区间。所选择区间的 得分 定义为这些区间权重的总和。
返回一个至多包含 4 个下标且字典序最小的数组，表示从 intervals 中选中的互不重叠且得分最大的区间。
如果两个区间没有任何重叠点，则称二者 互不重叠 。特别地，如果两个区间共享左边界或右边界，也认为二者重叠。
数组 a 的字典序小于数组 b 的前提是：当在第一个不同的位置上，a 的元素小于 b 的对应元素。如果前 min(a.length, b.length) 个元素均相同，则较短的数组字典序更小。
提示：
1 <= intervals.length <= 5 * 10^4
intervals[i].length == 3
intervals[i] = [li, ri, weighti]
1 <= li <= ri <= 10^9
1 <= weighti <= 10^9

相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
rating 2613 (clist.by)
 */