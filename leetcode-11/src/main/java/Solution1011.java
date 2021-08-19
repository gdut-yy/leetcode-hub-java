public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        // 左边界二分
        // 1 <= D <= weights.length <= 5 * 10^4
        // 1 <= weights[i] <= 500
        int left = 1;
        int right = 2500000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canShipWithinDays(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShipWithinDays(int[] weights, int days, int maxWeight) {
        int cnt = 1;
        int curWeight = 0;
        int i = 0;
        while (i < weights.length) {
            // 我们装载的重量不会超过船的最大运载重量。
            if (weights[i] > maxWeight) {
                return false;
            }
            curWeight += weights[i];
            if (curWeight > maxWeight) {
                curWeight = 0;
                cnt++;
            } else {
                i++;
            }
        }
        return cnt <= days;
    }
}
/*
1011. 在 D 天内送达包裹的能力
https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/

第 128 场周赛 T3。
左边界二分
 */