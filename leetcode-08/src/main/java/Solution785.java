import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setColor(int[][] graph, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int neighbor : graph[v]) {
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }
}
/*
785. 判断二分图
https://leetcode-cn.com/problems/is-graph-bipartite/

广度优先搜索。
 */