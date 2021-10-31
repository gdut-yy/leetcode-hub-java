package template;

/**
 * 前缀和数组
 */
public class PrefixSum {
    private final int[] preSum;

    public PrefixSum(int[] nums) {
        int len = nums.length;
        preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    /**
     * 求 nums[i,j] 的累加和
     */
    public int rangeSum(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum(new int[]{-2, 0, 3, -5, 2, -1});
        // 1
        System.out.println(prefixSum.rangeSum(0, 2));
        // -1
        System.out.println(prefixSum.rangeSum(2, 5));
        // -3
        System.out.println(prefixSum.rangeSum(0, 5));
    }
}
