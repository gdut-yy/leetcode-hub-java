package p689;

import java.util.Scanner;

public class CF689D {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int[][][] st;

    private static String solve() {
        st = new int[n][18][2];
        for (int i = 0; i < n; i++) {
            st[i][0][0] = a[i];
            st[i][0][1] = b[i];
        }
        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j][0] = Math.max(st[i][j - 1][0], st[i + (1 << (j - 1))][j - 1][0]);
                st[i][j][1] = Math.min(st[i][j - 1][1], st[i + (1 << (j - 1))][j - 1][1]);
            }
        }

        long ans = 0;
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            while (l < i && query(l, i) > 0) l++;
            while (r < i && query(r, i) >= 0) r++;
            ans += r - l;
        }
        return String.valueOf(ans);
    }

    static int query(int l, int r) {
        int k = bitsLen(r - l) - 1;
        int[] p = st[l][k], q = st[r - (1 << k)][k];
        return Math.max(p[0], q[0]) - Math.min(p[1], q[1]);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
D. Friends and Subsequences
https://codeforces.com/contest/689/problem/D

灵茶の试炼 2022-05-31
题目大意：
给你两个数组 a b，长度均为 n(n<=2e5)，元素范围 [-1e9,1e9]。
求所有满足 max(a[l..r]) = min(b[l..r]) 的区间 [l,r] 的个数。

rating 2100
https://codeforces.com/contest/689/submission/158934891
枚举左端点，区间 max 单调递增，区间 min 单调递减，因此可以二分或者双(三)指针找 max>=min 和 max>min 的最小(左)位置，两者相减即为右端点的合法个数。
求区间 max min 可以用线段树或 ST 表。线段树教程可以看群主 B 站视频。（右边链接）https://www.bilibili.com/video/BV18t4y1p736
话说这题改成 max^2 = min^2 还能不能做
======

input
6
1 2 3 2 1 4
6 7 1 2 3 2
output
2

input
3
3 3 3
1 1 1
output
0
 */