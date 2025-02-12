import java.util.Arrays;

public class Solution3424 {
    public long minCost(int[] arr, int[] brr, long k) {
        long ans1 = getAns(arr, brr);
        Arrays.sort(arr);
        Arrays.sort(brr);
        long ans2 = getAns(arr, brr) + k;
        return Math.min(ans1, ans2);
    }

    private long getAns(int[] arr, int[] brr) {
        int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(arr[i] - brr[i]);
        }
        return ans;
    }
}
/*
3424. 将数组变相同的最小代价
https://leetcode.cn/problems/minimum-cost-to-make-arrays-identical/description/

第 148 场双周赛 T2。

给你两个长度都为 n 的整数数组 arr 和 brr 以及一个整数 k 。你可以对 arr 执行以下操作任意次：
- 将 arr 分割成若干个 连续的 子数组，并将这些子数组按任意顺序重新排列。这个操作的代价为 k 。
- 选择 arr 中的任意一个元素，将它增加或者减少一个正整数 x 。这个操作的代价为 x 。
请你返回将 arr 变为 brr 的 最小 总代价。
子数组 是一个数组中一段连续 非空 的元素序列。
提示：
1 <= arr.length == brr.length <= 10^5
0 <= k <= 2 * 10^10
-10^5 <= arr[i] <= 10^5
-10^5 <= brr[i] <= 10^5

贪心。用交换论证法可以证明这样做是最优的。
时间复杂度 O(nlogn)。
 */