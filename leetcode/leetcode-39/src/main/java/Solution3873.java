import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3873 {
    public int maxActivated(int[][] points) {
        int n = points.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (xMap.containsKey(x)) {
                union(parent, size, i, xMap.get(x));
            } else {
                xMap.put(x, i);
            }

            // 合并相同 y 的点
            if (yMap.containsKey(y)) {
                union(parent, size, i, yMap.get(y));
            } else {
                yMap.put(y, i);
            }
        }
        List<Integer> compSizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                compSizes.add(size[i]);
            }
        }
        int first = 0, second = 0;
        for (int s : compSizes) {
            if (s > first) {
                second = first;
                first = s;
            } else if (s > second) {
                second = s;
            }
        }
        return 1 + first + second;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // 路径压缩
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int[] size, int a, int b) {
        int ra = find(parent, a);
        int rb = find(parent, b);
        if (ra == rb) return;
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
    }
}
/*
3873. 添加一个点后可激活的最大点数
https://leetcode.cn/problems/maximum-points-activated-with-one-addition/description/

第 493 场周赛 T4。

给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点的坐标。points 中的所有坐标都 互不相同。
如果一个点被 激活，那么所有与该点具有相同 x 坐标或 y 坐标的点也会被 激活。
激活会一直持续，直到没有额外的点可以被激活为止。
你可以 额外添加 一个不在 points 数组中的整数坐标点 (x, y) 。从这个新添加的点开始 激活。
返回一个整数，表示可以被激活的 最大 点数，包括新添加的点。
提示：
1 <= points.length <= 10^5
points[i] = [xi, yi]
-10^9 <= xi, yi <= 10^9
points 中的坐标均 互不相同。

中介并查集。
https://chat.deepseek.com/a/chat/s/25ed1d6d-74b3-419e-a2df-513c1b167ee6
 */