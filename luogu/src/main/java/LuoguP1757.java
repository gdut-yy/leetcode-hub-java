import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LuoguP1757 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // 物品的重量，利用价值，所属组数
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        System.out.println(solve(m, n, a, b, c));
    }

    private static String solve(int m, int n, int[] a, int[] b, int[] c) {
        // 分组
        Map<Integer, List<Integer>> idListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idListMap.computeIfAbsent(c[i], key -> new ArrayList<>()).add(i);
        }

        // 分组背包
        // f[j] 代表容量为 j 的背包能达到的最大价值
        int[] f = new int[m + 1];

        // 循环每一组
        for (Map.Entry<Integer, List<Integer>> entry : idListMap.entrySet()) {
            List<Integer> idList = entry.getValue();
            // 循环背包容量
            for (int i = m; i >= 0; i--) {
                for (int id : idList) {
                    if (i >= a[id]) {
                        f[i] = Math.max(f[i], f[i - a[id]] + b[id]);
                    }
                }
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
P1757 通天之分组背包
https://www.luogu.com.cn/problem/P1757

# 通天之分组背包

## 题目背景

直达通天路·小 A 历险记第二篇

## 题目描述

自 $01$ 背包问世之后，小 A 对此深感兴趣。一天，小 A 去远游，却发现他的背包不同于 $01$ 背包，他的物品大致可分为 $k$ 组，每组中的物品相互冲突，现在，他想知道最大的利用价值是多少。

## 输入格式

两个数 $m,n$，表示一共有 $n$ 件物品，总重量为 $m$。

接下来 $n$ 行，每行 $3$ 个数 $a_i,b_i,c_i$，表示物品的重量，利用价值，所属组数。

## 输出格式

一个数，最大的利用价值。

## 样例 #1

### 样例输入 #1

```
45 3
10 10 1
10 5 1
50 400 2
```

### 样例输出 #1

```
10
```

## 提示

$0 \leq m \leq 1000$，$1 \leq n \leq 1000$，$1\leq k\leq 100$，$a_i, b_i, c_i$ 在 `int` 范围内。
 */