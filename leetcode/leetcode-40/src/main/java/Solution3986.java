public class Solution3986 {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return time2int(endTime) - time2int(startTime);
    }

    private int time2int(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 * 60 +
                Integer.parseInt(time.substring(3, 5)) * 60 +
                Integer.parseInt(time.substring(6, 8));
    }
}
/*
3986. 统计起止时间经过的秒数
https://leetcode.cn/problems/number-of-elapsed-seconds-between-two-times/description/

第 510 场周赛 T1。

给你两个有效时间 startTime 和 endTime，它们均以字符串形式表示，格式为 "HH:MM:SS"。
返回从 startTime 到 endTime 经过的秒数（包含两个端点）。
提示：
startTime.length == 8
endTime.length == 8
startTime 和 endTime 均为格式 "HH:MM:SS" 的有效时间
00 <= HH <= 23
00 <= MM <= 59
00 <= SS <= 59
endTime 不早于 startTime

数学。库函数。
时间复杂度 O(1)。
相似题目: 1904. 你完成的完整对局数
https://leetcode.cn/problems/the-number-of-full-rounds-you-have-played/
 */