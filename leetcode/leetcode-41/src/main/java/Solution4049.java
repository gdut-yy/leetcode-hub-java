import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4049 {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> posMp = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            posMp.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> pos : posMp.values()) {
            if (pos.size() < 3) continue;
            int sz = pos.size();
            int d = pos.get(1) - pos.get(0);
            boolean flag = true;
            for (int i = 2; i < sz; i++) {
                int d1 = pos.get(i) - pos.get(i - 1);
                if (d1 != d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
/*
4049. 统计等间距出现整数数目 II
https://leetcode.cn/problems/count-values-with-equally-spaced-occurrences-ii/description/

第 519 场周赛 T2。

给你一个整数数组 nums。
如果一个整数 x 满足以下条件，则被称为 特别 的：
- x 在 nums 中 至少出现三次。
- x 的 所有 出现，在 nums 中都是 等间隔 的。换句话说，如果 x 的所有出现位置的下标为 i1 < i2 < ... < im，那么 i2 - i1 = i3 - i2 = ... = im - im-1。
返回 nums 中 不同 特别整数的数量。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

记录每个元素的所有出现位置。
时间复杂度 O(n)。
 */