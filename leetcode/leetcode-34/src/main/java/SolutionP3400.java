import java.util.Arrays;

public class SolutionP3400 {
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    cnt[(j - i + n) % n]++;
                }
            }
        }
        return Arrays.stream(cnt).max().orElseThrow();
    }
}
/*
$3400. 右移后的最大匹配索引数
https://leetcode.cn/problems/maximum-number-of-matching-indices-after-right-shifts/description/

给定两个长度相同的整数数组 nums1 和 nums2。
如果 nums1[i] == nums2[i] 则认为下标 i 是 匹配 的。
返回在 nums1 上进行任意次数 右移 后 最大 的 匹配 下标数量。
右移 是对于所有下标，将位于下标 i 的元素移动到 (i + 1) % n。
提示：
nums1.length == nums2.length
1 <= nums1.length, nums2.length <= 3000
1 <= nums1[i], nums2[i] <= 10^9

比较两个数组的所有元素，如果两个元素相等，那么需要移动的距离为 (j-i)%n，相当于移动这么多距离的情况下，相等的元素对 +1，最多循环移动 n-1次，最后统计 n-1 种情况里的最大值即可
时间复杂度 O(n^2)。
 */