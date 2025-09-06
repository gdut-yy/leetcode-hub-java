import java.util.HashMap;
import java.util.Map;

public class SolutionP3595 {
    public int[] onceTwice(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) cnt.merge(v, 1, Integer::sum);
        int[] ans = new int[2];
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            Integer c = entry.getValue();
            if (c == 1) ans[0] = entry.getKey();
            else if (c == 2) ans[1] = entry.getKey();
        }
        return ans;
    }
}
/*
$3595. 一次或两次
https://leetcode.cn/problems/once-twice/description/

给定一个整数数组 nums。在这个数组中：
- 有一个元素出现了 恰好 1 次。
- 有一个元素出现了 恰好 2 次。
- 其它所有元素都出现了 恰好 3 次。
返回一个长度为 2 的整数数组，其中第一个元素是只出现 1 次 的那个元素，第二个元素是只出现 2 次 的那个元素。
你的解决方案必须在 O(n) 时间 与 O(1) 空间中运行。
提示：
3 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
nums.length 是 3 的倍数。
恰好有一个元素出现 1 次，一个元素出现 2 次，其余所有元素都出现了 3 次。

哈希表统计频次。
时间复杂度 O(n)。
相似题目: 137. 只出现一次的数字 II
https://leetcode.cn/problems/single-number-ii/
 */