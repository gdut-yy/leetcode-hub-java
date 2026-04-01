public class Solution3875 {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
/*
3875. 构造奇偶一致的数组 I
https://leetcode.cn/problems/construct-uniform-parity-array-i/description/

第 494 场周赛 T1。

给你一个长度为 n 的数组 nums1，其中包含 互不相同 的整数。
你需要构造另一个长度为 n 的数组 nums2，使得 nums2 中的元素要么全部为 奇数，要么全部为 偶数。
对于每个下标 i，你必须从以下两种选择中 任选其一（顺序不限）：
- nums2[i] = nums1[i]
- nums2[i] = nums1[i] - nums1[j]，其中 j != i
如果能够构造出满足条件的数组，则返回 true；否则，返回 false。
提示：
1 <= n == nums1.length <= 100
1 <= nums1[i] <= 100
nums1 中的所有整数互不相同。

中国时间 2026-03-22 周日 10:30
佛山。
脑筋急转弯。
如果 nums1 全是奇数或者全是偶数，那么只用第一种操作 nums2[i] = nums1[i] 即可满足要求。
否则，由于偶数减去奇数等于奇数，随便选一个奇数 x，把每个偶数都减去 x（第二种操作），即可让所有偶数都变成奇数。
 */