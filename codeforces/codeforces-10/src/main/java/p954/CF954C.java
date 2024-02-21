package p954;

import java.util.Scanner;

public class CF954C {
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

    static final int INF = (int) 1e9;

    private static String solve() {
        int m = 0;
        for (int i = 1; i < n; i++) {
            int d = Math.abs(a[i] - a[i - 1]);
            if (d == 0) return "NO";
            if (d > 1) {
                if (m == 0) {
                    m = d;
                } else if (d != m) {
                    return "NO";
                }
            }
        }

        if (m == 0) {
            return "YES" + System.lineSeparator() + INF + " " + 1;
        }
        for (int i = 1; i < n; i++) {
            if (a[i - 1] + 1 == a[i] && a[i - 1] % m == 0 ||
                    a[i - 1] == a[i] + 1 && a[i] % m == 0) {
                return "NO";
            }
        }
        return "YES" + System.lineSeparator() + INF + " " + m;
    }
}
/*
C. Matrix Walk
https://codeforces.com/contest/954/problem/C

灵茶の试炼 2022-08-15
题目大意：
有一个 x 行 y 列的矩阵，你不知道 x 和 y 的大小，你只知道矩阵中的数字是从 1 开始连续递增的，即：
第一行是 1,2,3,...,y
第二行是 y+1,y+2,y+3,...,2y
……
定义矩阵上的一条路径为：从某一点出发，每一步往四个相邻格子走（不能出界），所走过的数字组成的序列。注意不能停在原地。
现在输入 n(≤2e5) 和一个长为 n 的路径 a (1≤a[i]≤1e9)。
如果存在某个矩阵能走出路径 a，且 x 和 y 均不超过 1e9，则输出 YES 和 x y，否则输出 NO。
如果有多个答案，输出任意一种。
进阶：如果 a[i] ≤ 1e18，其它约束不变，要怎么做？ @七水

rating 1700
https://codeforces.com/contest/954/submission/143601524
提示 1：在知道 y 的前提下，a[i]-a[i+1] 只能是哪些值？（代码的第一个 for，变量名用的 m 表示 y）
提示 2：在 y>1 的情况下，你不能从数字 y 一步走到数字 y+1。（代码的第二个 for）
具体实现逻辑见代码。
======

input
8
1 2 3 6 9 8 5 2
output
YES
3 3

input
6
1 2 1 2 5 3
output
NO

input
2
1 10
output
YES
4 9
 */
