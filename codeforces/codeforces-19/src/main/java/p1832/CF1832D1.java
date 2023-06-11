package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1832D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] k = new int[q];
        for (int i = 0; i < q; i++) {
            k[i] = scanner.nextInt();
        }
        System.out.println(solve(n, q, a, k));
    }

    private static String solve(int n, int q, int[] a, int[] k) {
        Arrays.sort(a);
        int[] backup = a;
        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            a = backup.clone();
            int ki = k[i];
            for (int j = 0; j < n; j++) {
                if (ki == 0) {
                    break;
                }
                // 最后一个 如果 ki 为偶数，提前退出
                if (ki % 2 == 0 && j == n - 1) {
                    break;
                }
                a[j] += ki;
                ki--;
            }
            // 余下 ki/2 个 -1
            ki /= 2;
            Arrays.sort(a);
            long diff = 0;
            for (int j = 0; j < n; j++) {
                diff += a[j] - a[0];
            }
            int ans = a[0];
            if (ki > diff) {
                ki -= diff;
                // 数论向上取整法
                ans -= (ki + n - 1) / n;
            }
            res[i] = ans;
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D1. Red-Blue Operations (Easy Version)
https://codeforces.com/contest/1832/problem/D1

题目大意：
简单版本和困难版本之间的唯一区别是 n 和 q 的最大值。1≤n,q≤1000
给定一个由 n 个整数组成的数组。最初，所有元素都是红色的。
可以对该 array 多次应用以下操作。在第 i 次操作中，选择数组的一个元素;然后:
如果元素是红色的，它增加 i 变成蓝色;
如果元素是蓝色的，它减少 i 变成红色。
操作从 1 开始编号，即。在第一次操作中，一些元素被改变了 1，以此类推。
你会被问到下列问题:
给定一个整数 k，如果对它进行 k 次运算，数组中最大的最小值是多少?
注意，这些操作不会影响查询之间的数组，所有查询都是在初始数组 a 上进行的。

k=1
+1
k=2
+2 +1
k=3
+3 +2 +1
k=4
+4 +3 +2 +1

k=5
+5 +4 +3 (-2/+1)
k=6
+6 +5 +4 +3(-2/+1)
k=7
+7 +6 +5 (-4/+3 -2/+1)

手玩，[0, n-2] 个数分别为 +k, +k-1, +k-2, ...
n-1 个数跟奇偶性有关。
剩下的就是 k/2 个 -1 均摊。
======

input
4 10
5 2 8 4
1 2 3 4 5 6 7 8 9 10
output
3 4 5 6 7 8 8 10 8 12

input
5 10
5 2 8 4 4
1 2 3 4 5 6 7 8 9 10
output
3 4 5 6 7 8 9 8 11 8

input
2 5
2 3
10 6 8 1 3
output
10 7 8 3 3
 */
