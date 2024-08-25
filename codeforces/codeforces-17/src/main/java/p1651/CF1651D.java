package p1651;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class CF1651D {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            s.put(new Pair(x, y), i);
        }
        System.out.println(solve());
    }

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Map<Pair, Integer> s;

    private static String solve() {
        String[] ans = new String[n];
        Queue<P2> q = new ArrayDeque<>();
        for (Map.Entry<Pair, Integer> entry : s.entrySet()) {
            Pair v = entry.getKey();
            Integer i = entry.getValue();
            for (int[] d : DIRECTIONS) {
                Pair w = new Pair(v.x + d[0], v.y + d[1]);
                if (!s.containsKey(w)) {
                    ans[i - 1] = w.toString();
                    q.add(new P2(v.x, v.y, w.toString()));
                    break;
                }
            }
        }
        for (P2 p : q) {
            s.remove(new Pair(p.i, p.j));
        }
        while (!q.isEmpty()) {
            P2 v = q.remove();
            for (int[] d : DIRECTIONS) {
                Pair w = new Pair(v.i + d[0], v.j + d[1]);
                if (s.containsKey(w)) {
                    int i = s.get(w);
                    s.remove(w);
                    ans[i - 1] = v.p;
                    q.add(new P2(w.x, w.y, v.p));
                }
            }
        }
        return String.join(System.lineSeparator(), ans);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            // Time limit exceeded on test 43
//            return Objects.hash(x, y);
            return Objects.hash(toString());
        }
    }

    static class P2 {
        int i, j;
        String p;

        public P2(int i, int j, String p) {
            this.i = i;
            this.j = j;
            this.p = p;
        }
    }
}
/*
D. Nearest Excluded Points
https://codeforces.com/contest/1651/problem/D

灵茶の试炼 2022-10-12
题目大意：
输入 n(≤2e5) 和 n 个二维平面上的互不相同的整点，坐标范围 [1,2e5]。
对每个整点，输出离它曼哈顿距离最近的，且不在输入中的整点。
两点的曼哈顿距离=横坐标之差的绝对值+纵坐标之差的绝对值。

rating 1900
https://codeforces.com/contest/1651/submission/175313097
把输入想象成海岛（群岛），对每个点，求其最近的海岸点。
从最特殊的点入手，即海滩上的点，这些点可以直接取四周中的一个不在输入中的点作为答案。
从这些点出发，写一个 BFS，去求出那些被包围的点的答案。
需要一些实现能力。我的代码中用删除操作来代替 vis 数组。
相似题目: 417. 太平洋大西洋水流问题
https://leetcode.cn/problems/pacific-atlantic-water-flow/
======

input
6
2 2
1 2
2 1
3 2
2 3
5 5
output
1 1
1 1
2 0
3 1
2 4
5 4

input
8
4 4
2 4
2 2
2 3
1 4
4 2
1 3
3 3
output
4 3
2 5
2 1
2 5
1 5
4 1
1 2
3 2
 */
