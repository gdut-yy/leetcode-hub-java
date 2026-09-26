import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class espressif03 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    /**
     * 算法：把子项目看作 AOE 网中的顶点，依赖关系 qi -> hi 看作有向边。
     * 项目的最早完成时间等于这个带权 DAG 上的最长路（关键路径）。
     *
     * 令 start[v] 表示子项目 v 的最早开始时间，则在拓扑排序的过程中：
     *     start[v] = max(start[v], start[u] + t[u])   （对所有边 u -> v）
     * 最终答案 = max(start[v] + t[v])。
     *
     * 时间复杂度：O(n + m)（拓扑排序 + 每条边处理一次）；
     * 空间复杂度：O(n + m)。
     */
    private static void solve() {
        int n = scanner.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        List<List<Integer>> next = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            next.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for (int i = 0; i < m; i++) {
            int q = scanner.nextInt();
            int h = scanner.nextInt();
            next.get(q).add(h);
            indeg[h]++;
        }

        int[] start = new int[n];
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue[tail++] = i;
            }
        }

        long answer = 0;
        while (head < tail) {
            int u = queue[head++];
            long finish = (long) start[u] + t[u];
            if (finish > answer) {
                answer = finish;
            }
            for (int v : next.get(u)) {
                if (finish > start[v]) {
                    start[v] = (int) finish;
                }
                if (--indeg[v] == 0) {
                    queue[tail++] = v;
                }
            }
        }
        out.println(answer);
    }
}
/*
项目管理
https://leetcode.cn/leetbook/read/espressif/5wt5ps/

假设你是一名项目管理人员，你的任务是通过收集信息，安排项目的执行，并跟踪项目进度。目前你有一个大项目需要安排，项目由 n (n < 1000) 子项目组成，而其中一些子项目是有依赖关系的。这种关系就是，其中一个子项目需要以另一个子项目的完成为前提。请计算出项目的最早完成时间。
请使用注释说明你的算法，并说明算法的复杂度。
输入描述:
每组输入包括n + m + 2行。
第1行只包含一个整数n，表示子项目的数量。
第2到n + 1行，每行一个整数ti，代表完成子项目i (0 <= i < n)所需的时间，其中0 < ti < 1000。
第n + 2行只包含一个整数m，表示子项目依赖关系的数量。
第n + 3到n + m + 2行，每行两个整数qi，hi(0 <= qi，hi < n)，代表qi项目完成以后才能开始hi项目。
输出描述:
输出只有一行，包含一个整数，表示最早完成时间。
示例1
输入
7
2
2
4
2
3
6
1
7
0 1
0 2
1 3
2 3
3 4
5 6
6 4
输出
11
 */
