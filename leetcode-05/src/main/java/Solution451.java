import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            stringBuilder.append(String.valueOf(cur.ch).repeat(Math.max(0, cur.cnt)));
        }
        return stringBuilder.toString();
    }

    private static class Node {
        char ch;
        int cnt;

        public Node(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
/*
451. 根据字符出现频率排序
https://leetcode-cn.com/problems/sort-characters-by-frequency/

给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
注意'A'和'a'被认为是两种不同的字符。

HashMap 统计频次 + 优先队列。
 */