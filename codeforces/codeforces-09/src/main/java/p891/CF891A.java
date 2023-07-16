package p891;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF891A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int gcdAll = 0, cnt1 = 0;
        for (int x : a) {
            gcdAll = getGCD(gcdAll, x);
            if (x == 1) cnt1++;
        }
        if (gcdAll != 1) return "-1";
        if (cnt1 > 0) return String.valueOf(n - cnt1);

        int minLen = n;
        // gcd, 相同的 gcd 的最晚出现的位置
        List<int[]> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new int[]{a[i], i});

            // 原地去重
            int k = 0;
            for (int[] p : g) {
                p[0] = getGCD(p[0], a[i]);
                if (g.get(k)[0] == p[0]) {
                    g.get(k)[1] = p[1]; // 合并相同值，下标取最小的
                } else {
                    k++;
                    g.set(k, p);
                }
            }
            g.subList(k + 1, g.size()).clear();

            if (g.get(0)[0] == 1) {
                // 这里本来是 i-g.get(0)[1]+1，把 +1 提出来合并到 return 中
                minLen = Math.min(minLen, i - g.get(0)[1]);
            }
        }
        return String.valueOf(n + (minLen - 1));
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
A. Pride
https://codeforces.com/contest/891/problem/A

题目大意：
你有一个长度为 n 的数组 a，你可以执行一些操作。每个操作都是这样的:从 a 中选择两个相邻的元素，比如 x 和 y，并用 gcd(x, y)替换其中一个元素，其中 gcd 表示最大公约数。
使所有元素都等于 1 所需的最少操作次数是多少?

rating 1500
子数组 LCM/GCD/OR/AND 模板
https://codeforces.com/contest/891/submission/135400527
相似题目: 2654. 使数组所有元素变成 1 的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
======

input
5
2 2 3 4 6
output
5
input
4
2 4 6 8
output
-1
input
3
2 6 9
output
4
 */
