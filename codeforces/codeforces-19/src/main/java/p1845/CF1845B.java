package p1845;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1845B {
    static int xa, ya, xb, yb, xc, yc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            xa = scanner.nextInt();
            ya = scanner.nextInt();
            xb = scanner.nextInt();
            yb = scanner.nextInt();
            xc = scanner.nextInt();
            yc = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int dxBA = xb - xa, dyBA = yb - ya;
        int dxCA = xc - xa, dyCA = yc - ya;
        int dx = 1, dy = 1;
        // 同向
        if (dxBA > 0 == dxCA > 0) {
            dxBA = Math.abs(dxBA) + 1;
            dxCA = Math.abs(dxCA) + 1;
        }
        // 同向
        if (dyBA > 0 == dyCA > 0) {
            dyBA = Math.abs(dyBA) + 1;
            dyCA = Math.abs(dyCA) + 1;
        }
        dx = Math.max(dx, Math.min(dxBA, dxCA));
        dy = Math.max(dy, Math.min(dyBA, dyCA));
        int ans = dx + dy - 1;
        return String.valueOf(ans);
    }
}
/*
B. Come Together
https://codeforces.com/contest/1845/problem/B

题目大意：
鲍勃和卡罗尔和爱丽丝玩了一整天，现在该回家了。爱丽丝、鲍勃和卡罗尔分别生活在无限的二维网格 A、B 和 C 单元格中。现在，它们都在 A 单元格里。
如果 Bob(或 Carol)在某个单元格中，他(她)可以移动到邻近的单元格之一。如果两个细胞共用一条边，就称为相邻细胞。例如，单元格(3,5)有四个相邻的单元格:(2,5)、(4,5)、(3,6)和(3,4)。
鲍勃想回到单元格 B，卡罗尔，回到单元格 C。它们都想走最短的路径，也就是说，走由尽可能少的细胞组成的路径。但他们也想一起走。
如果鲍勃和卡罗尔各自走一条最短的路径回家，他们可以一起走的最大细胞数是多少?

分类讨论。考虑在 a 的同侧，或者不同侧的场景。
======

input
3
3 1
1 3
6 4
5 2
2 2
7 2
1 1
4 3
5 5
output
3
1
6

1
1 99999999
1 1
1 2
99999998
 */
