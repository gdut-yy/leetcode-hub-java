package eight_problems_0x3f;

import java.util.Scanner;

public class Q3_SubArray_xor_add {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (int k = 0; k < 31; k++) {
            int cnt1 = 0;
            int xor = 0;
            for (int v : a) {
                xor ^= v >> k & 1;
                cnt1 += xor;
            }
            ans += (cnt1 * (n + 1L - cnt1)) << k;
        }
//        // 去掉长度为 1 的子数组
//        for (int v : a) ans -= v;
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360489

# 灵茶八题 - 子数组 ^w+

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有连续子数组的异或和的和。

例如 $a=[3,5]$ 有三个连续子数组 $[3],[5],[3,5]$，异或和分别为 $3,5,6$，所以答案为 $3+5+6=14$。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 10^5)$。

第二行输入 $n$ 个非负整数，表示数组 $a$ 中的元素 $(0\le a[i] \le 10^6)$。

## 输出格式

一个整数，表示 $a$ 的所有连续子数组的异或和的和。

## 样例 #1

### 样例输入 #1

```
2
3 5
```

### 样例输出 #1

```
14
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
