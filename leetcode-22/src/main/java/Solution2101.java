import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2101 {
    private Map<Integer, List<Integer>> outGraph;

    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        outGraph = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] bomb1 = bombs[i];
                int[] bomb2 = bombs[j];
                if (check(bomb1, bomb2)) {
                    List<Integer> outList = outGraph.getOrDefault(i, new ArrayList<>());
                    outList.add(j);
                    outGraph.put(i, outList);
                }
                if (check(bomb2, bomb1)) {
                    List<Integer> outList = outGraph.getOrDefault(j, new ArrayList<>());
                    outList.add(i);
                    outGraph.put(j, outList);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, bfs(i, len));
        }
        return max;
    }

    private int bfs(int bomb, int len) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        queue.add(bomb);
        visited[bomb] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                cnt++;
                for (int next : outGraph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * bomb1 能否引爆 bomb2
     */
    private boolean check(int[] bomb1, int[] bomb2) {
        long disX = bomb1[0] - bomb2[0];
        long disY = bomb1[1] - bomb2[1];
        long powerSum = disX * disX + disY * disY;
        // 爆炸范围的 半径
        long r1 = bomb1[2];
        return powerSum <= r1 * r1;
    }
}
/*
2101. 引爆最多的炸弹
https://leetcode-cn.com/problems/detonate-the-maximum-bombs/

第 67 场双周赛 T3。

给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，
ri 表示爆炸范围的 半径 。
你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。

范围 10^2
时间复杂度 O(n^3)
建有向图，然后逐个点 BFS，求最大值。（比赛时先入为主以为是无向图并查集，发现时为时已晚。。）
 */