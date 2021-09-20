import java.util.Random;

public class Solution528 {
    static class Solution {
        private final int[] preSum;
        private int total;

        public Solution(int[] w) {
            preSum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                preSum[i] = total;
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int p = random.nextInt(total);
            int left = 0;
            int right = preSum.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] > p) {
                    if (mid == 0 || preSum[mid - 1] <= p) {
                        return mid;
                    }
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
/*
528. 按权重随机选择
https://leetcode-cn.com/problems/random-pick-with-weight/

前缀和 + 二分查找
 */