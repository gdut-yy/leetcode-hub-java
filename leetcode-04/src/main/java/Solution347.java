import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else {
                if (entry.getValue() > priorityQueue.element().getValue()) {
                    priorityQueue.remove();
                    priorityQueue.add(entry);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.remove().getKey();
        }
        return res;
    }
}
/*
347. 前 K 个高频元素
https://leetcode-cn.com/problems/top-k-frequent-elements/

给你一个整数数组 nums 和一个整数 k，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

优先队列（小顶堆）
 */