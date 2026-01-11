import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class P10723 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        if (n == 1) {
            out.print(0);
            return;
        }

        int[] a = new int[n];
        int ans = n;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            ans -= a[i];
        }

        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
            deg[v]++;
            deg[w]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && a[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            ans--;
            int v = q.poll();
            if (g[v] != null) {
                for (int w : g[v]) {
                    if (a[w] > 0) {
                        continue;
                    }
                    deg[w]--;
                    if (deg[w] == 1) {
                        q.offer(w);
                    }
                }
            }
        }

        out.print(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P10723

灵茶の试炼 2026-01-06
输入 n(1≤n≤1e5) 和长为 n 的 01 数组 a。
然后输入一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
节点 i 的颜色为 a[i]，0 表示白色，1 表示黑色。
你需要把树上的某些节点涂黑，使得删除所有白色节点之后，剩余节点仍然组成一棵树。
输出最少需要把多少个节点从白色变成黑色。
注：0 个节点也是树。

用拓扑排序剥洋葱，去掉外面的白色节点。
剩余的节点都要染成黑色。
可能需要特判 n=1 的情况（取决于拓扑排序的写法），此时节点无论是白还是黑都无需操作，输出 0。
代码 https://paste.ubuntu.com/p/KNS53RJ2HH/
======
# P10723 [GESP202406 七级] 黑白翻转

## 题目描述

小杨有一棵包含 $n$ 个节点的树，这棵树上的任意一个节点要么是白色，要么是黑色。小杨认为一棵树是美丽树当且仅当在删除所有白色节点之后，剩余节点仍然组成一棵树。

小杨每次操作可以选择一个白色节点将它的颜色变为黑色，他想知道自己最少要执行多少次操作可以使得这棵树变为美丽树。

## 输入格式

第一行包含一个正整数 $n$，代表树的节点数。

第二行包含 $n$ 个非负整数 $a_1,a_2,\ldots,a_n$，其中如果 $a_i=0$，则节点 $i$ 的颜色为白色，否则为黑色。

之后 $n-1$ 行，每行包含两个正整数 $x_i,y_i$，代表存在一条连接节点 $x_i$ 和 $y_i$ 的边。

## 输出格式

输出一个整数，代表最少执行的操作次数。

## 输入输出样例 #1

### 输入 #1

```
5
0 1 0 1 0
1 2
1 3
3 4
3 5

```

### 输出 #1

```
2
```

## 说明/提示

### 样例解释

将节点 $1$ 和 $3$ 变为黑色即可使这棵树变为美丽树，此时删除白色节点 $5$，剩余黑色节点仍然组成一棵树。

### 数据范围
子任务编号|数据点占比|$n$ |$a_i$ |特殊条件
:-:|:-:|:-:|:-:|:-:
$1$|$30\%$ |$\leq 10^5$ | $0\leq a_i\leq 1$|树的形态为一条链
$2$|$30\%$ | $\leq 10^5$ | $0\leq a_i\leq 1$| 只有两个节点颜色为黑色
$3$|$40\%$|$\leq 10^5$|$0\leq a_i\leq 1$|

对于全部数据，保证有 $1\leq n\leq 10^5$，$0\leq a_i\leq 1$。
 */