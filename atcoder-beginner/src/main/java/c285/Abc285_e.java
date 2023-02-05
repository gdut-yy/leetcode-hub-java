package c285;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc285_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] b = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = b[i - 1] + a[(i + 1) / 2];
        }
        // f[i][j] 表示有 i 个任务固定，到目前为止连续 j 个工作日 的 最大生产力
        long[][] f = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], Long.MIN_VALUE);
        }
        f[1][0] = 0L;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (f[i][j] < 0) {
                    continue;
                }
                f[i + 1][j + 1] = Math.max(f[i + 1][j + 1], f[i][j]);
                f[i + 1][0] = Math.max(f[i + 1][0], f[i][j] + b[j]);
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, f[n][i] + b[i]);
        }
        System.out.println(res);
    }
}
/*
E - Work or Rest
https://atcoder.jp/contests/abc285/tasks/abc285_e

在高桥生活的世界里，一周有N天。
AtCoder王国的国王高桥给一周中的每一天都指定了“工作日”或“假日”。所有周的作业都应该是一样的。每周至少有一天应被指定为假日。在这种情况下，每周第i天的生产力由长度为N的序列a定义如下:
如果每周第i天是“holiday”，其生产力为0;如果一周的第i天是“weekday”，则其生产率为A min(x,y)，
如果最后一个假期是前x天，下一个假期是后y天。
请注意，由于定期分配，上一个/下一个假期可能属于不同的一周。具体请参见样例。
当任务选择得最优时，找出每周最大的生产力。在这里，每周的生产率是指每周第1天、第2天、……和第n天的生产率之和。

动态规划
 */