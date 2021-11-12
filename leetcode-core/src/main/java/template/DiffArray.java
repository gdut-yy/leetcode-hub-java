package template;

import java.util.Arrays;

/**
 * 差分数组
 */
public class DiffArray {
    private final int[] diff;

    public DiffArray(int n) {
        diff = new int[n + 1];
    }

    /**
     * nums[i] 到 [j] 增加 inc
     */
    public void rangeAdd(int i, int j, int inc) {
        diff[i] += inc;
        diff[j + 1] -= inc;
    }

    /**
     * 获取原数组
     */
    public int[] originalArray() {
        int[] res = new int[diff.length - 1];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        DiffArray diffArray = new DiffArray(5);
        diffArray.rangeAdd(1, 3, 2);
        diffArray.rangeAdd(2, 4, 3);
        diffArray.rangeAdd(0, 2, -2);
        // -2,0,3,5,3
        System.out.println(Arrays.toString(diffArray.originalArray()));
    }
}
