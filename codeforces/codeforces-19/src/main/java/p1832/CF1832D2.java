package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1832D2 {
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

    // https://codeforces.com/contest/1832/submission/205657665
    private static String solve(int n, int q, int[] a, int[] k) {
        Arrays.sort(a);
        int[] res = new int[q];

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        // 通项 a[i] + k - i
        // 预处理 a[i]-i 前缀最小值
        int[] pre = new int[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], a[i] - i);
        }

        for (int i = 0; i < q; i++) {
            int ki = k[i];
            if (ki < n) {
                res[i] = Math.min(pre[ki - 1] + ki, a[ki]);
            } else {
                if (n == 1) {
                    int ans = a[0] - ki / 2;
                    if (ki % 2 == 1) {
                        ans += ki;
                    }
                    res[i] = ans;
                } else {
                    // -1 -2 -3...
                    long s = sum - (n - 1L) * (n - 2) / 2;
                    s += ki * (n - 1L);

                    int ans = pre[n - 2] + ki;
                    ki -= n - 1;
                    if (ki % 2 == 1) {
                        s += ki;
                        ans = Math.min(ans, a[n - 1] + ki);
                        ki--;
                    } else {
                        ans = Math.min(ans, a[n - 1]);
                    }
                    s -= (long) ans * n;
                    ki /= 2;
                    if (ki > s) {
                        ans -= (ki - s - 1) / n + 1;
                    }
                    res[i] = ans;
                }
            }
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D2. Red-Blue Operations (Hard Version)
https://codeforces.com/contest/1832/problem/D2

题目大意：
简单版本和困难版本之间的唯一区别是 n 和 q 的最大值。1≤n,q≤2e5
给定一个由 n 个整数组成的数组。最初，所有元素都是红色的。
可以对该 array 多次应用以下操作。在第 i 次操作中，选择数组的一个元素;然后:
如果元素是红色的，它增加 i 变成蓝色;
如果元素是蓝色的，它减少 i 变成红色。
操作从 1 开始编号，即。在第一次操作中，一些元素被改变了 1，以此类推。
你会被问到下列问题:
给定一个整数 k，如果对它进行 k 次运算，数组中最大的最小值是多少?
注意，这些操作不会影响查询之间的数组，所有查询都是在初始数组 a 上进行的。

预处理优化。
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
