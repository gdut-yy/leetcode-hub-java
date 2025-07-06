package p2101;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2101C {
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
        int[] pre = f();
        reverse(a);
        int[] suf = f();

        long ans = 0;
        for (int i = 0; i < pre.length; i++) {
            ans += Math.max(n - 1 - suf[i] - pre[i], 0);
        }
        out.println(ans);
    }

    static int[] f() {
        List<Integer> pos = new ArrayList<>();
        DSU dsu = new DSU(n + 1);
        for (int i = 0; i < n; i++) {
            int l = dsu.find(a[i]);
            if (l > 0) {
                pos.add(i);
                dsu.fa[l] = l - 1;
            }
        }
        return pos.stream().mapToInt(Integer::intValue).toArray();
    }

    static void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }
}
/*
C. 23 Kingdom
https://codeforces.com/contest/2101/problem/C

灵茶の试炼 2025-06-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
构造数组 b，满足 1≤b[i]≤a[i]。
定义 d(x) 为 b 中最左边的元素 x 的下标与最右边的元素 x 的下标的绝对差。如果 x 不在 b 中，则 d(x)=0。
输出 d(1)+d(2)+...+d(n) 的最大值。

rating 2200
假设有 k 对相等元素，每对元素左边那个数的下标记录在列表 L 中，右边那个数的下标记录在列表 R 中，那么答案（式子变形后）就是
(R[0] + R[1] + R[2] + ... R[k-1]) - (L[0] + L[1] + L[2] + ... + L[k-1])
由此可见，左边元素与右边元素是【互相独立】的，可以分别计算。
对于 L 来说，维护一个未选集合 S=1~n。从左到右遍历 a，贪心地，我们选择 <= a[i] 的最大的未选数，（如果有这样的数就）从 S 中删除这个数，记录下标 i 到列表 L 中。
对于 R 同理，倒着遍历 a 计算。
代码实现时，用并查集维护下一个未被删除的元素，效率比有序集合 set 高。
计算答案时如果 L[i] >= R[i] 则退出循环。
代码 https://codeforces.com/contest/2101/submission/324969012
代码备份（Ubuntu Pastebin）
======

Input
4
4
1 2 1 2
2
2 2
10
1 2 1 5 1 2 2 1 1 2
8
1 5 2 8 4 1 4 2
Output
4
1
16
16
 */