public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        // 不可能准时到达的情况，hour < dist.length - 1
        if (hour <= dist.length - 1) {
            return -1;
        }
        // 寻找左侧边界的二分查找
        int left = 0;
        int right = 10000000;
        while (left < right) {
            int mid = (left + right) / 2;
            // 不能抵达就继续加速，在右分区查找
            if (isArrive(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isArrive(int[] dist, double hour, int speed) {
        double cnt = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            cnt += Math.ceil(dist[i] / (double) speed);
        }
        cnt += dist[dist.length - 1] / (double) speed;
        return cnt <= hour;
    }
}
/*
1870. 准时到达的列车最小时速
https://leetcode-cn.com/problems/minimum-speed-to-arrive-on-time/

第 242 场周赛 T2。
二分查找。分为三种，找一个目标，找左边界，找右边界。
本题为寻找左侧边界。
 */
