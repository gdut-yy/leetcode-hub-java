package shopee;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shopee005 {
    static Scanner scanner;
    static PrintWriter out;

    static final int maxn = 12;
    static final int maxd = 7;
    static final int maxl = 5;
    static final int INF = 0x3f3f3f3f;
    static final int NEG_INF = -INF;

    static final int[] low = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
    static final int[][] dis = {
            {2, 2, 2, 3, 2, 2, 2, 3, 3, 5, 3, 3},
            {2, 2, 2, 2, 3, 2, 3, 2, 3, 3, 5, 3},
            {2, 2, 2, 2, 2, 3, 3, 3, 2, 3, 3, 5},
            {3, 2, 2, 2, 3, 3, 5, 2, 2, 2, 3, 3},
            {2, 3, 2, 3, 2, 3, 2, 5, 2, 3, 2, 3},
            {2, 2, 3, 3, 3, 2, 2, 2, 5, 3, 3, 2},
            {2, 3, 3, 5, 2, 2, 2, 3, 3, 3, 2, 2},
            {3, 2, 3, 2, 5, 2, 3, 2, 3, 2, 3, 2},
            {3, 3, 2, 2, 2, 5, 3, 3, 2, 2, 2, 3},
            {5, 3, 3, 2, 3, 3, 3, 2, 2, 2, 2, 2},
            {3, 5, 3, 3, 2, 3, 2, 3, 2, 2, 2, 2},
            {3, 3, 5, 3, 3, 2, 2, 2, 3, 2, 2, 2}
    };

    static Map<List<Integer>, Integer> Hash;
    static List<List<Integer>> seq;
    static List<List<int[]>> e;

    static int getID(List<Integer> vec) {
        Integer id = Hash.get(vec);
        if (id == null) {
            id = Hash.size();
            Hash.put(vec, id);
            seq.add(vec);
            e.add(new ArrayList<>());
        }
        return id;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int m = scanner.nextInt();
        int[][] cost = new int[maxn][maxd];
        for (int i = 0; i < maxn; ++i) {
            for (int j = 0; j < maxd; ++j) {
                cost[i][j] = scanner.nextInt();
            }
        }

        Hash = new HashMap<>();
        seq = new ArrayList<>();
        e = new ArrayList<>();

        int[] sta = new int[maxn];
        for (int i = 0; i < maxn; ++i) {
            List<Integer> vec = new ArrayList<>(maxl);
            for (int k = 0; k < maxl; ++k) vec.add(-1);
            vec.set(maxl - 1, i);
            sta[i] = getID(vec);
        }

        for (int i = 0; i < seq.size(); ++i) {
            List<Integer> cur = seq.get(i);
            int curBack = cur.get(maxl - 1);
            for (int j = 0; j < maxn; ++j) {
                for (int dt = dis[curBack][j]; dt <= maxd; ++dt) {
                    int las = -maxd;
                    List<Integer> nxt = new ArrayList<>(maxl);
                    for (int x = 0; x < maxl; ++x) {
                        int val = (x + dt < maxl) ? cur.get(x + dt) : -1;
                        nxt.add(val);
                        if (cur.get(x) == j) {
                            las = x - dt;
                        }
                    }
                    nxt.set(maxl - 1, j);
                    int inc = cost[j][Math.min(maxl - 1 - las, maxd) - 1];
                    int toId = getID(nxt);
                    e.get(i).add(new int[]{toId, dt, inc});
                }
            }
        }

        int tot = seq.size();
        int[][] dp = new int[maxd][tot];
        for (int i = 0; i < maxd; ++i) {
            Arrays.fill(dp[i], NEG_INF);
        }

        for (int i = 1; i <= m; ++i) {
            int[] cur = new int[tot];
            Arrays.fill(cur, NEG_INF);
            for (int j = 0; j < maxn; ++j) {
                if (i >= low[j]) {
                    int idx = sta[j];
                    cur[idx] = Math.max(cur[idx], cost[j][maxd - 1]);
                }
            }
            for (int j = 0; j < tot; ++j) {
                for (int[] it : e.get(j)) {
                    if (i < it[1]) continue;
                    int to = it[0];
                    int dt = it[1];
                    int inc = it[2];
                    int prev = dp[(i - dt) % maxd][j];
                    if (prev != NEG_INF) {
                        cur[to] = Math.max(cur[to], prev + inc);
                    }
                }
            }
            dp[i % maxd] = cur;
        }

        int[] res = dp[m % maxd];
        int ans = 0;
        for (int val : res) {
            if (val > ans) ans = val;
        }
        out.println(ans);
    }
}
/*
Shopee-005. Shopee Farm
https://leetcode.cn/problems/mrLfqG/

Shopee Farm is your favorite game in Shopee app. In this game, you are living on a planet which looks like a giant soccer ball. Similar to a soccer ball, there are 12 pentagon faces and 20 hexagon faces which form a “Truncated Icosahedron” as follows:

image.png
Figure 1: The giant soccer ball

On each pentagon face, there is a tree. Each tree will produce some Shopee coins after each day. After seven days, if the coins on a face are not collected, the tree on that face will stop producing coins (until the coins are collected). Due to the climate difference between pentagon faces and hexagon faces, trees are only available on pentagon faces.

Let’s “flatten” the soccer ball and number the pentagon faces as follows:

image.png
Figure 2: The giant soccer ball flattened

There are D days in total. On the first day (day 0), you are standing on the hexagon face surrounded by face 1, 2, and 3 (the center face in Figure 2). Each day, you have to move to an adjacent face (you are not allowed to stay at the current face), collect all the Shopee coins on that face (if available). The number of coins you can collect is determined by this rule:

If you are standing on a hexagon face, there are no Shopee coins to collect.
Otherwise, let K be the id of the pentagon face that you are standing on,
If this is the first time you visit this face, the number of coins is C[K, 7]
Otherwise, let P be the index of the most recent day that you visited this face, let Q be the index of the current day, the number of coins is C[K, min(Q − P, 7)]
C is a 12-by-7 matrix of integers. It is guaranteed that C[K, i] ≤ C[K, j] for all i < j.

Find the maximum number of Shopee coins that you can collect at the end of day D − 1.

Input Format

The first line consists of an integer D, the number of days (1 ≤ D ≤ 10^3).
In the next 12 lines, line K (1 ≤ K ≤ 12) consists of 7 integers C[K, i] (1 ≤ i ≤ 7, 0 ≤ C[K, i] ≤ 10^5).
Output Format
Output the maximum number of Shopee coins that you can collect.

Note
To make sure that you have read the problem statement correctly, here are some facts that you can use to verify your understanding:

The distance between face 7 and face 10 is 3.
The distance between face 1 to face 10 is 5.
There are 12 pentagon faces and 20 hexagon faces.

Sample Input
1
100 200 300 400 500 600 700
101 201 301 401 501 601 701
102 202 302 402 502 602 702
103 203 303 403 503 603 703
104 204 304 404 504 604 704
105 205 305 405 505 605 705
106 206 306 406 506 606 706
107 207 307 407 507 607 707
108 208 308 408 508 608 708
109 209 309 409 509 609 709
110 210 310 410 510 610 710
111 211 311 411 511 611 711

10
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
2 4 5 5 6 8 9
0 0 0 0 0 0 0
0 0 0 0 0 0 0
1 1 5 6 6 8 8
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0

41
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
25 36 48 58 59 91 107
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0

Sample Output
702
25
803

Explanation
for sample test 1: On day 0, move to face 3, collects 702 Shoppe coins.
 */