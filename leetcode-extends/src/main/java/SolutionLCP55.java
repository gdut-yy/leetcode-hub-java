public class SolutionLCP55 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int res = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0];
            int num = fruit[1];
            int batch = (num % limit == 0) ? num / limit : num / limit + 1;
            res += time[type] * batch;
        }
        return res;
    }
}
/*
LCP 55. 采集果实
https://leetcode-cn.com/problems/PTXy4P/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T1。

欢迎各位勇者来到力扣新手村，本次训练内容为「采集果实」。
在新手村中，各位勇者需要采集一些果实来制作药剂。time[i] 表示勇者每次采集 1～limit 颗第 i 种类型的果实需要的时间（即每次最多可以采集 limit 颗果实）。
当前勇者需要完成「采集若干批果实」的任务， fruits[j] = [type, num] 表示第 j 批需要采集 num 颗 type 类型的果实。采集规则如下：
- 按 fruits 给定的顺序依次采集每一批次
- 采集完当前批次的果实才能开始采集下一批次
- 勇者完成当前批次的采集后将清空背包（即多余的果实将清空）
请计算并返回勇者完成采集任务最少需要的时间。
提示：
1 <= time.length <= 100
1 <= time[i] <= 100
1 <= fruits.length <= 10^3
0 <= fruits[i][0] < time.length
1 <= fruits[i][1] < 10^3
1 <= limit <= 100

模拟。
 */