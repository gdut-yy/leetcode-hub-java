package p33;

import java.util.Arrays;
import java.util.Scanner;

public class CF33C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int s = 0, maxS = 0;
        for (int v : a) {
            s = Math.max(s + v, v);
            maxS = Math.max(maxS, s);
        }
        int ans = maxS * 2 - Arrays.stream(a).sum();
        return String.valueOf(ans);
    }
}
/*
C. Wonderful Randomized Sum
https://codeforces.com/contest/33/problem/C

灵茶の试炼 2022-05-23
题目大意：
给你一个长为 n(<=1e5) 的数组，元素范围 [-1e4,1e4]。
你可以选择一段前缀和一段后缀（可为空），将所有被选择的元素改为其相反数（a[i] 变成 -a[i]）
问修改后的数组的所有元素之和的最大值。

rating 1800
https://codeforces.com/contest/33/submission/158116180
设中间一段未被修改的元素和为 x，那么其余部分元素和为 sum(a)-x，取反后为 x-sum(a)，此时数组元素和为 2x-sum(a)。
所以求个最大子段和即可。
======

input
3
-1 -2 -3
output
6

input
5
-4 2 0 5 0
output
11

input
5
-1 10 -5 10 -2
output
18
 */
