import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1338 {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : arr) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            priorityQueue.add(entry.getValue());
        }
        int cnt = 0;
        int ans = 0;
        while (!priorityQueue.isEmpty()) {
            cnt += priorityQueue.poll();
            ans++;
            if (cnt >= len / 2) {
                return ans;
            }
        }
        return len;
    }
}
/*
1338. 数组大小减半
https://leetcode-cn.com/problems/reduce-array-size-to-the-half/

统计各数值频次，贪心法，从最大频次开始统计至半数即可。
 */