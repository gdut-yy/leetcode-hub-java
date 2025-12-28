import java.util.Arrays;

public class Solution3767 {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        long sum2 = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; ++i) {
            sum2 += technique2[i];
            diff[i] = technique1[i] - technique2[i];
        }
        Arrays.sort(diff);
        int posCount = 0;
        for (int i = n - 1; i >= 0 && diff[i] > 0; --i) {
            posCount++;
        }
        int m = Math.max(k, posCount);
        long sumDiff = 0;
        for (int i = 0; i < m; ++i) {
            sumDiff += diff[n - 1 - i];
        }
        return sum2 + sumDiff;
    }
}
/*
3767. 选择 K 个任务的最大总分数
https://leetcode.cn/problems/maximize-points-after-choosing-k-tasks/description/

第 171 场双周赛 T3。

给你两个整数数组 technique1 和 technique2，长度均为 n，其中 n 代表需要完成的任务数量。
- 如果第 i 个任务使用技巧 1 完成，你将获得 technique1[i] 分。
- 如果使用技巧 2 完成，你将获得 technique2[i] 分。
此外给你一个整数 k，表示 必须 使用技巧 1 完成的 最少 任务数量。
你 必须 使用技巧 1 完成 至少 k 个任务（不需要是前 k 个任务）。
剩余的任务可以使用 任一 技巧完成。
返回一个整数，表示你能获得的 最大总分数。
提示：
1 <= n == technique1.length == technique2.length <= 10^5
1 <= technique1[i], technique2[i] <= 10^5
0 <= k <= n

贪心。
https://yuanbao.tencent.com/chat/naQivTmsDa/0ff8b5ad-e29d-4ec6-bb85-29c341fbea2f
时间复杂度 O(nlogn)。
 */