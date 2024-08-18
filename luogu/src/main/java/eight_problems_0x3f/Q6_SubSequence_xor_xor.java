package eight_problems_0x3f;

import java.util.Scanner;

public class Q6_SubSequence_xor_xor {
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
        if (n == 1) {
            return String.valueOf(a[0]);
        }
        return "0";
    }
}
/*
https://www.luogu.com.cn/problem/U360641

# 灵茶八题 - 子序列 ^w^

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有非空子序列的异或和的异或和。

例如，$a=[1,2,3]$ 的一个子序列是 $[1,3]$，这个子序列的异或和为 $2$。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 2\cdot 10^5)$。

第二行输入 $n$ 个整数，表示数组 $a$ 中的元素 $(0\le a[i] \le 10^9)$。

## 输出格式

一个整数，表示 $a$ 的所有非空子序列的异或和的异或和。

## 样例 #1

### 样例输入 #1

```
2
1 2
```

### 样例输出 #1

```
0
```

## 提示

其余题目见[《灵茶八题》题目列表](https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao)
 */