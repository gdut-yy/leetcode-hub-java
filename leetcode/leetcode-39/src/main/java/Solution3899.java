import java.util.Arrays;

public class Solution3899 {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        int a = sides[0], b = sides[1], c = sides[2];
        if (a + b <= c) { // 由于 a+c>b 和 b+c>a 一定成立，所以只需判断 a+b>c 是否成立
            return new double[0];
        }
        // 余弦定理
        final double rad = 180 / Math.PI;
        double A = Math.acos((double) (b * b + c * c - a * a) / (double) (b * c * 2)) * rad;
        double B = Math.acos((double) (a * a + c * c - b * b) / (double) (a * c * 2)) * rad;
        return new double[]{A, B, 180 - A - B}; // 小边对小角
    }
}
/*
3899. 三角形的内角度数
https://leetcode.cn/problems/angles-of-a-triangle/description/

第 497 场周赛 T2。

给你一个长度为 3 的正整数数组 sides。
判断是否能够由 sides 中的三个元素作为边长，构成一个 面积为正 的三角形。
如果可以构成这样的三角形，返回一个包含 3 个浮点数的数组，表示该三角形的三个 内角（单位为 度），并按 非递减顺序 排序。否则，返回一个空数组。
与真实答案的误差在 10^-5 以内的结果都将被视为正确。
提示：
sides.length == 3
1 <= sides[i] <= 1000

余弦定理。
时间复杂度 O(1)。
 */