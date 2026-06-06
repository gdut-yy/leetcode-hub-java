import java.util.Arrays;

public class Solution3911 {
    public int[] kthRemainingInteger(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = (nums[0] % 2 == 0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + ((nums[i] % 2 == 0) ? 1 : 0);
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            int ki = queries[i][2];

            int m = prefix[ri] - (li > 0 ? prefix[li - 1] : 0);
            if (m == 0) {
                ans[i] = 2 * ki;
                continue;
            }

            long low = ki;
            long high = ki + m;
            while (low < high) {
                long mid = low + (high - low) / 2;
                long x = 2 * mid;
                int idx = Arrays.binarySearch(nums, (int) x);
                int last;
                if (idx >= 0) {
                    last = idx;
                } else {
                    last = -idx - 2;
                }
                if (last < li) {
                    if (mid >= ki) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (last > ri) last = ri;
                    int count = prefix[last] - (li > 0 ? prefix[li - 1] : 0);
                    if (mid - count >= ki) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            ans[i] = (int) (2 * low);
        }
        return ans;
    }
}
/*
3911. 移除子数组元素后第 K 小偶数
https://leetcode.cn/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/description/

第 181 场双周赛 T4。

给你一个整数数组 nums，其中 nums 是 严格递增 的。
另给你一个二维整数数组 queries，其中 queries[i] = [li, ri, ki]。
对于每个查询 [li, ri, ki]：
- 考虑 子数组 nums[li..ri]
- 从 无限 的所有 正偶数 序列中：2, 4, 6, 8, 10, 12, 14, ...
- 移除 所有出现在 子数组 nums[li..ri] 中的元素。
- 找到移除后序列中剩余的第 ki 个 最小整数。
返回一个整数数组 ans，其中 ans[i] 是第 i 个查询的结果。
子数组 是数组中连续的 非空 元素序列。
如果数组中的每个元素都 严格大于 它的 前一个 元素（如果存在），则称该数组是 严格递增 的。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 是严格递增的
1 <= queries.length <= 10^5
queries[i] = [li, ri, ki]
0 <= li <= ri < nums.length
1 <= ki <= 10^9

二分套二分
https://chat.deepseek.com/a/chat/s/64572712-9b58-4367-b78d-2df6c0eb3b17
 */