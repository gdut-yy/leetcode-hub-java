import java.util.Arrays;

public class Solution453 {
    public int minMoves(int[] nums) {
        // 最小值
        int min = Arrays.stream(nums).min().getAsInt();
        int cnt = 0;
        for (int num : nums) {
            cnt += num - min;
        }
        return cnt;
    }
}
/*
453. 最小操作次数使数组元素相等
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/

给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。

每次操作将会使 n - 1 个元素增加 1
相当于每次操作将 1 个元素减少 1
 */