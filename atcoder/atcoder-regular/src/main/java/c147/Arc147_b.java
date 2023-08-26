package c147;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc147_b {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static List<int[]> ans;

    private static String solve() {
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - 2; j++) {
                if (p[j] % 2 == j % 2 && p[j + 2] % 2 != j % 2) {
                    f(1, j);
                }
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            if (p[i] % 2 != i % 2 && p[i + 1] % 2 == i % 2) {
                f(0, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - 2; j++) {
                if (p[j] > p[j + 2]) {
                    f(1, j);
                }
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(o -> (char) ('A' + o[0]) + " " + o[1])
                .collect(Collectors.joining(System.lineSeparator()));
    }

    static void f(int op, int i) {
        ans.add(new int[]{op, i});
        // p[i], p[i+1+op] = p[i+1+op], p[i]
        int tmp = p[i];
        p[i] = p[i + 1 + op];
        p[i + 1 + op] = tmp;
    }
}
/*
B - Swap to Sort
https://atcoder.jp/contests/arc147/tasks/arc147_b

灵茶の试炼 2022-12-12
题目大意：
输入 n(≤400) 和一个 1~n 的排列 p，下标从 1 开始。
你有两种操作：
操作 "A i" 可以交换 p[i] 和 p[i+1]；
操作 "B i" 可以交换 p[i] 和 p[i+2]。
你需要让 p 变为递增的。
最小化操作 A 的次数，同时总操作次数不能超过 1e5。
输出总操作次数，以及具体的操作内容，详见样例。
如果有多个符合要求的方案，输出任意一种。
保证存在这样的操作方案。

https://atcoder.jp/contests/arc147/submissions/37226588
提示 1：操作 B 对于奇数下标和偶数下标是独立的。
提示 2：找到 p[i] 和 i 奇偶性不同的数字，这些数字只能用操作 A 处理。
提示 3：用操作 B 可以将提示 2 的数字聚合在一起，然后就可以使用操作 A 了。最后再用操作 B 排序。
======

Input 1
4
3 2 4 1
Output 1
4
A 3
B 1
B 2
B 2

Input 2
3
1 2 3
Output 2
0

Input 3
6
2 1 4 3 6 5
Output 3
3
A 1
A 3
A 5
 */