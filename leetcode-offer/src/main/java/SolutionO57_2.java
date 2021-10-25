import java.util.ArrayList;
import java.util.List;

public class SolutionO57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] res = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    res[i - left] = i;
                }
                resList.add(res);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
/*
剑指 Offer 57 - II. 和为s的连续正数序列
https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

双指针。
时间复杂度 O(target)
空间复杂度 O(1)
 */
