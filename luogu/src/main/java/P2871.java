import java.util.Scanner;

public class P2871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 有 N 件物品和一个容量为 M 的背包。
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 第 i 件物品的重量是 wi，价值是 vi
        int[] W = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = scanner.nextInt();
            D[i] = scanner.nextInt();
        }

        // 0-1 背包
        // f[j] 代表容量为 j 的背包能达到的最大价值
        int[] f = new int[M + 1];
        for (int i = 0; i < N; i++) {
            int wi = W[i];
            int vi = D[i];
            for (int j = M; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + vi);
            }
        }
        System.out.println(f[M]);
    }
}
/*
P2871 [USACO07DEC]Charm Bracelet S
https://www.luogu.com.cn/problem/P2871

# [USACO07DEC] Charm Bracelet S

## 题目描述

Bessie has gone to the mall's jewelry store and spies a charm bracelet. Of course, she'd like to fill it with the best charms possible from the N (1 ≤ N ≤ 3,402) available charms. Each charm i in the supplied list has a weight Wi (1 ≤ Wi ≤ 400), a 'desirability' factor Di (1 ≤ Di ≤ 100), and can be used at most once. Bessie can only support a charm bracelet whose weight is no more than M (1 ≤ M ≤ 12,880).

Given that weight limit as a constraint and a list of the charms with their weights and desirability rating, deduce the maximum possible sum of ratings.

有 $N$ 件物品和一个容量为 $M$ 的背包。第 $i$ 件物品的重量是 $W_i$，价值是 $D_i$。求解将哪些物品装入背包可使这些物品的重量总和不超过背包容量，且价值总和最大。

## 输入格式

\* Line 1: Two space-separated integers: N and M

\* Lines 2..N+1: Line i+1 describes charm i with two space-separated integers: Wi and Di

第一行：物品个数 $N$ 和背包大小 $M$。

第二行至第 $N+1$ 行：第 $i$ 个物品的重量 $W_i$ 和价值 $D_i$。

## 输出格式

\* Line 1: A single integer that is the greatest sum of charm desirabilities that can be achieved given the weight constraints

输出一行最大价值。

## 样例 #1

### 样例输入 #1

```
4 6
1 4
2 6
3 12
2 7
```

### 样例输出 #1

```
23
```
 */