package c291;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc291_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] x = new int[n * 5];
        for (int i = 0; i < n * 5; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve(n, x));
    }

    private static String solve(int n, int[] x) {
        Arrays.sort(x);
        long sum = 0L;
        for (int i = n; i < n * 4; i++) {
            sum += x[i];
        }
        double res = sum / 3.0 / n;
        return String.valueOf(res);
    }
}
/*
B - Trimmed Mean
https://atcoder.jp/contests/abc291/tasks/abc291_b

题目大意：
高桥正在参加体操比赛。在比赛中，5N 名评委每人对高桥的表现进行评分，他的得分确定如下:
- 将 N 名评分最高的裁判的评分作废。
- 将 N 名评分最低的裁判的评分作废。
- 高桥的分数被定义为其余 3N 名评委分数的平均值。
更正式地说，Takahashi 的分数是通过对评委分数 S(|S|=5N)的多集执行以下步骤得到的:
- 重复以下操作 N 次:选择最大的元素(如果有多个这样的元素，选择其中一个)，从 S 中移除。
- 重复以下操作 N 次:选择最小的元素(如果有多个这样的元素，从中选择一个)，从 S 中移除。
- Takahashi 的分数定义为 S 中剩余的 3N 个元素的平均值。
第 i(1≤i≤5N)位评委对高桥的表现评分为 Xi 分。找到高桥的分数。

模拟。
======

Input 1
1
10 100 20 50 30
Output 1
33.333333333333336

Input 2
2
3 3 3 4 5 6 7 8 99 100
Output 2
5.500000000000000
 */