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
https://leetcode.cn/problems/remove-stones-to-minimize-the-total/

第 253 场周赛 T2。

给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
- 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
注意：你可以对 同一堆 石子多次执行此操作。
返回执行 k 次操作后，剩下石子的 最小 总数。
floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。

使用优先队列大顶堆进行模拟即可。
 */