public class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int a = 0; a < len; a++) {
            for (int b = a + 1; b < len; b++) {
                for (int c = b + 1; c < len; c++) {
                    for (int d = c + 1; d < len; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
1995. 统计特殊四元组
https://leetcode-cn.com/problems/count-special-quadruplets/

第 257 场周赛 T1。
四层循环暴力
 */