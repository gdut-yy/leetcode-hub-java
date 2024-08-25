package p750;

import java.util.Scanner;

public class CF750C {
    static int n;
    static int[][] cd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        cd = new int[n][2];
        for (int i = 0; i < n; i++) {
            cd[i][0] = scanner.nextInt();
            cd[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int inf = (int) 1e9;

    private static String solve() {
        int minR = -inf, maxR = inf, s = 0;
        for (int i = 0; i < n; i++) {
            int c = cd[i][0], d = cd[i][1];
            if (d == 1) {
                minR = Math.max(minR, 1900 - s);
            } else {
                maxR = Math.min(maxR, 1899 - s);
            }
            s += c;
        }
        if (minR > maxR) return "Impossible";
        if (maxR == inf) return "Infinity";
        return String.valueOf(maxR + s);
    }
}
/*
C. New Year and Rating
https://codeforces.com/contest/750/problem/C

灵茶の试炼 2023-10-25
题目大意：
输入 n(1≤n≤2e5)，表示某人参加了 n 场 CF 比赛。
然后输入 n 行，每行两个数 c(-100~100) 和 d(1~2)，其中 c 表示比赛后这个人的 rating 变化了 c（正数表示上分，负数表示掉分，0 表示不变），d 表示这个人参加的是 div1 还是 div2。
比赛前 rating >= 1900 才能参加 div1；比赛前 rating <= 1899 才能参加 div2。
输出 n 场比赛后，rating 最大可以是多少。
如果 rating 可以无限大（见样例 3），输出 Infinity。
如果输入的数据自相矛盾（见样例 2），输出 Impossible。
思考题：如果输入的 d 可以等于 3 呢？
此时 d=2 表示 rating 在 1600~1899，d=3 表示 rating <= 1599

rating 1600
https://www.luogu.com.cn/blog/endlesscheng/cf750c-new-year-and-rating-ti-xie
时间复杂度 O(n)
======

input
3
-7 1
5 2
8 2
output
1907

input
2
57 1
22 2
output
Impossible

input
1
-5 1
output
Infinity

input
4
27 2
13 1
-50 1
8 2
output
1897
 */
