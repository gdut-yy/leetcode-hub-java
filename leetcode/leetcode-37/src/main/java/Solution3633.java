public class Solution3633 {
}
/*
3633. 最早完成陆地和水上游乐设施的时间 I
https://leetcode.cn/problems/earliest-finish-time-for-land-and-water-rides-i/description/

第 162 场双周赛 T1。

给你两种类别的游乐园项目：陆地游乐设施 和 水上游乐设施。
- 陆地游乐设施
  - landStartTime[i] – 第 i 个陆地游乐设施最早可以开始的时间。
  - landDuration[i] – 第 i 个陆地游乐设施持续的时间。
- 水上游乐设施
  - waterStartTime[j] – 第 j 个水上游乐设施最早可以开始的时间。
  - waterDuration[j] – 第 j 个水上游乐设施持续的时间。
一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。
- 游乐设施可以在其开放时间开始，或 之后任意时间 开始。
- 如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
- 完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
返回游客完成这两个游乐设施的 最早可能时间 。
提示:
1 <= n, m <= 100
landStartTime.length == landDuration.length == n
waterStartTime.length == waterDuration.length == m
1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 1000

同: 3635. 最早完成陆地和水上游乐设施的时间 II
https://leetcode.cn/problems/earliest-finish-time-for-land-and-water-rides-ii/description/
 */