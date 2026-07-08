package c443;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc443_f {
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

    private static void solve() {
        int n = scanner.nextInt();
        int[][] from = new int[n][10];
        int[] q = new int[n * 10];
        int head = 0, tail = 0;
        for (int d = 1; d < 10; d++) {
            int r = d % n;
            from[r][d] = -1;
            q[tail++] = r * 10 + d;
        }
        while (head < tail) {
            int p = q[head++];
            int r = p / 10, d = p % 10;
            if (r == 0) {
                StringBuilder ans = new StringBuilder();
                ans.append((char) ('0' + d));
                while (from[r][d] >= 0) {
                    p = from[r][d];
                    r = p / 10;
                    d = p % 10;
                    ans.append((char) ('0' + d));
                }
                out.println(ans.reverse());
                return;
            }
            for (int d2 = d; d2 < 10; d2++) {
                int r2 = (r * 10 + d2) % n;
                if (from[r2][d2] == 0) {
                    from[r2][d2] = p;
                    q[tail++] = r2 * 10 + d2;
                }
            }
        }
        out.println(-1);
    }
}
/*
F - Non-Increasing Number
https://atcoder.jp/contests/abc443/tasks/abc443_f

灵茶の试炼 2026-06-12
题目大意：
输入 n(1≤n≤3e6)。
输出最小正整数 x，满足 x 是 n 的倍数，且 x 的十进制表示从高到低是递增的（允许相邻相等）。
如果不存在满足要求的 x，输出 -1。
思考：如果只需要判断是否有解，有没有更快的做法？
思考：如果只需要输出答案的长度，有没有更快的做法？

rating
正整数 x 是 n 的倍数，等价于 x % n = 0。
所以关注点在 x % n。
在从左到右（从高到低）枚举填什么数字的过程中，维护所填数字模 n 的结果 r，以及最近填入的数字 d。
想象一个 9n 个节点的有向图（注意我们不能填 0），每个节点是 (r, d)。
从 (r, d) 出发，从小到大枚举下一个数位填 d2，那么可以移动到 ((r*10+d2), d2)。
最小化 x 的值，即计算从 (0,0) 到 (0,d) 的最短路。
长度相同时，由于 d2 是从小到大枚举的，所以会优先搜索字典序更小的。
为了输出 x，需要记录 from[b] = a，表示从节点 a 移动到节点 b。
我的代码把节点压缩成了 r*10+d，用 -1 表示起点，0 表示未访问。
代码 https://atcoder.jp/contests/abc443/submissions/76573089
======

Input 1
21
Output 1
126

Input 2
10
Output 2
-1

Input 3
3
Output 3
3

Input 4
1089
Output 4
9999999999999999999999
 */
