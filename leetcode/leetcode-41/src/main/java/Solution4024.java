public class Solution4024 {
    public int nearestDrone(int[][] drones, int[] target) {
        int tx = target[0], ty = target[1];
        int minDis = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < drones.length; i++) {
            int xi = drones[i][0], yi = drones[i][1], rangei = drones[i][2];
            int dis = Math.abs(tx - xi) + Math.abs(ty - yi);
            if (dis < minDis && dis <= rangei) {
                minDis = dis;
                ans = i;
            }
        }
        return ans;
    }
}
/*
4024. 最近的可用无人机
https://leetcode.cn/problems/nearest-available-drone/description/

第 515 场周赛 T1。

给你一个二维整数数组 drones，其中 drones[i] = [xi, yi, rangei] 表示第 ith 架无人机的横坐标、纵坐标和飞行范围。
另给你一个整数数组 target = [tx, ty]，表示目标的坐标。
如果无人机 drones[i] 的坐标与目标坐标之间的曼哈顿距离小于或等于其 rangei，则该无人机能够到达目标。
返回能够到达目标且与目标之间曼哈顿距离最小的无人机的下标。如果存在多个符合条件的无人机，则返回其中最小的下标。如果没有无人机能够到达目标，则返回 -1。
两个坐标 (xi, yi) 和 (xj, yj) 之间的曼哈顿距离为 |xi - xj| + |yi - yj|。
提示：
1 <= drones.length <= 100
drones[i] = [xi, yi, rangei]
target = [tx, ty]
-25 <= xi, yi, tx, ty <= 25
1 <= rangei <= 100

中国时间 2026-08-16 周日 10:30
佛山。
遍历。
时间复杂度 O(n)。
 */