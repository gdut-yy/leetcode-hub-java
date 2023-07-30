package p991;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF991D {
    static char[] s1, s2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s1 = scanner.next().toCharArray();
        s2 = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;
    // 依次对应题目描述的 4 种 L 形状
    private static final int[][] SHAPE = {{3, 1}, {1, 3}, {2, 3}, {3, 2}};

    private static String solve() {
        // 第 -1 列视作都是 X
        int[] f = {-INF, -INF, -INF, 0};
        for (int i = 0; i < s1.length; i++) {
            int b = s1[i];
            // 第 i 列的 X
            int cur = b >> 6 | s2[i] >> 6 << 1;
            int[] nf = {-INF, -INF, -INF, -INF};
            // 不填 L
            nf[cur] = max(f[0], f[1], f[2], f[3]);
            // 填 L，枚举 L 形状
            for (int[] p : SHAPE) {
                // 枚举第 i-1 列
                for (int pre = 0; pre < 4; pre++) {
                    // 可以填 L
                    if ((p[0] & pre) == 0 && (p[1] & cur) == 0) {
                        nf[p[1] | cur] = Math.max(nf[p[1] | cur], f[pre] + 1);
                    }
                }
            }
            f = nf;
        }
        int ans = max(f[0], f[1], f[2], f[3]);
        return String.valueOf(ans);
    }

    private static int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
/*
D. Bishwock
https://codeforces.com/contest/991/problem/D

灵茶の试炼 2023-07-11
题目大意：
https://codeforces.com/contest/991/problem/D
输入一个 2 行 n(≤100) 列的棋盘。
用数字 0 表示空格子，大写字母 X 表示一开始就被占据的格子。
你有无数个 L 形状的积木，可以旋转，也就是如下 4 种形状：
XX   XX   0X   X0
X0   0X   XX   XX
积木只能放在空格子上（占据 3 个空格子），不能放在被占据的格子上。积木之间不能重叠。
问：最多可以往棋盘上放多少个积木？

https://codeforces.com/contest/991/submission/213197678
定义 f[i][0/1/2/3] 表示考虑前 i 列格子最多能放多少积木，其中第 i 列【未被占据/第一行被占据/第二行被占据/两行都被占据】。
如果不放积木，那么 f[i][x] = max(f[i-1])，这里 x 是题目输入的第 i 列的格子状态。
如果放积木，那么枚举积木的 4 种旋转状态，具体见代码（有详细注释哦）
代码实现时，可以用滚动数组优化空间。
======

input
00
00
output
1

input
00X00X0XXX0
0XXX0X00X00
output
4

input
0X0X0
0X0X0
output
0

input
0XXX0
00000
output
2
 */
