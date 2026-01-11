import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P1282 {
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
        int bias = n * 5;

        int[] f = new int[bias * 2 + 1];
        Arrays.fill(f, INF);
        f[bias] = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int[] nf = new int[f.length];
            Arrays.fill(nf, INF);

            int d = x - y;
            for (int j = bias - i * 5; j <= bias + i * 5; j++) {
                if (f[j] < INF) {
                    nf[j + d] = Math.min(nf[j + d], f[j]);
                    nf[j - d] = Math.min(nf[j - d], f[j] + 1);
                }
            }
            f = nf;
        }

        for (int i = 0; i <= bias; i++) {
            int ans = Math.min(f[bias - i], f[bias + i]);
            if (ans < INF) {
                out.println(ans);
                break;
            }
        }
    }
}
/*
https://www.luogu.com.cn/problem/P1282

灵茶の试炼 2025-12-09
输入 n(1≤n≤1000) 和 n 行 2 列的矩阵，元素范围 [1,6]。
你可以交换每行的两个数。
你需要最小化 |第一列的和 - 第二列的和|。
输出最小交换次数。

设 d = 第一列的和 - 第二列的和（没有绝对值）。
我们需要知道：
能否让 d = 0？至少要交换多少次？
能否让 d = ±1？至少要交换多少次？
能否让 d = ±2？至少要交换多少次？
……
想一想，最后一步发生了什么？是否交换？子问题是什么？
是否交换类似选或不选，最终得到的 d 类似背包容量，所以本题类似 0-1 背包。
定义 f[i][j] 表示让前 i 行的「第一列的和 - 第二列的和」= j 的最小交换次数。
这里查表法刷表法都可以，我用的刷表法。
设 x = 第 i 行的两数之差（左边减右边）。
不交换：用 f[i][j] 更新 f[i+1][j+x] 的最小值。
交换：用 f[i][j]+1 更新 f[i+1][j-x] 的最小值。
初始值 f[i][j] = inf，除了 f[0][0] = 0。
答案：先找到满足 f[i][j] < inf 的最小的 |j|，然后输出 min(f[i][j], f[i][-j])。
为避免负数下标，可以把所有 j 都增加（偏移）n*5。
代码 https://paste.ubuntu.com/p/fH4KQqDt9x/
======
# P1282 多米诺骨牌

## 题目描述

多米诺骨牌由上下 $2$ 个方块组成，每个方块中有 $1\sim6$ 个点。现有排成行的上方块中点数之和记为 $S_1$，下方块中点数之和记为 $S_2$，它们的差为 $\left|S_1-S_2\right|$。如图，$S1=6+1+1+1=9$，$S2=1+5+3+2=11$，$\left|S_1-S_2\right|=2$。每个多米诺骨牌可以旋转 $180°$，使得上下两个方块互换位置。请你计算最少旋转多少次才能使多米诺骨牌上下 $2$ 行点数之差达到最小。

![](https://cdn.luogu.com.cn/upload/pic/91.png)

对于图中的例子，只要将最后一个多米诺骨牌旋转 $180°$，即可使上下 $2$ 行点数之差为 $0$。

## 输入格式

输入文件的第一行是一个正整数 $n(1\leq n\leq 1000)$，表示多米诺骨牌数。接下来的 $n$ 行表示 $n$ 个多米诺骨牌的点数。每行有两个用空格隔开的正整数，表示多米诺骨牌上下方块中的点数 $a$ 和 $b$，且 $1\leq a,b\leq 6$。

## 输出格式

输出文件仅一行，包含一个整数。表示求得的最小旋转次数。

## 输入输出样例 #1

### 输入 #1

```
4
6 1
1 5
1 3
1 2

```

### 输出 #1

```
1

```
 */