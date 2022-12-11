import java.util.ArrayList;
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
 */