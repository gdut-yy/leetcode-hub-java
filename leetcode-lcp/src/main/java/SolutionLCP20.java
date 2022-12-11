import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCP20 {
    private static final int MOD = (int) (1e9 + 7);

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        // 后往前 BFS. target => 0 [time, pos]
        priorityQueue.add(new long[]{0, target});
        while (!priorityQueue.isEmpty()) {
            long[] top = priorityQueue.remove();
            long time = top[0];
            long pos = top[1];
            if (pos == 0) {
                return (int) (time % MOD);
            }

            // 直接走 0 => target
            priorityQueue.add(new long[]{time + pos * inc, 0});
            for (int i = 0; i < jump.length; i++) {
                long remain = pos % jump[i];
                // 先跳右后左 (x+y) % jump[i] == 0
                priorityQueue.add(new long[]{time + remain * inc + cost[i], pos / jump[i]});
                // 先跳左后右 (x-y) % jump[i] == 0
                priorityQueue.add(new long[]{time + (jump[i] - remain) * dec + cost[i], pos / jump[i] + 1});
            }
        }
        return -1;
    }
}
/*
LCP 20. 快速公交
https://leetcode.cn/problems/meChtZ/

小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：
- 小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
- 小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。
小扣可以搭乘任意编号的公交车且搭乘公交次数不限。
假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
注意：小扣可在移动过程中到达编号大于 target 的站点。
提示：
1 <= target <= 10^9
1 <= jump.length, cost.length <= 10
2 <= jump[i] <= 10^6
1 <= inc, dec, cost[i] <= 10^6

后往前 BFS
https://leetcode.cn/problems/meChtZ/solution/suan-fa-xiao-ai-li-kou-bei-li-jie-zhen-t-tg1z/
思考 hqztrue 佬的 hack 用例
 */