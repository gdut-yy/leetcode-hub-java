import java.util.ArrayList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(0, graph, new ArrayList<>(), resList);
        return resList;
    }

    private void dfs(int source, int[][] graph, List<Integer> path, List<List<Integer>> resList) {
        path.add(source);
        if (source == graph.length - 1) {
            resList.add(new ArrayList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, resList);
            }
        }
        path.remove(path.size() - 1);
    }
}
/*
797. 所有可能的路径
https://leetcode-cn.com/problems/all-paths-from-source-to-target/

深度优先搜索。
 */