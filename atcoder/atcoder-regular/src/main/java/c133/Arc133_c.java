package c133;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc133_c {
    static int n, m, k;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sa = 0, sb = 0;
        for (int v : a) sa += ((k - 1L) * m - v) % k;
        for (int v : b) sb += ((k - 1L) * n - v) % k;

        long ans = (sa % k != sb % k) ? -1 : (long) n * m * (k - 1) - Math.max(sa, sb);
        return String.valueOf(ans);
    }
}
/*
C - Row Column Sums
https://atcoder.jp/contests/arc133/tasks/arc133_c

灵茶の试炼 2022-11-24
题目大意：
输入 n m k (≤2e5) 和长度分别为 n 和 m 的数组 a 和 b，元素范围 [0,k-1]。
构造一个 n 行 m 列，元素范围在 [0,k-1] 的矩阵，使得第 i 行的元素和 % k = a[i]，第 j 列的元素和 % k = b[j]。
你只需要输出这个矩阵的元素和的最大值。
如果这个矩阵不存在，输出 -1。

https://atcoder.jp/contests/arc133/submissions/36747125
不妨把矩阵的每个数都置为 k-1，然后慢慢减小。
对于第 i 行来说，这一行的元素总共需要减小 ((k-1)*m-a[i])%k，累加所有行的减小量，得到 sa。
对于第 j 列来说，这一列的元素总共需要减小 ((k-1)*n-b[j])%k，累加所有列的减小量，得到 sb。
如果 sa%k != sb%k，则无解。
否则 sa-sb 是 k 的倍数，不妨设 sa > sb，那么可以把第一列的减小量 += sa-sb，使得行列减小量之和相同。
然后就可以不断选择行列的减小量均为正数的，把这个元素减一。
这样最后会操作 max(sa,sb) 次。
所以答案是 n*m*(k-1) - max(sa,sb)。
======

Input 1
2 4 3
0 2
1 2 2 0
Output 1
11

Input 2
3 3 4
0 1 2
1 2 3
Output 2
-1
 */