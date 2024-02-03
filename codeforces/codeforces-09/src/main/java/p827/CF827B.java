package p827;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF827B {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int sz = (n - 1) / k, extra = (n - 1) % k;

        List<String> ans = new ArrayList<>();
        int mn = 2 * sz + Math.min(extra, 2);
        ans.add(String.valueOf(mn));
        for (int i = 1, cur = k + 2; i <= k; i++) {
            int sz0 = sz;
            if (i > extra) {
                sz0--;
            }
            ans.add((k + 1) + " " + i);
            if (sz0 > 0) {
                ans.add(i + " " + cur);
                cur++;
            }
            for (int j = 1; j < sz0; j++) {
                ans.add((cur - 1) + " " + cur);
                cur++;
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
B. High Load
https://codeforces.com/contest/827/problem/B

灵茶の试炼 2022-09-16
题目大意：
输入 n 和 k (2≤k<n≤2e5)。
构造一棵有 n 个节点的树，其中度数为 1 的点恰好有 k 个，且这些点之间的最大距离最小。
输出这个最小值，和这棵树的 n-1 条边。节点编号从 1 开始。
如果有多种构造方案，输出任意一种。
注：一个点的度数等于与该点相连的边的数目。

rating 1800
https://codeforces.com/problemset/submission/827/172319103
提示 1：构造一个形如章鱼的结构：根 + k 条链。
提示 2：其中有 (n-1)%k 条链的长度为 (n-1)/k+1，其余为 (n-1)/k。
上面代码的做法是，根的编号为 k+1，每条链的第一个节点的编号为 1~k。
======

input
3 2
output
2
1 2
2 3

input
5 3
output
3
1 2
2 3
3 4
3 5
 */
