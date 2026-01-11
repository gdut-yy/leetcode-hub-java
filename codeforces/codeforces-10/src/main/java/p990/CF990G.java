package p990;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF990G {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MX = 200001;

    static int[] cnt = new int[MX];
    static int[] time = new int[MX];
    static int[] fa = new int[MX];
    static long[] size = new long[MX];
    static long[] f = new long[MX];
    static ArrayList<int[]>[] es = new ArrayList[MX];
    static int now;

    public static int find(int x) {
        int rt = x;
        while (true) {
            if (time[rt] != now) {
                time[rt] = now;
                fa[rt] = rt;
                size[rt] = 1;
            }
            if (fa[rt] == rt) {
                break;
            }
            rt = fa[rt];
        }
        int temp = x;
        while (fa[temp] != rt) {
            int next = fa[temp];
            fa[temp] = rt;
            temp = next;
        }
        return rt;
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            cnt[a[i]]++;
        }

        Arrays.setAll(es, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int g = getGCD(a[v], a[w]);
            es[g].add(new int[]{v, w});
        }

        for (int i = MX - 1; i > 0; i--) {
            now = i;
            for (int j = i; j < MX; j += i) {
                for (int[] e : es[j]) {
                    int x = find(e[0]);
                    int y = find(e[1]);
                    if (x != y) {
                        f[i] += size[x] * size[y];
                        size[x] += size[y];
                        fa[y] = x;
                    }
                }
            }
            for (int j = i * 2; j < MX; j += i) {
                f[i] -= f[j];
            }
        }

        for (int i = 0; i < MX; i++) {
            f[i] += cnt[i];
            if (f[i] > 0) {
                out.println(i + " " + f[i]);
            }
        }
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
G. GCD Counting
https://codeforces.com/contest/990/problem/G

灵茶の试炼 2025-09-05
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。
然后输入一棵无向树的 n-1 条边，节点编号从 1 到 n。节点 i 的点权为 a[i]。
对于每个满足 x ≤ y 的节点对 (x,y)，计算从 x 到 y 的简单路径的点权 GCD。
定义 f(i) 表示 GCD 等于 i 的简单路径个数。
对于每个 [1,2e5] 中的 i，如果 f(i) > 0，输出 i 和 f(i)。

rating 2400
推荐先完成更简单的 LC3312. 查询排序后的最大公约数，下面接着题解继续讲，只讲不同之处。
本题要求 x <= y，我们可以先算出 x < y 的方案数，再加上 x = y（即一个点）的方案数，即点权的出现次数。
定义 f[i] 表示路径点权 GCD 是 i 的倍数的简单路径个数。路径至少包含 2 个点。
对于点权均为 i 的倍数的相邻节点，用并查集连起来，那么每个连通块可以任选两个点，对应的简单路径 GCD 也是 i 的倍数。方案数为 C(连通块大小, 2)，加到 f[i] 中。
注：对于每个 i，独立创建并查集。
然后用 LC3312 的方法容斥计算。
但这样做，需要枚举点权为 i 的倍数的节点 v，然后枚举 v 的邻居 w，如果 a[w] 不是 i 的倍数，就是无效枚举了。
为避免无效枚举，可以定义 v-w 的边权为 gcd(a[v],a[w])，按照边权分组。那么边权是 i 的倍数的边，就一定会被并查集合并，这样就没有无效枚举了。
另一个技巧是，为避免反复初始化并查集，可以用时间戳标记是否需要初始化，具体见代码。
时间复杂度：每条边权为 g 的边会被 g 的因子枚举到，因子个数可以用开立方估计，所计算量大致为 O(cbrt(2e5) * n)。
代码 https://codeforces.com/contest/990/submission/335538370
代码备份（上面打不开的同学看这个）
======

Input
3
1 2 3
1 2
2 3
Output
1 4
2 1
3 1

Input
6
1 2 4 8 16 32
1 6
6 3
3 4
4 2
6 5
Output
1 6
2 5
4 6
8 1
16 2
32 1

Input
4
9 16 144 6
1 3
2 3
4 3
Output
1 1
2 1
3 1
6 2
9 2
16 2
144 1
 */
