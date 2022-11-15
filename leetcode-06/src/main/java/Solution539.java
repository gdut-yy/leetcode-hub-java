import java.util.BitSet;
import java.util.List;

public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        BitSet bitSet = new BitSet(1440);
        for (String timePoint : timePoints) {
            String[] times = timePoint.split(":");
            int minute = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            if (bitSet.get(minute)) {
                return 0;
            }
            bitSet.set(minute, true);
        }
        return getMinDiff(bitSet);
    }

    private int getMinDiff(BitSet bitSet) {
        int bitSetLen = 1440;
        int minDiff = bitSetLen - 1;
        int prev = -1;
        int first = bitSetLen - 1;
        int last = -1;
        for (int i = 0; i < bitSetLen; i++) {
            if (bitSet.get(i)) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }
                prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }
        minDiff = Math.min(first + bitSetLen - last, minDiff);
        return minDiff;
    }
}
/*
539. 最小时间差
https://leetcode.cn/problems/minimum-time-difference/

给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
提示：
2 <= timePoints.length <= 2 * 10^4
timePoints[i] 格式为 "HH:MM"

BitSet 长度为定长 1440，为常数，因此：
时间复杂度 O(1)
空间复杂度 O(1)
注意 BitSet#size()、BitSet#length() 与 boolean[] bitset; bitset.length 之间的区别
 */