package c377;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc377_c {
    static Scanner scanner = new Scanner(System.in);
    static long n, m;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    private static String solve() {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            long a = scanner.nextInt() - 1;
            long b = scanner.nextInt() - 1;
            long key = a << 32 | b;
            set.add(key);
            for (int[] d : DIRECTIONS) {
                long nx = a + d[0];
                long ny = b + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    key = nx << 32 | ny;
                    set.add(key);
                }
            }
        }
        long ans = n * n - set.size();
        return String.valueOf(ans);
    }
}
/*
C - Avoid Knight Attack
https://atcoder.jp/contests/abc377/tasks/abc377_c

题目大意：
有一个由 $N^2$ 个正方形组成的网格，网格中有 $N$ 行和 $N$ 列。让 $(i,j)$ 表示从顶端 $(1\leq i\leq N)$ 起的第 $i$ 行和从左侧 $(1\leq j\leq N)$ 起的第 $j$ 列的正方形。
每个方格要么是空的，要么放了一颗棋子。网格上有 $M$ 个棋子，而 $k$ -th $(1\leq k\leq M)$ 个棋子被放在了 $(a_k,b_k)$ 个方格上。
您想把棋子放在**个空格**上，使它**不能被任何现有棋子吃掉**。
放置在位置 $(i,j)$ 上的棋子可以吃掉满足以下任何条件的棋子：
- 置于位置 $(i+2,j+1)$ 上
- 置于位置 $(i+1,j+2)$ 上
- 置于位置 $(i-1,j+2)$ 上
- 置于位置 $(i-2,j+1)$ 上
- 置于 $(i-2,j-1)$ 方格上
- 置于 $(i-1,j-2)$ 方格上
- 置于 $(i+1,j-2)$ 方格上
- 置于 $(i+2,j-1)$ 方格上
在这里，涉及不存在的正方形的条件被认为是永远不会满足的。
例如，放在 $(4,4)$ 位置上的棋子可以吃掉放在下图中蓝色所示位置上的棋子：
您可以将棋子放在几个位置上？
#### 限制因素
- $1\leq N\leq10^9$
- $1\leq M\leq2\times10^5$
- $1\leq a_k\leq N,1\leq b_k\leq N\ (1\leq k\leq M)$
- $(a_k,b_k)\neq(a_l,b_l)\ (1\leq k\lt l\leq M)$
- 所有输入值均为整数。

n 达到 1e9，不能暴力枚举，需要引入 哈希表 去重。
======

Input 1
8 6
1 4
2 1
3 8
4 5
5 2
8 3
Output 1
38

Input 2
1000000000 1
1 1
Output 2
999999999999999997

Input 3
20 10
1 4
7 11
7 15
8 10
11 6
12 5
13 1
15 2
20 10
20 15
Output 3
338
 */
