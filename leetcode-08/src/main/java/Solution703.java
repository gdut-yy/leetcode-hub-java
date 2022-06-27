import java.util.PriorityQueue;

public class Solution703 {
    static class KthLargest {
        private final PriorityQueue<Integer> priorityQueue;
        private final int size;

        /**
         * 使用整数 k 和整数流 nums 初始化对象。
         *
         * @param k    第 k 大元素
         * @param nums 整数流 nums
         */
        public KthLargest(int k, int[] nums) {
            size = k;
            priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                this.add(num);
            }
        }

        /**
         * 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
         *
         * @param val val
         * @return int
         */
        public int add(int val) {
            if (priorityQueue.size() < size) {
                priorityQueue.add(val);
            } else if (val > priorityQueue.element()) {
                priorityQueue.remove();
                priorityQueue.add(val);
            }
            return priorityQueue.element();
        }
    }
}
/*
703. 数据流中的第 K 大元素
https://leetcode.cn/problems/kth-largest-element-in-a-stream/

优先队列（小顶堆）

每个 int add(int val) 时间复杂度为 O(logk)
priorityQueue 空间复杂度为 O(k)
 */