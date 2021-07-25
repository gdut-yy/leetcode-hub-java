public class Solution1904 {
    public int numberOfRounds(String startTime, String finishTime) {
        // 处理 hour/minute
        int[] startTimes = dealWithTimeString(startTime);
        int[] finishTimes = dealWithTimeString(finishTime);

        // “如果 finishTime 早于 startTime ，这表示你玩了个通宵”
        // 因此要加上 24 hour. 注意不能只比较 hour，因为也存在 hour 相等，minute 不等的场景
        if ((startTimes[0] > finishTimes[0])
                || (startTimes[0] == finishTimes[0]) && (startTimes[1] > finishTimes[1])) {
            finishTimes[0] += 24;
        }

        // 取整开始结束时间
        this.dealWithStartTimes(startTimes);
        this.dealWithFinishTimes(finishTimes);

        // 计算结果
        if (startTimes[0] > finishTimes[0]) {
            return 0;
        }
        return (finishTimes[0] - startTimes[0]) * 4 + (finishTimes[1] - startTimes[1]) / 15;
    }

    private int[] dealWithTimeString(String time) {
        String[] times = time.split(":");
        return new int[]{Integer.parseInt(times[0]), Integer.parseInt(times[1])};
    }

    /**
     * 处理 startTime 0 ~ 59
     */
    private void dealWithStartTimes(int[] startTimes) {
        int minute = startTimes[1];
        if (minute % 15 != 0) {
            // 向右取整
            minute = minute / 15 * 15 + 15;
        }
        if (minute == 60) {
            startTimes[0] += 1;
            startTimes[1] = 0;
        } else {
            startTimes[1] = minute;
        }
    }

    /**
     * 处理 finishTimes 0 ~ 59
     */
    private void dealWithFinishTimes(int[] finishTimes) {
        int minute = finishTimes[1];
        if (minute % 15 != 0) {
            // 向左取整
            minute = minute / 15 * 15;
        }
        finishTimes[1] = minute;
    }
}
/*
1904. 你完成的完整对局数
https://leetcode-cn.com/problems/the-number-of-full-rounds-you-have-played/

第 246 场周赛 T2。
考察边界值处理。需注意用例 startTime = "00:47", finishTime = "00:57" 避免返回负值
 */