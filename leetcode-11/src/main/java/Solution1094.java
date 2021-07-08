public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 0 <= trips[i][1] < trips[i][2] <= 1000
        int len = 1000 + 1;
        // 差分数组
        int[] diff = new int[len];
        for (int[] trip : trips) {
            int i = trip[1] - 1;
            // 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
            int j = trip[2] - 1 - 1;
            int change = trip[0];
            diff[i] += change;
            diff[j + 1] -= change;
        }
        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        // 比较最值
        for (int cur : res) {
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
/*
1094. 拼车
https://leetcode-cn.com/problems/car-pooling/

差分数组。len = 1001
 */