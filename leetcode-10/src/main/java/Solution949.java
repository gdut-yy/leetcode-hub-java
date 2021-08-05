import java.util.Locale;

public class Solution949 {
    public String largestTimeFromDigits(int[] arr) {
        int largestMinutes = -1;
        for (int i0 = 0; i0 < 4; i0++) {
            for (int i1 = 0; i1 < 4; i1++) {
                if (i1 != i0) {
                    largestMinutes = getLargestMinutes(arr, largestMinutes, i0, i1);
                }
            }
        }
        if (largestMinutes == -1) {
            return "";
        }
        return String.format(Locale.ENGLISH, "%02d:%02d", largestMinutes / 60, largestMinutes % 60);
    }

    /**
     * 降低 "圈复杂度"
     */
    private int getLargestMinutes(int[] arr, int largestMinutes, int i0, int i1) {
        for (int i2 = 0; i2 < 4; i2++) {
            if (i2 != i0 && i2 != i1) {
                int i3 = 6 - i0 - i1 - i2;

                int hour = arr[i0] * 10 + arr[i1];
                int minute = arr[i2] * 10 + arr[i3];
                if (hour <= 23 && minute <= 59) {
                    largestMinutes = Math.max(largestMinutes, hour * 60 + minute);
                }
            }
        }
        return largestMinutes;
    }
}
/*
949. 给定数字能组成的最大时间
https://leetcode-cn.com/problems/largest-time-for-given-digits/

第 113 场周赛 T1。
暴力即可。最多 24 种情况。
 */