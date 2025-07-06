import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1352 {
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
            int w = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = dfs(0, -1);
        return String.valueOf(Math.max(ans[0], ans[1]));
    }

    static int[] dfs(int v, int fa) {
        int chosen = a[v];
        int notChosen = 0;
        for (Integer w : g[v]) {
            if (w != fa) {
                int[] sub = dfs(w, v);
                int nc = sub[0], c = sub[1];
                notChosen += Math.max(nc, c);
                chosen += nc;
            }
        }
        return new int[]{notChosen, chosen};
    }
}
/*
# P1352 没有上司的舞会
https://www.luogu.com.cn/problem/P1352

## 题目描述

某大学有 $n$ 个职员，编号为 $1\ldots n$。

他们之间有从属关系，也就是说他们的关系就像一棵以校长为根的树，父结点就是子结点的直接上司。

现在有个周年庆宴会，宴会每邀请来一个职员都会增加一定的快乐指数 $r_i$，但是呢，如果某个职员的直接上司来参加舞会了，那么这个职员就无论如何也不肯来参加舞会了。

所以，请你编程计算，邀请哪些职员可以使快乐指数最大，求最大的快乐指数。

## 输入格式

输入的第一行是一个整数 $n$。

第 $2$ 到第 $(n + 1)$ 行，每行一个整数，第 $(i+1)$ 行的整数表示 $i$ 号职员的快乐指数 $r_i$。

第 $(n + 2)$ 到第 $2n$ 行，每行输入一对整数 $l, k$，代表 $k$ 是 $l$ 的直接上司。

## 输出格式

输出一行一个整数代表最大的快乐指数。

## 输入输出样例 #1

### 输入 #1

```
7
1
1
1
1
1
1
1
1 3
2 3
6 4
7 4
4 5
3 5
```

### 输出 #1

```
5
```

## 说明/提示

#### 数据规模与约定

对于 $100\%$ 的数据，保证 $1\leq n \leq 6 \times 10^3$，$-128 \leq r_i\leq 127$，$1 \leq l, k \leq n$，且给出的关系一定是一棵树。
 */