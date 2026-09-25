import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Meituan008 {
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
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] matrix = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        int res;
        if (x == y) {
            res = 0;
        } else {
            // 储存边
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] line : matrix) {
                int n1 = line[0];
                int n2 = line[1];
                List<Integer> list = map.getOrDefault(n1, new ArrayList<>());
                list.add(n2);
                map.put(n1, list);
                list = map.getOrDefault(n2, new ArrayList<>());
                list.add(n1);
                map.put(n2, list);
            }
            boolean[] visitedX = new boolean[matrix.length + 2];
            boolean[] visitedY = new boolean[matrix.length + 2];
            visitedX[x] = visitedY[y] = true;
            Deque<Integer> todoX = new ArrayDeque<>();
            Deque<Integer> todoY = new ArrayDeque<>();
            todoX.add(x);
            todoY.add(y);

            // cntY 为小团已到达但小美未到达的位置的数量
            int cntY = 1;
            int time = 0;

            // 同时BFS, 当小团没有位置时结束
            while (cntY > 0) {
                time++;
                // 小美要先BFS, 因为小团不可以去小美的位置
                int size = todoX.size();
                for (int i = 0; i < size; i++) {
                    int currX = todoX.poll();
                    for (int next : map.get(currX)) {
                        if (visitedX[next]) {
                            continue;
                        }
                        if (visitedY[next]) {
                            cntY--;
                        }
                        todoX.add(next);
                        visitedX[next] = true;
                    }
                }
                size = todoY.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        int currY = todoY.poll();
                        for (int next : map.get(currY)) {
                            if (visitedY[next] || visitedX[next]) {
                                continue;
                            }
                            todoY.add(next);
                            visitedY[next] = true;
                            cntY++;
                        }
                    }
                }
            }
            res = time;
        }

        out.print(res);
    }
}
/*
meituan-008. 小团无路可逃
https://leetcode.cn/problems/vSYUMc/

小团惹小美生气了，小美要去找小团“讲道理”。小团望风而逃，他们住的地方可以抽象成一棵有n个结点的树，小美位于 x 位置，小团位于 y 位置。
小团和小美每个单位时间内都可以选择不动或者向相邻的位置转移，很显然最终小团会无路可逃，只能延缓一下被“讲道理”的时间，
请问最多经过多少个单位时间后，小团会被追上。
格式：
输入：
- 输入第一行包含三个整数 n，x，y，分别表示树上的结点数量，小美所在的位置和小团所在的位置。
- 接下来有 n-1 行，每行两个整数 u，v，表示 u 号位置和 v 号位置之间有一条边，即 u 号位置和 v 号位置彼此相邻。
输出：
- 输出仅包含一个整数，表示小美追上小团所需的时间。
示例：
输入：
5 1 2
2 1
3 1
4 2
5 3
输出：2
提示：
1 <= n <= 50000
 */