import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution850 {
    private static final int MOD = (int) (1e9 + 7);

    public int rectangleArea(int[][] rectangles) {
        int m = 0;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
//        for (int[] sq : squares) {
//            mp.put(sq[0], 1);
//            mp.put(sq[0] + sq[2], 1);
//        }
        for (int[] re : rectangles) {
            mp.put(re[0], 1);
            mp.put(re[2], 1);
        }
        for (Map.Entry<Integer, Integer> p : mp.entrySet()) p.setValue(m++);
        int[] A = new int[m];
        for (Map.Entry<Integer, Integer> p : mp.entrySet()) A[p.getValue()] = p.getKey();
        // 离散化结束

        // 把正方形的上下边界取出来
        List<int[]> vec = new ArrayList<>();
//        for (int[] sq : squares) {
//            vec.add(new int[]{sq[1], mp.get(sq[0]) + 1, mp.get(sq[0] + sq[2]), 1});
//            vec.add(new int[]{sq[1] + sq[2], mp.get(sq[0]) + 1, mp.get(sq[0] + sq[2]), -1});
//        }
        for (int[] re : rectangles) {
            vec.add(new int[]{re[1], mp.get(re[0]) + 1, mp.get(re[2]), 1});
            vec.add(new int[]{re[3], mp.get(re[0]) + 1, mp.get(re[2]), -1});
        }
        vec.sort(Arrays::compare);

        // 求总的面积并
        long tot = 0;
        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(m);
        seg.build(A, 1, 1, m - 1);
        for (int i = 0; i + 1 < vec.size(); i++) {
            // 考虑水平线 y = vec[i][0] 和 y = vec[i + 1][0] 之间的情况
            seg.modify(1, 1, m - 1, vec.get(i)[1], vec.get(i)[2], vec.get(i)[3]);
            // 求横截长度
            int len = A[m - 1] - A[0];
            // 如果最小覆盖数是 0，那么扣掉相应的长度
            if (seg.info[1].mn == 0) len -= seg.info[1].len;
            // 面积 = 横截长度 * 高度差
            tot += (long) len * (vec.get(i + 1)[0] - vec.get(i)[0]);
        }
        return (int) (tot % MOD);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            // mn：当前节点的最小覆盖数
            // len：满足覆盖数 = 最小覆盖数的 A[i] 之和
            // lazy：加法的懒标记
            int mn, len, lazy;

            public Info(int mn, int len, int lazy) {
                this.mn = mn;
                this.len = len;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int mn = Math.min(a.mn, b.mn);
            return new Info(mn, (a.mn == mn ? a.len : 0) + (b.mn == mn ? b.len : 0), 0);
        }

        // 对节点的覆盖数整个增加 qv，只影响 mn，不影响 len
        void _do(int p, int qv) {
            info[p].mn += qv;
            info[p].lazy += qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.fill(info, new Info(0, 0, 0));
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(0, A[r] - A[r - 1], 0);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void spread(int p) {
            if (info[p].lazy == 0) return;
            _do(p << 1, info[p].lazy);
            _do(p << 1 | 1, info[p].lazy);
            info[p].lazy = 0;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, qv);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }
    }
}
/*
850. 矩形面积 II
https://leetcode.cn/problems/rectangle-area-ii/description/

给你一个轴对齐的二维数组 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中 (xi1, yi1) 是该矩形 左下角 的坐标， (xi2, yi2) 是该矩形 右上角 的坐标。
计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。
返回 总面积 。因为答案可能太大，返回 10^9 + 7 的 模 。
提示：
1 <= rectangles.length <= 200
rectanges[i].length = 4
0 <= xi1, yi1, xi2, yi2 <= 10^9
xi1 <= xi2
yi1 <= yi2
所有矩阵面积不为 0。

矩形面积并。
Lazy 线段树 + 扫描线。
相似题目: 3454. 分割正方形 II
https://leetcode.cn/problems/separate-squares-ii/description/
 */