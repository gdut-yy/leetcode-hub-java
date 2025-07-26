import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution818 {
    // dijkstra
    static class V1 {
        public int racecar(int target) {
            int k = 33 - Integer.numberOfLeadingZeros(target - 1);
            int barrier = 1 << k;

            // dijkstra_mlogm
            int[] dist = new int[2 * barrier + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[target] = 0;
            // target, steps
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{target, 0});
            while (!pq.isEmpty()) {
                int[] top = pq.remove();
                int target1 = top[0], steps1 = top[1];
                int y = Math.floorMod(target1, dist.length); //
                if (dist[y] > steps1) continue;

                for (int j = 0; j <= k; ++j) {
                    int walk = (1 << j) - 1;
                    int target2 = walk - target1;
                    int steps2 = steps1 + j + (target2 != 0 ? 1 : 0);

                    // -3 % 17 = -3, Math.floorMod(-3, 17) = 14
                    int z = Math.floorMod(target2, dist.length);
                    if (Math.abs(target2) <= barrier && steps2 < dist[z]) {
                        dist[z] = steps2;
                        pq.add(new int[]{target2, steps2});
                    }
                }
            }
            return dist[0];
        }
    }

    // 动态规划
    static class V2 {
        public int racecar(int target) {
            // dp[x] 表示到达位置 x 的最短指令长度
            int[] dp = new int[target + 3];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 4;

            for (int t = 3; t <= target; t++) {
                int k = 32 - Integer.numberOfLeadingZeros(t);
                int full = (1 << k) - 1;
                if (t == full) {
                    dp[t] = k;
                    continue;
                }
                for (int j = 0; j < k - 1; ++j) {
                    dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
                }
                if ((1 << k) - 1 - t < t) {
                    dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
                }
            }
            return dp[target];
        }
    }
}
/*
818. 赛车
https://leetcode.cn/problems/race-car/description/

你的赛车可以从位置 0 开始，并且速度为 +1 ，在一条无限长的数轴上行驶。赛车也可以向负方向行驶。赛车可以按照由加速指令 'A' 和倒车指令 'R' 组成的指令序列自动行驶。
- 当收到指令 'A' 时，赛车这样行驶：
  - position += speed
  - speed *= 2
- 当收到指令 'R' 时，赛车这样行驶：
  - 如果速度为正数，那么speed = -1
  - 否则 speed = 1
当前所处位置不变。
例如，在执行指令 "AAR" 后，赛车位置变化为 0 --> 1 --> 3 --> 3 ，速度变化为 1 --> 2 --> 4 --> -1 。
给你一个目标位置 target ，返回能到达目标位置的最短指令序列的长度。
提示：
1 <= target <= 10^4

dijkstra / 动态规划 https://leetcode.cn/problems/race-car/solutions/38854/sai-che-by-leetcode/
时间复杂度 O(TlogT)。其中 O(T) 表示 barrier 的数量级
 */