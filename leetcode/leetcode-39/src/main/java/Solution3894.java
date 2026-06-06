public class Solution3894 {
    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        else if (timer == 30) return "Orange";
        else if (30 < timer && timer <= 90) return "Red";
        else return "Invalid";
    }
}
/*
3894. 交通信号灯的颜色
https://leetcode.cn/problems/traffic-signal-color/description/

第 180 场双周赛 T1。

给你一个整数 timer，表示交通信号灯上的剩余时间（以秒为单位）。
信号灯遵循以下规则：
- 如果 timer == 0，信号灯为 "Green"
- 如果 timer == 30，信号灯为 "Orange"
- 如果 30 < timer <= 90，信号灯为 "Red"
返回信号灯的当前状态。如果均不满足上述条件，返回 "Invalid"。
提示：
0 <= timer <= 1000

模拟。
时间复杂度 O(1)。
 */