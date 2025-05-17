import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Function;

public class P3957 {
    static int n, d, k;
    static pair[] a;

    //    static int[][] a; // x, pt
    record pair(int x, int pt) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = scanner.nextInt();
        k = scanner.nextInt();
//        a = new int[n + 1][2];
        a = new pair[n + 1];
        a[0] = new pair(0, 0);
        for (int i = 1; i <= n; i++) {
//            a[i][0] = scanner.nextInt();
//            a[i][1] = scanner.nextInt();
            int x = scanner.nextInt();
            int pt = scanner.nextInt();
            a[i] = new pair(x, pt);
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        int lim = a[n].x - d;
        long[] f = new long[n + 1];
        int ans = sortSearch(lim + 1, g -> {
            int l = Math.max(d - g, 1);
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(0);
            int j = 1;
            for (int i = 1; i <= n; i++) {
                if (a[i].x < l) {
                    f[i] = -INF;
                    continue;
                }
                while (a[j].x <= a[i].x - l) {
                    while (!dq.isEmpty() && f[j] >= f[dq.getLast()]) {
                        dq.removeLast();
                    }
                    dq.add(j);
                    j++;
                }
                while (!dq.isEmpty() && a[dq.getFirst()].x < a[i].x - d - g) {
                    dq.removeFirst();
                }
                if (!dq.isEmpty()) {
                    f[i] = f[dq.getFirst()] + a[i].pt;
                    if (f[i] >= k) {
                        return true;
                    }
                } else {
                    f[i] = -INF;
                }
            }
            return false;
        });
        if (ans > lim) {
            ans = -1;
        }
        return String.valueOf(ans);
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
https://www.luogu.com.cn/problem/P3957

灵茶の试炼 2025-04-17
输入 n(1≤n≤5e5) d(1≤d≤2e3) k(1≤k≤1e9) 和 n 个 pair，每个 pair 输入两个数 xi(1≤xi≤1e9) 和 si(-1e5≤si≤1e5)。保证 xi 是递增的。
坐标轴上有 n 个点，xi 是点的位置，si 是到达这个点可以得到的分数。
在游戏的开始，你可以花费 g 个金币强化你的跳跃能力，使你可以从 x 跳到在 [x+max(d-g,1), x+d+g] 中的点。
注意在游戏的过程中，不能花费金币强化能力。
注意你必须跳到输入的 n 个点中，不能跳到其他位置。
你从原点 0 开始向右跳。
你可以在任意时刻结束游戏。
目标是让总得分 >= k。
输出 g 的最小值。如果无法做到，输出 -1。
提示：请先完成昨天的题目。

g 越大，越能满足要求，反之越无法满足要求。
所以可以二分 g。
对于固定的 g，类似昨天的题目 P1725，从 i 跳到 [max(d-g,1),d+g] 中的位置。注意跳到的位置需要在 x 中。
本题 x 可以达到 1e9，需要用双指针求出哪些 x 在转移来源中。
细节：
如果 x[i] < max(d-g,1)，那么无法从起点跳到 x[i]，所以 f[i] = -inf。
如果转移来源是空的（没有任何位置可以跳到 x[i]，双端队列是空的），那么 f[i] = -inf。
开区间二分上界为 x[n]-d+1，也可以写 1e9。
代码 https://www.luogu.com.cn/paste/b1noyski

# P3957 [NOIP 2017 普及组] 跳房子

## 题目背景

NOIP2017 普及组 T4

## 题目描述

跳房子，也叫跳飞机，是一种世界性的儿童游戏，也是中国民间传统的体育游戏之一。

跳房子的游戏规则如下：

在地面上确定一个起点，然后在起点右侧画 $n$ 个格子，这些格子都在同一条直线上。每个格子内有一个数字（整数），表示到达这个 格子能得到的分数。玩家第一次从起点开始向右跳，跳到起点右侧的一个格子内。第二次再从当前位置继续向右跳，依此类推。规则规定：

玩家每次都必须跳到当前位置右侧的一个格子内。玩家可以在任意时刻结束游戏，获得的分数为曾经到达过的格子中的数字之和。

现在小 R 研发了一款弹跳机器人来参加这个游戏。但是这个机器人有一个非常严重的缺陷，它每次向右弹跳的距离只能为固定的 $d$。小 R 希望改进他的机器人，如果他花 $g$ 个金币改进他的机器人，那么他的机器人灵活性就能增加 $g$，但是需要注意的是，每 次弹跳的距离至少为 $1$。具体而言，当 $g<d$ 时，他的机器人每次可以选择向右弹跳的距离为 $d-g,d-g+1,d-g+2,\ldots,d+g-1,d+g$；否则当 $g \geq d$ 时，他的机器人每次可以选择向右弹跳的距离为 $1,2,3,\ldots,d+g-1,d+g$。

现在小 R 希望获得至少 $k$ 分，请问他至少要花多少金币来改造他的机器人。

## 输入格式

第一行三个正整数 $n,d,k$，分别表示格子的数目，改进前机器人弹跳的固定距离，以及希望至少获得的分数。相邻两个数 之间用一个空格隔开。

接下来 $n$ 行，每行两个整数 $x_i,s_i$，分别表示起点到第 $i$ 个格子的距离以及第 $i$ 个格子的分数。两个数之间用一个空格隔开。保证 $x_i$ 按递增顺序输入。

## 输出格式

共一行，一个整数，表示至少要花多少金币来改造他的机器人。若无论如何他都无法获得至少 $k$ 分，输出 $-1$。

## 输入输出样例 #1

### 输入 #1

```
7 4 10
2 6
5 -3
10 3
11 -3
13 1
17 6
20 2
```

### 输出 #1

```
2
```

## 输入输出样例 #2

### 输入 #2

```
7 4 20
2 6
5 -3
10 3
11 -3
13 1
17 6
20 2
```

### 输出 #2

```
-1
```

## 说明/提示

**样例 1 说明**

花费 $2$ 个金币改进后，小 R 的机器人依次选择的向右弹跳的距离分别为 $ 2, 3, 5, 3, 4,3$，先后到达的位置分别为 $2, 5, 10, 13, 17, 20$，对应 $ 1, 2, 3, 5, 6, 7$ 这 $6$ 个格子。这些格子中的数字之和 $ 15$ 即为小 R 获得的分数。

**样例 2 说明**

由于样例中 $7$ 个格子组合的最大可能数字之和只有 $18$，所以无论如何都无法获得 $20$ 分。

**数据规模与约定**

本题共 10 组测试数据，每组数据等分。

对于全部的数据满足 $1 \le n \le 5\times10^5$，$1 \le d \le2\times10^3$，$1 \le x_i, k \le 10^9$，$|s_i| < 10^5$。

对于第 $1, 2$ 组测试数据，保证 $n\le 10$。

对于第 $3, 4, 5$ 组测试数据，保证 $n \le 500$。

对于第 $6, 7, 8$ 组测试数据，保证 $d = 1$。
 */