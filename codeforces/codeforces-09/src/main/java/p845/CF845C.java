package p845;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF845C {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        int end1 = -1, end2 = -1;
        for (int[] p : a) {
            int l = p[0], r = p[1];
            if (l > end1) {
                end1 = r;
            } else if (l > end2) {
                end2 = r;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Two TVs
https://codeforces.com/contest/845/problem/C

灵茶の试炼 2024-03-12
题目大意：
输入 n(1≤n≤2e5) 和 n 个闭区间，每个闭区间 [L,R] 都满足 0≤L<R≤1e9。
能否将这 n 个闭区间分成两组，每组内的区间交集为空？允许一组是空的。
输出 YES 或 NO。

rating 1500
定义两个变量 end1 和 end2 分别表示两个集合的最大右端点，初始值为 -1。
把区间按照左端点从小到大排序。
遍历区间，如果区间左端点比 end1 和 end2 都大，那么放在哪个集合都是可以的（因为后面遍历的区间左端点只会更大）。如果只比一个大就放入对应集合。否则输出 NO。
如果遍历中没有输出 NO 就输出 YES。
https://codeforces.com/contest/845/submission/249220307
======

Input
3
1 2
2 3
4 5
Output
YES

Input
4
1 2
2 3
2 3
1 2
Output
NO
 */
