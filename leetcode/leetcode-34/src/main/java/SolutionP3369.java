import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class SolutionP3369 {
    static class StatisticsTracker {
        Queue<Integer> q;
        DualHeap dh;
        Map<Integer, Integer> frequencies;
        TreeMap<Integer, TreeSet<Integer>> frequencyNumbers;

        public StatisticsTracker() {
            q = new ArrayDeque<>();
            dh = new DualHeap();
            frequencies = new HashMap<>();
            frequencyNumbers = new TreeMap<>();
        }

        public void addNumber(int number) {
            q.add(number);
            dh.add(-number); // 注意这里需要变通一下再调用板子，题目要求 如果中位数有两个选择，则取两个值中较大的一个。
            frequencies.merge(number, 1, Integer::sum);
            int frequency = frequencies.get(number);
            frequencyNumbers.putIfAbsent(frequency, new TreeSet<>());
            frequencyNumbers.get(frequency).add(number);
            if (frequency > 1) {
                frequencyNumbers.get(frequency - 1).remove(number);
                if (frequencyNumbers.get(frequency - 1).isEmpty()) {
                    frequencyNumbers.remove(frequency - 1);
                }
            }
        }

        public void removeFirstAddedNumber() {
            Integer rm = q.remove();
            dh.del(-rm);
            Integer frequency = frequencies.merge(rm, -1, Integer::sum);
            if (frequency == 0) {
                frequencies.remove(rm);
            }
            if (frequency > 0) {
                frequencyNumbers.putIfAbsent(frequency, new TreeSet<>());
                frequencyNumbers.get(frequency).add(rm);
            }
            frequencyNumbers.get(frequency + 1).remove(rm);
            if (frequencyNumbers.get(frequency + 1).isEmpty()) {
                frequencyNumbers.remove(frequency + 1);
            }
        }

        public int getMean() {
            long sum = dh.largeSum + dh.smallSum;
            return (int) (-sum / q.size());
        }

        public int getMedian() {
            return -dh.median();
        }

        public int getMode() {
            return frequencyNumbers.lastEntry().getValue().first();
        }

        static class DualHeap {
            PriorityQueue<Integer> small, large;
            int smallSize, largeSize;
            long smallSum, largeSum;
            Map<Integer, Integer> delayed;

            public DualHeap() {
                small = new PriorityQueue<>(Comparator.reverseOrder());
                large = new PriorityQueue<>();
                smallSize = 0;
                largeSize = 0;
                smallSum = 0;
                largeSum = 0;
                delayed = new HashMap<>();
            }

            public void add(int num) {
                if (small.isEmpty() || num <= small.peek()) {
                    small.offer(num);
                    smallSize++;
                    smallSum += num;
                } else {
                    large.offer(num);
                    largeSize++;
                    largeSum += num;
                }
                balance();
            }

            public void del(int num) {
                delayed.merge(num, 1, Integer::sum);
                if (num <= small.peek()) {
                    smallSize--;
                    smallSum -= num;
                } else {
                    largeSize--;
                    largeSum -= num;
                }
                balance();
            }

            public int median() {
                return small.peek();
            }

            public void balance() {
                if (smallSize > largeSize + 1) {
                    int num = small.poll();
                    large.offer(num);
                    smallSize--;
                    largeSize++;
                    smallSum -= num;
                    largeSum += num;
                } else if (smallSize < largeSize) {
                    int num = large.poll();
                    small.offer(num);
                    smallSize++;
                    largeSize--;
                    smallSum += num;
                    largeSum -= num;
                }
                for (PriorityQueue<Integer> pq : Arrays.asList(small, large)) {
                    while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
                        int num = pq.poll();
                        if (delayed.merge(num, -1, Integer::sum) == 0) {
                            delayed.remove(num);
                        }
                    }
                }
            }
        }
    }
}
/*
$3369. 设计数组统计跟踪器
https://leetcode.cn/problems/design-an-array-statistics-tracker/description/

设计一个数据结构来跟踪它其中的值，并回答一些有关其平均值、中位数和众数的询问。
实现 StatisticsTracker 类。
- StatisticsTracker()：用空数组初始化 StatisticsTracker 对象。
- void addNumber(int number)：将 number 添加到数据结构中。
- void removeFirstAddedNumber()：从数据结构删除最早添加的数字。
- int getMean()：返回数据结构中数字向下取整的 平均值。
- int getMedian()：返回数据结构中数字的 中位数。
- int getMode()：返回数据结构中数字的 众数。如果有多个众数，返回最小的那个。
注意：
- 数组的 平均值 是所有值的和除以数组中值的数量。
- 数组的 中位数 是在非递减顺序排序后数组的中间元素。如果中位数有两个选择，则取两个值中较大的一个。
- 数组的 众数 是数组中出现次数最多的元素。
提示：
1 <= number <= 10^9
addNumber，removeFirstAddedNumber，getMean，getMedian 和 getMode 的总调用次数最多为 10^5。
removeFirstAddedNumber，getMean，getMedian 和 getMode 只会在数据结构中至少有一个元素时被调用。

对顶堆，懒删除。
相似题目: 480. 滑动窗口中位数
https://leetcode.cn/problems/sliding-window-median/description/
$3422. 将子数组元素变为相等所需的最小操作数
https://leetcode.cn/problems/minimum-operations-to-make-subarray-elements-equal/description/
 */