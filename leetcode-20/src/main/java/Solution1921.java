import java.util.Arrays;

public class Solution1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        double[] times = new double[len];
        for (int i = 0; i < len; i++) {
            times[i] = dist[i] / (double) speed[i];
        }
        int cnt = 0;
        // 升序排列
        Arrays.sort(times);
        for (int i = 0; i < len; i++) {
            if (i < times[i]) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
/*
1921. 消灭怪物的最大数量
https://leetcode-cn.com/problems/eliminate-maximum-number-of-monsters/

时间 = 路程 / 速度
求出每个怪物到达所需的时间。贪心法，每分钟解决所需时间最小的那个。则第 n 分钟最多能解决 n+1 个怪物，前提是所需的时间要小于怪物到达的时间，否则游戏 GG
*/
