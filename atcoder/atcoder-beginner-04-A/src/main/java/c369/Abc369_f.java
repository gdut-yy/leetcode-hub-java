package c369;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc369_f {
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

    static int[] ftV, ftI;
    static int ftLen;

    static void ftUpdate(int i, int v, int idx) {
        for (; i <= ftLen; i += i & -i) {
            if (ftV[i] < v) {
                ftV[i] = v;
                ftI[i] = idx;
            }
        }
    }

    static int[] ftPre(int i) {
        int resV = 0, resI = 0;
        for (; i > 0; i &= i - 1) {
            if (resV < ftV[i]) {
                resV = ftV[i];
                resI = ftI[i];
            }
        }
        return new int[]{resV, resI};
    }

    private static void solve() {
        int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
        int[][] a = new int[n + 2][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        a[n][0] = 1;
        a[n][1] = 1;
        a[n + 1][0] = h;
        a[n + 1][1] = w;
        Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        ftLen = w;
        ftV = new int[w + 1];
        ftI = new int[w + 1];
        int[] f = new int[n + 2];
        int[] from = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            int[] mx = ftPre(a[i][1]);
            f[i] = mx[0] + 1;
            from[i] = mx[1];
            ftUpdate(a[i][1], f[i], i);
        }
        out.println(f[n + 1] - 2);
        StringBuilder sb = new StringBuilder();
        for (int i = n + 1; i > 0; ) {
            int j = from[i];
            for (int k = 0; k < a[i][1] - a[j][1]; k++) sb.append('R');
            for (int k = 0; k < a[i][0] - a[j][0]; k++) sb.append('D');
            i = j;
        }
        out.println(sb.reverse());
    }
}
/*
F - Gather Coins
https://atcoder.jp/contests/abc369/tasks/abc369_f

灵茶の试炼 2026-05-21
题目大意：
输入 h(2≤h≤2e5) w(2≤w≤2e5) n(1≤n≤min(hw-2,2e5)) 表示一个 h 行 w 列的网格图。
然后输入网格图中 n 个硬币的行号和列号（从 1 开始）。
保证左上角 (1,1) 和右下角 (h,w) 没有硬币，保证一个格子至多一枚硬币。
从左上角走到右下角，只能向下或向右移动到相邻格子，最多能收集多少枚硬币？
输出最大硬币数。
然后输出任意一条具体的路径，包含 h+w-2 个字符，用 'D' 表示向下，用 'R' 表示向右。

rating
把 a 按照 (r,c) 双关键字排序。
定义 f[i] 表示从左上角移动到 a[i]，能收集的最大硬币数。
遍历 a，对于 a[i]，我们需要知道在遍历过的 a[j] 中，满足 c[j] <= c[i] 的 f[j] 的最大值，以及最大值的下标。
这可以用值域树状数组维护。
树状数组的下标是列号，保存的是 pair，包含值域前缀最大值，以及最大值在 f 中的下标。
代码实现时，为方便计算，把 (1,1) 和 (h,w) 加到 a 中。
代码 https://atcoder.jp/contests/abc369/submissions/75900910
======

Input 1
3 4 4
3 3
2 1
2 3
1 4
Output 1
3
DRRDR

Input 2
2 2 2
2 1
1 2
Output 2
1
DR

Input 3
10 15 8
2 7
2 9
7 9
10 3
7 11
8 12
9 6
8 1
Output 3
5
DRRRRRRRRDDDDDRRDRDDRRR
 */
