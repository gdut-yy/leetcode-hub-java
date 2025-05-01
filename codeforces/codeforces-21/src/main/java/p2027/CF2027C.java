package p2027;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF2027C {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    static Map<Long, List<Long>> to;
    static long ans;
    static Set<Long> vis;

    private static String solve() {
        to = new HashMap<>();
        for (int i = 1; i < n; i++) {
            long v = a[i];
            v += i;
            to.computeIfAbsent(v, e -> new ArrayList<>()).add(v + i);
        }

        ans = n;
        vis = new HashSet<>();
        dfs(n);
        return String.valueOf(ans);
    }

    static void dfs(long v) {
        vis.add(v);
        ans = Math.max(ans, v);
        for (Long w : to.getOrDefault(v, new ArrayList<>())) {
            if (!vis.contains(w)) {
                dfs(w);
            }
        }
    }
}
/*
C. Add Zeros
https://codeforces.com/contest/2027/problem/C

灵茶の试炼 2024-12-03
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e12)。
数组下标从 0 开始。用 |a| 表示数组当前长度。
你可以执行多次如下操作：
选择一个 [1,|a|-1] 中的下标 i，满足 a[i] = |a|-i。然后在 a 的末尾添加 i 个 0。
输出 |a| 的最大值。

rating 1500
式子变形为 a[i]+i = |a|。
所以只有当数组长度为一个特定值的时候，才能选择 i 操作。操作后，数组的长度变成了 |a|+i = a[i]+2i。
转换成有向图模型，从 a[i]+i 向 a[i]+2i 连边。
然后从节点 n（初始数组长度）开始 DFS 这个图，能访问到的最大节点编号即为答案。
代码 https://codeforces.com/contest/2027/submission/292826365
代码备份（洛谷）
======

Input
4
5
2 4 6 2 5
5
5 4 4 5 1
4
6 8 2 3
1
1
Output
10
11
10
1
 */
