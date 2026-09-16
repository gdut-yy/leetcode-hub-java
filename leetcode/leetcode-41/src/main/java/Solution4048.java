import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4048 {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> posMp = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            posMp.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> pos : posMp.values()) {
            if (pos.size() != 3) continue;
            int d1 = pos.get(1) - pos.get(0);
            int d2 = pos.get(2) - pos.get(1);
            if (d1 == d2) ans++;
        }
        return ans;
    }
}
/*
4048. 统计等间距出现整数数目 I
https://leetcode.cn/problems/count-values-with-equally-spaced-occurrences-i/description/

给你一个整数数组 nums。
如果一个整数 x 满足以下条件，则被称为 特别 的：
- x 在 nums 中 恰好出现三次。
- x 的 所有 三次出现，在 nums 中都是 等间隔 的。换句话说，如果 x 的所有出现位置的下标为 i1 < i2 < i3，那么 i2 - i1 = i3 - i2。
返回 nums 中 不同 特别整数的数量。
提示:
3 <= nums.length <= 100
1 <= nums[i] <= 100

记录每个元素的所有出现位置。
时间复杂度 O(n)。
 */