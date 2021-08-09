import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1962 {
    public int minStoneSum(int[] piles, int k) {
        // 大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            priorityQueue.add(pile);
        }
        while (!priorityQueue.isEmpty() && k > 0) {
            int curMax = priorityQueue.poll();
            int newVal = curMax - (int) Math.floor(curMax >> 1);
            priorityQueue.add(newVal);
            k--;
        }
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            res += priorityQueue.poll();
        }
        return res;
    }
}
/*
1962. 移除石子使总数最小
https://leetcode-cn.com/problems/remove-stones-to-minimize-the-total/

第 253 场周赛 T2。
使用优先队列大顶堆进行模拟即可。
 */