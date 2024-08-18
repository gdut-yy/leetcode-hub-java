import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LuoguP1379 {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int M = 3, N = 3;
    static final long FINAL = 123804765;

    private static String solve() {
        long n = Long.parseLong(s);
        Queue<Long> q = new ArrayDeque<>();
        Map<Long, Integer> mp = new HashMap<>();
        q.add(n);
        mp.put(n, 0);
        while (!q.isEmpty()) {
            long x = q.remove();
            int[][] c = new int[M][N];
            int f = 0, g = 0;
            long y = x;
            if (x == FINAL) break;
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    c[i][j] = (int) (y % 10);
                    y /= 10;
                    if (c[i][j] == 0) {
                        f = i;
                        g = j;
                    }
                }
            }
            for (int[] d : DIRECTIONS) {
                int nx = f + d[0];
                int ny = g + d[1];
                long ns = 0;
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    swap(c, nx, ny, f, g);
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < N; j++) {
                            ns = ns * 10 + c[i][j];
                        }
                    }
                    if (!mp.containsKey(ns)) {
                        mp.put(ns, mp.get(x) + 1);
                        q.add(ns);
                    }
                    swap(c, nx, ny, f, g);
                }
            }
        }
        return String.valueOf(mp.get(FINAL));
    }

    static void swap(int[][] c, int x0, int y0, int x1, int y1) {
        int tmp = c[x0][y0];
        c[x0][y0] = c[x1][y1];
        c[x1][y1] = tmp;
    }
}
/*
P1379 八数码难题
https://www.luogu.com.cn/problem/P1379

# 八数码难题

## 题目描述

在 $3\times 3$ 的棋盘上，摆有八个棋子，每个棋子上标有 $1$ 至 $8$ 的某一数字。棋盘中留有一个空格，空格用 $0$ 来表示。空格周围的棋子可以移到空格中。要求解的问题是：给出一种初始布局（初始状态）和目标布局（为了使题目简单,设目标状态为 $123804765$），找到一种最少步骤的移动方法，实现从初始布局到目标布局的转变。

## 输入格式

输入初始状态，一行九个数字，空格用 $0$ 表示。

## 输出格式

只有一行，该行只有一个数字，表示从初始状态到目标状态需要的最少移动次数。保证测试数据中无特殊无法到达目标状态数据。

## 样例 #1

### 样例输入 #1

```
283104765
```

### 样例输出 #1

```
4
```

## 提示

### 样例解释

![](https://cdn.luogu.com.cn/upload/image_hosting/7rhxbnup.png)

图中标有 $0$ 的是空格。绿色格子是空格所在位置，橙色格子是下一步可以移动到空格的位置。如图所示，用四步可以达到目标状态。

并且可以证明，不存在更优的策略。
 */