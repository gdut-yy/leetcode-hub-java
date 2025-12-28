import java.util.HashMap;
import java.util.Map;

public class Solution3785 {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        // 可行性
        Map<Integer, Integer> cntNums = new HashMap<>();
        Map<Integer, Integer> cntForb = new HashMap<>();
        for (int x : nums) cntNums.merge(x, 1, Integer::sum);
        for (int x : forbidden) cntForb.merge(x, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> e : cntNums.entrySet()) {
            int v = e.getKey();
            int occ = e.getValue();
            int forb = cntForb.getOrDefault(v, 0);
            if (occ > n - forb) return -1;
        }

        int b = 0;
        int cMax = 0;
        Map<Integer, Integer> badCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == forbidden[i]) {
                b++;
                int v = nums[i];
                int c = badCnt.merge(v, 1, Integer::sum);
                if (c > cMax) cMax = c;
            }
        }
        if (b == 0) return 0;
        int ceilHalf = (b + 1) / 2;
        return Math.max(ceilHalf, cMax);
    }
}
/*
3785. 避免禁用值的最小交换次数
https://leetcode.cn/problems/minimum-swaps-to-avoid-forbidden-values/description/

第 481 场周赛 T3。

给你两个长度为 n 的整数数组 nums 和 forbidden。
你可以执行以下操作任意次（包括零次）：
- 选择两个 不同 下标 i 和 j，然后交换 nums[i] 和 nums[j]。
返回使得对于每个下标 i，nums[i] 不等于 forbidden[i] 所需的 最小 交换次数。如果无论如何都无法满足条件，返回 -1。
提示：
1 <= n == nums.length == forbidden.length <= 10^5
1 <= nums[i], forbidden[i] <= 10^9

结论题。
如果某个数 x 在 nums 和 forbidden 中总出现次数超过 n，那么无解。
否则一定有解。最少操作 max(ceil(n/2), mx) 此，其中 n 是 a 的长度，mx 是 a 中出现次数最多的元素的出现次数。
时间复杂度 O(n)。
 */