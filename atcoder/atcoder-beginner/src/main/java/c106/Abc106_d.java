package c106;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc106_d {
    static int n, m, q;
    static int[][] lr, pq;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        pq = new int[q][2];
        for (int i = 0; i < q; i++) {
            pq[i][0] = scanner.nextInt();
            pq[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] f = new int[n][n];
        for (int[] p : lr) {
            int l = p[0] - 1, r = p[1] - 1;
            f[l][r]++;
        }
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                f[l][r] += f[l + 1][r] + f[l][r - 1] - f[l + 1][r - 1];
            }
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int p = pq[i][0] - 1, q = pq[i][1] - 1;
            ans[i] = f[p][q];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
D - AtCoder Express 2
https://atcoder.jp/contests/abc106/tasks/abc106_d

灵茶の试炼 2022-11-21
题目大意：
输入 n(≤500) m(≤2e5) q(≤1e5)。
然后输入 m 个在 [1,n] 内的闭区间，即每行输入两个数表示闭区间 [L,R]。
然后输入 q 个询问，每个询问也是输入两个数表示闭区间 [p,q]。
对每个询问，输出在 [p,q] 内的完整闭区间的个数。

https://atcoder.jp/contests/abc106/submissions/36691336
定义 f[l][r] 表示在 [l,r] 内的完整闭区间个数。
容斥一下可得
f[l][r] = f[l+1][r] + f[l][r-1] - f[l+1][r-1] + a[l][r]
这里 a[l][r] 是 m 个闭区间中的 [l,r] 的个数。
这样就可以 O(1) 地回答每个询问了。
======

Input 1
2 3 1
1 1
1 2
2 2
1 2
Output 1
3

Input 2
10 3 2
1 5
2 8
7 10
1 7
3 10
Output 2
1
1

Input 3
10 10 10
1 6
2 9
4 5
4 7
4 7
5 8
6 6
6 7
7 9
10 10
1 8
1 9
1 10
2 8
2 9
2 10
3 8
3 9
3 10
1 10
Output 3
7
9
10
6
8
9
6
7
8
10
 */