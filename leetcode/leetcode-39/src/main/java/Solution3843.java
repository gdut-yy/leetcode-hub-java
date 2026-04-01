import java.util.HashMap;
import java.util.Map;

public class Solution3843 {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) cnt.merge(v, 1, Integer::sum);

        int[] cc = new int[nums.length + 1];
        for (int c : cnt.values()) cc[c]++;

        for (int v : nums) {
            if (cc[cnt.get(v)] == 1) return v;
        }
        return -1;
    }
}
/*
3843. 频率唯一的第一个元素
https://leetcode.cn/problems/first-element-with-unique-frequency/description/

第 489 场周赛 T2。

给你一个整数数组 nums。
返回数组中第一个（从左到右扫描）出现频率与众不同 的元素。如果不存在这样的元素，返回 -1。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

统计出现次数的出现次数。
时间复杂度 O(n)。
 */