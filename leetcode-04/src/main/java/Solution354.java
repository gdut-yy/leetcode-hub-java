import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int len = envelopes.length;

        // LIS
        // ascend[idx] 表示长度为 idx 的最长上升子序列的末尾元素的最小值，用 idx 记录目前最长上升子序列的长度
        int[] ascend = new int[len + 1];
        int idx = 1;
        ascend[idx] = envelopes[0][1];
        for (int i = 1; i < len; i++) {
            // 严格递增
            if (envelopes[i][1] > ascend[idx]) {
                idx++;
                ascend[idx] = envelopes[i][1];
            } else {
                int left = 1;
                int right = idx;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    // 严格递增
                    if (ascend[mid] >= envelopes[i][1]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                ascend[left] = envelopes[i][1];
            }
        }
        return idx;
    }
}
/*
354. 俄罗斯套娃信封问题
https://leetcode.cn/problems/russian-doll-envelopes/

给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
注意：不允许旋转信封。
提示：
1 <= envelopes.length <= 10^5
envelopes[i].length == 2
1 <= wi, hi <= 10^5

二维偏序问题。
可以按宽度升序排序，高度降序排序，再按高度求 LIS 长度。
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */