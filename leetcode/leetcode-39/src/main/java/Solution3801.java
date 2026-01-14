import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3801 {
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int[] len = new int[n];
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            len[i] = lists[i].length;
            for (int v : lists[i]) {
                all.add(v);
            }
        }
        Collections.sort(all);
        int[] allElements = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            allElements[i] = all.get(i);
        }

        int totalMasks = 1 << n;
        int[] totalLen = new int[totalMasks];
        int[] median = new int[totalMasks];

        for (int mask = 1; mask < totalMasks; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    sum += len[i];
                }
            }
            totalLen[mask] = sum;
        }

        for (int mask = 1; mask < totalMasks; mask++) {
            int L = totalLen[mask];
            int k = (L - 1) / 2;
            int left = 0, right = allElements.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                int midVal = allElements[mid];
                if (countLE(lists, mask, midVal) >= k + 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            median[mask] = allElements[left];
        }

        long[] dp = new long[totalMasks];
        Arrays.fill(dp, Long.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[1 << i] = 0;
        }
        for (int mask = 1; mask < totalMasks; mask++) {
            for (int A = (mask - 1) & mask; A > 0; A = (A - 1) & mask) {
                int B = mask ^ A;
                long cost = dp[A] + dp[B] + totalLen[A] + totalLen[B] + Math.abs(median[A] - median[B]);
                if (cost < dp[mask]) {
                    dp[mask] = cost;
                }
            }
        }
        return dp[totalMasks - 1];
    }

    private int countLE(int[][] lists, int mask, int x) {
        int cnt = 0;
        for (int i = 0; i < lists.length; i++) {
            if ((mask >> i & 1) == 1) {
                cnt += countLEInArray(lists[i], x);
            }
        }
        return cnt;
    }

    private int countLEInArray(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
/*
3801. 合并有序列表的最小成本
https://leetcode.cn/problems/minimum-cost-to-merge-sorted-lists/description/

第 483 场周赛 T4。

给你一个二维整数数组 lists，其中每个 lists[i] 是一个按照 非递减顺序 排序的非空整数数组。
你可以 重复 选择两个列表 a = lists[i] 和 b = lists[j]（i != j），并将它们合并。合并 a 和 b 的 成本 为：
len(a) + len(b) + abs(median(a) - median(b))，其中 len 和 median 分别表示列表的长度和中位数。
合并 a 和 b 后，从 lists 中移除 a 和 b，并将新的合并后 有序列表（元素按从小到大排列）插入到 lists 中的 任意 位置。重复此过程直到只剩下 一个 列表。
返回将所有列表合并为一个有序列表所需的 最小总成本。
数组的 中位数 是指排序后位于中间的元素。如果数组元素数量为偶数，则取左侧中间元素。
提示：
2 <= lists.length <= 12
1 <= lists[i].length <= 500
-10^9 <= lists[i][j] <= 10^9
lists[i] 按照非递减顺序排序。
lists[i].length 的总和不超过 2000。

子集状压 DP + 二分中位数
rating 2403 (clist.by)
 */