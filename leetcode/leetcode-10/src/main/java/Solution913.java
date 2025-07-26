import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution913 {
    private static final int HOLE = 0;

    public int catMouseGame(int[][] g) {
        int n = g.length;
        int[][][] deg = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                deg[i][j][0] = g[i].length;
                deg[i][j][1] = g[j].length;
            }
            // 对于猫来说，所有连到洞的边都不能走
            for (int j : g[HOLE]) {
                deg[i][j][1]--;
            }
        }

        int[][][] winner = new int[n][n][2];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            winner[HOLE][i][1] = 1; // 鼠到达洞中（此时轮到猫移动），鼠获胜
            winner[i][i][0] = winner[i][i][1] = 2; // 猫和鼠出现在同一个节点，无论轮到谁移动，都是猫获胜
            q.offer(new int[]{HOLE, i, 1}); // 从终点开始倒推
            q.offer(new int[]{i, i, 0});
            q.offer(new int[]{i, i, 1});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int mouse = cur[0], cat = cur[1], turn = cur[2];
            int win = winner[mouse][cat][turn]; // 最终谁赢了
            for (int[] pre : getPreStates(mouse, cat, turn, g, winner)) {
                int preMouse = pre[0], preCat = pre[1], preTurn = turn ^ 1;
                // 情况一：如果上一回合鼠从 pre 移动到 cur，最终鼠赢，那么标记 pre 状态的 winner = 鼠
                // 情况二：如果上一回合猫从 pre 移动到 cur，最终猫赢，那么标记 pre 状态的 winner = 猫
                // 情况三：如果上一回合鼠从 pre 移动到 cur，最终猫赢，那么待定，直到我们发现从 pre 出发能到达的状态都是猫赢，那么标记 pre 状态的 winner = 猫
                // 情况四：如果上一回合猫从 pre 移动到 cur，最终鼠赢，那么待定，直到我们发现从 pre 出发能到达的状态都是鼠赢，那么标记 pre 状态的 winner = 鼠
                if (preTurn == win - 1 || --deg[preMouse][preCat][preTurn] == 0) {
                    winner[preMouse][preCat][preTurn] = win;
                    q.offer(new int[]{preMouse, preCat, preTurn}); // 继续倒推
                }
            }
        }

        // 鼠在节点 1，猫在节点 2，当前轮到鼠移动
        return winner[1][2][0]; // 返回最终谁赢了（或者平局）
    }

    // 获取 (mouse, cat, turn) 的上个状态（值尚未确定）
    private List<int[]> getPreStates(int mouse, int cat, int turn, int[][] g, int[][][] winner) {
        List<int[]> preStates = new ArrayList<>();
        if (turn == 0) { // 当前轮到鼠移动
            for (int preCat : g[cat]) { // 上一轮猫的位置
                if (preCat != HOLE && winner[mouse][preCat][1] == 0) { // 猫无法移动到洞中
                    preStates.add(new int[]{mouse, preCat});
                }
            }
        } else { // 当前轮到猫移动
            for (int preMouse : g[mouse]) { // 上一轮鼠的位置
                if (winner[preMouse][cat][0] == 0) {
                    preStates.add(new int[]{preMouse, cat});
                }
            }
        }
        return preStates;
    }
}
/*
913. 猫和老鼠
https://leetcode.cn/problems/cat-and-mouse/

第 104 场周赛 T4。

两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
此外，猫无法移动到洞中（节点 0）。
然后，游戏在出现以下三种情形之一时结束：
- 如果猫和老鼠出现在同一个节点，猫获胜。
- 如果老鼠到达洞中，老鼠获胜。
- 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
- 如果老鼠获胜，则返回 1；
- 如果猫获胜，则返回 2；
- 如果平局，则返回 0 。
提示：
3 <= graph.length <= 50
1 <= graph[i].length < graph.length
0 <= graph[i][j] < graph.length
graph[i][j] != i
graph[i] 互不相同
猫和老鼠在游戏中总是移动

逆向思维 + 拓扑序 DP https://leetcode.cn/problems/cat-and-mouse/solutions/3070461/ni-xiang-si-wei-tuo-bu-xu-dppythonjavacg-wp8k/
时间复杂度 O(n^3)
相似题目: 1728. 猫和老鼠 II
https://leetcode.cn/problems/cat-and-mouse-ii/description/
 */