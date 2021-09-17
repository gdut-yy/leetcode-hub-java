public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        // 不可能准时到达的情况，hour <= dist.length - 1
        if (hour <= dist.length - 1) {
            return -1;
        }
        // 左边界二分
        // n == dist.length
        // 1 <= n <= 10^5
        int left = 0;
        int right = 10000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 不能抵达就继续加速，在右分区查找
            if (canMinSpeedOnTime(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMinSpeedOnTime(int[] dist, double hour, int speed) {
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
左边界二分
 */
