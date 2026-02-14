import java.util.ArrayDeque;
import java.util.Queue;

public class Solution3829 {
    static class RideSharingSystem {
        private Queue<Integer> riderQueue;
        private Queue<Integer> driverQueue;
        private boolean[] riderWaiting;
        private boolean[] driverIdle;

        public RideSharingSystem() {
            riderQueue = new ArrayDeque<>();
            driverQueue = new ArrayDeque<>();
            riderWaiting = new boolean[1001];
            driverIdle = new boolean[1001];
        }

        public void addRider(int riderId) {
            if (!riderWaiting[riderId]) {
                riderQueue.offer(riderId);
                riderWaiting[riderId] = true;
            }
        }

        public void addDriver(int driverId) {
            if (!driverIdle[driverId]) {
                driverQueue.offer(driverId);
                driverIdle[driverId] = true;
            }
        }

        public int[] matchDriverWithRider() {
            while (!riderQueue.isEmpty() && !riderWaiting[riderQueue.peek()]) {
                riderQueue.poll();
            }
            while (!driverQueue.isEmpty() && !driverIdle[driverQueue.peek()]) {
                driverQueue.poll();
            }
            if (riderQueue.isEmpty() || driverQueue.isEmpty()) {
                return new int[]{-1, -1};
            }
            int rider = riderQueue.poll();
            int driver = driverQueue.poll();
            riderWaiting[rider] = false;
            driverIdle[driver] = false;
            return new int[]{driver, rider};
        }

        public void cancelRider(int riderId) {
            if (riderId >= 1 && riderId <= 1000 && riderWaiting[riderId]) {
                riderWaiting[riderId] = false;
            }
        }
    }
}
/*
3829. 设计共享出行系统
https://leetcode.cn/problems/design-ride-sharing-system/description/

第 487 场周赛 T3。

现在需要设计一个共享出行系统管理乘客的叫车请求和司机的空闲状态。乘客发出叫车请求，司机在系统中陆续变为可用状态。系统需要按照乘客和司机到达的顺序进行匹配。
实现 RideSharingSystem 类：
- RideSharingSystem() 初始化系统。
- void addRider(int riderId) 添加一个新的乘客，其 ID 为 riderId。
- void addDriver(int driverId) 添加一个新的司机，其 ID 为 driverId。
- int[] matchDriverWithRider() 匹配最早到达的空闲司机和最早等待的乘客，并将这两者从系统中移除。返回一个大小为 2 的整数数组，result = [driverId, riderId]，表示匹配成功。如果没有可用的匹配，返回 [-1, -1]。
- void cancelRider(int riderId) 取消指定 riderId 的乘客的叫车请求，前提是该乘客存在并且尚未被匹配。
提示：
1 <= riderId, driverId <= 1000
每个 riderId 在乘客中是唯一的，且最多被添加一次。
每个 driverId 在司机中是唯一的，且最多被添加一次。
最多会调用 1000 次 addRider、addDriver、matchDriverWithRider 和 cancelRider。

队列模拟。
 */