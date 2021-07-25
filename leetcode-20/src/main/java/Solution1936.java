public class Solution1936 {
    public int addRungs(int[] rungs, int dist) {
        int len = rungs.length;
        // 差分数组
        int[] diff = new int[len];
        diff[0] = rungs[0];
        for (int i = 1; i < len; i++) {
            diff[i] = rungs[i] - rungs[i - 1];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (diff[i] > dist) {
                int mod = diff[i] % dist;
                if (mod == 0) {
                    // [0, 4] 2 => 0 2 4 即可，整除情况需 -1
                    res += diff[i] / dist - 1;
                } else {
                    // [0, 5] 2 => 0 2 4 5 取除数即可
                    res += diff[i] / dist;
                }
            }
        }
        return res;
    }
}
/*
1936. 新增的最少台阶数
https://leetcode-cn.com/problems/add-minimum-number-of-rungs/

第 250 场周赛 T2。
差分数组。时间复杂度 O(n)
 */