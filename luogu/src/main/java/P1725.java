import base.Unaccepted;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

@Unaccepted
public class P1725 {
    static int n, l, r;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] f = new long[n + 1];
        for (int i = 1; i < l; i++) {
            f[i] = -INF;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = l; i <= n; i++) {
            while (!dq.isEmpty() && f[i - l] >= f[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i - l);
            if (dq.getFirst() < i - r) {
                dq.removeFirst();
            }
            f[i] = f[dq.getFirst()] + a[i];
        }
        long ans = f[n - r + 1];
        for (int i = n - r + 1; i < f.length; i++) {
            ans = Math.max(ans, f[i]);
        }
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P1725

灵茶の试炼 2025-04-16
输入 n L R(1≤L≤R≤n≤2e5) 和长为 n+1 的数组 a(-1e3≤a[i]≤1e3)，下标从 0 开始。保证 a[0]=0。
有 n+1 个格子，编号从 0 到 n。
你从 0 号格子向右跳。如果你在格子 i，可以跳到编号 [i+L,i+R] 中的任意格子。
跳到格子 i 后，总得分增加 a[i]。
如果跳出界（i>n），游戏结束。
输出游戏结束后的最大总得分。

本题可以刷表法，用 f[i]+a[i] 更新 f[i+L] 到 f[i+R] 的最大值，需要 lazy 线段树。
也可以查表法，用 f[i-R] 到 f[i-L] 更新 f[i]，需要单调队列。下面说这个怎么做。
定义 f[i] 表示到达格子 i 得到的最大分数（包含 a[i]）。
那么有
f[i] = {f[i-R] 到 f[i-L] 的最大值} + a[i]。
f[i-R] 到 f[i-L] 的最大值，即 239. 滑动窗口最大值。
初始值：f[0]=0，f[1] 到 f[L-1] 初始化成 -inf，因为无法到达。
答案：f[n-R+1] 到 f[n] 的最大值。
代码 https://www.luogu.com.cn/paste/n4w8nhau

# P1725 琪露诺

## 题目描述

在幻想乡，琪露诺是以笨蛋闻名的冰之妖精。

某一天，琪露诺又在玩速冻青蛙，就是用冰把青蛙瞬间冻起来。但是这只青蛙比以往的要聪明许多，在琪露诺来之前就已经跑到了河的对岸。于是琪露诺决定到河岸去追青蛙。

小河可以看作一列格子依次编号为 $0$ 到 $N$，琪露诺只能从编号小的格子移动到编号大的格子。而且琪露诺按照一种特殊的方式进行移动，当她在格子 $i$ 时，她只移动到区间 $[i+L,i+R]$ 中的任意一格。你问为什么她这么移动，这还不简单，因为她是笨蛋啊。

每一个格子都有一个冰冻指数 $A_i$，编号为 $0$ 的格子冰冻指数为 $0$。当琪露诺停留在那一格时就可以得到那一格的冰冻指数 $A_i$。琪露诺希望能够在到达对岸时，获取最大的冰冻指数，这样她才能狠狠地教训那只青蛙。

但是由于她实在是太笨了，所以她决定拜托你帮它决定怎样前进。

开始时，琪露诺在编号 $0$ 的格子上，只要她下一步的位置编号大于 $N$ 就算到达对岸。

## 输入格式

第一行三个正整数 $N, L, R$。

第二行共 $N+1$ 个整数，第 $i$ 个数表示编号为 $i-1$ 的格子的冰冻指数 $A_{i-1}$。

## 输出格式

一个整数，表示最大冰冻指数。

## 输入输出样例 #1

### 输入 #1

```
5 2 3
0 12 3 11 7 -2
```

### 输出 #1

```
11
```

## 说明/提示

对于 $60\%$ 的数据，$N \le 10^4$。

对于 $100\%$ 的数据，$N \le 2\times 10^5$，$-10^3 \le  A_i\le 10^3 $，$1 \le L \le R \le N $。数据保证最终答案不超过 $2^{31}-1$。
 */