import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        // 目前所有已经落稳的 方块堆叠的最高高度 。
        int highest = 0;
        List<Integer> resList = new ArrayList<>();
        // 线段树
        DynamicSegTreeUpd dynamicSegTreeUpd = new DynamicSegTreeUpd();
        for (int[] position : positions) {
            // 左闭右开
            int left = position[0];
            int right = position[0] + position[1] - 1;

            int newHeight = (int) (dynamicSegTreeUpd.getMax(left, right) + position[1]);
            highest = Math.max(highest, newHeight);
            dynamicSegTreeUpd.update(left, right, newHeight);
            resList.add(highest);
        }
        return resList;
    }

    // 动态开点线段树
    private static class DynamicSegTreeUpd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, max, lazy;
        }

        // 区间 [l,r] 置为 val
        public void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 求和
        public long getSum(int l, int r) {
            return this.getSum(l, r, 0, N, root);
        }

        // 区间 [l,r] 最大值
        public long getMax(int l, int r) {
            return this.getMax(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum = (t - s + 1L) * val;
                node.max = val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private long getSum(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.sum;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, node.rs);
            }
            return sum;
        }

        private long getMax(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.max;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long max = 0;
            if (l <= mid) {
                max = getMax(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
            }
            return max;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.sum = node.lazy * (mid - s + 1L);
                node.rs.sum = node.lazy * (t - mid);
                node.ls.max = node.lazy;
                node.rs.max = node.lazy;
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }

    public List<Integer> fallingSquares2(int[][] positions) {
        // 离散化
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] position : positions) {
            treeSet.add(position[0]);
            treeSet.add(position[0] + position[1]);
        }
        int idx = 1;
        Map<Integer, Integer> idxMap = new HashMap<>();
        while (!treeSet.isEmpty()) {
            idxMap.put(treeSet.pollFirst(), idx++);
        }

        // 坐标点数
        int N = idxMap.size();

        // 目前所有已经落稳的 方块堆叠的最高高度 。
        int highest = 0;
        List<Integer> resList = new ArrayList<>();
        // 线段树
        SegmentTree segmentTree = new SegmentTree(N);
        for (int[] position : positions) {
            int left = idxMap.get(position[0]);
            // 左闭右开
            int right = idxMap.get(position[0] + position[1]) - 1;
            int height = segmentTree.getMax(left, right, 1, N, 1);

            int newHeight = height + position[1];
            highest = Math.max(highest, newHeight);
            segmentTree.update(left, right, newHeight, 1, N, 1);
            resList.add(highest);
        }
        return resList;
    }

    private static class SegmentTree {
        private final int[] max;
        private final int[] lazy;

        public SegmentTree(int n) {
            this.max = new int[4 * n];
            this.lazy = new int[4 * n];
        }

        // 区间修改，将 [l,r] 置为 val
        // 函数入口: update(l, r, val, 1, n, 1)
        public void update(int l, int r, int val, int s, int t, int p) {
            if (l <= s && t <= r) {
                max[p] = val;
                lazy[p] = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(p);
            if (l <= mid) {
                update(l, r, val, s, mid, p * 2);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, p * 2 + 1);
            }
            pushUp(p);
        }


        // 区间查询，求 [l,r] 范围最大值
        // 函数入口: getMax(l, r, 1, n, 1)
        public int getMax(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return max[p];
            }
            int mid = s + (t - s) / 2;
            pushDown(p);
            int max = 0;
            if (l <= mid) {
                max = Math.max(max, getMax(l, r, s, mid, p * 2));
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, p * 2 + 1));
            }
            return max;
        }

        private void pushDown(int p) {
            if (lazy[p] > 0) {
                max[p * 2] = lazy[p];
                max[p * 2 + 1] = lazy[p];
                lazy[p * 2] = lazy[p];
                lazy[p * 2 + 1] = lazy[p];
                lazy[p] = 0;
            }
        }

        private void pushUp(int p) {
            max[p] = Math.max(max[p * 2], max[p * 2 + 1]);
        }
    }
}
/*
699. 掉落的方块
https://leetcode.cn/problems/falling-squares/

在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
注意:
1 <= positions.length <= 1000.
1 <= positions[i][0] <= 10^8.
1 <= positions[i][1] <= 10^6.

离散化线段树，区间修改 + 区间查询最值。
需要实现带 懒惰标记 的线段树，从而确保在 区间修改 时复杂度仍为 O(log n)
相似题目: 218. 天际线问题
https://leetcode.cn/problems/the-skyline-problem/
 */