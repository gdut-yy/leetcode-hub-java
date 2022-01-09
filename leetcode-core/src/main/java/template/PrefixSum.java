package template;

/**
 * 一维前缀和/一维差分
 */
public class PrefixSum {
    private final int len;
    private final int[] preSum;
    private final int[] diff;

    public PrefixSum(int[] nums) {
        this.len = nums.length;
        // 前缀和
        preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 差分 init
        diff = new int[len + 1];
    }

    /**
     * 前缀和：求 nums [i,j] 的累加和
     */
    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }

    /**
     * 差分：nums [i,j] 增加 inc
     */
    public void rangeAdd(int i, int j, int inc) {
        diff[i] += inc;
        diff[j + 1] -= inc;
    }

    /**
     * 差分：获取原数组
     */
    public int[] originalArray() {
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
