package p2117;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF2117C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int ans = 0;
        Set<Integer> pre = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int v : a) {
            cur.add(v);
            pre.remove(v);
            if (pre.isEmpty()) {
                ans++;
                pre = new HashSet<>(cur);
                cur.clear();
            }
        }
        out.println(ans);
    }
}
/*
C. Cool Partition
https://codeforces.com/contest/2117/problem/C

灵茶の试炼 2025-06-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
把 a 分成若干段，要求：除了最后一段外，每一段的元素必须出现在下一段中。比如 [1,1,2] 的所有元素都在 [1,2,3] 中。
输出最多能把 a 分成多少段。

rating 1200
贪心地，每段越短越好。
第一段就是 a[0]。
第二段是包含 a[0] 的最短子数组。
第三段就是包含第二段所有数的最短子数组，依此类推。
用两个 set 记录上一段和当前段的元素。
不断删除上一段的元素，直到上一段的元素为空，就找到了一个新的段。
代码 https://codeforces.com/problemset/submission/2117/324979299
代码备份（Ubuntu Pastebin）
======

Input
8
6
1 2 2 3 1 5
8
1 2 1 3 2 1 3 2
5
5 4 3 2 1
10
5 8 7 5 8 5 7 8 10 9
3
1 2 2
9
3 3 1 4 3 2 4 1 2
6
4 5 4 5 6 4
8
1 2 1 2 1 2 1 2
Output
2
3
1
3
1
3
3
4
 */
