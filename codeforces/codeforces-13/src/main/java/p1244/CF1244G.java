package p1244;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1244G {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
            q[i] = i + 1;
        }
        long d = k - (long) n * (n + 1) / 2;
        if (d < 0) {
            out.println(-1);
            return;
        }
        int l = 0, r = n - 1;
        while (l < r && d >= r - l) {
            d -= r - l;
            int tmp = q[l]; q[l] = q[r]; q[r] = tmp;
            l++;
            r--;
        }
        if (l < r && d > 0) {
            int tmp = q[l]; q[l] = q[(int)(l + d)]; q[(int)(l + d)] = tmp;
            d = 0;
        }
        out.println(k - d);
        StringBuilder sb = new StringBuilder();
        for (int v : p) sb.append(v).append(" ");
        out.println(sb.toString().trim());
        sb = new StringBuilder();
        for (int v : q) sb.append(v).append(" ");
        out.println(sb.toString().trim());
    }
}
/*
G. Running in Pairs
https://codeforces.com/contest/1244/problem/G

灵茶の试炼 2026-03-13
题目大意：
输入 n(1≤n≤1e6) 和 k(1≤k≤n*n)。
构造两个 1~n 的排列 p 和 q，设 S = sum(max(p[i],q[i]))，在 S ≤ k 的前提下，让 S 尽量大。
如果无解，输出 -1。
否则输出三行：
S
p
q

rating 2400
由于 max(p[i], q[i]) >= p[i]，所以 sum(max(p[i], q[i])) >= sum(p) = 1+2+...+n = n*(n+1)/2。
所以 k < n*(n+1)/2 时无解。
否则初始化 p[i] = q[i] = i，在此基础上调整。此时 sum(max(p[i], q[i])) = 1+2+...+n = n*(n+1)/2。
设 d = k - n*(n+1)/2，目标是让 d 尽量小且非负。
如果交换 q[L] 和 q[R] (L < R)：
交换前，这两个位置的贡献是 max(L,L) + max(R,R) = L + R。
交换后，这两个位置的贡献是 max(L,R) + max(R,L) = 2R。
d 减少了 2R - (L + R) = R - L。
由上式可知，为了让 d 尽量小，优先把下标小的与下标大的交换。
比如交换 3 次，那么参与交换的下标集合是 {1,2,3} 和 {n,n-1,n-2}，两个集合中的下标任意配对即可。为方便代码实现，规定让 i 和 n+1-i 配对。
如果某次交换会导致 d < 0，那么只需把 L 和 L+d 交换，即可让 d 恰好等于 0。
代码 https://codeforces.com/problemset/submission/1244/366052788
代码备份（上面打不开的同学看这个）
======

Input
5 20
Output
20
1 2 3 4 5
5 2 4 3 1

Input
3 9
Output
8
1 2 3
3 2 1

Input
10 54
Output
-1
 */
