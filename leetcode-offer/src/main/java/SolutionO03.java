import java.util.HashMap;
import java.util.Map;

public class SolutionO03 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            int curVal = cntMap.getOrDefault(num, 0);
            if (curVal == 1) {
                return num;
            } else {
                cntMap.put(num, curVal + 1);
            }
        }
        return -1;
    }
}
/*
剑指 Offer 03. 数组中重复的数字
https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */