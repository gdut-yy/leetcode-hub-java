package didi;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DD2019012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();

        List<String> res = solve(n);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static List<String> solve(int n) {
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int d = xy2d(n, new int[]{j, i}) + 1;
                list.add(String.valueOf(d));
            }
            resList.add(String.join(" ", list));
        }
        Collections.reverse(resList);
        return resList;
    }

    // convert (x,y) to d
    private static int xy2d(int n, int[] p) {
        int rx, ry, s, d = 0;
        for (s = n / 2; s > 0; s /= 2) {
            rx = (p[0] & s) > 0 ? 1 : 0;
            ry = (p[1] & s) > 0 ? 1 : 0;
            d += s * s * ((3 * rx) ^ ry);
            rot(n, p, rx, ry);
        }
        return d;
    }

    // convert d to (x,y)
    private static void d2xy(int n, int d, int[] p) {
        int rx, ry, s, t = d;
        p[0] = p[1] = 0;
        for (s = 1; s < n; s *= 2) {
            rx = 1 & (t / 2);
            ry = 1 & (t ^ rx);
            rot(s, p, rx, ry);
            p[0] += s * rx;
            p[1] += s * ry;
            t /= 4;
        }
    }

    // rotate/flip a quadrant appropriately
    private static void rot(int n, int[] p, int rx, int ry) {
        if (ry == 0) {
            if (rx == 1) {
                p[0] = n - 1 - p[0];
                p[1] = n - 1 - p[1];
            }
            // Swap x and y
            int tmp = p[0];
            p[0] = p[1];
            p[1] = tmp;
        }
    }
}
/*
DD-2019012. Hilbert 曲线
https://leetcode.cn/problems/Bec9GP/

在数学分析中，有这样一个问题:能否用一条无限长的线，穿过任意维度空间里面的所有点?答案是肯定的，而且不止有一种这样的曲线。
Hilbert 曲线就是其中的一种，它在边长 n=2，4，8 的图上的 索引效果如下所示
以边长为 2 的图像举例，左下角的方格编号为 1，左上角为 2，右上角为 3，右下角为 4，其余的图像也可以以此找到遍历网格的顺序。
下面我们希望给定任何边长为 2 的乘方的网格矩形，给出基于 Hilbert 曲线索引的网格顺序，全部以左下角为第一个被索引的元素，其索引值为 1，输出完整矩阵的索引值
格式：
输入：
- 一个数字 N 。
输出：
- 完整矩阵的索引值。
示例：
输入：4
输出：
6 7 10 11
5 8 9 12
4 3 14 13
1 2 15 16
提示：
N <= 256

https://en.wikipedia.org/wiki/Hilbert_curve
 */