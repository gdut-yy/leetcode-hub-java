package c205;

import java.io.PrintWriter;
import java.util.Scanner;

public class Arc205_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] deg = new int[n + 1]; // Java 数组默认初始化为0

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            deg[u]++;
            deg[v]++;
        }

        long totalEdges = (long) n * (n - 1) / 2;
        int countOdd = 0;
        for (int i = 1; i <= n; i++) {
            int whiteDeg = n - 1 - deg[i];
            if (whiteDeg % 2 != 0) {
                countOdd++;
            }
        }

        long result = totalEdges - countOdd / 2;
        out.println(result);
    }
}
/*
B - Triangle Toggle
https://atcoder.jp/contests/arc205/tasks/arc205_b

题目大意：
有一个完整的图，图中有 N 个顶点，编号为 1 至 N 。每条边的颜色为黑色或白色。在 i=1,2,...,M 中，连接顶点 U_i 和 V_i 的边被涂成黑色，其他所有边都被涂成白色。
您可以执行以下操作零次或多次。
- 选择满足 1 <= a < b <= c <= N 的整数 (a,b,c) 的三倍，并将以下三条边分别重新涂成白色到黑色，黑色到白色。
    - 连接顶点 a 和 b 的边
    - 连接顶点 b 和 c 的边
    - 连接顶点 a 和 c 的边
请找出在进行适当操作时最多可以将多少条边染成黑色。

https://yuanbao.tencent.com/chat/naQivTmsDa/faa770cb-8f04-4baa-9929-eb278fdb7126
======

Input 1
4 1
1 2
Output 1
5

Input 2
7 3
1 2
2 3
3 6
Output 2
20

Input 3
123123 0
Output 3
7579575003
 */
