package c461;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc461_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void update(int[] t, int i, int v) {
        for (; i < t.length; i += i & -i) {
            t[i] += v;
        }
    }

    static int pre(int[] t, int i) {
        int res = 0;
        for (; i > 0; i &= i - 1) {
            res += t[i];
        }
        return res;
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] tRow = new int[n + 1];
        int[] tCol = new int[n + 1];
        int[] row = new int[q + 1];
        int[] col = new int[q + 1];
        long ans = 0;
        for (int t = q; t > 0; t--) {
            int op = scanner.nextInt();
            int i = scanner.nextInt();
            if (op == 1) {
                int lastT = tRow[i];
                tRow[i] = t;
                if (lastT == 0) {
                    ans += n;
                } else {
                    ans += pre(col, lastT);
                    update(row, lastT, -1);
                }
                update(row, t, 1);
            } else {
                int lastT = tCol[i];
                tCol[i] = t;
                if (lastT == 0) {
                    lastT = q;
                } else {
                    update(col, lastT, -1);
                }
                ans -= pre(row, lastT);
                update(col, t, 1);
            }
            out.println(ans);
        }
    }
}
/*
E - E-liter
https://atcoder.jp/contests/abc461/tasks/abc461_e

灵茶の试炼 2026-06-18
题目大意：
输入 n(1≤n≤3e5) 和 q(1≤q≤3e5)。
有一个 n 行 n 列的网格图，初始所有格子均为白色。行列编号均从 1 开始。
输入 q 个操作，格式如下：
"1 r"：把第 r 行的格子都涂黑。
"2 c"：把第 c 列的格子都涂白。
对于每个操作，输出操作后网格中的黑色格子总数。

rating
从特殊到一般。
想一想，如果网格图只有 1 行 n 列，怎么做？怎么判断格子现在的颜色？
对于第 c 列，我需要知道这一列上一次涂白是什么时候，以及涂白之后，是否有行操作把整行涂黑了？这样我才能判断出第 c 列当前是白还是黑。
对于第 1 行，我需要知道这一行上一次涂黑是什么时候，以及发生在涂黑之后的列涂白有多少个。可以用树状数组维护列操作的时间戳。
一般地：
维护每行每列上一次操作的时间戳 tRow tCol。为方便使用树状数组，时间戳可以从 q 倒着减到 1。
一共需要两个树状数组。
对于行，用树状数组记录最近的行操作时间戳，树状数组下标是时间戳，维护的是出现次数。对第 r 行操作时，先从树状数组中删除旧的时间戳 lastT=tRow[r]，再加上当前时间戳 t。查询列的树状数组发生在 [lastT, t] 之间的列操作次数，即为白->黑的个数，加到答案中。
对于列，用树状数组记录最近的列操作时间戳，树状数组下标是时间戳，维护的是出现次数。对第 c 列操作时，先从树状数组中删除旧的时间戳 lastT=tCol[c]，再加上当前时间戳 t。查询行的树状数组发生在 [lastT, t] 之间的行操作次数，即为黑->白的个数，从答案中减去。
代码 https://atcoder.jp/contests/abc461/submissions/76604234
======

Input 1
3 4
1 1
1 3
2 2
1 1
Output 1
3
6
4
5

Input 2
300000 1
2 300000
Output 2
0
 */
