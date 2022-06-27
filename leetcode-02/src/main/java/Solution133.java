import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);
        Map<Integer, Node> graph = new HashMap<>();
        graph.put(node.val, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.remove();
                for (Node neighbor : curNode.neighbors) {
                    if (!visited.contains(neighbor.val)) {
                        graph.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                        visited.add(neighbor.val);
                        queue.add(neighbor);
                    }
                    graph.get(curNode.val).neighbors.add(graph.get(neighbor.val));
                }
            }
        }
        return graph.get(node.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
/*
133. 克隆图
https://leetcode.cn/problems/clone-graph/

给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}

BFS
 */