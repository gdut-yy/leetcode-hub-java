import java.util.Arrays;

public class SfTech220619T4 {
    public boolean isPointInPolygon(double x, double y, double[] coords) {
        int n = coords.length / 2;

        double[] vx = new double[n];
        double[] vy = new double[n];
        for (int i = 0; i < n; i++) {
            vx[i] = coords[i * 2];
            vy[i] = coords[i * 2 + 1];
        }

        // pnpoly
        double maxX = Arrays.stream(vx).max().getAsDouble();
        double minX = Arrays.stream(vx).min().getAsDouble();
        double maxY = Arrays.stream(vy).max().getAsDouble();
        double minY = Arrays.stream(vy).min().getAsDouble();
        if (x < minX || x > maxX || y < minY || y > maxY) {
            return false;
        }

        boolean res = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            if ((vy[i] > y) != (vy[j] > y)
                    && (x < (vx[j] - vx[i]) * (y - vy[i]) / (vy[j] - vy[i]) + vx[i])) {
                res = !res;
            }
        }
        return res;
    }
}
/*
顺丰04. 顺丰中转场车辆入场识别-电子围栏
https://leetcode.cn/contest/sf-tech/problems/uWWzsv/

【背景】
物流站点的王经理需要对进出站点的物流车辆进行管理，王经理需要通过车载定位知道某物流车辆是否在某个划定的区域内，如果物流车辆超出指定的区域，系统会自动发送提醒信息给王经理，王经理可以通过提醒信息来监管具体情况。
【问题】
几何计算简化如下：
点（x，y） 为车辆所在坐标点，coords[x1,y1,x2,y2,x3,y3,x4,x4,....,x1,y1]为连续封闭区域坐标点。
现给定连续封闭坐标点的一维数组coords[n]和车辆坐标(x,y)，
返回车辆是否在封闭区域coords内（点在多边形边界线上算在区域内）。
【示例】
image.png
输入：
x = 1, y = 3,
coords = [0,0,0,4,4,4,2,2,4,0,0,0]
输出：true
提示
0 < coords.length < 1000
0 < coords[i] < 10000.0
0 < x < 10000.0
0 < y < 10000.0
点在多边形边界线上算在区域内
输入：
6
3
[1,2,3,4,5,3,6,1,3,1,1,2]
输出：
true
预期：
false

pnpoly 法
光线投射算法 (Ray casting algorithm) 奇偶规则 (Even-odd rule) https://oi-wiki.org/geometry/2d/#ray-casting-algorithm
 */