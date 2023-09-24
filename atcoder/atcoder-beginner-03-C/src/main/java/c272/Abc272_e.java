package c272;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc272_e {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> b = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            int l = 1;
            if (v < 0) {
                l = (-v + i - 1) / i;
            }
            int r = Math.min(m, (n - 1 - v) / i);
            for (int j = l; j <= r; j++) {
                b.computeIfAbsent(j, key -> new ArrayList<>()).add(v + j * i);
            }
        }

        int[] ans = new int[m];
        int[] time = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (Integer v : b.getOrDefault(i, new ArrayList<>())) {
                time[v] = i;
            }
            int mex = 0;
            while (time[mex] == i) {
                mex++;
            }
            ans[i - 1] = mex;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
E - Add and Mex
https://atcoder.jp/contests/abc272/tasks/abc272_e

灵茶の试炼 2022-12-19
题目大意：
输入 n(≤2e5) m(≤2e5) 和长为 n 的整数数组 a (-1e9≤a[i]≤1e9)，下标从 1 开始。
执行如下操作 m 次：
对 1~n 的每个 i，把 a[i] += i。
每次操作后，输出 mex(a)，即不在 a 中的最小非负整数。

https://atcoder.jp/contests/abc272/submissions/37376965
提示 1：由于 a 中只有 n 个数，因此在 [0,n-1] 范围之外的 a[i] 是没有意义的。
提示 2：对于每个 i，有多少次操作，使得操作后 a[i] 仍然在 [0,n-1] 范围内？
提示 3：根据调和级数，总共有 O(nlogn) 次这样的操作。
提示 4：对每个 a[i]，把满足提示 2 的操作次数以及操作后的结果存下来，按照操作次数分组归类。
提示 5：每个操作次数所对应的结果记录到一个哈希表中，暴力枚举计算 mex（提示 3）。
代码实现时可以用时间戳来优化。
======

Input 1
3 3
-1 -1 -6
Output 1
2
2
0

Input 2
5 6
-2 -2 -5 -7 -15
Output 2
1
3
2
0
0
0
 */