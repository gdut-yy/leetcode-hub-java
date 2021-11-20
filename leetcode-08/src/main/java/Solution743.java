public class Solution743 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 有 n 个网络节点，标记为 1 到 n
        // 邻接矩阵 weights[ui][vi] = wi 表示从 ui 到 vi 有权重为 wi 的边
        int[][] weights = buildAdj(times, n);
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    weights[i][j] = Math.min(weights[i][j], weights[i][p] + weights[p][j]);
                }
            }
        }
        // 遍历答案
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, weights[k][i]);
        }
        return max == INF ? -1 : max;
    }

    private int[][] buildAdj(int[][] times, int n) {
        int[][] weights = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    weights[i][j] = weights[j][i] = 0;
                } else {
                    weights[i][j] = weights[j][i] = INF;
                }
            }
        }
        for (int[] time : times) {
            int ui = time[0];
            int vi = time[1];
            int wi = time[2];
            weights[ui][vi] = wi;
        }
        return weights;
    }
}
/*
743. 网络延迟时间
https://leetcode-cn.com/problems/network-delay-time/

有 n 个网络节点，标记为  1  到 n。
给你一个列表  times，表示信号经过 有向 边的传递时间。  times[i] = (ui, vi, wi)，
其中  ui  是源节点，vi  是目标节点， wi  是一个信号从源节点传递到目标节点的时间。
现在，从某个节点  K  发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回  -1 。

最短路。
Floyd
时间复杂度 O(n^3)

【宫水三叶】涵盖所有的「存图方式」与「最短路算法（详尽注释）」
https://leetcode-cn.com/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
 */