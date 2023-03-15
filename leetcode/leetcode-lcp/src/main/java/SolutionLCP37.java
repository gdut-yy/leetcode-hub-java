import java.util.ArrayList;
import java.util.List;

public class SolutionLCP37 {
    private static final int GET_MIN = 0;
    private static final int GET_MAX = 1;
    private static final double eps = 1e-8;

    // https://leetcode.cn/problems/zui-xiao-ju-xing-mian-ji/solution/lcp-37-zui-xiao-ju-xing-mian-ji-by-zerot-u52c/
    public double minRecSize(int[][] lines) {
        int n = lines.length;

//        vector<pair<double, double>> l;
        List<double[]> list = new ArrayList<>();
//        for (const auto & line:lines){
//            l.emplace_back(line[0], line[1]);
//        }
        for (int[] line : lines) {
            list.add(new double[]{line[0], line[1]});
        }
//        sort(l.begin(), l.end(),[](const auto & u, const auto & v){
//            return u.first < v.first || (u.first == v.first && u.second > v.second);
//        });
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Double.compare(o2[1], o1[1]);
            }
            return Double.compare(o1[0], o2[0]);
        });

        double xmin = -get(list, GET_MAX);
//        sort(l.begin(), l.end(),[](const auto & u, const auto & v){
//            return u.first > v.first || (u.first == v.first && u.second > v.second);
//        });
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Double.compare(o2[1], o1[1]);
            }
            return Double.compare(o2[0], o1[0]);
        });
        double xmax = -get(list, GET_MIN);
//        for (auto & [k, b]:l){
//            b = -b / k;
//            k = 1. / k;
//        }
        for (double[] doubles : list) {
            doubles[1] = -doubles[1] / doubles[0];
            doubles[0] = 1.0 / doubles[0];
        }
//        sort(l.begin(), l.end(),[](const auto & u, const auto & v){
//            return u.first < v.first || (u.first == v.first && u.second > v.second);
//        });
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Double.compare(o2[1], o1[1]);
            }
            return Double.compare(o1[0], o2[0]);
        });
        double ymin = -get(list, GET_MAX);
//        sort(l.begin(), l.end(),[](const auto & u, const auto & v){
//            return u.first > v.first || (u.first == v.first && u.second > v.second);
//        });
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Double.compare(o2[1], o1[1]);
            }
            return Double.compare(o2[0], o1[0]);
        });
        double ymax = -get(list, GET_MIN);
        return (xmax - xmin) * (ymax - ymin);
    }

    private double get(List<double[]> list, int op) {
        int n = list.size();
        double best = 0;
        boolean valid = false;
        for (int i = 1; i < n; i++) {
            if (Math.abs(list.get(i)[0] - list.get(i - 1)[0]) < eps) {
                continue;
            }
            double slope = (list.get(i)[1] - list.get(i - 1)[1]) / (list.get(i)[0] - list.get(i - 1)[0]);
            if (!valid) {
                valid = true;
                best = slope;
            } else {
                if (op == GET_MIN) {
                    best = Math.min(best, slope);
                } else {
                    best = Math.max(best, slope);
                }
            }
        }
        return valid ? best : 0.;
    }
}
/*
LCP 37. 最小矩形面积
https://leetcode.cn/problems/zui-xiao-ju-xing-mian-ji/

二维平面上有 NN 条直线，形式为 y = kx + b，其中 k、b为整数 且 k > 0。所有直线以 [k,b] 的形式存于二维数组 lines 中，不存在重合的两条直线。
两两直线之间可能存在一个交点，最多会有 C(n,2)  个交点。我们用一个平行于坐标轴的矩形覆盖所有的交点，请问这个矩形最小面积是多少。
若直线之间无交点、仅有一个交点或所有交点均在同一条平行坐标轴的直线上，则返回0。
注意：返回结果是浮点数，与标准答案 绝对误差或相对误差 在 10^-4 以内的结果都被视为正确结果
限制：
1 <= lines.length <= 10^5 且 lines[i].length == 2
1 <= lines[0] <= 10000
-10000 <= lines[1] <= 10000
与标准答案绝对误差或相对误差在 10^-4 以内的结果都被视为正确结果
 */