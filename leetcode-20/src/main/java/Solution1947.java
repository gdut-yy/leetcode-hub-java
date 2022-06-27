import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution1947 {
    /**
     * 全排列
     * 时间复杂度 O(m^2*n + m*m!)
     */
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        // n 个问题
        int n = students[0].length;
        // m 名学生和 m 名导师
        int m = students.length;
        // 预处理
        // score[i][j] 代表下标为 i 的学生与下标为 j 的老师的 兼容性评分
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score[i][j] += 1;
                    }
                }
            }
        }
        // 全排列学生
        int[] studentOrders = new int[m];
        for (int i = 0; i < m; i++) {
            studentOrders[i] = i;
        }
        List<List<Integer>> arrangeList = permute(studentOrders);
        int max = 0;
        for (List<Integer> arrange : arrangeList) {
            int cnt = 0;
            for (int mentorIdx = 0; mentorIdx < m; mentorIdx++) {
                int studentIdx = arrange.get(mentorIdx);
                cnt += score[studentIdx][mentorIdx];
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // nums 的一个快照
        List<Integer> snapshotNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int len = nums.length;
        dfs(res, snapshotNums, len, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> snapshotNums, int len, int curI) {
        if (curI == len) {
            // 记录当前快照的副本
            res.add(new ArrayList<>(snapshotNums));
        }
        for (int i = curI; i < len; i++) {
            // 操作
            Collections.swap(snapshotNums, curI, i);
            // 下一迭代
            dfs(res, snapshotNums, len, curI + 1);
            // 回退操作
            Collections.swap(snapshotNums, curI, i);
        }
    }

    /**
     * 匈牙利算法（KM 算法）
     * 时间复杂度 O(n^3)
     */
    public int maxCompatibilitySum2(int[][] students, int[][] mentors) {
        // n 个问题
        int n = students[0].length;
        // m 名学生和 m 名导师
        int m = students.length;
        // 预处理
        // score[i][j] 代表下标为 i 的学生与下标为 j 的老师的 兼容性评分
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score[i][j] += 1;
                    }
                }
            }
        }
        KmAlgo kmAlgo = new KmAlgo(m, score);
        return kmAlgo.getMaximumWeight();
    }

    private static class KmAlgo {
        private final int n;
        // 左集合对应的匹配点
        private final int[] matchX;
        // 右集合对应的匹配点
        private final int[] matchY;
        // 连接右集合的左点
        private final int[] pre;
        // 拜访数组 左
        private final boolean[] visX;
        // 拜访数组 右
        private final boolean[] visY;
        // 可行顶标 给每个节点 i 分配一个权值 l(i)，对于所有边 (u,v) 满足 w(u,v) <= l(u) + l(v)。
        private final int[] lx;
        private final int[] ly;
        private final int[][] graph;
        private final int[] slack;
        private static final int INF = Integer.MAX_VALUE;
        private final Queue<Integer> queue;

        public KmAlgo(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
            this.queue = new LinkedList<>();
            this.matchX = new int[n];
            Arrays.fill(matchX, -1);
            this.matchY = new int[n];
            Arrays.fill(matchY, -1);
            this.pre = new int[n];
            this.visX = new boolean[n];
            this.visY = new boolean[n];
            this.lx = new int[n];
            Arrays.fill(lx, -INF);
            this.ly = new int[n];
            this.slack = new int[n];
        }

        public int getMaximumWeight() {
            // 初始顶标
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    lx[i] = Math.max(lx[i], graph[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(slack, INF);
                Arrays.fill(visX, false);
                Arrays.fill(visY, false);
                bfs(i);
            }
            // custom
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += graph[i][matchX[i]];
            }
            return res;
        }

        private boolean check(int v) {
            visY[v] = true;
            if (matchY[v] != -1) {
                queue.add(matchY[v]);
                // in S
                visX[matchY[v]] = true;
                return false;
            }
            // 找到新的未匹配点 更新匹配点 pre 数组记录着"非匹配边"上与之相连的点
            while (v != -1) {
                matchY[v] = pre[v];
                // swap(v, matchx[pre[v]]);
                int tmp = matchX[pre[v]];
                matchX[pre[v]] = v;
                v = tmp;
            }
            return true;
        }

        private void bfs(int i) {
            queue.clear();
            queue.add(i);
            visX[i] = true;
            while (true) {
                while (!queue.isEmpty()) {
                    int u = queue.remove();
                    for (int v = 0; v < n; v++) {
                        if (!visY[v]) {
                            int delta = lx[u] + ly[v] - graph[u][v];
                            if (slack[v] >= delta) {
                                pre[v] = u;
                                if (delta > 0) {
                                    slack[v] = delta;
                                } else if (check(v)) {
                                    // delta=0 代表有机会加入相等子图 找增广路
                                    // 找到就return 重建交错树
                                    return;
                                }
                            }
                        }
                    }
                }
                // 没有增广路 修改顶标
                int a = INF;
                for (int j = 0; j < n; j++) {
                    if (!visY[j]) {
                        a = Math.min(a, slack[j]);
                    }
                }
                for (int j = 0; j < n; j++) {
                    // S
                    if (visX[j]) {
                        lx[j] -= a;
                    }
                    // T
                    if (visY[j]) {
                        ly[j] += a;
                    }
                    // T'
                    else {
                        slack[j] -= a;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (!visY[j] && slack[j] == 0 && check(j)) {
                        return;
                    }
                }
            }
        }
    }
}
/*
1947. 最大兼容性评分和
https://leetcode.cn/problems/maximum-compatibility-score-sum/

第 251 场周赛 T3。

有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。
这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，
其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，
其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。
每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。
例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。
给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。
提示：
m == students.length == mentors.length
n == students[i].length == mentors[j].length
1 <= m, n <= 8
students[i][k] 为 0 或 1
mentors[j][k] 为 0 或 1

二分图最大权匹配。
数据量很少，直接 全排列 或者 状态压缩 dp
全排列 时间复杂度 O(m^2*n + m*m!)
也可以使用 匈牙利算法（KM 算法）

相似题目: 1066. 校园自行车分配 II
https://leetcode.cn/problems/campus-bikes-ii/
 */