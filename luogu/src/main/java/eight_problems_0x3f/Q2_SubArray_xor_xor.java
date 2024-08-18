package eight_problems_0x3f;

import java.util.Scanner;

public class Q2_SubArray_xor_xor {
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
        if (n % 2 == 0) return "0";
        long ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans ^= a[i];
        }
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360487

# 灵茶八题 - 子数组 ^w^

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有连续子数组的异或和的异或和。

例如 $a=[1,3]$ 有三个连续子数组 $[1],[3],[1,3]$，异或和分别为 $1,3,2$，所以答案为 $1 \oplus 3\oplus 2=0$。其中 $\oplus$ 表示异或运算。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 2\cdot 10^5)$。

第二行输入 $n$ 个非负整数，表示数组 $a$ 中的元素 $(0\le a[i] \le 10^9)$。

## 输出格式

一个整数，表示 $a$ 的所有连续子数组的异或和的异或和。

## 样例 #1

### 样例输入 #1

```
2
1 3
```

### 样例输出 #1

```
0
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