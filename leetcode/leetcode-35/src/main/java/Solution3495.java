public class Solution3495 {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long sum_level = 0;
            int k = 1;
            int prev = 1;
            int curr = 4;
            while (prev <= r) {
                int start_k = prev;
                int end_k = curr - 1;
                int overlap_start = Math.max(l, start_k);
                int overlap_end = Math.min(r, end_k);
                if (overlap_start <= overlap_end) {
                    long count = overlap_end - overlap_start + 1;
                    sum_level += count * k;
                }
                prev = curr;
                curr *= 4;
                k++;
            }
            ans += (sum_level + 1) / 2;
        }
        return ans;
    }
}
/*
3495. 使数组元素都变为零的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-array-elements-zero/description/

第 442 场周赛 T4。

给你一个二维数组 queries，其中 queries[i] 形式为 [l, r]。每个 queries[i] 表示了一个元素范围从 l 到 r （包括 l 和 r ）的整数数组 nums 。
在一次操作中，你可以：
选择一个查询数组中的两个整数 a 和 b。
将它们替换为 floor(a / 4) 和 floor(b / 4)。
你的任务是确定对于每个查询，将数组中的所有元素都变为零的 最少 操作次数。返回所有查询结果的总和。
提示：
1 <= queries.length <= 10^5
queries[i].length == 2
queries[i] == [l, r]
1 <= l < r <= 10^9

数学。
时间复杂度 O(qlogR)。
 */