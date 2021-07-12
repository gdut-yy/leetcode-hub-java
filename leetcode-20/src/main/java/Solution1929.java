import java.util.Arrays;

public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i];
            ans[i + len] = nums[i];
        }
        return ans;
    }
}
/*
1929. 数组串联
https://leetcode-cn.com/problems/concatenation-of-array/

第 249 场周赛签到题。按题意写即可。
 */