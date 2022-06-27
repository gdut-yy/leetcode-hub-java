import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionO41 {
    static class MedianFinder {
        // 小顶堆
        private final PriorityQueue<Integer> minHeap;
        // 大顶堆
        private final PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
                if (minHeap.size() + 1 < maxHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
/*
剑指 Offer 41. 数据流中的中位数
https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/

同: 295. 数据流的中位数
https://leetcode.cn/problems/find-median-from-data-stream/
 */