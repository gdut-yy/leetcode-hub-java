import java.util.ArrayList;
import java.util.List;

public class SolutionLCP15 {
    // https://leetcode.cn/problems/you-le-yuan-de-mi-gong/solution/you-le-yuan-de-mi-gong-tan-xin-si-lu-by-leetcode-s/
    public int[] visitOrder(int[][] points, String direction) {
        int n = points.length;
        boolean[] used = new boolean[n]; // 记录点的遍历情况，False未遍历 / True已遍历
        List<Integer> order = new ArrayList<>(); // 记录返回结果

        // 查找最左的点作为 起始点
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] < points[start][0]) {
                start = i;
            }
        }
        used[start] = true;
        order.add(start);

        for (char c : direction.toCharArray()) {
            int nxt = -1;
            if (c == 'L') {
                // 转向方向为 L，选择相对方向最右的点
                for (int j = 0; j < n; j++) {
                    if (used[j]) continue;
                    if (nxt == -1 || cross(sub(points[nxt], points[start]), sub(points[j], points[start])) < 0) {
                        nxt = j;
                    }
                }
            } else {
                // 转向方向为 R，选择相对方向最左的点
                for (int j = 0; j < n; j++) {
                    if (used[j]) continue;
                    if (nxt == -1 || cross(sub(points[nxt], points[start]), sub(points[j], points[start])) > 0) {
                        nxt = j;
                    }
                }
            }
            // 返回结果加入选择的点，更新下一次转向的起点
            start = nxt;
            used[start] = true;
            order.add(start);
        }
        // 添加最后一个剩余点
        for (int i = 0; i < n; i++) {
            if (!used[i]) order.add(i);
        }
        return order.stream().mapToInt(i -> i).toArray();
    }

    // 求点 a 到点 b 的向量
    private int[] sub(int[] a, int[] b) {
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    // 求向量 a 到向量 b 的向量叉积
    private int cross(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }
}
/*
LCP 15. 游乐园的迷宫
https://leetcode.cn/problems/you-le-yuan-de-mi-gong/description/

小王来到了游乐园，她玩的第一个项目是模拟推销员。有一个二维平面地图，其中散布着 N 个推销点，编号 0 到 N-1，不存在三点共线的情况。每两点之间有一条直线相连。
游戏没有规定起点和终点，但限定了每次转角的方向。首先，小王需要先选择两个点分别作为起点和终点，然后从起点开始访问剩余 N-2 个点恰好一次并回到终点。
访问的顺序需要满足一串给定的长度为 N-2 由 L 和 R 组成的字符串 direction，表示从起点出发之后在每个顶点上转角的方向。
根据这个提示，小王希望你能够帮她找到一个可行的遍历顺序，输出顺序下标（若有多个方案，输出任意一种）。可以证明这样的遍历顺序一定是存在的。
限制：
3 <= points.length <= 1000 且 points[i].length == 2
1 <= points[i][0],points[i][1] <= 10000
direction.length == points.length - 2
direction 只包含 "L","R"

求凸包？
时间复杂度 O(n^2)。
相似题目: 587. 安装栅栏
https://leetcode.cn/problems/erect-the-fence/
 */