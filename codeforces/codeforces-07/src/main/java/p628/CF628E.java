package p628;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF628E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    static class V1 {
        static int n, m;
        static int[] t;
        static int[] time;
        static int now;

        private static void solve() {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] emptyL = new int[n][m];
            int[][] emptyR = new int[n][m];

            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                int p = -1;
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == '.') {
                        p = j;
                    }
                    emptyL[i][j] = p;
                }

                p = m;
                for (int j = m - 1; j >= 0; j--) {
                    if (s.charAt(j) == '.') {
                        p = j;
                    }
                    emptyR[i][j] = p;
                }
            }

            t = new int[m + 1];
            time = new int[m + 1];
            now = 0;

            long ans = 0;
            for (int K = 0; K < n + m - 1; K++) {
                Map<Integer, List<Integer>> delTodo = new HashMap<>();
                now++;

                for (int j = Math.min(K, m - 1); j >= Math.max(K - n + 1, 0); j--) {
                    int i = K - j;
                    int r = emptyR[i][j];

                    if (r == j) {
                        delTodo = new HashMap<>();
                        now++;
                        continue;
                    }

                    add(j, 0);
                    ans += pre(r);
                    int l = emptyL[i][j] + 1;

                    delTodo.putIfAbsent(l, new ArrayList<>());
                    delTodo.get(l).add(j);

                    if (delTodo.containsKey(j)) {
                        for (int jj : delTodo.get(j)) {
                            del(jj, 0);
                        }
                    }
                }
            }
            out.print(ans);
        }

        static void add(int i, int value) {
            for (int j = i + 1; j <= m; j += j & -j) {
                if (time[j] < now) {
                    time[j] = now;
                    t[j] = 0;
                }
                t[j]++;
            }
        }

        static void del(int i, int value) {
            for (int j = i + 1; j <= m; j += j & -j) {
                if (time[j] == now) {
                    t[j]--;
                }
            }
        }

        static int pre(int i) {
            int res = 0;
            for (int j = i; j > 0; j &= j - 1) {
                if (time[j] == now) {
                    res += t[j];
                }
            }
            return res;
        }
    }

    static class V2 {
        private static void solve() {
            n = scanner.nextInt();
            m = scanner.nextInt();

            emptyL = new int[n][m];
            emptyR = new int[n][m];

            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                int p = -1;
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == '.') {
                        p = j;
                    }
                    emptyL[i][j] = p;
                }

                p = m;
                for (int j = m - 1; j >= 0; j--) {
                    if (s.charAt(j) == '.') {
                        p = j;
                    }
                    emptyR[i][j] = p;
                }
            }

            t = new int[m + 1];
            time = new int[m + 1];
            delTodo = new ArrayList[m + 1];
            for (int i = 0; i <= m; i++) {
                delTodo[i] = new ArrayList<>();
            }
            keys = new ArrayList<>();

            for (int K = 0; K < n + m - 1; K++) {
                clear();
                for (int j = Math.min(K, m - 1); j >= Math.max(K - n + 1, 0); j--) {
                    int i = K - j;
                    int r = emptyR[i][j];
                    if (r == j) {
                        clear();
                        continue;
                    }
                    add(j + 1);
                    ans += pre(r);
                    int l = emptyL[i][j] + 1;
                    delTodo[l].add(j + 1);
                    keys.add(l);
                    for (int idx : delTodo[j]) {
                        del(idx);
                    }
                }
            }

            out.println(ans);
        }

        static int n, m;
        static long ans;
        static int[][] emptyL, emptyR;
        static int[] t, time;
        static int now;
        static List<Integer>[] delTodo;
        static List<Integer> keys;

        static void add(int i) {
            for (; i <= m; i += i & -i) {
                if (time[i] < now) {
                    time[i] = now;
                    t[i] = 0;
                }
                t[i]++;
            }
        }

        static void del(int i) {
            for (; i <= m; i += i & -i) {
                t[i]--;
            }
        }

        static int pre(int i) {
            int res = 0;
            for (; i > 0; i &= i - 1) {
                if (time[i] == now) {
                    res += t[i];
                }
            }
            return res;
        }

        static void clear() {
            now++;
            for (int l : keys) {
                delTodo[l].clear();
            }
            keys.clear();
        }
    }
}
/*
E. Zbazi in Zeydabad
https://codeforces.com/contest/628/problem/E

灵茶の试炼 2025-09-04
题目大意：
输入 n m(1≤n,m≤3000) 和一个 n 行 m 列的网格图，只包含 '.' 和 'z'。
定义「Z 图案」为网格图中的子正方形，它的第一行、最后一行和反对角线都是 'z'。
注意：对于 Z 图案的其余单元格，没有限制，可以是 '.' 或者 'z'。
特别地，Z 图案的大小可以是 1，即只有一个 'z'。
输出这个网格图有多少个 Z 图案。

rating 2300
Z 图案由一条上水平线 + 一条反对角线 + 一条下水平线组成。每条线都必须全为 z。
考虑枚举中间，即枚举每条反对角线。
对于每条反对角线，我的做法是从右上往左下枚举反对角线上的点。如何枚举反对角线见【模板】遍历对角线。https://docs.qq.com/scenario/link.html?url=https%3A%2F%2Fleetcode.cn%2Fproblems%2Fdiagonal-traverse%2Fsolutions%2F3762798%2Fmo-ban-bian-li-dui-jiao-xian-pythonjavac-jnky%2F&pid=300000000%24XahDeYFlMiqs&cid=144115263182171511&nlc=1
假设现在枚举到了某条反对角线的点 (i,j)，把这个点当作 Z 图形左下角的点，即下水平线的左端点。
如果 a[i][j] 是空，那么断开了，我们重置所有统计数据。
如果 a[i][j] 是 z，那么：
设 (i,j) 往右最远连续 z 的位置是 (i,r)，即下水平线的右端点的最大值。
那么上水平线需要满足：
1. 上水平线的左端点的列号 <= j。
2. 上水平线的右端点的列号 <= r。
想一想，用什么数据结构维护？如何快速计算满足该要求的上水平线的个数？
用树状数组维护。
当我们遍历到 a[i][j]=z 时，把这个 (i,j) 当作上水平线的右端点。执行树状数组的 update(j, 1)。
设 (i,j) 往左最远的 z 的位置是 (i,L)。那么加一个标记：当我们后面遍历到 j=L 时，删除这个记录。
为此，需要创建一个 delTodo 二维列表，往 delTodo[L] 中添加 j。当我们后面遍历到 j=L 时，对 delTodo[L] 中的所有下标 k，执行树状数组的 update(k, -1)。
准备好这些数据后，再来看我们的要求：
1. 左端点的列号需要 <= j。我们通过 delTodo 维护，删除了过期数据，这个条件自动满足。
2. 右端点的列号 <= r。在树状数组中查询前缀和即可，即 [1,r] 的元素和。
最后来说一个技巧，前文提到，当 a[i][j] 是空时，要「重置一切」。
一种方法是把 delTodo 中的所有下标都执行树状数组的 update(k, -1)。
不想再花 O(log) 时间执行 update 怎么办？另一种方法是用时间戳懒更新，具体见代码。
注：很多人写的代码都额外维护了反对角线的 z 的个数，但这是多余的。
写法一 map（简洁，但是慢） https://codeforces.com/problemset/submission/628/336248010
写法二 列表+clear（快） https://codeforces.com/problemset/submission/628/336247329
代码备份（上面打不开的同学看这个）
======

Input
4 4
zzzz
zzz.
.z..
zzzz
Output
16

Input
1 4
z.z.
Output
2

Input
2 2
zz
zz
Output
5
 */