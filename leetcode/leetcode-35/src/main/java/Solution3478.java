import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3478 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> nums1[o]));

        long[] ans = new long[n];
        int l = 0, r = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sumK = 0;
        while (r < n) {
            while (nums1[ids[l]] < nums1[ids[r]]) {
                pq.add(nums2[ids[l]]);
                sumK += nums2[ids[l]];
                if (pq.size() > k) {
                    Integer top = pq.remove();
                    sumK -= top;
                }
                l++;
            }
            ans[ids[r]] = sumK;

            r++;
        }
        return ans;
    }
}
/*
3478. 选出和最大的 K 个元素
https://leetcode.cn/problems/choose-k-elements-with-maximum-sum/description/

第 440 场周赛 T2。

给你两个整数数组，nums1 和 nums2，长度均为 n，以及一个正整数 k 。
对从 0 到 n - 1 每个下标 i ，执行下述操作：
- 出所有满足 nums1[j] 小于 nums1[i] 的下标 j 。
- 这些下标对应的 nums2[j] 中选出 至多 k 个，并 最大化 这些值的总和作为结果。
返回一个长度为 n 的数组 answer ，其中 answer[i] 表示对应下标 i 的结果。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 10^6
1 <= k <= n

离线询问 + 堆维护 topK。
时间复杂度 O(nlogn)。
 */