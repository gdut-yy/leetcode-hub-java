import base.Unaccepted;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Unaccepted
public class P1966 {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        a = f(a);
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            p[x] = i;
        }
        b = f(b);
        for (int i = 0; i < n; i++) {
            int v = b[i];
            b[i] = p[v];
        }
        long ans = mergeCount(b) % ((int) 1e8 - 3);
        return String.valueOf(ans);
    }

    static int[] f(int[] a) {
        int m = 0;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int v : a) {
            mp.put(v, 1);
        }
        for (Map.Entry<Integer, Integer> p : mp.entrySet()) p.setValue(m++);
        int[] A = new int[m];
//        for (Map.Entry<Integer, Integer> p : mp.entrySet()) A[p.getValue()] = p.getKey();
        for (int i = 0; i < n; i++) A[i] = mp.get(a[i]);
        return A;
    }

    static int mergeCount(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return 0;
        }
        int[] left = Arrays.copyOfRange(a, 0, n / 2);
        int[] right = Arrays.copyOfRange(a, n / 2, n);
        int cnt = mergeCount(left) + mergeCount(right);
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (l < left.length && (r == right.length || left[l] <= right[r])) {
                a[i] = left[l];
                l++;
            } else {
                cnt += n / 2 - l;
                a[i] = right[r];
                r++;
            }
        }
        return cnt;
    }
}
/*
https://www.luogu.com.cn/problem/P1966

灵茶の试炼 2025-04-23
输入 n(1≤n≤1e5) 和两个长为 n 的数组 a 和 b，元素范围 [0,2^31)。保证 a 中没有重复元素，b 中没有重复元素。
每次操作，你可以交换 a 中的一对相邻元素，或者 b 中的一对相邻元素。
为了最小化 (a[i]-b[i])^2 之和，至少要操作多少次？
输出【最小操作次数】模 1e8 - 3 的结果。

(ai-bi)^2 = ai^2-2*ai*bi+bi^2，其中 ai^2 和 bi^2 是定值，我们只需最大化 ai*bi 之和。
根据排序不等式，如果 ai 和 bi 都是递增的，那么 ai*bi 之和是最大的。
a 和 b 离散化后，把 a 置换 成 0~n-1，设这个置换为 P(x)，应用到 b 上，得到数组 b'。
答案为 b' 的逆序对。
别忘了取模。
代码 https://www.luogu.com.cn/paste/tab2tl7w

# P1966 [NOIP 2013 提高组] 火柴排队

## 题目背景

NOIP2013 提高组 D1T2

## 题目描述

涵涵有两盒火柴，每盒装有 $n$ 根火柴，每根火柴都有一个高度。 现在将每盒中的火柴各自排成一列， 同一列火柴的高度互不相同， 两列火柴之间的距离定义为：$ \sum (a_i-b_i)^2$。

其中 $a_i$ 表示第一列火柴中第 $i$ 个火柴的高度，$b_i$ 表示第二列火柴中第  $i$ 个火柴的高度。

每列火柴中相邻两根火柴的位置都可以交换，请你通过交换使得两列火柴之间的距离最小。请问得到这个最小的距离，最少需要交换多少次？如果这个数字太大，请输出这个最小交换次数对 $10^8-3$ 取模的结果。

## 输入格式

共三行，第一行包含一个整数 $n$，表示每盒中火柴的数目。

第二行有 $n$ 个整数，每两个整数之间用一个空格隔开，表示第一列火柴的高度。

第三行有 $n$ 个整数，每两个整数之间用一个空格隔开，表示第二列火柴的高度。

## 输出格式

一个整数，表示最少交换次数对 $10^8-3$ 取模的结果。

## 输入输出样例 #1

### 输入 #1

```
4
2 3 1 4
3 2 1 4
```

### 输出 #1

```
1
```

## 输入输出样例 #2

### 输入 #2

```
4
1 3 4 2
1 7 2 4
```

### 输出 #2

```
2
```

## 说明/提示

**输入输出样例说明一**

最小距离是 $ 0$，最少需要交换 $1$ 次，比如：交换第 $1 $ 列的前 $ 2$ 根火柴或者交换第 $2$ 列的前 $2 $ 根火柴。

**输入输出样例说明二**

最小距离是 $10$，最少需要交换 $2$ 次，比如：交换第 $1$ 列的中间 $2$ 根火柴的位置，再交换第 $2$ 列中后 $2$ 根火柴的位置。

**数据范围**

对于 $10\%$ 的数据， $1 \leq n \leq 10$；

对于 $30\%$ 的数据，$1 \leq n \leq 100$；

对于 $60\%$ 的数据，$1 \leq n \leq 10^3$；

对于 $100\%$ 的数据，$1 \leq n \leq 10^5$，$0 \leq$ 火柴高度 $< 2^{31}$。
 */