import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3885 {
    static class EventManager {
        PriorityQueue<int[]> heap;
        Map<Integer, Integer> priorityMap;

        public EventManager(int[][] events) {
            heap = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });
            priorityMap = new HashMap<>();
            for (int[] e : events) {
                int id = e[0];
                int pri = e[1];
                priorityMap.put(id, pri);
                heap.offer(new int[]{-pri, id});
            }
        }

        public void updatePriority(int eventId, int newPriority) {
            priorityMap.put(eventId, newPriority);
            heap.offer(new int[]{-newPriority, eventId});
        }

        public int pollHighest() {
            while (!heap.isEmpty()) {
                int[] top = heap.poll();
                int negPri = top[0];
                int id = top[1];
                int expectedPri = -negPri;
                if (priorityMap.containsKey(id) && priorityMap.get(id) == expectedPri) {
                    priorityMap.remove(id);
                    return id;
                }
            }
            return -1;
        }
    }
}
/*
3885. 设计事件管理器
https://leetcode.cn/problems/design-event-manager/description/

第 495 场周赛 T2。

给你一组初始事件列表，其中每个事件有一个唯一的 eventId 和一个 priority（优先级）。
实现 EventManager 类：
- EventManager(int[][] events) 使用给定事件初始化管理器，其中 events[i] = [eventIdi, priorityi]。
- void updatePriority(int eventId, int newPriority) 更新具有 id 为 eventId 的 活跃 事件的优先级为 newPriority。
- int pollHighest() 移除并返回具有 最高优先级 的 活跃事件 的 eventId。如果有多个活动事件具有相同的优先级，则返回 eventId 最小的事件。如果没有活跃事件，则返回 -1。
如果一个事件没有被 pollHighest() 移除，则称其为 活跃事件。
提示：
1 <= events.length <= 10^5
events[i] = [eventId, priority]
1 <= eventId <= 10^9
1 <= priority <= 10^9
events 中的所有 eventId 值都是 唯一的 。
1 <= newPriority <= 10^9
对每次调用 updatePriority，eventId 都指向一个 活跃事件。
对 updatePriority 和 pollHighest 的总调用次数最多为 10^5 次。

懒更新堆。
https://chat.deepseek.com/a/chat/s/17d4725d-3c3a-4713-8fb0-e1e7ec633a47
 */