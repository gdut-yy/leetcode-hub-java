package p1032;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1032C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 末尾加个哨兵，方便处理只有一个元素 or 最后两个元素相等的情况
        a[n] = a[n - 1];

        int[] b = new int[n];
        int i = 0;
        while (i < n) {
            if (a[i] == a[i + 1]) {
                if (b[i] == 0) {
                    b[i] = 2;
                    if (i > 0 && b[i - 1] == 2) {
                        b[i] = 3;
                    }
                }
                i++;
                continue;
            }

            // 处理连续下降段或连续上升段
            int st = i;
            for (i += 2; i < n && a[i] != a[i - 1] && (a[i] < a[i - 1] == a[i - 1] < a[i - 2]); i++) {
            }
            if (a[st] > a[st + 1]) {
                b[st] = 5;
                if (st > 0 && b[st - 1] == 5) {
                    b[st] = 4;
                }
                for (st++; st < i; st++) {
                    b[st] = b[st - 1] - 1;
                }
            } else {
                b[st] = 1;
                if (st > 0 && b[st - 1] == 1) {
                    b[st] = 2;
                }
                for (st++; st < i; st++) {
                    b[st] = b[st - 1] + 1;
                }
            }
            i--;
            if (b[i] < 1 || b[i] > 5) {
                return "-1";
            }
        }
        return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Playing Piano
https://codeforces.com/contest/1032/problem/C

灵茶の试炼 2022-08-18
题目大意：
输入 n (≤1e5) 和一个长为 n 的数组 a (1≤a[i]≤2e5)。
构造一个长为 n 的数组 b，满足：
1. 1≤b[i]≤5；
2. 如果 a[i]<a[i+1]，则 b[i]<b[i+1]；
3. 如果 a[i]>a[i+1]，则 b[i]>b[i+1]；
4. 如果 a[i]=a[i+1]，则 b[i]≠b[i+1]；
如果不存在这样的 b 则输出 -1，否则输出任意一个满足要求的 b。

constructive algorithms
rating 1700
纯构造做法
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1032c
每一个上升段和下降段都可以一段段地处理。
对于上升段，让起始值尽量小，每次增长 1。
对于下降段，让起始值尽量大，每次减少 1。
相等的段，元素可以取 2 或 3，这样不会妨碍上升段和下降段的起始值。
具体实现技巧见代码。
======

input
5
1 1 4 2 2
output
1 4 5 4 5

input
7
1 5 7 8 10 3 1
output
1 2 3 4 5 4 3

input
19
3 3 7 9 8 8 8 8 7 7 7 7 5 3 3 3 3 8 8
output
1 3 4 5 4 5 4 5 4 5 4 5 4 3 5 4 3 5 4
 */