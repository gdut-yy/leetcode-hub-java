package p723;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF723C {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int avg = n / m;
        int[] cnt = new int[m + 1];
        List<Integer> ex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > m) {
                ex.add(i);
            } else if (++cnt[a[i]] > avg) {
                ex.add(i);
            }
        }

        int i = 0;
        for (int v = 1; v <= m; v++) {
            for (int c = avg - cnt[v]; c > 0; c--) {
                a[ex.get(i)] = v;
                i++;
            }
        }
        return avg + " " + i + System.lineSeparator()
                + Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Polycarp at the Radio
https://codeforces.com/contest/723/problem/C

灵茶の试炼 2022-06-06
题目大意：
给你一个数组 a，长度不超过 2000，元素值在 [1,1e9]。另外还给你一个数 m (1<=m<=n)。
每次修改操作你可以将某个 a[i] 修改为任意数字。
定义 count(v) 表示 v 在 a 中的出现次数。
请你修改 a，最大化 min(count(v)), v in [1,m]，即最大化 count(1), count(2), ..., count(m) 的最小值。
按顺序输出：最大化的结果、最小修改次数、修改之后的 a。

rating 1600
https://codeforces.com/problemset/submission/723/159598106
最小次数的最大值为 n/m。
需要修改某些数字，使得 [1,m] 中每个数字均出现至少 n/m 次。
我们可以找出大于 m 的和出现次数超过 n/m 的数字，将其修改为出现次数小于 n/m 的那些数字。
======

input
4 2
1 2 3 2
output
2 1
1 2 1 2

input
7 3
1 3 2 2 2 2 1
output
2 1
1 3 3 2 2 2 1

input
4 4
1000000000 100 7 1000000000
output
1 4
1 2 3 4
 */
