public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 1 <= n <= 2 * 10^4
        int len = n;
        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] booking : bookings) {
            // 从 1 到 n 进行编号，因此需 -1
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int change = booking[2];
            diff[i] += change;
            diff[j + 1] -= change;
        }
        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
/*
1109. 航班预订统计
https://leetcode-cn.com/problems/corporate-flight-bookings/

差分数组。len <= 2 * 10^4
 */