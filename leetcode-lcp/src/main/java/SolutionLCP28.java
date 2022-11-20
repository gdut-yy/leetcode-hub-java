import java.util.Arrays;

public class SolutionLCP28 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        long cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            // 超出时间限制
//            for (int j = i + 1; j < len; j++) {
//                if (nums[i] + nums[j] <= target) {
//                    cnt++;
//                }
//            }

            // 二分优化
            int j = binarySearchRightBound(nums, target - nums[i]);
            if (j > i) {
                cnt = cnt + j - i;
            } else {
                break;
            }
        }
        return (int) (cnt % 1000000007);
    }

    private int binarySearchRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
LCP 28. 采购方案
https://leetcode.cn/problems/4xy4Wx/

小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
提示：
2 <= nums.length <= 10^5
1 <= nums[i], target <= 10^5

类似 LCP17 排序 + 二分
时间复杂度 O(nlogn)
 */