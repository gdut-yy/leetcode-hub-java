import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // 拓扑排序
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        Set<Integer> seenSet = new HashSet<>();
        for (List<Integer> seq : seqs) {
            seenSet.addAll(seq);
            for (int i = 1; i < seq.size(); i++) {
                int pre = seq.get(i - 1);
                int cur = seq.get(i);

                Set<Integer> outSet = outGraph.getOrDefault(pre, new HashSet<>());
                outSet.add(cur);
                outGraph.put(pre, outSet);

                Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
                inSet.add(pre);
                inGraph.put(cur, inSet);
            }
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        int n = org.length;
        // 序列 org 是 1 到 n 整数的排列
        for (int i = 1; i <= n; i++) {
            // 用例 org = [1], seqs = []
            if (!seenSet.remove(i)) {
                return false;
            }
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        if (!seenSet.isEmpty()) {
            return false;
        }
        List<Integer> resList = new ArrayList<>();
        // 从 seqs 重建唯一的序列
        while (queue.size() == 1) {
            int cur = queue.remove();
            resList.add(cur);
            for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                inGraph.get(next).remove(cur);
                if (inGraph.get(next).size() == 0) {
                    queue.add(next);
                }
            }
        }
        int[] res = resList.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(org, res);
    }
}
/*
$444. 序列重建
https://leetcode-cn.com/problems/sequence-reconstruction/

验证原始的序列 org 是否可以从序列集 seqs 中唯一地重建。序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104 。
重建是指在序列集 seqs 中构建最短的公共超序列。（即使得所有  seqs 中的序列都是该最短序列的子序列）。
请你确定是否只可以从 seqs 重建唯一的序列，且该序列就是 org 。

拓扑排序。
 */