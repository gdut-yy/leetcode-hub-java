package p23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF23C {
    static int n;
    static int[][] a; // x, y, i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            n = n * 2 - 1;
            a = new int[n][3];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
                a[i][2] = i + 1;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long s = 0;
        for (int[] p : a) {
            s += p[1];
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        long se = 0;
        for (int i = 0; i < n; i += 2) {
            se += a[i][1];
        }

        List<Integer> ans = new ArrayList<>();
        if (se * 2 >= s) { // 方案一
            for (int i = 0; i < n; i += 2) {
                ans.add(a[i][2]);
            }
        } else { // 方案二
            for (int i = 1; i < n; i += 2) {
                ans.add(a[i][2]);
            }
            ans.add(a[n - 1][2]);
        }
        return "YES" + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Oranges and Apples
https://codeforces.com/contest/23/problem/C

灵茶の试炼 2024-02-09
题目大意：
输入 T 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 表示有 2n-1 个盒子。然后输入 2n-1 行，每行 2 个数字 a[i] 和 o[i]，表示第 i 个盒子中的苹果个数和橘子个数，元素范围 [0,1e9]。
你需要从这 2n-1 个盒子中，选出 n 个盒子。
能否使这 n 个盒子中的苹果个数之和 >= sum(a)/2，且橘子个数之和 >= sum(o)/2？
如果不能，输出 NO，否则输出 YES 和你选的这 n 个盒子的编号（按照输入的顺序，编号从 1 开始）。

rating 2500
https://www.luogu.com.cn/blog/endlesscheng/solution-cf23c
======

input
2
2
10 15
5 7
20 18
1
0 0
output
YES
1 3
YES
1
 */
