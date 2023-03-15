import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCP59 {
    // https://leetcode.cn/problems/NfY1m5/solution/by-tsreaper-qhvj/
    public long buildBridge(int num, int[][] wood) {
        PriorityQueue<Long> L = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> R = new PriorityQueue<>();
        L.add((long) wood[0][0]);
        R.add((long) wood[0][0]);
        long biasL = 0, biasR = 0, ans = 0;
        for (int i = 1; i < wood.length; i++) {
            biasL -= wood[i][1] - wood[i][0];
            biasR += wood[i - 1][1] - wood[i - 1][0];
            long l0 = L.element() + biasL;
            long r0 = R.element() + biasR;
            int x = wood[i][0];
            if (x < l0) {
                ans += l0 - x;
                L.poll();
                L.add(x - biasL);
                L.add(x - biasL);
                R.add(l0 - biasR);
            } else if (x > r0) {
                ans += x - r0;
                R.poll();
                R.add(x - biasR);
                R.add(x - biasR);
                L.add(r0 - biasL);
            } else {
                L.add(x - biasL);
                R.add(x - biasR);
            }
        }
        return ans;
    }
}
/*
LCP 59. 搭桥过河
https://leetcode.cn/problems/NfY1m5/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T5。

欢迎各位勇者来到力扣城，本次试炼主题为「搭桥过河」。
勇者面前有一段长度为 num 的河流，河流可以划分为若干河道。每条河道上恰有一块浮木，wood[i] 记录了第 i 条河道上的浮木初始的覆盖范围。
- 当且仅当浮木与相邻河道的浮木覆盖范围有重叠时，勇者才可以在两条浮木间移动
- 勇者 仅能在岸上 通过花费一点「自然之力」，使任意一条浮木沿着河流移动一个单位距离
请问勇者跨越这条河流，最少需要花费多少「自然之力」。
提示:
1 <= num <= 10^9
1 <= wood.length <= 10^5
wood[i].length == 2
1 <= wood[i][0] <= wood[i][1] <= num

Slope Trick
原题：https://atcoder.jp/contests/arc070/tasks/arc070_c
https://www.cnblogs.com/wyzwyz/p/14038855.html
相似题目: LCP 24. 数字游戏
https://leetcode.cn/problems/5TxKeK/
 */