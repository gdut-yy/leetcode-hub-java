import java.util.Arrays;

public class SolutionLCP18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        long cnt = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i = 0; i < staple.length; i++) {
            int want = x - staple[i];
            int idx = binarySearchRightBound(drinks, want);
            if (idx >= 0 && idx < drinks.length) {
                cnt += idx + 1;
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
LCP 18. 早餐组合
https://leetcode-cn.com/problems/2vYnGI/

排序 + 二分
时间复杂度 O(nlogn)
 */