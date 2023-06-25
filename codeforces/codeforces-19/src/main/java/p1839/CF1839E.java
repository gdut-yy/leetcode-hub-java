package p1839;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1839E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int s = 0;
        int[] f = new int[n * 300 + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            s += a[i];
            for (int j = s; j >= a[i]; j--) {
                if (f[j] == 0 && f[j - a[i]] > 0) {
                    f[j] = i;
                }
            }
        }

        int x = 1, y = 1;
        if (s % 2 == 1 || f[s / 2] == 0) {
            // 无法分出两个 s/2 集合，先手必胜
            System.out.println("First");
            while (true) {
                // 随便玩，直接取第一个 > 0 的数即可
                for (int i = 1; i <= n; i++) {
                    if (a[i] > 0) {
                        x = i;
                        break;
                    }
                }
                System.out.println(x);
                y = scanner.nextInt();
                if (y < 1) {
                    break;
                }
                int d = Math.min(a[x], a[y]);
                a[x] -= d;
                a[y] -= d;
            }
        } else {
            // 后手必胜
            System.out.println("Second");
            boolean[] left = new boolean[n + 1];
            for (s /= 2; s > 0; s -= a[f[s]]) {
                left[f[s]] = true;
            }
            while (true) {
                x = scanner.nextInt();
                if (x < 1) {
                    break;
                }
                for (int i = 1; i <= n; i++) {
                    if (a[i] > 0 && left[i] != left[x]) {
                        y = i;
                        break;
                    }
                }
                int d = Math.min(a[x], a[y]);
                a[x] -= d;
                a[y] -= d;
                System.out.println(y);
            }
        }
    }
}
/*
E. Decreasing Game
https://codeforces.com/contest/1839/problem/E

这是一个互动的问题。
考虑以下两个玩家的游戏:
- 首先，黑板上写了一个长度为 n 的整数数组 a1,a2,...,an。
- 游戏由回合组成。在每一轮中，会发生以下事情:
  - 第一个玩家选择任意 i 使 ai>0。如果没有这样的 i，第一个玩家输掉游戏(第二个玩家赢)，游戏结束。
  - 第二个参与人选择任意 j≠i 且 aj>0。如果没有这样的 j，第二个玩家输掉游戏(第一个玩家赢)，游戏结束。
  - 设 d=min(ai,aj) ai 和 aj 的值同时减少 d，下一轮开始。
可以证明，游戏总是在有限的回合数后结束。
你必须选择你将为哪个玩家玩(第一或第二)并赢得游戏。

https://codeforces.com/contest/1839/submission/208417965
设和为 s，如果能分出两个 s/2 集合，后手必胜
0-1 背包 记录转移来源
======

input
4
10 4 6 3


3

1

0
output
First

1

2

4
---
input
6
4 5 5 11 3 2

2

5

4

6

1

0
output

Second

4

4

3

1

3
 */
