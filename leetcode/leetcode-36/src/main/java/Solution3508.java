import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution3508 {
    // 队列上二分
    static class Router {
        record Packet(int source, int destination, int timestamp) {
        }

        int memoryLimit;
        Queue<Packet> packetQueue;
        Set<Packet> packetSet;
        Map<Integer, List<Integer>> destinationMap;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.packetQueue = new ArrayDeque<>();
            this.packetSet = new HashSet<>();
            this.destinationMap = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet newPacket = new Packet(source, destination, timestamp);
            if (packetSet.contains(newPacket)) {
                return false;
            }
            if (packetQueue.size() >= memoryLimit) {
                forwardPacket();
            }
            packetQueue.add(newPacket);
            packetSet.add(newPacket);

            List<Integer> destTsMap = destinationMap.computeIfAbsent(destination, e -> new ArrayList<>());
            destTsMap.add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (packetQueue.isEmpty()) {
                return new int[0];
            }
            Packet packet = packetQueue.remove();
            packetSet.remove(packet);
            int dest = packet.destination;
            List<Integer> tsMap = destinationMap.get(dest);
            tsMap.removeFirst(); // O(n)
            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> tsMap = destinationMap.get(destination);
            if (tsMap == null) {
                return 0;
            }
            int i = lowerBound(tsMap, startTime);
            int j = lowerBound(tsMap, endTime + 1);
            return j - i;
        }

        private int lowerBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) >= key) r = m;
                else l = m + 1;
            }
            return l;
        }
    }

    // 每个 destination 一个动态开点线段树
    static class Router2 {
        record Packet(int source, int destination, int timestamp) {
        }

        int memoryLimit;
        Queue<Packet> packetQueue;
        Set<Packet> packetSet;
        Map<Integer, DynamicLazySegmentTree> destinationMap;

        public Router2(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.packetQueue = new ArrayDeque<>();
            this.packetSet = new HashSet<>();
            this.destinationMap = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet newPacket = new Packet(source, destination, timestamp);
            if (packetSet.contains(newPacket)) {
                return false;
            }
            if (packetQueue.size() >= memoryLimit) {
                forwardPacket();
            }
            packetQueue.add(newPacket);
            packetSet.add(newPacket);

            DynamicLazySegmentTree destTsMap = destinationMap.computeIfAbsent(destination, k -> new DynamicLazySegmentTree());
            destTsMap.rangeApply(timestamp, timestamp, 1);
            return true;
        }

        public int[] forwardPacket() {
            if (packetQueue.isEmpty()) {
                return new int[0];
            }
            Packet packet = packetQueue.remove();
            packetSet.remove(packet);
            int dest = packet.destination;
            int ts = packet.timestamp;
            DynamicLazySegmentTree tsMap = destinationMap.get(dest);
            tsMap.rangeApply(ts, ts, -1);
            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            DynamicLazySegmentTree tsMap = destinationMap.get(destination);
            if (tsMap == null) {
                return 0;
            }
            return (int) tsMap.query(startTime, endTime);
        }

        // 动态开点线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
        static class DynamicLazySegmentTree {
            static final int N = (int) (1e9 + 10);
            final Node root = new Node();

            static class Node {
                Node ls, rs;
                long sum, lazy;
            }

            long mergeInfo(Node ls, Node rs) {
                return ls.sum + rs.sum;
            }

            void _do(Node p, int l, int r, long qv) {
                p.sum += (r - l + 1L) * qv;
                p.lazy += qv;
            }

            void rangeApply(int ql, int qr, int val) {
                this.rangeApply(root, 0, N, ql, qr, val);
            }

            void rangeApply(Node p, int l, int r, int ql, int qr, int qv) {
                if (ql <= l && r <= qr) {
                    _do(p, l, r, qv);
                    return;
                }
                int m = l + (r - l) / 2;
                spread(p, l, r, m);
                if (ql <= m) rangeApply(p.ls, l, m, ql, qr, qv);
                if (qr > m) rangeApply(p.rs, m + 1, r, ql, qr, qv);
                maintain(p);
            }

            long query(int ql, int qr) {
                return query(root, 0, N, ql, qr);
            }

            long query(Node p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return p.sum;
                }
                int m = l + (r - l) / 2;
                spread(p, l, r, m);
                if (qr <= m) return query(p.ls, l, m, ql, qr);
                if (ql > m) return query(p.rs, m + 1, r, ql, qr);
                return query(p.ls, l, m, ql, qr) + query(p.rs, m + 1, r, ql, qr);
            }

            void spread(Node p, int l, int r, int m) {
                if (p.ls == null) p.ls = new Node();
                if (p.rs == null) p.rs = new Node();
                if (p.lazy != 0) {
                    _do(p.ls, l, m, p.lazy);
                    _do(p.rs, m + 1, r, p.lazy);
                    p.lazy = 0;
                }
            }

            void maintain(Node p) {
                p.sum = mergeInfo(p.ls, p.rs);
            }
        }
    }
}
/*
3508. 设计路由器
https://leetcode.cn/problems/implement-router/description/

第 444 场周赛 T2。

请你设计一个数据结构来高效管理网络路由器中的数据包。每个数据包包含以下属性：
- source：生成该数据包的机器的唯一标识符。
- destination：目标机器的唯一标识符。
- timestamp：该数据包到达路由器的时间戳。
实现 Router 类：
Router(int memoryLimit)：初始化路由器对象，并设置固定的内存限制。
- memoryLimit 是路由器在任意时间点可以存储的 最大 数据包数量。
- 如果添加一个新数据包会超过这个限制，则必须移除 最旧的 数据包以腾出空间。
bool addPacket(int source, int destination, int timestamp)：将具有给定属性的数据包添加到路由器。
- 如果路由器中已经存在一个具有相同 source、destination 和 timestamp 的数据包，则视为重复数据包。
- 如果数据包成功添加（即不是重复数据包），返回 true；否则返回 false。
int[] forwardPacket()：以 FIFO（先进先出）顺序转发下一个数据包。
- 从存储中移除该数据包。
- 以数组 [source, destination, timestamp] 的形式返回该数据包。
- 如果没有数据包可以转发，则返回空数组。
int getCount(int destination, int startTime, int endTime)：
- 返回当前存储在路由器中（即尚未转发）的，且目标地址为指定 destination 且时间戳在范围 [startTime, endTime]（包括两端）内的数据包数量。
注意：对于 addPacket 的查询会按照 timestamp 的递增顺序进行。
提示：
2 <= memoryLimit <= 10^5
1 <= source, destination <= 2 * 10^5
1 <= timestamp <= 10^9
1 <= startTime <= endTime <= 10^9
addPacket、forwardPacket 和 getCount 方法的总调用次数最多为 10^5。
对于 addPacket 的查询，timestamp 按递增顺序给出。

题目保证 timestamp 递增，可以在队列上二分。
如果不保证递增，则需要动态开点线段树。
 */