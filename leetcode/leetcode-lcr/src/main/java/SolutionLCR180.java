import java.util.ArrayList;
import java.util.List;

public class SolutionLCR180 {
    public int[][] fileCombination(int target) {
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
        return resList.toArray(int[][]::new);
    }
}
/*
LCR 180. 文件组合
https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/

待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
注意，返回时需遵循以下规则：
- 每种组合按照文件编号 升序 排列；
- 不同组合按照第一个文件编号 升序 排列。
提示：
1 <= target <= 10^5

双指针。
时间复杂度 O(target)
空间复杂度 O(1)
 */
