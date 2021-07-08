public class Solution1854 {
    public int maximumPopulation(int[][] logs) {
        // 1950 <= birthi < deathi <= 2050
        int len = 2050 - 1950 + 1;
        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] log : logs) {
            int i = log[0] - 1950;
            // 人不应当计入他们死亡当年的人口中
            int j = log[1] - 1950 - 1;
            int change = 1;
            diff[i] += change;
            diff[j + 1] -= change;
        }
        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        // 统计最值
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (res[i] > max) {
                max = res[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1950;
    }
}
/*
1854. 人口最多的年份
https://leetcode-cn.com/problems/maximum-population-year/

差分数组。区间为 100，暴力也是可以的。
 */