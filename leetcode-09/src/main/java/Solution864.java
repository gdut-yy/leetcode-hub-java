import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution864 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = Integer.MAX_VALUE;
    private int M;
    private int N;

    public int shortestPathAllKeys(String[] grid) {
        this.M = grid.length;
        this.N = grid[0].length();

        // location : the points of interest
        Map<Character, int[]> location = new HashMap<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                char ch = grid[i].charAt(j);
                if (ch != '.' && ch != '#') {
                    location.put(ch, new int[]{i, j});
                }
            }
        }

        int targetState = (1 << (location.size() / 2)) - 1;
        Map<Character, Map<Character, Integer>> dists = new HashMap<>();
        for (char place : location.keySet()) {
            dists.put(place, bfsFrom(grid, place, location));
        }

        // Dijkstra
        PriorityQueue<ANode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        priorityQueue.add(new ANode(new Node('@', 0), 0));
        Map<Node, Integer> finalDist = new HashMap<>();
        finalDist.put(new Node('@', 0), 0);

        while (!priorityQueue.isEmpty()) {
            ANode anode = priorityQueue.poll();
            Node node = anode.node;
            int d = anode.dist;
            if (finalDist.getOrDefault(node, INF) < d) {
                continue;
            }
            if (node.state == targetState) {
                return d;
            }

            for (char destination : dists.get(node.place).keySet()) {
                int d2 = dists.get(node.place).get(destination);
                int state2 = node.state;
                if (Character.isLowerCase(destination)) {
                    // key
                    state2 |= (1 << (destination - 'a'));
                }
                if (Character.isUpperCase(destination)) {
                    // lock
                    if ((node.state & (1 << (destination - 'A'))) == 0) {
                        // no key
                        continue;
                    }
                }
                if (d + d2 < finalDist.getOrDefault(new Node(destination, state2), INF)) {
                    finalDist.put(new Node(destination, state2), d + d2);
                    priorityQueue.add(new ANode(new Node(destination, state2), d + d2));
                }
            }
        }
        return -1;
    }

    private Map<Character, Integer> bfsFrom(String[] grid, char source, Map<Character, int[]> location) {
        int sr = location.get(source)[0];
        int sc = location.get(source)[1];
        boolean[][] seen = new boolean[M][N];
        seen[sr][sc] = true;
        int curDepth = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        queue.add(null);
        Map<Character, Integer> dist = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p == null) {
                curDepth++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            int curM = p[0];
            int curN = p[1];
            if (grid[curM].charAt(curN) != source && grid[curM].charAt(curN) != '.') {
                dist.put(grid[curM].charAt(curN), curDepth);
                // Stop walking from here if we reach a point of interest
                continue;
            }

            for (int[] dir : DIRECTIONS) {
                int nextM = curM + dir[0];
                int nextN = curN + dir[1];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !seen[nextM][nextN]) {
                    if (grid[nextM].charAt(nextN) != '#') {
                        queue.add(new int[]{nextM, nextN});
                        seen[nextM][nextN] = true;
                    }
                }
            }
        }
        return dist;
    }

    private static class ANode {
        Node node;
        int dist;

        ANode(Node n, int d) {
            node = n;
            dist = d;
        }
    }

    private static class Node {
        char place;
        int state;

        Node(char p, int s) {
            place = p;
            state = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node other = (Node) o;
            return (place == other.place && state == other.state);
        }

        @Override
        public int hashCode() {
            return 256 * state + place;
        }
    }
}
/*
864. 获取所有钥匙的最短路径
https://leetcode.cn/problems/shortest-path-to-get-all-keys/

给定一个二维网格 grid ，其中：
- '.' 代表一个空房间
- '#' 代表一堵
- '@' 是起点
- 小写字母代表钥匙
- 大写字母代表锁
我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。
我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。
换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 30
grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
钥匙的数目范围是 [1, 6] 
每个钥匙都对应一个 不同 的字母
每个钥匙正好打开一个对应的锁

方法一: 暴力+枚举 因为钥匙的数目范围不超过 6，可以枚举每种钥匙组合。时间复杂度 O(m*n*A*A!) 理论上界 3,888,000
方法二: 关键点+dijkstra
官方题解: https://leetcode.cn/problems/shortest-path-to-get-all-keys/solution/huo-qu-suo-you-yao-chi-de-zui-duan-lu-jing-by-leet/
 */