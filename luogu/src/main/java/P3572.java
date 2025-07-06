import base.Unaccepted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

@Unaccepted
public class P3572 {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve();
        out.flush();
    }

    record pair(int f, int i) {
    }

    private static void solve() {
        int t = scanner.nextInt();
        while (t-- > 0) {
            int k = scanner.nextInt();
            Deque<pair> dq = new ArrayDeque<>();
            dq.addLast(new pair(0, 0));
            for (int i = 1; i < n; i++) {
                if (dq.getFirst().i < i - k) {
                    dq.removeFirst();
                }
                int f = dq.getFirst().f;
                if (a[i] >= a[dq.getFirst().i]) {
                    f++;
                }
                while (!dq.isEmpty() && f < dq.getLast().f || f == dq.getLast().f && a[i] >= a[dq.getLast().i]) {
                    dq.removeLast();
                }
                dq.addLast(new pair(f, i));
            }
            out.println(dq.getLast().f);
        }
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
https://www.luogu.com.cn/problem/P3572

灵茶の试炼 2025-05-08
输入 n(1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入 t(≤25) 和 t 组数据。每组数据输入 k(1≤k≤n-1)。
有 n 棵树，高度从左到右记录在数组 a 中。
有一只鸟，从第一棵树开始飞。
它每次可以从下标 i 飞到下标在 [i+1,i+k] 中的任意一棵树。但如果飞到一棵高度大于等于当前树的树，鸟的疲劳值会增加 1。
输出鸟从第一棵树飞到最后一棵树的最小疲劳值。

本文下标从 0 开始。
从左往右，假设鸟现在在树 i，枚举鸟从左边的树 j 飞过来。于是 0~i 的问题变成 0~j 的子问题。
定义 f[i] 表示鸟从树 0 飞到树 i 的最小疲劳值。
那么有 f[i] = min_j f[j] + (a[j] <= a[i])
其中 j 从 i-k 到 i-1。
只看 min_j f[j] 的话，是个滑动窗口最小值，可以用 单调队列 优化。
但 a[j] <= a[i] 怎么处理？要分 a[j] <= a[i] 和 a[j] > a[i] 两种情况讨论吗？
不需要。在有多个相同 f[j] 的情况下，保证 a[j] 大的在前就行。
如此处理后，可以保证队首是最优转移来源，其余转移来源不会算出比队首更小的 f[j] + (a[j] <= a[i])。（注意 a[j] <= a[i] 只有 0 或者 1）
初始值 f[0] = 0。
答案为 f[n-1]。
代码 https://www.luogu.com.cn/paste/wtwxxlzy

# P3572 [POI 2014] PTA-Little Bird

## 题目描述

有 $n$ 棵树排成一排，第 $i$ 棵树的高度是 $d_i$。

有 $q$ 只鸟要从第 $1$ 棵树到第 $n$ 棵树。

当第 $i$ 只鸟在第 $j$ 棵树时，它可以飞到第 $j+1, j+2, \cdots, j+k_i$ 棵树。

如果一只鸟飞到一颗高度大于等于当前树的树，那么它的劳累值会增加 $1$，否则不会。

由于这些鸟已经体力不支，所以它们想要最小化劳累值。

## 输入格式

第一行输入 $n$。

第二行 $n$ 个数，第 $i$ 个数表示 $d_i$。

第三行输入 $q$。

接下来 $q$ 行，每一行一个整数，第 $i$ 行的整数为 $k_i$。

## 输出格式

共 $q$ 行，每一行输出第 $i$ 只鸟的最小劳累值。

## 输入输出样例 #1

### 输入 #1

```
9
4 6 3 6 3 7 2 6 5
2
2
5
```

### 输出 #1

```
2
1
```

## 说明/提示

$1 \le n \le 10^6$，$1 \le d_i \le 10^9$，$1 \le q \le 25$，$1 \le k_i \le n - 1$。
 */