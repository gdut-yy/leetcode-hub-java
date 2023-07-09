package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1846D {
    static int n, d, h;
    static int[] y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            d = scanner.nextInt();
            h = scanner.nextInt();
            y = new int[n];
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(y);

        double one = (double) d * h / 2.0;
        double ans = one * n;
        for (int i = 1; i < n; i++) {
            if (y[i] - y[i - 1] < h) {
                double delta = h - (y[i] - y[i - 1]);
                // 面积比等于边长比的平方 delta^2 / h^2
                ans -= one * delta * delta / h / h;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Rudolph and Christmas Tree
https://codeforces.com/contest/1846/problem/D

题目大意：
鲁道夫画了一棵美丽的圣诞树，并决定把这幅画印出来。然而，墨盒里的墨水常常在最不方便的时候用完。因此，鲁道夫想要提前计算他需要多少绿色墨水。
这棵树是垂直的树干，在不同的高度有相同的三角形树枝。树干的厚度可以忽略不计。
每个分支都是底边为 d，高为 h 的等腰三角形，底边垂直于树干。三角形以一定角度向上排列，并且树干正好在中间通过。第 i 个三角形的底的高度为 yi。
下图显示了一个树的例子，树的 d=4,h=2，三个分支的基座高度为[1,4,5]。
帮助鲁道夫计算树枝的总面积。

排序后 枚举计数。
======

input
5
3 4 2
1 4 5
1 5 1
3
4 6 6
1 2 3 4
2 1 200000
1 200000
2 4 3
9 11
output
11
2.5
34.5
199999.9999975
11.333333
 */
