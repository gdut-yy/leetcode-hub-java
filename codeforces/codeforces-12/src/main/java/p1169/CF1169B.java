package p1169;

import java.util.Scanner;

public class CF1169B {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        return f(a[0][0], 0) || f(a[0][1], 0) ? "YES" : "NO";
    }

    static boolean f(int x, int y) {
        for (int[] p : a) {
            if (p[0] == x || p[0] == y || p[1] == x || p[1] == y) {
                continue;
            }
            if (y > 0) {
                return false;
            }
            return f(x, p[0]) || f(x, p[1]);
        }
        return true;
    }
}
/*
B. Pairs
https://codeforces.com/contest/1169/problem/B

灵茶の试炼 2023-11-21
题目大意：
输入 n(2≤n≤3e5) m(1≤m≤3e5) 和 m 个数对 (a[i],b[i])，元素范围 [1,n] 且 a[i] != b[i]。
能否找到两个数 x 和 y，使得每个数对中至少有一个数是 x 或者是 y？
输出 YES 或 NO。

rating 1500
提示 1：逆向思维：在第一个数对中，肯定有 x 或 y。
提示 2：枚举 x=a[0] 或者 x=b[0]，向后寻找，如果有一对数 (a[i],b[i]) 不包含 x，那么 y 肯定在这对数当中。
提示 3：枚举 y=a[i] 或者 y=b[i]，继续向后寻找，如果后面的数对都包含 x 或 y，则输出 YES。
如果所有的枚举都没有输出 YES，则输出 NO。
推荐用递归实现，非常简洁。
该方法可以推广至每个数对都包含 3 个数中的一个的情况。更多的数也同理。
https://codeforces.com/contest/1169/submission/232804200
======

input
4 6
1 2
1 3
1 4
2 3
2 4
3 4
output
NO

input
5 4
1 2
2 3
3 4
4 5
output
YES

input
300000 5
1 2
1 2
1 2
1 2
1 2
output
YES
 */
