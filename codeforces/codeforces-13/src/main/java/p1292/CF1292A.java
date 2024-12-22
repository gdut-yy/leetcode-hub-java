package p1292;

import java.util.Scanner;

public class CF1292A {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int cnt = 0;
        int[][] ban = new int[2][(int) (1e5 + 2)];
        String[] output = new String[q];
        for (int i = 0; i < q; i++) {
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt();

            ban[r][c] ^= 1;
            int s = ban[r ^ 1][c] + ban[r ^ 1][c - 1] + ban[r ^ 1][c + 1];
            if (ban[r][c] > 0) {
                cnt += s;
            } else {
                cnt -= s;
            }
            output[i] = cnt > 0 ? "No" : "Yes";
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
A. NEKO's Maze Game
https://codeforces.com/contest/1292/problem/A

灵茶の试炼 2024-08-13
题目大意：
输入 n(2≤n≤1e5) 和 q(1≤q≤1e5)。
有一个 2 行 n 列的网格图，一开始所有格子都是空的。行列编号从 1 开始。
然后输入 q 个操作，每个操作输入两个数 r c，表示切换 r 行 c 列这个格子的状态：从空格子变成障碍格子，或者从障碍格子变成空格子。
对于每个询问，判断能否从左上角走到右下角，输出 Yes 或 No。题目保证起点和终点不会变成障碍。
你只能走上下左右的相邻格子，且不能走到障碍格子上。

rating 1400
说一个写起来很简单的做法。
如果存在两个障碍格，它们上下相邻，或者斜向相邻，那么就无法从起点走到终点。
这启发我们统计这样的障碍格的 pair 个数。
例如 (1,5) 变成障碍格，那么就看 (2,4), (2,5), (2,6) 这三个格子是否为障碍格，若这三个格子中有 x 个障碍格，那么 pair 个数就增加 x。
例如 (1,5) 变成空格子，那么就看 (2,4), (2,5), (2,6) 这三个格子是否为障碍格，若这三个格子中有 x 个障碍格，那么 pair 个数就减少 x。
如果 pair 个数 = 0，那么就可以从起点走到终点，反之不行。
代码 https://codeforces.com/problemset/submission/1292/276043172
======

Input
5 5
2 3
1 4
2 4
2 3
1 4
Output
Yes
No
No
No
Yes
 */
