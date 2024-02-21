package p500;

import java.util.Scanner;

public class CF500C {
    static int n, m;
    static int[] w, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] last = new int[n + 1];
        int[] vis = new int[n + 1];
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = last[b[i]] + 1; j < i; j++) {
                int v = b[j];

                if (vis[v] != i) {
                    vis[v] = i;
                    ans += w[v];
                }
            }
            last[b[i]] = i;
        }
        return String.valueOf(ans);
    }
}
/*
C. New Year Book Reading
https://codeforces.com/contest/500/problem/C

灵茶の试炼 2024-01-31
题目大意：
输入 n(2≤n≤500)，m(1≤m≤1000)，长为 n 的数组 w(1≤a[i]≤100)，长为 m 的数组 b(1≤b[i]≤n)。
0x3F 有 n 本书，第 i 本书的重量为 w[i]。
这 n 本书按照某种顺序，从上到下摆成一摞。
有 m 天。在第 i 天，0x3F 会阅读第 b[i] 本书。
阅读之前，0x3F 需要把在 b[i] 上面的书抬起来，拿出 b[i]，然后放下抬起来的书。这个过程会消耗一些体力，消耗值等于 b[i] 上面所有书的重量之和（不含 b[i]）。
阅读之后，0x3F 会把 b[i] 放在这摞书的最上面。
0x3F 可以决定这 n 本书的初始摆放顺序。
输出 0x3F 体力消耗之和的最小值。

rating 1600
脑筋急转弯。在 b 中越靠前的书越在上面。
遍历 b 数组，对于 b[i]，设其上一次出现的下标为 last[b[i]]（默认为 0），那么从 last[b[i]] + 1 到 i-1 之间的书必然都在 b[i] 上面，把这些书的重量加入答案即可（注意一本书多次出现，只能算一次重量）。
https://codeforces.com/contest/500/submission/241226666
======

input
3 5
1 2 3
1 3 2 3 1
output
12
 */