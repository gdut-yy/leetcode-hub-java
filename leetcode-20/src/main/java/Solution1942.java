import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;

public class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetFriendTimes = times[targetFriend];
        // 按到达时间升序排序
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
        // BitSet 模拟
        int len = times.length;
        BitSet[] bitSet = new BitSet[len];
        for (int i = 0; i < len; i++) {
            bitSet[i] = new BitSet(100000);
            bitSet[i].set(0, len, false);
        }
        for (int[] time : times) {
            int arrival = time[0];
            int leaving = time[1];
            // 编号最小 且未被占据的椅子
            int seat = 0;
            while (bitSet[seat].get(arrival)) {
                seat++;
            }
            // 占据椅子
            bitSet[seat].set(arrival, leaving, true);
            if (arrival == targetFriendTimes[0]) {
                return seat;
            }
        }
        return 0;
    }
}
/*
1942. 最小未被占据椅子的编号
https://leetcode-cn.com/problems/the-number-of-the-smallest-unoccupied-chair/

第 57 场双周赛 T2。
1 <= arrivali < leavingi <= 10^5
暴力时间复杂度达 O(n^2) 使用 BitSet 进行模拟可以 AC
 */