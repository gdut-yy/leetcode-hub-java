import java.io.PrintWriter;
import java.util.Scanner;

public class P10719 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int INF = (int) 1e9;

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = INF;
        String[] a = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
            int[] sum = new int[m];

            for (int up = i; up >= 0; up--) {
                int s = 0, l = 0;
                for (int j = 0; j < m; j++) {
                    sum[j] += (a[up].charAt(j) & 1);
                    s += sum[j];

                    while (s >= k) {
                        ans = Math.min(ans, (i - up + 1) * (j - l + 1));
                        s -= sum[l];
                        l++;
                    }
                }
            }
        }

        if (ans == INF) {
            ans = 0;
        }

        out.print(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P10719

灵茶の试炼 2026-01-05
输入 n m(1≤n,m≤100) k(1≤k≤n*m) 和 n 行 m 列的 01 矩阵。
找到一个最小的子矩阵，包含至少 k 个 1。
输出子矩阵的大小（长*宽）。如果不存在这样的子矩阵，输出 0。

枚举子矩阵的上下边界，同时维护每一列的和，把问题变成一维问题。
一维问题：求满足和 >= k 的连续子数组的最小长度 * 子矩阵的高。
这是标准的不定长滑动窗口，做法同 LC209. 长度最小的子数组。
时间复杂度：O(n^2 * m)。
代码 https://paste.ubuntu.com/p/YWcV4ZrJ4R/
======
# P10719 [GESP202406 五级] 黑白格

## 题目描述

小杨有一个 $n$ 行 $m$ 列的网格图，其中每个格子要么是白色，要么是黑色。

小杨想知道至少包含 $k$ 个黑色格子的最小子矩形包含了多少个格子。

## 输入格式

第一行包含三个正整数 $n,m,k$，含义如题面所示。

之后 $n$ 行，每行⼀个长度为 $m$ 的 $\texttt{01}$ 串，代表网格图第 $i$ 行格子的颜色，如果为 $\texttt{0}$，则对应格子为白色，否则为黑色。

## 输出格式

输出一个整数，代表至少包含 $k$ 个黑色格子的最小子矩形包含格子的数量，如果不存在则输出 $0$。

## 输入输出样例 #1

### 输入 #1

```
4 5 5
00000
01111
00011
00011
```

### 输出 #1

```
6
```

## 说明/提示

#### 样例解释

对于样例 $1$，假设 $(i,j)$ 代表第 $i$ 行第 $j$ 列，至少包含 $5$ 个黑色格子的最小子矩形的四个顶点为 $(2,4)$，$(2,5)$，$(4,4)$，$(4,5)$，共包含 $6$ 个格子。

#### 数据范围

对于全部数据，保证有 $1\le n,m\le 100$，$1\le k\le n\times m$。

| 子任务编号 | 得分 | $n,m$ |
| :--: | :--: | :--: |
| $1$ | $20$ | $\le 10$  |
| $2$ | $40$ | $n=1$，$1\le m\le 100$ |
| $3$ | $40$ | $\le 100$|

Update on 2024/7/9：添加了若干组 hack 数据，感谢 @cff_0102 的贡献。
 */