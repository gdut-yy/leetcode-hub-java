import java.util.HashMap;
import java.util.Map;

public class Solution3761 {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minD = Integer.MAX_VALUE;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int reversed = reverse(nums[i]);
            if (mp.containsKey(reversed)) {
                int j = mp.get(reversed);
                int d = j - i;
                if (d < minD) {
                    minD = d;
                }
            }
            mp.put(nums[i], i);
        }

        return minD == Integer.MAX_VALUE ? -1 : minD;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
/*
3761. 镜像对之间最小绝对距离
https://leetcode.cn/problems/minimum-absolute-distance-between-mirror-pairs/description/

第 478 场周赛 T3。

给你一个整数数组 nums。
镜像对 是指一对满足下述条件的下标 (i, j)：
- 0 <= i < j < nums.length，并且
- reverse(nums[i]) == nums[j]，其中 reverse(x) 表示将整数 x 的数字反转后形成的整数。反转后会忽略前导零，例如 reverse(120) = 21。
返回任意镜像对的下标之间的 最小绝对距离。下标 i 和 j 之间的绝对距离为 abs(i - j)。
如果不存在镜像对，返回 -1。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

枚举右，维护左。
时间复杂度 O(nlogU)。
 */