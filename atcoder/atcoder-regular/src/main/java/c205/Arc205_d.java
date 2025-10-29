package c205;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arc205_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] p = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            p[i] = scanner.nextInt();
        }

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            g.get(p[i] - 1).add(i + 1);
        }

        int[] sz = new int[n];
        Arrays.fill(sz, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int child : g.get(i)) {
                sz[i] += sz[child];
            }
        }

        long ans = 0;
        long z = 0;
        int now = 0;
        while (true) {
            if (z > 0) {
                ans++;
                z--;
            }
            List<Integer> children = g.get(now);
            if (children.isEmpty()) {
                break;
            }

            long max_c = 0;
            long sum_c = 0;
            int max_idx = -1;
            for (int child : children) {
                long c_val = sz[child];
                sum_c += c_val;
                if (c_val > max_c) {
                    max_c = c_val;
                    max_idx = child;
                }
            }

            if (sum_c - max_c + z >= max_c) {
                ans += (sum_c + z) / 2;
                break;
            } else {
                z += sum_c - max_c;
                now = max_idx;
            }
        }
        out.println(ans);
    }
}
/*
D - Non-Ancestor Matching
https://atcoder.jp/contests/arc205/tasks/arc205_d

题目大意：
给你一棵有根的树，树上有 N 个顶点，编号从 1 到 N 。顶点 1 是根，顶点 i 的父顶点 (2 <= i <= N) 是顶点 i 的父顶点。 (2 <= i <= N) 是顶点 p_i 的父节点。 (1<= p_i < i) .初始情况下，所有顶点均为白色。
您可以执行下列操作序列零次或多次。
- 选择一对满足以下所有条件的整数 (u,v) 。
    - 1<= u < v <= N
    - 顶点 u 和 v 均为白色。
    - u 不是 v 的祖先。
- 将顶点 u 和 v 着色为黑色。
这里的" u 不是 v 的祖先 "意味着无论执行多少次移动到当前顶点的父顶点的操作，都无法从顶点 v 到达顶点 u 。
请找出以适当顺序执行操作时所能执行的最大操作次数。
给你 T 个测试用例，请找出每个测试用例的答案。

https://atcoder.jp/contests/arc205/editorial/13828
======

Input 1
4
6
1 2 2 2 5
7
1 2 3 4 5 6
7
1 2 3 4 2 4
12
1 1 2 2 2 4 4 4 7 7 7
Output 1
2
0
2
5
 */
