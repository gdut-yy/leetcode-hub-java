package p639;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF639B {
    static int n, d, h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = scanner.nextInt();
        h = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        if (d > h * 2 || d == 1 && n > 2) {
            return "-1";
        }
        if (n == 2) {
            return "1 2";
        }

        List<String> ans = new ArrayList<>();
        if (h == 1) {
            for (int i = 2; i <= n; i++) {
                ans.add(1 + " " + i);
            }
        } else {
            for (int i = 1; i <= h; i++) {
                ans.add(i + " " + (i + 1));
            }
            if (h < d) {
                ans.add(1 + " " + (h + 2));
                for (int i = h + 2; i <= d; i++) {
                    ans.add(i + " " + (i + 1));
                }
            }
            for (int i = d + 2; i <= n; i++) {
                ans.add(2 + " " + i);
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
B. Bear and Forgotten Tree 3
https://codeforces.com/contest/639/problem/B

灵茶の试炼 2022-07-13
题目大意：
【易错题】
输入三个正整数 n(2<=n<=1e5), d 和 h(1<=h<=d<=n-1)。
请你构造一棵有 n 个节点，直径为 d，高度为 h 的无向树。
若无法构造，输出 -1；否则输出这棵树，用 n-1 条边表示（任意一种合法构造方案均可，节点的编号从 1 开始）。
直径：树上任意两节点的最远距离。
高度：节点 1 和任意节点的最远距离。

rating 1600
constructive algorithms
https://codeforces.com/problemset/submission/639/163977647
先说一般的构造逻辑：
1. 构造一条从 1 出发，长为 h 的链。
2. 如果 h<d，则构造另一条从 1 出发，长为 d-h 的链，这样直径就构造好了。
3. 其余点连到 2 上。
为了满足这个构造的条件，需要特判的东西还是挺多的：
1. 用两条长为 h 的链可以拼成长为 2h 的直径。如果 d>2h，返回 -1。
2. 特判 d=1，那么 n 只能是 2，否则返回 -1。
3. 特判 n=2，输出 1-2。
4. 特判 h=1，这个时候所有点只能连到 1 上，输出 1-2, 1-3, ..., 1-n。
5. 然后就是一般的构造了。
======

input
5 3 2
output
1 2
1 3
3 4
3 5

input
8 5 2
output
-1

input
8 4 2
output
4 8
5 7
2 3
8 1
2 1
5 6
1 5
 */