public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;

        // maxLeft[i] 代表 [0, i] 区间最大值
        int[] maxLeft = new int[len];
        maxLeft[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        // minRight[i] 代表 [i, len) 区间最小值
        int[] minRight = new int[len];
        minRight[len - 1] = nums[len - 1];
        for (int i = len - 2; i > 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        // left 的长度要尽可能小
        for (int i = 1; i < len; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return 0;
    }
}
/*
915. 分割数组
https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals/

第 104 场周赛 T2。
无须滑动窗口，极值比较即可。
时间复杂度 O(n)
 */