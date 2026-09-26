import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class espressif02 {
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

    private static void solve() {
        int p = scanner.nextInt();
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();

        // 族谱是一棵树：每个父亲最多两个儿子
        int[] parent = new int[p];
        int[] child1 = new int[p];
        int[] child2 = new int[p];
        Arrays.fill(parent, -1);
        Arrays.fill(child1, -1);
        Arrays.fill(child2, -1);

        for (int i = 0; i < p - 1; i++) {
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            parent[s] = f;
            if (child1[f] == -1) {
                child1[f] = s;
            } else {
                child2[f] = s;
            }
        }

        // 唯一没有父亲的人就是共同祖先（根）
        int root = 0;
        for (int i = 0; i < p; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }

        // 计算每个人的辈份（根的辈份为 0）
        int[] depth = new int[p];
        int[] stack = new int[p];
        int size = 0;
        stack[size++] = root;
        while (size > 0) {
            int u = stack[--size];
            if (child1[u] != -1) {
                depth[child1[u]] = depth[u] + 1;
                stack[size++] = child1[u];
            }
            if (child2[u] != -1) {
                depth[child2[u]] = depth[u] + 1;
                stack[size++] = child2[u];
            }
        }

        // 找最近公共祖先（两人先走到同一层，再一起向上）
        int a = p1;
        int b = p2;
        int da = depth[a];
        int db = depth[b];
        while (da > db) {
            a = parent[a];
            da--;
        }
        while (db > da) {
            b = parent[b];
            db--;
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        int lca = a;

        // 亲疏关系：树上最短路径的边数
        int d = depth[p1] + depth[p2] - 2 * depth[lca];
        // 辈份关系：第一个人高于第二个人的辈份数
        int gen = depth[p2] - depth[p1];
        out.println(d + " " + gen);
    }
}
/*
家族关系
https://leetcode.cn/leetbook/read/espressif/5wuoar/

有一本族谱里，记录了一个家族多代人的关系。该族谱只记录同族的男丁，且记录了所有同族的男丁。族谱里只有一个共同祖先，其余的人都是他的后代。每个父亲最多只有两个儿子，且所有的父子关系都被记录。请判断任意两个人的亲疏关系和辈份关系。亲疏关系可以使用数字表示，如父子关系是 1，爷孙关系和兄弟关系是 2，以此类推。辈份关系是指第一个人高于第二个人的辈份数，可以是正数，负数或 0。
输入描述:
每组输入包含p行。
第一行，输入3个整数p，P1，P2，其中p表示族谱中的人数（他们用 0 - p-1 进行编号），他们间的父子关系对数是 p - 1（除了共同祖先，每个人的父亲都在族谱里），P1，P2表示需要检查关系的两个人的编号。
第2到p行，每行两个整数Fi，Si（0 <= i < p - 1），表示Fi是Si的父亲。
输出描述:
输出只有一行，包含2个整数d，b，分别表示P1和P2的亲疏关系和辈份关系。
示例1
输入
15 7 2
0 1
0 2
1 3
1 4
2 5
2 6
3 7
3 8
4 9
4 10
5 11
5 12
6 13
6 14
输出
4 -2
 */
