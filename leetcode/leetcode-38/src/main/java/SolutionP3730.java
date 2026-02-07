import java.util.Arrays;

public class SolutionP3730 {
    public long maxCaloriesBurnt(int[] heights) {
        int n = heights.length;
        Arrays.sort(heights);
        int prev = 0;
        int l = 0, r = n - 1;
        boolean selectMax = true;
        long ans = 0;
        while (l <= r) {
            if (selectMax) {
                ans += (long) (heights[r] - prev) * (heights[r] - prev);
                prev = heights[r];
                r--;
            } else {
                ans += (long) (heights[l] - prev) * (heights[l] - prev);
                prev = heights[l];
                l++;
            }
            selectMax = !selectMax;
        }
        return ans;
    }
}
/*
$3730. 跳跃燃烧的最大卡路里
https://leetcode.cn/problems/maximum-calories-burnt-from-jumps/description/

给定一个长度为 n 的整数数组 heights，其中 heights[i] 表示训练计划中第 i 个块的高度。
你从地面（高度0）开始，必须 按照任意顺序跳到每个方块上，且只能跳 一次。
- 从一个高度为 a 的块起跳到另一个高度为 b 的块所消耗的卡路里是 (a - b)^2。
- 从地面跳到所选的第一个方块高度 heights[i] 所 消耗的卡路里 是 (0 - heights[i])^2。
返回通过选择最优跳跃序列所能燃烧的 最大 总卡路里。
注意：一旦你跳到第一个方块上，就无法返回地面。
提示：
1 <= n == heights.length <= 10^5
1 <= heights[i] <= 10^5

贪心。
https://leetcode.cn/problems/maximum-calories-burnt-from-jumps/solutions/3821276/3730-tiao-yue-ran-shao-de-zui-da-qia-lu-bda7u/
时间复杂度 O(nlogn)。
 */