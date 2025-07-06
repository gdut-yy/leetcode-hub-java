import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1036 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int M = 1000000;
    private static final int N = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // 没有方格被封锁，所以一定可以到达目标方格。
        if (blocked.length == 0) {
            return true;
        }
        Set<String> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] + ":" + block[1]);
        }
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] source, int[] target, Set<String> blockedSet) {
        // BFS
        Queue<int[]> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.add(source);
        vis.add(source[0] + ":" + source[1]);

        // blockedSet 可以围住的最大个数
        int k = blockedSet.size();
        int max = k * (k - 1) / 2;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove();
                // 到达目标方格
                if (Arrays.equals(cur, target)) {
                    return true;
                }
                for (int[] d : DIRECTIONS) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !vis.contains(nx + ":" + ny)
                            && !blockedSet.contains(nx + ":" + ny)) {
                        vis.add(nx + ":" + ny);
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            // 若访问过的点超出范围，必定可达
            if (cnt > max) {
                return true;
            }
        }
        return false;
    }
}
/*
1036. 逃离大迷宫
https://leetcode.cn/problems/escape-a-large-maze/

第 134 场周赛 T4。

在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，
其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
提示：
0 <= blocked.length <= 200
blocked[i].length == 2
0 <= xi, yi < 10^6
source.length == target.length == 2
0 <= sx, sy, tx, ty < 10^6
source != target
题目数据保证 source 和 target 不在封锁列表内

我们知道 BFS 时空复杂度在 O(n^2) 10^6 妥妥 TLE + MLE
因此需要转变思维，从长度为 200 的 blocked 入手。
 */