package p1826;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1826F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();

            System.out.println("? 0 1 0");
            double[] x0s = new double[n];
            for (int i = 0; i < n; i++) {
                x0s[i] = scanner.nextDouble();
                scanner.nextDouble();
            }

            System.out.println("? 1 0 0");
            double[] y0s = new double[n];
            for (int i = 0; i < n; i++) {
                scanner.nextDouble();
                y0s[i] = scanner.nextDouble();
            }

            System.out.println("? 0.25 -50.25 0");
            double[] xs = new double[n];
            for (int i = 0; i < n; i++) {
                xs[i] = scanner.nextDouble();
                scanner.nextDouble();
            }
            Arrays.sort(xs);

            StringBuilder stringBuilder = new StringBuilder("!");
            for (double x0 : x0s) {
                for (double y0 : y0s) {
                    double x = (201 * x0 + y0) * 201 / (201 * 201 + 1);
                    int i = searchDoubles(xs, x);
                    if (i > 0 && x - xs[i - 1] < 5e-4 || i < n && xs[i] - x < 5e-4) {
                        stringBuilder.append(String.format(" %.5f %.5f", x0, y0));
                    }
                }
            }
            System.out.println(stringBuilder);
        }
    }

    // Params:
    // a – the array to be searched
    // key – the value to be searched for
    private static int searchDoubles(double[] nums, double key) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (nums[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
F. Fading into Fog
https://codeforces.com/contest/1826/problem/F

题目大意：
这是一个互动的问题。
在二维欧几里得平面上有 n 个具有实坐标的不同隐点。在一个查询中，你可以让某条直线 ax+by+c=0 得到这条直线上所有 n 个点的投影。给出的预测是不准确的，请阅读交互部分更清楚。
使用最少的查询次数，猜测所有 n 个点并以某种顺序输出它们。这里的最小性是指解决任何可能的测试用例所需的最小查询数。
隐藏点是预先固定的，在整个交互过程中不会改变。换句话说，交互器不是自适应的。
点 A 到直线 ax+by+c=0 的投影是直线上离 A 最近的点。

交互题
计算几何
点在直线的投影坐标 n维向量投影坐标 几何投影坐标
https://blog.csdn.net/guyuealian/article/details/53954005
y = kx + b
y-y0 = -(x-x0)/k
得
x1 = k(y0-b+x0) / (k^2+1)
y1 = kx1 + b
======

input
1
2

1 1 2.5 1

1.500000001 1.500000000 2 2

output

? 0 1 -1

? 0.2 -0.2 0

! 1 3 2.5 0.500000001
 */
