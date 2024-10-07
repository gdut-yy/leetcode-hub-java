import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCR160 {
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
            return (maxHeap.element() + minHeap.element()) / 2.0;
        }
    }
}
/*
LCR 160. 数据流中的中位数
https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/

中位数 是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
- void addNum(int num) - 从数据流中添加一个整数到数据结构中。
- double findMedian() - 返回目前所有元素的中位数。
提示：
最多会对 addNum、findMedian 进行 50000 次调用。

同: 295. 数据流的中位数
https://leetcode.cn/problems/find-median-from-data-stream/
 */