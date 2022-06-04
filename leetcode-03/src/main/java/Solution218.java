import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, Comparator.comparingInt(o -> o[2]));

        // 离散化（左闭右开）
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] building : buildings) {
            treeSet.add(building[0]);
            treeSet.add(building[1]);
        }
        int idx = 1;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> idxMap = new HashMap<>();
        while (!treeSet.isEmpty()) {
            int originIdx = treeSet.pollFirst();
            idxMap.put(originIdx, idx++);
            list.add(originIdx);
        }

        // 坐标点数
        int N = idxMap.size();

        // 线段树
        SegmentTree segmentTree = new SegmentTree(N);
        for (int[] building : buildings) {
            int left = idxMap.get(building[0]);
            // 左闭右开
            int right = idxMap.get(building[1]) - 1;
            segmentTree.update(left, right, building[2], 1, N, 1);
        }

        // 查询左端点最值
        List<List<Integer>> resList = new ArrayList<>();
        int pre = 0;
        for (int i = 1; i <= N; i++) {
            int height = segmentTree.getMax(i, i, 1, N, 1);
            if (height != pre) {
                resList.add(List.of(list.get(i - 1), height));
                pre = height;
            }
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
            // pushDown
            pushDown(p);

            int mid = s + (t - s) / 2;
            if (l <= mid) {
                update(l, r, val, s, mid, p * 2);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, p * 2 + 1);
            }
            // pushUp
            pushUp(p);
        }


        // 区间查询，求 [l,r] 范围最大值
        // 函数入口: getMax(l, r, 1, n, 1)
        public int getMax(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return max[p];
            }
            // pushDown
            pushDown(p);

            int mid = s + (t - s) / 2;
            int maxn = 0;
            if (l <= mid) {
                maxn = Math.max(maxn, getMax(l, r, s, mid, p * 2));
            }
            if (r > mid) {
                maxn = Math.max(maxn, getMax(l, r, mid + 1, t, p * 2 + 1));
            }
            return maxn;
        }

        private void pushDown(int p) {
            if (lazy[p] > 0) {
                max[p * 2] = lazy[p];
                max[p * 2 + 1] = lazy[p];
                lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
                lazy[p] = 0;
            }
        }

        private void pushUp(int p) {
            max[p] = Math.max(max[p * 2], max[p * 2 + 1]);
        }
    }
}
/*
218. 天际线问题
https://leetcode-cn.com/problems/the-skyline-problem/

城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
- lefti 是第 i 座建筑物左边缘的 x 坐标。
- righti 是第 i 座建筑物右边缘的 x 坐标。
- heighti 是第 i 座建筑物的高度。
你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。
天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

离散化线段树。
时间复杂度 O(nlogn)
相似题目: 699. 掉落的方块
https://leetcode.cn/problems/falling-squares/
 */