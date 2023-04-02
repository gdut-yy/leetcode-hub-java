package p1157;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1157E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a, b));
    }

    private static String solve(int n, int[] a, int[] b) {
        int[] cnt = new int[n];
        for (int bi : b) {
            cnt[bi]++;
        }
        DSU dsu = new DSU(n + 1);
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                dsu.union(i);
            }
        }

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            int bi = dsu.find((n - a[i]) % n);
            if (bi == n) {
                bi = dsu.find(0);
            }
            cnt[bi]--;
            if (cnt[bi] == 0) {
                dsu.union(bi);
            }
            c[i] = (a[i] + bi) % n;
        }

        return Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int x) {
            fa[find(x)] = find(x + 1);
        }

//        void union(int p, int q) {
//            int rootP = find(p);
//            int rootQ = find(q);
//            if (rootP == rootQ) {
//                return;
//            }
//            fa[rootQ] = rootP;
//        }
    }
}
/*
E. Minimum Array
https://codeforces.com/contest/1157/problem/E

灵茶の试炼 2023-03-20
题目大意：
输入 n(≤2e5) 和两个长为 n 的数组 a b，元素范围在 [0,n-1]。
你可以重排数组 b。
还有一个长为 n 的数组 c，其中 c[i] = (a[i] + b[i]) % n。
输出字典序最小的 c。

https://codeforces.com/contest/1157/submission/198294259
对于 a[i]，需要去找 (n-a[i])%n，如果不存在就找更大的，如果找到 n-1 都没有，就从 0 开始找。
这样做是暴力的，有多种优化方法：
- 类似 multiset 这样的平衡树，只维护存在的
- 并查集，如果 x 不存在，则把 x 和 x+1 合并，这样可以快速找到下一个存在的。
======

input
4
0 1 2 1
3 2 1 1
output
1 0 0 2

input
7
2 5 1 5 3 4 3
2 4 3 5 6 5 1
output
0 0 0 1 0 2 4
 */
