import java.util.Arrays;
import java.util.Comparator;

public class ZjFuture220708T1 {
    public boolean canReceiveAllSignals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
/*
zj-future01. 信号接收
https://leetcode.cn/contest/zj-future2022/problems/WYKGLO/

假设有若干信号发射源定时发送信号， signals[i] = [start, end) 表示第 i 个信号发射源运作的开始时间 start 和停止时间 end 。
若调度员的接收设备同一时刻仅能接收一个发射源发出的信号，请判断调度员能否收到所有发射源的完整信号。
注意：只有接收了一个信号源从开始到结束的所有信号才算完整信号。
示例 1：
输入：signals = [[0,40],[10,15],[20,30]]
输出：false
解释：
时间 [10,15) 内不能同时接收信号 0 和信号 1，
时间 [20,30) 内不能同时接收信号 0 和信号 2。
示例 2：
输入：signals = [[2,8],[8,14]]
输出：true
示例 3：
输入：signals = [[9,12],[2,3]]
输出：true
提示：
0 <= signals.length <= 10^4
signals[i].length == 2
0 <= starti < endi <= 10^6

相似题目: 729. 我的日程安排表 I
https://leetcode.cn/problems/my-calendar-i/
 */