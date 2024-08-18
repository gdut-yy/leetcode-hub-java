package eight_problems_0x3f;

import java.util.Scanner;

public class Q8_SubSequence_add_xor {
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
        int m = 1 << 16;
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int v = a[i];
            for (int j = m; j >= v; j--) {
                dp[j] = dp[j] ^ dp[j - v];
            }
        }

        int ans = 0;
        for (int i = 0; i <= m; i++) {
            if (dp[i] != 0) {
                ans ^= i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
https://www.luogu.com.cn/problem/U360643

# 灵茶八题 - 子序列 +w^

## 题目描述

给你一个长为 $n$ 的数组 $a$，输出它的所有非空子序列的元素和的异或和。

例如 $a=[1,2,3]$ 有七个非空子序列 $[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]$，元素和分别为 $1,2,3,3,4,5,6$，所以答案为 $1\oplus 2\oplus 3\oplus 3\oplus 4\oplus 5\oplus 6=4$。

## 输入格式

第一行输入一个整数 $n\ (1\le n \le 1000)$。

第二行输入 $n$ 个整数，表示数组 $a$ 中的元素 $(a[i]\ge 0, \sum a[i]< 2^{16})$。

## 输出格式

一个整数，表示 $a$ 的所有非空子序列的元素和的异或和。

## 样例 #1

### 样例输入 #1

```
3
1 2 3
```

### 样例输出 #1

```
4
```

## 提示

其余题目见[《灵茶八题》题目列表](https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao)
 */