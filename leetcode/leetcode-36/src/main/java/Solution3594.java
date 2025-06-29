import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3594 {
    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        double[] maxTimeSub = new double[1 << n];
        for (int g = 0; g < (1 << n); g++) {
            double maxT = 0;
            for (int i = 0; i < n; i++) {
                if (((g >> i) & 1) == 1) {
                    if (time[i] > maxT) {
                        maxT = time[i];
                    }
                }
            }
            maxTimeSub[g] = maxT;
        }

        List<Integer>[] subsets = new ArrayList[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            subsets[mask] = new ArrayList<>();
            for (int g = mask; g > 0; g = (g - 1) & mask) {
                int cnt = Integer.bitCount(g);
                if (cnt >= 1 && cnt <= k) {
                    subsets[mask].add(g);
                }
            }
        }

        double[][][] dp = new double[1 << n][m][2];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Double.POSITIVE_INFINITY);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        dp[(1 << n) - 1][0][1] = 0.0;
        q.add(new int[]{(1 << n) - 1, 0, 1});

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int mask = state[0];
            int stage = state[1];
            int boat = state[2];
            double t = dp[mask][stage][boat];

            if (boat == 1) {
                for (int g : subsets[mask]) {
                    double maxT = maxTimeSub[g];
                    double d = maxT * mul[stage];
                    int time_floor = (int) Math.floor(d);
                    int new_stage = (stage + time_floor) % m;
                    int new_mask = mask ^ g;
                    int new_boat = 0;
                    double new_time = t + d;

                    if (new_time < dp[new_mask][new_stage][new_boat]) {
                        dp[new_mask][new_stage][new_boat] = new_time;
                        q.add(new int[]{new_mask, new_stage, new_boat});
                    }
                }
            } else {
                if (mask != 0) {
                    for (int i = 0; i < n; i++) {
                        if ((mask & (1 << i)) == 0) {
                            double d = time[i] * mul[stage];
                            int time_floor = (int) Math.floor(d);
                            int new_stage = (stage + time_floor) % m;
                            int new_mask = mask | (1 << i);
                            int new_boat = 1;
                            double new_time = t + d;

                            if (new_time < dp[new_mask][new_stage][new_boat]) {
                                dp[new_mask][new_stage][new_boat] = new_time;
                                q.add(new int[]{new_mask, new_stage, new_boat});
                            }
                        }
                    }
                }
            }
        }

        double minTotalTime = Double.POSITIVE_INFINITY;
        for (int stage = 0; stage < m; stage++) {
            if (dp[0][stage][0] < minTotalTime) {
                minTotalTime = dp[0][stage][0];
            }
        }

        return minTotalTime == Double.POSITIVE_INFINITY ? -1.0 : minTotalTime;
    }
}
/*
3594. 所有人渡河所需的最短时间
https://leetcode.cn/problems/minimum-time-to-transport-all-individuals/description/

第 455 场周赛 T4。

有 n 名人员在一个营地，他们需要使用一艘船过河到达目的地。这艘船一次最多可以承载 k 人。渡河过程受到环境条件的影响，这些条件以 周期性 的方式在 m 个阶段内变化。
每个阶段 j 都有一个速度倍率 mul[j]：
- 如果 mul[j] > 1，渡河时间会变长。
- 如果 mul[j] < 1，渡河时间会缩短。
每个人 i 都有一个划船能力，用 time[i] 表示，即在中性条件下（倍率为 1 时）单独渡河所需的时间（以分钟为单位）。
规则：
- 从阶段 j 出发的一组人 g 渡河所需的时间（以分钟为单位）为组内成员的 最大 time[i]，乘以 mul[j] 。
- 该组人渡河所需的时间为 d，阶段会前进 floor(d) % m 步。
- 如果还有人留在营地，则必须有一人带着船返回。设返回人的索引为 r，返回所需时间为 time[r] × mul[current_stage]，记为 return_time，阶段会前进 floor(return_time) % m 步。
返回将所有人渡河所需的 最少总时间 。如果无法将所有人渡河，则返回 -1。
提示：
1 <= n == time.length <= 12
1 <= k <= 5
1 <= m <= 5
1 <= time[i] <= 100
m == mul.length
0.5 <= mul[i] <= 2.0

状态压缩动态规划。https://yuanbao.tencent.com/chat/naQivTmsDa/818d87fb-54ed-49e0-9643-d71de7114f65
dp[mask][stage][boat] 存储达到该状态所需的最少时间，其中：
mask：二进制数，表示当前还在营地的人员（1表示在营地，0表示已到目的地）。
stage：当前环境阶段（0到m-1）。
boat：船的位置（0在目的地，1在营地）。
时间复杂度 O(2^n * m * 2)。
rating 2615 (clist.by)
 */