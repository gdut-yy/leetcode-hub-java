import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] nums) {
        // 降序排列数组
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = tmp;
        }
        // 固定大小的滑动窗口
        int i = 0;
        while (i + 2 < len) {
            // 贪心，找到符合要求的就是最大周长的三角形
            if (isPerimeter(nums[i], nums[i + 1], nums[i + 2])) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            } else {
                i++;
            }
        }
        // 不能形成任何面积不为零的三角形，返回 0
        return 0;
    }

    private boolean isPerimeter(int aLen, int bLen, int cLen) {
        return aLen + bLen > cLen
                && bLen + cLen > aLen
                && aLen + cLen > bLen
                && Math.abs(aLen - bLen) < cLen
                && Math.abs(bLen - cLen) < aLen
                && Math.abs(aLen - cLen) < bLen;
    }
}
/*
976. 三角形的最大周长
https://leetcode-cn.com/problems/largest-perimeter-triangle/

第 119 场周赛 T2。

给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
如果不能形成任何面积不为零的三角形，返回 0。

贪心法。固定大小的滑动窗口。降序排列数组后，第一个符合要求的就是最大周长的三角形。
 */