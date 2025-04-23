package c163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc163_f {
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static long[] ans;
    static int[] size;

    private static String solve() {
        ans = new long[n];
        size = new int[n];
        dfs(0, -1);

        for (int i = 0; i < n; i++) {
            long s = ans[i];
            int m = n - size[i];
            ans[i] = n * (n + 1L) / 2 - s - m * (m + 1L) / 2;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int dfs(int v, int fa) {
        int c = a[v] - 1;
        int old = size[c];
        int sz = 1;
        for (Integer w : g[v]) {
            if (w == fa) continue;
            size[c] = 0;
            int szW = dfs(w, v);
            sz += szW;
            long m = szW - size[c];
            ans[c] += m * (m + 1) / 2;
        }
        size[c] = old + sz;
        return sz;
    }
}
/*
F - path pass i
https://atcoder.jp/contests/abc163/tasks/abc163_f

灵茶の试炼 2025-02-21
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
然后输入一棵无向树的 n-1 条边，节点编号从 1 到 n。
节点 i 的颜色是 a[i]。
定义 f(c) = 包含颜色 c 的简单路径的数目。注：只有 1 个点也算路径。
输出 f(1),f(2),...,f(n)。

正难则反，计算不包含颜色 c 的简单路径数。
所有路径数减去不包含颜色 c 的路径数就是答案。
去掉颜色 c 节点后，树分成了若干连通块。
对于大小为 m 的连通块，其中有 m*(m+1)/2 条简单路径。
如何快速计算各个连通块的大小？
如图，去掉粉色节点后，考虑包含节点 y 的连通块，它的大小等于：
子树 y 的大小，减去子树 z1,z2,z3 的大小之和。
如何计算子树 z1,z2,z3 的大小之和？
额外用一个数组 size[c] 记录以颜色 c 为根的子树的大小之和。
这对吗？考虑 x 更上面的节点，这样做 z1,z2,z3 的子树大小岂不是会和 x 的子树大小相加？
为了避免重复累加子树大小，直接用子树 x 的大小「覆盖」子树 z1,z2,z3 的大小之和。
具体来说，在 dfs(x) 的开头，用临时变量 old 记录 size[c]；在 dfs(x) 的末尾，覆盖 size[c] = old + 子树 x 的大小。
代码 https://atcoder.jp/contests/abc163/submissions/62212336
======

Input 1
3
1 2 1
1 2
2 3
Output 1
5
4
0

Input 2
1
1
Output 2
1

Input 3
2
1 2
1 2
Output 3
2
2

Input 4
5
1 2 3 4 5
1 2
2 3
3 4
3 5
Output 4
5
8
10
5
5

Input 5
8
2 7 2 5 4 1 7 5
3 1
1 2
2 7
4 5
5 6
6 8
7 8
Output 5
18
15
0
14
23
0
23
0
 */
