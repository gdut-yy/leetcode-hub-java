public class Solution3876 {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int v : nums1) {
            if (v % 2 == 0) {
                minEven = Math.min(minEven, v);
            } else {
                minOdd = Math.min(minOdd, v);
            }
        }
        // 只有偶数，或者最小的偶数 > 最小的奇数
        return minOdd == Integer.MAX_VALUE || minOdd < minEven;
    }
}
/*
3876. 构造奇偶一致的数组 II
https://leetcode.cn/problems/construct-uniform-parity-array-ii/description/

第 494 场周赛 T2。

给你一个长度为 n 的数组 nums1，其中包含 互不相同 的整数。
你需要构造另一个长度为 n 的数组 nums2，使得 nums2 中的元素要么全部为 奇数，要么全部为 偶数。
对于每个下标 i，你必须从以下两种选择中 任选其一（顺序不限）：
- nums2[i] = nums1[i]
- nums2[i] = nums1[i] - nums1[j]，其中 j != i，且满足 nums1[i] - nums1[j] >= 1
如果能够构造出满足条件的数组，则返回 true；否则，返回 false。
提示：
1 <= n == nums1.length <= 10^5
1 <= nums1[i] <= 10^9
nums1 中的所有整数互不相同。

如果 nums1 全是奇数或者全是偶数，那么只用第一种操作 nums2[i] = nums1[i] 即可满足要求。
否则，看能不能全变奇数（不能全变偶数，因为奇数减奇数才能变偶数，但是最小的奇数没法减）
偶数只能减去奇数才能变成奇数，当最小奇数小于所有的偶数，即成立。
 */