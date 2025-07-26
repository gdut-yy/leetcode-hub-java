import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        int[] neg = new int[n + 1];
        long[] W = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            p[i] = boxes[i - 1][0];
            w[i] = boxes[i - 1][1];
            if (i > 1) {
                neg[i] = neg[i - 1] + ((p[i - 1] != p[i]) ? 1 : 0);
            }
            W[i] = W[i - 1] + w[i];
        }

        Deque<Integer> opt = new ArrayDeque<>();
        opt.add(0);
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            while (!opt.isEmpty() && (i - opt.getFirst() > maxBoxes || W[i] - W[opt.getFirst()] > maxWeight)) {
                opt.removeFirst();
            }

            f[i] = g[opt.getFirst()] + neg[i] + 2;

            if (i != n) {
                g[i] = f[i] - neg[i + 1];
                while (!opt.isEmpty() && g[i] <= g[opt.getLast()]) {
                    opt.removeLast();
                }
                opt.addLast(i);
            }
        }

        return f[n];
    }
}
/*
1687. 从仓库到码头运输箱子
https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/description/

你有一辆货运卡车，你需要用这一辆车把一些箱子从仓库运送到码头。这辆卡车每次运输有 箱子数目的限制 和 总重量的限制 。
给你一个箱子数组 boxes 和三个整数 portsCount, maxBoxes 和 maxWeight ，其中 boxes[i] = [portsi , weighti] 。
- portsi 表示第 i 个箱子需要送达的码头，weightsi 是第 i 个箱子的重量。
- portsCount 是码头的数目。
- maxBoxes 和 maxWeight 分别是卡车每趟运输箱子数目和重量的限制。
箱子需要按照 数组顺序 运输，同时每次运输需要遵循以下步骤：
- 卡车从 boxes 队列中按顺序取出若干个箱子，但不能违反 maxBoxes 和 maxWeight 限制。
- 对于在卡车上的箱子，我们需要 按顺序 处理它们，卡车会通过 一趟行程 将最前面的箱子送到目的地码头并卸货。如果卡车已经在对应的码头，那么不需要 额外行程 ，箱子也会立马被卸货。
- 卡车上所有箱子都被卸货后，卡车需要 一趟行程 回到仓库，从箱子队列里再取出一些箱子。
卡车在将所有箱子运输并卸货后，最后必须回到仓库。
请你返回将所有箱子送到相应码头的 最少行程 次数。
提示：
1 <= boxes.length <= 10^5
1 <= portsCount, maxBoxes, maxWeight <= 10^5
1 <= portsi <= portsCount
1 <= weightsi <= maxWeight

动态规划 + 单调队列优化 https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/solutions/519237/cong-cang-ku-dao-ma-tou-yun-shu-xiang-zi-dqnq/
时间复杂度 O(n)。
 */