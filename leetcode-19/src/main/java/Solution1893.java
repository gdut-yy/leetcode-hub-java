public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 范围 <= 50 boolean 默认值是 false
        boolean[] rangeArr = new boolean[55];
        for (int[] range : ranges) {
            // 模拟操作
            for (int i = range[0]; i <= range[1]; i++) {
                if (!rangeArr[i]) {
                    rangeArr[i] = true;
                }
            }
        }
        // 校验
        for (int i = left; i <= right; i++) {
            if (!rangeArr[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
1893. 检查是否区域内所有整数都被覆盖
https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

第 54 场双周赛 T1。
由于数组长度非常小，直接进行模拟即可。
 */