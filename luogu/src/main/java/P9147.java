import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// CF446A
public class P9147 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 1;
        int[][] f = new int[n][2];
        f[0][0] = 1;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                f[i][0] = f[i - 1][0] + 1;
                f[i][1] = f[i - 1][1] + 1;
            } else {
                f[i][0] = 1;
                f[i][1] = 2; // 把 a[i-1] 改成任意 <= a[i]-1 的数
            }
            if (i > 1 && a[i] > a[i - 2] + 1) { // 把 a[i-1] 改成 [a[i-2]+1, a[i]-1] 中的任意数字
                f[i][1] = max(f[i][1], f[i - 2][0] + 2); // 在 f[i-2][0] 的基础上多了两个数
            }
            ans = max(ans, f[i][0], f[i][1], f[i - 1][0] + 1); // 在 f[i-1][0] 的基础上，修改 a[i] 为任意 >= a[i-1]+1 的数
        }
        return String.valueOf(ans);
    }

    static int max(int... values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
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
# P9147 签到题

## 题目背景

著名的【数据删除】是一个热爱旅游的人！这一天他来到了神秘的 ZYL 国度。

入海关的时候他被问到了一个题目，如果答对他就可以顺利到达 ZYL 的首都 ZY 了！身为堂堂【数据删除】，他居然还花了 $10^{-233}$ 秒才想出来做法，实在是有点难的！于是他决定拿来考考你。

## 题目描述

给定长度为 $n$ 的序列 $a$，保证 $a_i$ 是**正整数**。你需要选择一个位置 $i$ 并将 $a_i$ 修改为一个**任意的整数**。最大化最长**严格**上升子串的长度。

所谓严格上升子串，就是从序列中选出位置**连续**的若干个数字，满足后一个数字比前一个大（而不能相等或小于）。

如序列 $[1,4,2,3,5]$ 中，子序列 $[2,3,5]$ 就是严格上升子串，而 $[4,2,3]$（不上升）和 $[1,2,3]$（不连续）则不是。

## 输入格式

第一行，一个正整数 $n$，表示序列的长度。

第二行，$n$ 个正整数 $a_1, a_2, \ldots, a_n$，表示序列 $a$。

## 输出格式

输出一行一个整数，表示修改后，你最大化的最长严格上升子串的长度。

## 输入输出样例 #1

### 输入 #1

```
5
1 4 2 2 3
```

### 输出 #1

```
3
```

## 输入输出样例 #2

### 输入 #2

```
5
1 2 3 2 1
```

### 输出 #2

```
4
```

## 输入输出样例 #3

### 输入 #3

```
5
1 2 3 1 5
```

### 输出 #3

```
5
```

## 输入输出样例 #4

### 输入 #4

```
6
8 2 3 1 4 5
```

### 输出 #4

```
4
```

## 输入输出样例 #5

### 输入 #5

```
6
7 2 9 4 5 6
```

### 输出 #5

```
5
```

## 说明/提示

**【样例解释 \#1】**

对于样例 \#1，我们可以将序列 $[1,4,2,2,3]$ 中的第三个位置修改为 $5$，得到新序列 $[1,4,5,2,3]$。这个序列的最长严格上升子串是 $[1,4,5]$，长度为 $3$。

容易证明，不存在一种修改方案使得修改后的序列的最长严格上升子串的长度大于 $3$。

---

**【样例解释 \#4】**

对于样例 \#4，我们可以将序列 $[8,2,3,1,4,5]$ 中的第三个位置修改为 $0$，得到新序列 $[8,2,0,1,4,5]$。这个序列的最长严格上升子串是 $[0,1,4,5]$，长度为 $4$。

容易证明，不存在一种修改方案使得修改后的序列的最长严格上升子串的长度大于 $4$。

---

**【数据范围】**

对于前 $20\%$ 的数据，满足 $n \le 5$，$a_i \le 5$。
对于前 $40\%$ 的数据，满足 $n \le 10$，$a_i \le 10$。
对于前 $70\%$ 的数据，满足 $n \le 300$。
对于 $100 \%$ 的数据，满足 $1 \le n \le {10}^6$，$1 \le a_i \le {10}^9$。
 */