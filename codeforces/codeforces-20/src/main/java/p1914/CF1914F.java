package p1914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1914F {
    static int n;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            g = new ArrayList[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int w = 2; w <= n; w++) {
                int v = scanner.nextInt();
                g[v].add(w);
            }
            System.out.println(solve());
        }
    }

    static int[] sz;

    private static String solve() {
        sz = new int[n + 1];
        Arrays.fill(sz, 1);
        dfs(1);

        int ans = 0, other = 0, x = 1;
        while (true) {
            if (other > 0) {
                ans++; // 找个其它点和 x 匹配
                other--;
            }
            if (g[x].isEmpty()) {
                break;
            }

            int s = sz[x] - 1;
            int y = g[x].get(0);
            // 情况一，算出答案
            if (sz[y] * 2 <= s + other) {
                ans += (s + other) / 2;
                break;
            }

            // 情况二，继续迭代
            other += s - sz[y];
            x = y;
        }
        return String.valueOf(ans);
    }

    static void dfs(int x) {
        for (Integer y : g[x]) {
            dfs(y);
            sz[x] += sz[y];
            if (sz[y] > sz[g[x].get(0)]) {
                // swap(g[x][0], y);
//                int tmp = g[x].get(0);
//                g[x].set(0, y);
//                y = tmp;
                g[x].set(0, y);
            }
        }
    }
}
/*
F. Programming Competition
https://codeforces.com/contest/1914/problem/F

题目大意：
BerSoft 是德国最大的 IT 公司。BerSoft 公司有 n 名员工，编号从 1 到 n。
第一个员工是公司的负责人，他没有任何上级。每一个员工 i 都有一个直接上级 pi。
如果符合下列条件之一，则认为员工 x 是员工 y 的直接或间接上级:
- 员工 x 是员工 y 的直接上级;
- 员工 x 是员工 y 的直接上级。
BerSoft 公司的结构是这样组织的:公司的领导高于每一个员工。
一场编程比赛即将举行。为此，应该创建两人团队。然而，如果一个团队中的一名员工是另一名员工的上级，他们在一起会感到不舒服。所以，两个人的团队应该建立，这样就没有人比另一个人优越。请注意，任何员工都不能参与多个团队。
你的任务是根据上述规则计算队伍的最大数量。

rating 1900
树上贪心【Codeforces 916 (Div. 3) F】
https://www.bilibili.com/video/BV1d94y1c7fb/
https://codeforces.com/contest/1914/submission/238203148
P1352 没有上司的舞会
https://www.luogu.com.cn/problem/P1352
======

input
6
4
1 2 1
2
1
5
5 5 5 1
7
1 2 1 1 3 3
7
1 1 3 2 2 4
7
1 2 1 1 1 3
output
1
0
1
3
3
3
 */
