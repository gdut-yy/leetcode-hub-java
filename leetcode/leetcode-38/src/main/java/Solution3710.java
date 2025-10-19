import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Solution3710 {
    public int maxPartitionFactor(int[][] points) {
        int n = points.length;
        if (n == 2) {
            return 0;
        }
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (d > maxDist) {
                    maxDist = d;
                }
            }
        }
        int low = 0, high = maxDist;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (check(mid, points)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean check(int mid, int[][] points) {
        int n = points.length;
        if (mid == 0) {
            return true;
        }
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (d < mid) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int x = q.poll();
                    for (int y : g[x]) {
                        if (color[y] == 0) {
                            color[y] = 3 - color[x];
                            q.offer(y);
                        } else if (color[y] == color[x]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
/*
3710. 最大划分因子
https://leetcode.cn/problems/maximum-partition-factor/description/

第 167 场双周赛 T4。

给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示笛卡尔平面上第 i 个点的坐标。
两个点 points[i] = [xi, yi] 和 points[j] = [xj, yj] 之间的 曼哈顿距离 是 |xi - xj| + |yi - yj|。
将这 n 个点分成 恰好两个非空 的组。一个划分的 划分因子 是位于同一组内的所有无序点对之间 最小 的曼哈顿距离。
返回所有有效划分中 最大 可能的 划分因子 。
注意: 大小为 1 的组不存在任何组内点对。当 n = 2 时（两个组大小都为 1），没有组内点对，划分因子为 0。
提示:
2 <= points.length <= 500
points[i] = [xi, yi]
-10^8 <= xi, yi <= 10^8

二分图。
https://yuanbao.tencent.com/chat/naQivTmsDa/9d2aa592-e153-441c-bd83-379c04918f61
rating 2158 (clist.by)
 */