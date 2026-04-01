import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3854 {
    public int[] makeParityAlternating(int[] nums) {
        int n = nums.length;
        List<List<Integer>> nums632_0 = new ArrayList<>();
        List<List<Integer>> nums632_1 = new ArrayList<>();
        int operations0 = 0, operations1 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == (i & 1)) {
                // 偶奇偶奇偶奇……
                nums632_0.add(Arrays.asList(nums[i]));
                nums632_1.add(Arrays.asList(nums[i] - 1, nums[i] + 1));
                operations1++;
            } else {
                // 奇偶奇偶奇偶……
                nums632_0.add(Arrays.asList(nums[i] - 1, nums[i] + 1));
                nums632_1.add(Arrays.asList(nums[i]));
                operations0++;
            }
        }
        int[] ans0 = smallestRange(nums632_0);
        int[] ans1 = smallestRange(nums632_1);
        if (operations0 < operations1 || (operations0 == operations1 && ans0[1] - ans0[0] <= ans1[1] - ans1[0])) {
            return new int[]{operations0, ans0[1] - ans0[0]};
        }
        return new int[]{operations1, ans1[1] - ans1[0]};
    }

    private int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> zipList = new ArrayList<>(); // v, i
        for (int i = 0; i < nums.size(); i++) {
            for (Integer v : nums.get(i)) {
                zipList.add(new int[]{v, i});
            }
        }
        zipList.sort(Comparator.comparingInt(o -> o[0]));

        int ansL = zipList.getFirst()[0], ansR = zipList.getLast()[0];
        int k = nums.size();
        int[] cnt = new int[k];
        int l = 0, r = 0;
        int repeated = 0;
        while (r < zipList.size()) {
            int i = zipList.get(r)[1];
            if (++cnt[i] == 1) repeated++;
            while (repeated == k) {
                if (zipList.get(r)[0] - zipList.get(l)[0] < ansR - ansL) {
                    ansL = zipList.get(l)[0];
                    ansR = zipList.get(r)[0];
                }
                i = zipList.get(l)[1];
                if (--cnt[i] == 0) repeated--;
                l++;
            }
            r++;
        }
        return new int[]{ansL, ansR};
    }
}
/*
3854. 使数组奇偶交替的最少操作
https://leetcode.cn/problems/minimum-operations-to-make-array-parity-alternating/description/

第 177 场双周赛 T3。

给你一个整数数组 nums。
如果对于每一个下标 i（其中 0 <= i < n - 1），nums[i] 和 nums[i + 1] 具有不同的奇偶性（一个是偶数，另一个是奇数），则该数组被称为 奇偶交替 的。
在一次操作中，你可以选择任意下标 i，并将 nums[i] 增加 1 或减少 1。
返回一个长度为 2 的整数数组 answer，其中：
- answer[0] 是使数组变为奇偶交替所需的 最少 操作次数。
- answer[1] 是在所有通过执行 恰好 answer[0] 次操作获得的奇偶交替数组中，max(nums) - min(nums) 的 最小 可能值。
长度为 1 的数组被认为是奇偶交替的。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

对于 x=nums[i]，如果不操作 x，视作列表 [x]，否则视作列表 [x−1,x+1]，于是我们得到了 n 个列表。问题相当于找到一个最短的值域范围 [a,b]，使得每个列表都至少有一个数在 [a,b] 中。
相似题目: 632. 最小区间
https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/
 */