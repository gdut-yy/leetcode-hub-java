package eight_problems_0x3f;

import java.util.Scanner;

public class Q5_SubSequence_add_add {
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

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long sum = 0;
        // 2^{n-1}
        long cnt = 1;
        for (int i = 0; i < n; i++) {
            sum = (sum + a[i]) % MOD;
            if (i > 0) cnt = (cnt * 2) % MOD;
        }
        long ans = sum * cnt % MOD;
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360640

# 灵茶八题 - 子序列 +w+

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有非空子序列的元素和的元素和。

例如 $a=[1,2,3]$ 有七个非空子序列 $[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]$，元素和分别为 $1,2,3,3,4,5,6$，所以答案为 $1+2+3+3+4+5+6=24$。

由于答案很大，你需要输出答案模 $10^9+7$ 后的结果。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 2\cdot 10^5)$。

第二行输入 $n$ 个整数，表示数组 $a$ 中的元素 $(0\le a[i] \le 10^9)$。

## 输出格式

一个整数，表示 $a$ 的所有非空子序列的元素和的元素和，模 $10^9+7$ 后的结果。

## 样例 #1

### 样例输入 #1

```
3
1 2 3
```

### 样例输出 #1

```
24
```

## 提示

其余题目见[《灵茶八题》题目列表](https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao)
 */