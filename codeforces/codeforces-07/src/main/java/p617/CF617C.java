package p617;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF617C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[][] dir4 = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[] size;
    static int[][] id;
    static String[] a;
    static int n;
    static int k;
    static int[] vis;

    private static void solve() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

        int ts = 0;
        int ans = 0;
        id = new int[n][n];
        size = new int[n * n + 1];
        int sizeIdx = 1;

        // DFS 标记连通分量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i].charAt(j) == 'X' || id[i][j] != 0) {
                    continue;
                }
                size[sizeIdx] = 0;
                dfs(i, j, sizeIdx);
                sizeIdx++;
            }
        }

        vis = new int[sizeIdx];
        Arrays.fill(vis, -1);

        for (int top = 0; top <= n - k; top++) {
            // 初始化当前窗口的连通分量大小
            for (int r = 0; r < n; r++) {
                for (int i = top; i < top + k; i++) {
                    if (r < n) {
                        int compId = id[i][r];
                        if (compId > 0) {
                            size[compId]--;
                        }
                    }
                }

                int l = r - k + 1;
                if (l < 0) {
                    continue;
                }

                int s = 0;
                ts++;
                // 检查上下左右边界上的连通分量
                for (int i = Math.max(top - 1, 0); i <= Math.min(top + k, n - 1); i++) {
                    int j, step, count;
                    if (i == top - 1 || i == top + k) {
                        j = l;
                        step = 1;
                        count = k;
                    } else {
                        j = l - 1;
                        step = k + 1;
                        count = 2;
                    }
                    for (int c = 0; c < count; c++) {
                        if (j >= 0 && j < n) {
                            int compId = id[i][j];
                            if (compId > 0 && vis[compId] != ts) {
                                vis[compId] = ts;
                                s += size[compId];
                            }
                        }
                        j += step;
                    }
                }
                ans = Math.max(ans, s);

                // 恢复左侧列连通分量大小
                for (int i = top; i < top + k; i++) {
                    int compId = id[i][l];
                    if (compId > 0) {
                        size[compId]++;
                    }
                }
            }

            // 恢复最后 k-1 列的连通分量大小
            for (int l = n - k + 1; l < n; l++) {
                for (int i = top; i < top + k; i++) {
                    int compId = id[i][l];
                    if (compId > 0) {
                        size[compId]++;
                    }
                }
            }
        }
        out.println(ans + k * k);
    }

    static void dfs(int i, int j, int compId) {
        id[i][j] = compId;
        size[compId]++;
        for (int[] d : dir4) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < n && a[x].charAt(y) != 'X' && id[x][y] == 0) {
                dfs(x, y, compId);
            }
        }
    }
}
/*
C. Bear and Square Grid
https://codeforces.com/contest/679/problem/C

灵茶の试炼 2025-07-11
题目大意：
输入 n(1≤n≤500) k(1≤k≤n) 和一个 n 行 n 列的网格图，只包含 .（表示空地）和 X（表示障碍）。
你可以把一个 k*k 大小的区域中的格子全部变成空地。这个操作只能执行一次。
输出操作后，网格图的最大空地连通块的大小（连通块的空地个数）。
注：网格图是上下左右四连通的。

rating 2400
推荐先完成本题 k=1 的简单版本 LC827. 最大人工岛，原题是 CF616C。
假设我们在某个 k*k 的区域操作，那么在这个区域之外的一圈（除去四角）连通块，就全部连起来了。
所以问题就是计算外面这一圈连通块的大小之和。
注意，对于这些连通块的大小，需要减去在 k*k 区域中的空地个数，避免重复统计。
注意，类似 U 型锁，外面这一圈的某些连通块，可能原本就是同一个连通块，我们需要给连通块编号，避免重复统计。
枚举 k*k 区域的上边界，那么下边界就知道了。
固定上下边界后，我们可以用长为 k 的定长滑动窗口解决。进入窗口就减少连通块的大小，离开窗口就增大连通块的大小。
注意收尾工作：最后一个窗口算完后，需要恢复（增大）窗口中的连通块大小。
代码 https://codeforces.com/contest/679/submission/326719684
代码备份（Ubuntu Pastebin）
======

Input
5 2
..XXX
XX.XX
X.XXX
X...X
XXXX.
Output
10

Input
5 3
.....
.XXX.
.XXX.
.XXX.
.....
Output
25
 */
