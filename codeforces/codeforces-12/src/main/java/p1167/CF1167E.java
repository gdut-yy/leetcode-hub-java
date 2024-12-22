package p1167;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1167E {
    static final int MAX_N = (int) (1e6 + 5);
    static final int INF = (int) 1e9;

    static int n, x;
    static int[][] ps = new int[MAX_N][3]; // l, r, v

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        for (int i = 0; i < MAX_N; i++) {
            ps[i][0] = INF;
            ps[i][2] = i;
        }
        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            if (ps[v][0] == INF) {
                ps[v][0] = i;
            }
            ps[v][1] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<int[]> b = new ArrayList<>();
        for (int[] p : ps) {
            if (p[1] > 0) {
                b.add(p);
            }
        }
        n = b.size();

        int i = 0;
        while (i < n - 1 && b.get(i)[1] < b.get(i + 1)[0]) {
            i++;
        }
        if (i == n - 1) {
            long ans = x * (x + 1L) / 2;
            return String.valueOf(ans);
        }

        long ans = (long) b.get(i + 1)[2] * (x + 1 - b.get(n - 1)[2]); // 去掉后缀 b[<=i+1] ~ b[n-1]
        for (int j = n - 1; j == n - 1 || b.get(j)[1] < b.get(j + 1)[0]; j--) {
            while (i >= 0 && b.get(i)[1] >= b.get(j)[0]) {
                i--;
            }
            ans += (long) b.get(i + 1)[2] * (b.get(j)[2] - b.get(j - 1)[2]); // 去掉 b[<=i+1] ~ b[j-1]
        }
        return String.valueOf(ans);
    }
}
/*
E. Range Deleting
https://codeforces.com/contest/1167/problem/E

灵茶の试炼 2024-07-18
题目大意：
输入 n(1≤n≤1e6) x(1≤x≤1e6) 和长为 n 的数组 a(1≤a[i]≤x)。
定义 D(a,L,R) 为删除 a 中所有元素值在 [L,R] 中的元素后，剩余的元素组成的数组（不改变顺序）。
输出有多少对 (L,R) 满足 1<=L<=R<=x 且 D(a,L,R) 是非降数组，即相邻元素左边 <= 右边。

rating 2100
本题是近期打卡题【力扣 2972. 统计移除递增子数组的数目 II】的变形题。
由于思路和代码都非常接近，推荐先把力扣那题做了。
核心思路：删除元素后，对于剩余的每个元素，考察其出现位置的区间，这些区间必须不相交。
记录每个元素首次和最后一次出现的位置。
定义 ps[v].l 表示元素 v 首次出现的位置，ps[v].r 表示元素 v 最后一次出现的位置。
用闭区间 [ps[v].l, ps[v].r] 表示元素 v。
对于剩余元素中的两个数 v 和 w，如果 v < w，那么区间 [ps[v].l, ps[v].r] 必须在区间 [ps[w].l, ps[w].r] 的左侧，即 ps[v].r < ps[w].l。
首先考虑一个简单情况：1 到 x 中的每个数都在数组 a 中。
和力扣 2972 题代码一样，双指针，把「元素值比大小」改成 ps[v].r < ps[w].l 这样的「区间左右端点比大小」即可。
本题的一个难点是，如果有元素不在 a 中，怎么算清楚这种情况，尤其是不能重复统计。
首先把 ps 中的元素值在 a 中的区间提取出来，得到数组 b。
其中 b[i].l 和 b[i].r 是第 i 个区间的左右端点，b[i].v 是第 i 个区间对应的元素值。
看上去在 b 数组上「区间左右端点比大小」就行，怎么把不在 a 中的元素值考虑进来呢？
和 2972 题 我的题解 一样，首先讨论删除后缀的情况，然后讨论一般情况。
删除后缀 b[k] 到 b[n-1]，其中 n 是 b 的长度，k <= i+1。
那么删除的范围，最小值 <= b[i+1].v，最大值 >= b[n-1].v，根据乘法原理，这一共有 b[i+1].v * (x + 1 - b[n-1].v) 个。
然后讨论删除的不是后缀的情况。
删除 b[k] 到 b[j-1]，保留 b[j] 到 b[n-1]，那么删除的范围，最小值 <= b[i+1].v，最大值在左闭右开区间 [b[j-1].v, b[j].v) 中，根据乘法原理，这一共有 b[i+1].v * (b[j].v - b[j-1].v) 个。
代码 https://codeforces.com/contest/1167/submission/270260662
======

Input
3 3
2 3 1
Output
4

Input
7 4
1 3 1 2 2 4 3
Output
6
 */