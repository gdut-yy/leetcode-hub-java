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
https://leetcode-cn.com/problems/4xy4Wx/

LCP 简单题也得整个二分
时间复杂度 O(nlogn)
 */