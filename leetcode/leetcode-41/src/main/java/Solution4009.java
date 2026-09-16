import java.util.HashMap;
import java.util.Map;

public class Solution4009 {
    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        int n = demand.length;
        Map<Long, Integer> cur = new HashMap<>();
        cur.put(encode(0, 0, 0, fuel[0], fuel[1]), 0);
        int served = 0;
        while (served < n) {
            int d = demand[served];
            Map<Long, Integer> next = new HashMap<>();
            for (Map.Entry<Long, Integer> e : cur.entrySet()) {
                long key = e.getKey();
                int mw = e.getValue();
                int[] st = decode(key);
                int t = st[0], f0 = st[1], f1 = st[2], r0 = st[3], r1 = st[4];
                if (r0 >= d) {
                    int wait = f0 - t;
                    long nk = encode(f0, f0 + d, Math.max(f1, f0), r0 - d, r1);
                    putMin(next, nk, Math.max(mw, wait));
                }
                if (r1 >= d) {
                    int wait = f1 - t;
                    long nk = encode(f1, Math.max(f0, f1), f1 + d, r0, r1 - d);
                    putMin(next, nk, Math.max(mw, wait));
                }
            }
            if (next.isEmpty()) {
                if (served == 0) return -1;
                int ans = Integer.MAX_VALUE;
                for (int v : cur.values()) ans = Math.min(ans, v);
                return ans;
            }
            cur = next;
            served++;
        }
        int ans = Integer.MAX_VALUE;
        for (int v : cur.values()) ans = Math.min(ans, v);
        return ans;
    }

    private static final int BT = 128;
    private static final int BR = 64;

    private long encode(int t, int f0, int f1, int r0, int r1) {
        return ((((long) t * BT + f0) * BT + f1) * BR + r0) * BR + r1;
    }

    private int[] decode(long key) {
        int[] st = new int[5];
        st[4] = (int) (key % BR);
        key /= BR;
        st[3] = (int) (key % BR);
        key /= BR;
        st[2] = (int) (key % BT);
        key /= BT;
        st[1] = (int) (key % BT);
        key /= BT;
        st[0] = (int) key;
        return st;
    }

    private void putMin(Map<Long, Integer> map, long key, int mw) {
        Integer old = map.get(key);
        if (old == null || mw < old) {
            map.put(key, mw);
        }
    }
}
/*
4009. 最小化最大可能等待时间
https://leetcode.cn/problems/minimum-possible-maximum-waiting-time/description/

第 188 场双周赛 T4。

给你一个整数数组 demand，其中 demand[i] 是第 i 辆车需要的燃料量。
同时给你一个长度为 2 的整数数组 fuel。有 恰好 两个加油机，编号为 0 和 1，其中 fuel[j] 是加油机 j 中可用的初始燃料量。
允许车辆按 递增 的下标顺序开始加油。第 0 辆车在时间 0 被允许加油，对于每个 i > 0，第 i 辆车 恰好 在第 i - 1 辆车开始加油时被允许加油。
加油过程遵循以下规则：
- 每个加油机一次 最多 只能服务一辆车。
- 只有当加油机空闲且剩余燃料 至少 为 demand[i] 时，车辆才能在该加油机开始加油。
- 汽车等待所选加油机空闲后 立即 开始加油。它不能切换加油机或在所选加油机空闲后故意等待。
- 给一辆车加油需要 demand[i] 秒，并将该加油机的剩余燃料减少 demand[i]。
- 一旦开始，加油过程不能被中断。
- 当两个加油机都空闲时，如果没有任何一个加油机的剩余燃料 至少 为 demand[i]，则过程终止，且无法再服务更多车辆。
车辆的 等待时间 是从它被允许开始加油到实际开始加油之间的时间。
在 最大化 被服务车辆数量的所有分配方案中，返回所有被服务车辆中 最大 等待时间的 最小 可能值。如果没有车辆可以被服务，返回 -1。
提示：
1 <= demand.length <= 50
1 <= demand[i] <= 20
fuel.length == 2
1 <= fuel[i] <= 50

多维 DP。
 */