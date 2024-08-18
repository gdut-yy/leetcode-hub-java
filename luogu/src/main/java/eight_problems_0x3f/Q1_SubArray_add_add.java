package eight_problems_0x3f;

import java.util.Scanner;

public class Q1_SubArray_add_add {
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
        for (int i = 0; i < n; i++) {
            long c = (i + 1L) * (n - i);
            ans += c * a[i];
        }
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360300

# 灵茶八题 - 子数组 +w+

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有连续子数组的元素和的元素和。

例如 $a=[1,2]$ 有三个连续子数组 $[1],[2],[1,2]$，元素和分别为 $1,2,3$，所以答案为 $1+2+3=6$。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 2\cdot 10^5)$。

第二行输入 $n$ 个整数，表示数组 $a$ 中的元素 $(-10^3\le a[i] \le 10^3)$。

## 输出格式

一个整数，表示 $a$ 的所有连续子数组的元素和的元素和。

## 样例 #1

### 样例输入 #1

```
2
1 2
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