import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SolutionLCP32 {
    // https://leetcode.cn/problems/t3fKg1/solution/you-xian-dui-lie-tan-xin-rust-by-lucifer-4spv/
    public int processTasks(int[][] tasks) {
        int n = tasks.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] task : tasks) {
            treeSet.add(task[0]);
            treeSet.add(task[1] + 1);
        }
        List<Integer> list = new ArrayList<>(treeSet);
        int m = list.size();
        Map<Integer, Integer> map = new HashMap<>(m);
        for (int i = 0; i < m; i++) {
            map.put(list.get(i), i);
        }

        // TODO
        List<ArrayList<Integer>> starts = Stream.generate(ArrayList<Integer>::new)
                .limit(m).toList();
        for (int i = 0; i < n; i++) {
            starts.get(map.get(tasks[i][0])).add(i);
        }

        int ans = 0;
        int extra = 0;
        // slots, index
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (o1, o2) -> {
            if (o1[0] > o2[0] || (o1[0] == o2[0] && o1[1] > o2[1])) {
                return 1;
            } else if (o1[0] < o2[0] || o1[1] < o2[1]) {
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < m - 1; i++) {
            while (!pq.isEmpty() && tasks[pq.peek()[1]][1] < list.get(i)) {
                pq.poll();
            }

            for (int u : starts.get(i)) {
                int slots = extra + tasks[u][1] - list.get(i) + 1 - tasks[u][2];
                pq.add(new int[]{slots, u});
            }

            int currentSeg = list.get(i + 1) - list.get(i);
            if (!pq.isEmpty()) {
                int minSlots = pq.peek()[0] - extra;
                int slotsToDel = currentSeg;

                if (minSlots < currentSeg) {
                    int delta = currentSeg - minSlots;
                    ans += delta;
                    slotsToDel -= delta;
                }

                extra += slotsToDel;
            }
        }

        return ans;
    }

    private static final int N = (int) 1e9;

    // TLE
    public int processTasks2(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));

        DynamicSegTreeUpd dynamicSegTreeUpd = new DynamicSegTreeUpd();
        for (int[] task : tasks) {
            int l = task[0], r = task[1], period = task[2];
            int sum = (int) dynamicSegTreeUpd.getSum(l, r);
            period -= sum;
            if (period > 0) {
                // r - l1 + 1 - sum(l1, r) = period
                // l1 = r + 1 - sum(l1, r) - period
                int left = l;
                int right = r;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    if ((r - mid + 1) - dynamicSegTreeUpd.getSum(mid, r) <= period) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                int l1 = left;
                dynamicSegTreeUpd.update(l1, r, 1);
            }
        }
        return (int) dynamicSegTreeUpd.getSum(0, N);
    }

    static class DynamicSegTreeUpd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, lazy;
        }

        // 区间 [l,r] 置为 val
        public void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 求和
        public long getSum(int l, int r) {
            return this.getSum(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum = (t - s + 1L) * val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private long getSum(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.sum;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, node.rs);
            }
            return sum;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.sum = node.lazy * (mid - s + 1L);
                node.rs.sum = node.lazy * (t - mid);
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
        }
    }
}
/*
LCP 32. 批量处理任务
https://leetcode.cn/problems/t3fKg1/

某实验室计算机待处理任务以 [start,end,period] 格式记于二维数组 tasks，表示完成该任务的时间范围为起始时间 start 至结束时间 end 之间，需要计算机投入 period 的时长，注意：
1. period 可为不连续时间
2. 首尾时间均包含在内
处于开机状态的计算机可同时处理任意多个任务，请返回电脑最少开机多久，可处理完所有任务。
提示：
2 <= tasks.length <= 10^5
tasks[i].length == 3
0 <= tasks[i][0] <= tasks[i][1] <= 10^9
1 <= tasks[i][2] <= tasks[i][1]-tasks[i][0] + 1

相似题目:
 */