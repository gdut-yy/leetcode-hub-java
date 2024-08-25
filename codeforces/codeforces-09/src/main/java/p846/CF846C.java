package p846;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF846C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }

        // 前后缀分解
        long[][] pre = new long[n + 1][2];
        for (int i = 0; i < n; i++) {
            if (s[i + 1] > pre[i][0]) {
                pre[i + 1] = new long[]{s[i + 1], i + 1};
            } else {
                pre[i + 1] = pre[i].clone();
            }
        }

        long ans = (long) -1e18;
        long p = -1, q = -1, r = -1;
//        long suf = s[n], sufI = n;
//        for (int i = n; i >= 0; i--) {
//            if (s[i] > suf) {
//                suf = s[i];
//                sufI = i;
//            }
//            long t = pre[i][0] - s[i] + suf;
//            if (t > ans) {
//                ans = t;
//                p = pre[i][1];
//                q = i;
//                r = sufI;
//            }
//        }

        long[][] suf = new long[n + 1][2];
        suf[n] = new long[]{s[n], n};
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] > suf[i + 1][0]) {
                suf[i] = new long[]{s[i], i};
            } else {
                suf[i] = suf[i + 1].clone();
            }
        }

        for (int i = n; i >= 0; i--) {
            long t = pre[i][0] - s[i] + suf[i][0];
            if (t > ans) {
                ans = t;
                p = pre[i][1];
                q = i;
                r = suf[i][1];
            }
        }
        return p + " " + q + " " + r;
    }
}
/*
C. Four Segments
https://codeforces.com/contest/846/problem/C

灵茶の试炼 2023-05-31
题目大意：
输入 n(1≤n≤5000) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
定义 s(i,i)=0, s(i,j)=a[i]+a[i+1]+...+a[j-1]。
计算 s(0,i)-s(i,j)+s(j,k)-s(k,n) 的最大值，其中 0≤i≤j≤k≤n。
你需要输出最大值对应的 i,j,k。
如果有多个满足要求的答案，输出任意一个。
进阶：你能想出一个 O(n) 的算法吗？

rating 1800
https://codeforces.com/contest/846/submission/207819522
用前缀和将 s(0,i)-s(i,j)+s(j,k)-s(k,n) 变成
2*(s[i]-s[j]+s[k])-s[n]。
转换成求 s[i]-s[j]+s[k] 的最大值。
前后缀分解，计算 s 的前缀最大值和后缀最大值，然后枚举 s[j]。
======

input
3
-1 2 3
output
0 1 3

input
4
0 0 -1 0
output
0 0 0

input
1
10000
output
1 1 1

100
-1 -1 0 1 -1 0 0 -1 -1 1 1 0 1 0 -1 1 0 0 -1 0 0 0 1 0 0 1 1 1 1 0 -1 -1 0 0 0 1 1 -1 0 0 1 1 1 0 -1 -1 0 -1 0 -1 -1 0 1 0 1 -1 1 -1 -1 -1 0 0 -1 0 -1 -1 0 -1 1 1 -1 1 0 1 -1 -1 1 1 -1 1 0 -1 1 -1 1 1 1 1 1 -1 0 1 0 0 -1 0 1 1 -1 -1
 */
