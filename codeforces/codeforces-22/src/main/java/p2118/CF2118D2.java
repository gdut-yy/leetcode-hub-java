package p2118;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class CF2118D2 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
        }

        long[] d = new long[n];
        int[] to = new int[n * 2];
        Arrays.fill(to, -1);
        Map<Long, List<Integer>> idx = new HashMap<>();
        Map<Long, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextLong();
            long v = (x[i] % k - d[i] + k) % k;
            if (last.containsKey(v)) {
                int j = last.get(v);
                to[n + j] = i;
            }
            last.put(v, i);
            idx.computeIfAbsent(v, e -> new ArrayList<>()).add(i);
        }

        last.clear();
        for (int i = n - 1; i >= 0; i--) {
            long v = (x[i] % k + d[i] % k) % k;
            if (last.containsKey(v)) {
                int j = last.get(v);
                to[j] = n + i;
            }
            last.put(v, i);
        }

        byte[] vis = new byte[2 * n]; // 0: unvisited, -1: visiting, 1: visited
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            long v = scanner.nextLong();
            long mod = v % k;
            List<Integer> idList = idx.getOrDefault(mod, new ArrayList<>());

            int j = sortSearch(idList.size(), id -> x[idList.get(id)] >= v);

            boolean result;
            if (j == idList.size()) {
                result = true;
            } else {
                result = dfs(idList.get(j), vis, to);
            }
            out.println(result ? "YES" : "NO");
        }
    }

    static boolean dfs(int v, byte[] vis, int[] to) {
        if (vis[v] != 0) {
            return vis[v] > 0;
        }
        vis[v] = -1;
        int w = to[v];
        if (w < 0 || dfs(w, vis, to)) {
            vis[v] = 1;
            return true;
        }
        return false;
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
D2. Red Light, Green Light (Hard version)
https://codeforces.com/contest/2118/problem/D2

灵茶の试炼 2025-09-25
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) k(1≤k≤1e15)，长为 n 的严格递增数组 x(1≤x[i]≤1e15)，长为 n 的数组 d(0≤d[i]<k)。
一维数轴上有 n 个信号灯，坐标记录在 x 中。
位于 x[i] 的信号灯在第 d[i],d[i]+k,d[i]+2k,... 秒为红灯，其余时刻为绿灯。
然后输入 q(1≤q≤2e5) 和 q 个询问，每个询问输入 v(1≤v≤1e15)。
在第 0 秒，你位于坐标 v，面朝右。
每一秒，执行如下指令：
首先，如果当前位置有信号灯且为红灯，移动方向反向，否则移动方向不变。
然后，移动一个单位。
对于每个询问，判断能否移动出界，即移动到第一个信号灯的左边，或者最后一个信号灯的右边。
输出 YES 或 NO。

rating 2200
想象成一个乒乓球在一些挡板（信号灯）之间弹来弹去。
把信号灯 i 视作两个点 i 和 n+i，点 i 表示往左，点 n+i 表示往右。
如果能从信号灯 i（红灯）往左恰好移动到信号灯 j（红灯），那么连一条从 i 到 n+j 的有向边。
如果能从信号灯 i（红灯）往右恰好移动到信号灯 j（红灯），那么连一条从 n+i 到 j 的有向边。
如果我们在红灯之间无限移动，就输出 NO。
注：2n 个点，每个点至多连一条出边，是个内向基环森林。
对于往右的情况，考察从哪个信号灯 j（红灯）可以往右移动到信号灯 i（红灯）。
必须满足 d[j] + (x[i] - x[j]) 模 k 同余于 d[i]。
即 x[j]-d[j] 与 x[i]-d[i] 是模 k 同余的。
用一个 map 记录上一个 (x[j]-d[j])%k 的下标 j（如果位置是负数，记得 +k 调整为非负数）。
然后连一条从 n+j 到 i 的有向边。
对于往左的情况，同理。公式变形后，map 记录的是上一个 (x[j]+d[j])%k 的下标 j。
建好图后，问题转换成从某个点出发，能否走到出度为 0 的点，还是说一直在基环中打转。
写个 DFS 判断能否走到基环。
怎么找到这个出发点呢？注意出发点必须是红灯。
对于一个参数为 (x[i],d[i]) 的信号灯，如果我们从 <= x[i] 且与 x[i]-d[i] 同余的位置出发，就恰好在红灯时移动到信号灯 i。
所以要按照 (x[i]-d[i])%k 分组（把负数调整为非负数），每组内记录信号灯的下标。
在组内二分查找位置 >= v 的第一个信号灯，即为出发点（往左弹）。
代码 https://codeforces.com/contest/2118/submission/339210928
代码备份（上面打不开的同学看这个）
======

Input
4
2 2
1 4
1 0
3
1 2 3
9 4
1 2 3 4 5 6 7 8 9
3 2 1 0 1 3 3 1 1
5
2 5 6 7 8
4 2
1 2 3 4
0 0 0 0
4
1 2 3 4
3 4
1 2 3
3 1 1
3
1 2 3
Output
YES
NO
YES
YES
YES
YES
NO
NO
YES
YES
NO
NO
YES
NO
YES
 */
