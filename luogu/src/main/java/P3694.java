import base.Unaccepted;

import java.util.Scanner;

@Unaccepted
public class P3694 {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] sum = new int[n + 1][20];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            sum[i] = sum[i - 1].clone();
            sum[i][v - 1]++;
        }

        int u = 1 << m;
        int[] sz = new int[u];
        for (int i = 0; i < m; i++) {
            int v = sum[n][i];
            int highBit = 1 << i;
            for (int mask = 0; mask < highBit; mask++) {
                int s = sz[mask];
                sz[highBit | mask] = s + v;
            }
        }

        int[] f = new int[u];
        for (int s = 0; s < u; s++) {
            int fs = f[s];
            // for cus, lb := u-1^s, 0; cus > 0; cus ^= lb {
            for (int cus = u - 1 ^ s, lb = 0; cus > 0; cus ^= lb) {
                lb = cus & -cus;
                int ns = s | lb;
                int p = Integer.numberOfTrailingZeros(lb);
                f[ns] = Math.max(f[ns], fs + sum[sz[ns]][p] - sum[sz[s]][p]);
            }
        }

        int ans = n - f[u - 1];
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/P3694

灵茶の试炼 2025-05-01
输入 n(1≤n≤1e5) m(1≤m≤20) 和长为 n 的数组 a(1≤a[i]≤m)。
n 个偶像排成一行，第 i 个偶像来自第 a[i] 个乐队。每个乐队至少有一个偶像。
重排这 n 个偶像，使得来自同一乐队的偶像连续的站在一起。
最小化需要改变位置的人数。

状压 DP 之相邻无关全排列 DP。
关键思路：
每个乐队的人数已知。
对于固定的排列方式，每个乐队站在哪个范围是可以确定的。
用前缀和可以求出原数组的一段范围中的乐队人数。
计算最多保留多少个人不变，最后用 n 减去答案。
f[i] 表示前面排的是乐队集合 i 的情况下，最多保留多少个人不变。
考虑刷表法，枚举下一个乐队是第 j 个乐队（j 不在 i 中），用前缀和求出 a 数组的对应范围中的第 j 个乐队的人数。对应范围可以通过乐队集合 i 的总人数，以及第 j 个乐队的总人数求得。
那么有 f[i|j] <- f[i] + 范围中的第 j 个乐队的人数（用最大值更新）。
代码 https://www.luogu.com.cn/paste/5xuu39nf

# P3694 邦邦的大合唱站队

## 题目背景

BanG Dream!里的所有偶像乐队要一起大合唱，不过在排队上出了一些问题。

## 题目描述

$N$ 个偶像排成一列，他们来自 $M$ 个不同的乐队。每个团队至少有一个偶像。

现在要求重新安排队列，使来自同一乐队的偶像连续的站在一起。重新安排的办法是，让若干偶像出列（剩下的偶像不动），然后让出列的偶像一个个归队到原来的空位，归队的位置任意。

请问最少让多少偶像出列？

## 输入格式

第一行 $2$ 个整数 $N,M$。

接下来 $N$ 行，每行一个整数 $a_i(1\le a_i \le M)$，表示队列中第 $i$ 个偶像的团队编号。

## 输出格式

一个整数，表示答案

## 输入输出样例 #1

### 输入 #1

```
12 4
1
3
2
4
2
1
2
3
1
1
3
4
```

### 输出 #1

```
7
```

## 说明/提示

【样例解释】

```cpp
1  3   √
3  3
2  3   √
4  4
2  4   √
1  2   √
2  2
3  2   √
1  1
1  1
3  1   √
4  1   √
```
【数据规模】

对于20%的数据，$N\le 20, M=2$

对于40%的数据，$N\le 100, M\le 4$

对于70%的数据，$N\le 2000, M\le 10$

对于全部数据，$1\le N\le 10^5, M\le 20$
 */