import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SolutionP3422 {
    static class V1 {
        public long minOperations(int[] nums, int k) {
            long ans = Long.MAX_VALUE;
            DualHeap dh = new DualHeap();
            for (int r = 0; r < nums.length; r++) {
                // 1. 右进
                dh.add(nums[r]);
                int l = r - k + 1; // 窗口左端点
                if (l < 0) continue; // 窗口大小不足 k，尚未形成第一个窗口
                // 2. 更新答案
                int median = dh.median();
                long cost = dh.largeSum - median * dh.largeSize
                        + median * dh.smallSize - dh.smallSum;
                ans = Math.min(ans, cost);
                // 3. 左出
                dh.del(nums[l]);
            }
            return ans;
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
                delayed.put(num, delayed.getOrDefault(num, 0) + 1);
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

    static class V2 {
        public long minOperations(int[] nums, int k) {
            int n = nums.length;
            MultiSets ms = new MultiSets(k, k / 2);
            long ans = Long.MAX_VALUE;
            for (int r = 0; r < n; r++) {
                // 1. 右进
                ms.add(nums[r]);
                int l = r - k + 1; // 窗口左端点
                if (l < 0) continue; // 窗口大小不足 k，尚未形成第一个窗口
                // 2. 更新答案
                long median = ms.median();
                long cost = ms.largeSum - median * ms.largeSize
                        + median * ms.smallSize - ms.smallSum;
                ans = Math.min(ans, cost);
                // 3. 左出
                ms.del(nums[l]);
            }
            return ans;
        }

        static class MultiSets {
            int n, k;
            TreeMap<Integer, Integer> large, small; // 原为 x, y
            int largeSize, smallSize;
            long largeSum, smallSum;

            // n:窗口大小, k:第 k 大 (0-index)
            public MultiSets(int n, int k) {
                this.n = n;
                this.k = k;
                this.large = new TreeMap<>();
                this.small = new TreeMap<>();
                this.largeSize = 0;
                this.smallSize = 0;
                largeSum = 0;
                smallSum = 0;
            }

            private void add(int v) {
                yInsert(v);
                balance();
            }

            private void del(int v) {
                if (large.containsKey(v)) xErase(v);
                else yErase(v);
                balance();
            }

            int median() {
                return small.lastKey();
            }

            private void balance() {
                if (largeSize + smallSize < n) return;
                while (largeSize < k) {
                    int ey = small.lastKey();
                    xInsert(ey);
                    yErase(ey);
                }
                if (largeSize == 0 || smallSize == 0) return;
                while (true) {
                    int ex = large.firstKey();
                    int ey = small.lastKey();
                    if (ex >= ey) break;
                    xErase(ex);
                    yErase(ey);
                    xInsert(ey);
                    yInsert(ex);
                }
            }

            private void xInsert(int v) {
                large.merge(v, 1, Integer::sum);
                largeSize++;
                largeSum += v;
            }

            private void yInsert(int v) {
                small.merge(v, 1, Integer::sum);
                smallSize++;
                smallSum += v;
            }

            private void xErase(int v) {
                if (large.merge(v, -1, Integer::sum) == 0) large.remove(v);
                largeSize--;
                largeSum -= v;
            }

            private void yErase(int v) {
                if (small.merge(v, -1, Integer::sum) == 0) small.remove(v);
                smallSize--;
                smallSum -= v;
            }
        }
    }
}
/*
$3422. 将子数组元素变为相等所需的最小操作数
https://leetcode.cn/problems/minimum-operations-to-make-subarray-elements-equal/description/

给定一个整数数组 nums 和一个整数 k。你可以进行任意次以下操作：
- 给 nums 的任何元素增加或减少 1。
返回确保 至少 有一个大小为 k 的 nums 中的 子数组 的所有元素都相等的所需的 最小 操作数。
提示：
2 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6
2 <= k <= nums.length

对顶堆。
相似题目: 480. 滑动窗口中位数
https://leetcode.cn/problems/sliding-window-median/description/
$3369. 设计数组统计跟踪器
https://leetcode.cn/problems/design-an-array-statistics-tracker/description/
 */