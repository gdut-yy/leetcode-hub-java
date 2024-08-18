package eight_problems_0x3f;

import java.util.Scanner;

public class Q4_SubArray_add_xor {
    static int n;
    static int[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            s[i] += s[i - 1];
        }
        System.out.println(solve());
    }

    static class Fenwick {
        int n;
        int[] tr;

        public Fenwick(int n) {
            this.n = n;
            tr = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            pos++;
            for (; pos <= n; pos += lb(pos)) tr[pos] += val;
        }

        int query(int pos) {
            pos++;
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tr[pos];
            return ret;
        }
    }

    private static String solve() {
        int ans = 0;
        for (int k = 0; (1L << k) <= s[n]; k++) {
            Fenwick fen = new Fenwick(s[n]);
            fen.add(0, 1);

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                int ts = (s[i] & ((1 << (k + 1)) - 1));
                if (s[i] >= 1 << (k + 1)) ts |= 1 << (k + 1);

                int r = ts - (1 << k), l = ts - (1 << (k + 1)) + 1;
                cnt += fen.query(r) - fen.query(l - 1);
                l -= 1 << (k + 1);
                r -= 1 << (k + 1);
                cnt += fen.query(r) - fen.query(l - 1);

                fen.add(s[i] & ((1 << (k + 1)) - 1), 1);
            }
            if ((cnt & 1) == 1) ans |= 1 << k;
        }
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360500

# 灵茶八题 - 子数组 +w^

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有连续子数组的元素和的异或和。

例如 $a=[1,3]$ 有三个连续子数组 $[1],[3],[1,3]$，元素和分别为 $1,3,4$，所以答案为 $1\oplus 3\oplus 4=6$。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 2\cdot 10^5)$。

第二行输入 $n$ 个整数，表示数组 $a$ 中的元素 $(0\le a[i] \le 100)$。

## 输出格式

一个整数，表示 $a$ 的所有连续子数组的元素和的异或和。

## 样例 #1

### 样例输入 #1

```
2
1 3
```

### 样例输出 #1

```
6
```

## 样例 #2

### 样例输入 #2

```
1
1
```

### 样例输出 #2

```
1
```

## 提示

其余题目见[《灵茶八题》题目列表](https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao)
 */