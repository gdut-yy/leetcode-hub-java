import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Ccbft211029T3_2 {
    // 吴自华: 第三题可以在排名页看Vigilant ShockleyAL9的代码，很清晰。以换乘次数作为第一权值，当前路径作为第二权值，直接套Dijkstra即可。
    // https://leetcode-cn.com/contest/ccbft-2021fall/ranking/
    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        // n2line = collections.defaultdict(list)
        Map<Integer, List<Integer>> n2line = new HashMap<>();
        // neighbour = collections.defaultdict(lambda: collections.defaultdict(list))
        Map<Integer, Map<Integer, List<Integer>>> neighbour = new HashMap<>();

        // for i, nodes in enumerate(lines):
        for (int i = 0; i < lines.length; i++) {
            int[] nodes = lines[i];

            // for j, nt in enumerate(nodes):
            for (int j = 0; j < nodes.length; j++) {
                int nt = nodes[j];

                // n2line[nt].append(i)
                List<Integer> ntList = n2line.getOrDefault(nt, new ArrayList<>());
                ntList.add(i);
                n2line.put(nt, ntList);

                // if j < len(nodes) - 1:
                if (j < nodes.length - 1) {
                    // nnt = nodes[j + 1]
                    // neighbour[nt][nnt].append(i)
                    // neighbour[nnt][nt].append(i)
                    int nnt = nodes[j + 1];
                    neighbourAppend(neighbour, nt, nnt, i);
                    neighbourAppend(neighbour, nnt, nt, i);
                }
            }
        }

        // heap = [[-1, [start], None]]
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.ct == o2.ct) {
                for (int i = 0; i < o1.patht.size() && i < o2.patht.size(); i++) {
                    if (!o1.patht.get(i).equals(o2.patht.get(i))) {
                        return o1.patht.get(i).compareTo(o2.patht.get(i));
                    }
                }
                return o1.patht.size() - o2.patht.size();
            }
            return o1.ct - o2.ct;
        });
        priorityQueue.add(new Node(-1, List.of(start), -1));

        // while len(heap) > 0:
        while (!priorityQueue.isEmpty()) {
            // ct, patht, last_line = heapq.heappop(heap)
            Node node = priorityQueue.poll();
            int ct = node.ct;
            List<Integer> patht = node.patht;
            int last_line = node.last_line;

            // if patht[-1] == end:
            //     return patht
            int pathtLast = patht.get(patht.size() - 1);
            if (pathtLast == end) {
                return patht.stream().mapToInt(i -> i).toArray();
            }

            // s_path = set(patht)
            Set<Integer> s_path = new HashSet<>(patht);

            // for nb in neighbour[patht[-1]]:
            Map<Integer, List<Integer>> neighbourPathtLast = neighbour.getOrDefault(pathtLast, new HashMap<>());
            for (int nb : neighbourPathtLast.keySet()) {
                // if nb in s_path:
                //     continue
                if (s_path.contains(nb)) {
                    continue;
                }

                // if last_line in neighbour[patht[-1]][nb]:
                //     heapq.heappush(heap, [ct, patht + [nb], last_line])
                List<Integer> neighbourPathtLastNb = neighbourPathtLast.getOrDefault(nb, new ArrayList<>());
                if (neighbourPathtLastNb.contains(last_line)) {
                    List<Integer> copyPatht = new ArrayList<>(patht);
                    copyPatht.add(nb);
                    priorityQueue.add(new Node(ct, copyPatht, last_line));
                }
                // else:
                //     for llt in neighbour[patht[-1]][nb]:
                //         heapq.heappush(heap, [ct + 1, patht + [nb], llt])
                else {
                    for (int llt : neighbourPathtLastNb) {
                        List<Integer> copyPatht = new ArrayList<>(patht);
                        copyPatht.add(nb);
                        priorityQueue.add(new Node(ct + 1, copyPatht, llt));
                    }
                }
            }
        }
        return new int[]{};
    }

    private void neighbourAppend(Map<Integer, Map<Integer, List<Integer>>> neighbour, int nt, int nnt, int i) {
        Map<Integer, List<Integer>> ntMap = neighbour.getOrDefault(nt, new HashMap<>());
        List<Integer> ntNntList = ntMap.getOrDefault(nnt, new ArrayList<>());
        ntNntList.add(i);
        ntMap.put(nnt, ntNntList);
        neighbour.put(nt, ntMap);
    }

    private static class Node {
        int ct;
        List<Integer> patht;
        int last_line;

        public Node(int ct, List<Integer> patht, int last_line) {
            this.ct = ct;
            this.patht = patht;
            this.last_line = last_line;
        }
    }
}