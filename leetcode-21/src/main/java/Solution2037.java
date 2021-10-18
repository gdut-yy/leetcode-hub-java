import java.util.Arrays;

public class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
/*
2037. 使每位学生都有座位的最少移动次数
https://leetcode-cn.com/problems/minimum-number-of-moves-to-seat-everyone/

第 63 场双周赛 T1。
排序后累加即可。
 */