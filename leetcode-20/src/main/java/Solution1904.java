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

一款新的在线电子游戏在近期发布，在该电子游戏中，以 刻钟 为周期规划若干时长为 15 分钟 的游戏对局。
这意味着，在 HH:00、HH:15、HH:30 和 HH:45 ，将会开始一个新的对局，其中 HH 用一个从 00 到 23 的整数表示。
游戏中使用 24 小时制的时钟 ，所以一天中最早的时间是 00:00 ，最晚的时间是 23:59 。
给你两个字符串 startTime 和 finishTime ，均符合 "HH:MM" 格式，分别表示你 进入 和 退出 游戏的确切时间，请计算在整个游戏会话期间，你完成的 完整对局的对局数 。
- 例如，如果 startTime = "05:20" 且 finishTime = "05:59" ，这意味着你仅仅完成从 05:30 到 05:45 这一个完整对局。
而你没有完成从 05:15 到 05:30 的完整对局，因为你是在对局开始后进入的游戏；同时，你也没有完成从 05:45 到 06:00 的完整对局，因为你是在对局结束前退出的游戏。
如果 finishTime 早于 startTime ，这表示你玩了个通宵（也就是从 startTime 到午夜，再从午夜到 finishTime）。
假设你是从 startTime 进入游戏，并在 finishTime 退出游戏，请计算并返回你完成的 完整对局的对局数 。

考察边界值处理。需注意用例 startTime = "00:47", finishTime = "00:57" 避免返回负值
 */