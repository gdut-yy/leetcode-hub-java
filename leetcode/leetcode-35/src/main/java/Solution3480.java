import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3480 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] groups = new ArrayList[n + 1];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (int[] p : conflictingPairs) {
            int a = p[0];
            int b = p[1];
            groups[Math.min(a, b)].add(Math.max(a, b));
        }

        long ans = 0;
        long[] extra = new long[n + 2];
        long maxExtra = 0;
        // 维护最小 b 和次小 b
        int b0 = n + 1;
        int b1 = n + 1;
        for (int a = n; a > 0; a--) {
            List<Integer> listB = groups[a];
            for (int b : listB) {
                if (b < b0) {
                    b1 = b0;
                    b0 = b;
                } else if (b < b1) {
                    b1 = b;
                }
            }
            ans += b0 - a;
            extra[b0] += b1 - b0;
            maxExtra = Math.max(maxExtra, extra[b0]);
        }

        return ans + maxExtra;
    }
}
/*
3480. 删除一个冲突对后最大子数组数目
https://leetcode.cn/problems/maximize-subarrays-after-removing-one-conflicting-pair/description/

第 440 场周赛 T4。

给你一个整数 n，表示一个包含从 1 到 n 按顺序排列的整数数组 nums。此外，给你一个二维数组 conflictingPairs，其中 conflictingPairs[i] = [a, b] 表示 a 和 b 形成一个冲突对。
从 conflictingPairs 中删除 恰好 一个元素。然后，计算数组 nums 中的非空子数组数量，这些子数组都不能同时包含任何剩余冲突对 [a, b] 中的 a 和 b。
返回删除 恰好 一个冲突对后可能得到的 最大 子数组数量。
子数组 是数组中一个连续的 非空 元素序列。
提示：
2 <= n <= 10^5
1 <= conflictingPairs.length <= 2 * n
conflictingPairs[i].length == 2
1 <= conflictingPairs[i][j] <= n
conflictingPairs[i][0] != conflictingPairs[i][1]

枚举子数组左端点，看看有多少个合法的右端点。
b 的最小值，记作 b0。有 [i,b0-1] 所以有  b0-i.
删除一个冲突对时，b 的次小值，记作 b1，额外增加 b1-b0.
时间复杂度 O(n)。
rating 2647 (clist.by)
 */