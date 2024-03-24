package p988;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF988F {
    static int dst, n, m;
    static Seg[] seg;
    static List<Pair> a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dst = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();

        seg = new Seg[n];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            seg[i] = new Seg(l, r);
        }
        a = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int w = scanner.nextInt();
            a.add(new Pair(x, w));
        }
        System.out.println(solve());
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        Arrays.sort(seg, (o1, o2) -> Integer.compare(o1.l, o2.r));
        a.sort(Comparator.comparingInt(o -> o.x));

        if (a.get(0).x > seg[0].l) {
            return "-1";
        }
        a.add(new Pair(seg[n - 1].r, 0)); // 方便计算答案（也可以用 dst，但其实完全不需要这个值）
        int[] f = new int[m + 1];
        int j = -1;
        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i).x;
            while (j + 1 < n && seg[j + 1].l < x) { // 寻找 x 左侧最近区间左端点
                j++;
            }
            if (j < 0) continue;
            x = Math.min(x, seg[j].r); // 如果 x 在区间外（x 与左端点重合也算），那么移动到左侧区间的右端点时就应该丢伞了
            if (a.get(i - 1).x >= x) { // 如果上面没有 continue 那么这里必然 i>0
                f[i] = f[i - 1];
                continue;
            }
            f[i] = INF;
            for (int k = 0; k < i; k++) {
                Pair q = a.get(k);
                f[i] = Math.min(f[i], f[k] + (x - q.x) * q.w);
            }
        }
        return String.valueOf(f[m]);
    }

    static class Seg {
        int l, r;

        public Seg(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static class Pair {
        int x, w;

        public Pair(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
}
/*
F. Rain and Umbrellas
https://codeforces.com/contest/988/problem/F

灵茶の试炼 2022-10-11
题目大意：
输入正整数 dst(≤2000), n(≤(dst+1)/2) 和 m(≤2000)。
然后输入 n 个互不相交的下雨区间，左右端点满足 0≤L<R≤dst。
然后输入 m 行，每行两个数表示雨伞的位置 x[i](≤dst) 和重量 w[i](≤1e5)。
你需要从 0 出发走到 dst。在下雨区间内移动必须打伞（区间端点处不算下雨）。
你可以中途换伞。
带着伞移动时，每走一单位长度，消耗的耐力等于伞的重量。
你可以丢掉伞，空手移动时消耗的耐力为零。
输出到达 dst 至少需要消耗多少耐力。如果无法到达 dst，输出 -1。
进阶：请写一个和坐标范围无关的代码，即使坐标范围达到 1e9 也可以通过。

rating 2100
https://codeforces.com/contest/988/submission/175402975
为方便计算答案，假设 dst 处（或者最后一个下雨的位置）还有一把伞。
定义 f[i] 表示到达 x[i] 时，至少需要消耗的耐力。
记 x'[i] 为 x[i] 左侧最近有雨的位置（这可以用双指针求出），我们可以在这里丢伞。
枚举上一把伞的位置，有
f[i] = min(f[j] + (x'[i] - x[j]) * w[j]), 其中 j 需满足 x[j] < x'[i]。
详细注释见代码，时间复杂度 O(m^2)。
======

input
10 2 4
3 7
8 10
0 10
3 4
8 1
1 2
output
14

input
10 1 1
0 9
0 5
output
45

input
10 1 1
0 9
1 5
output
-1
 */