package p1744;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1744B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] type = new int[q];
            int[] x = new int[q];
            for (int j = 0; j < q; j++) {
                type[j] = scanner.nextInt();
                x[j] = scanner.nextInt();
            }

            List<String> res = solve(n, a, q, type, x);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[] a, int q, int[] type, int[] x) {
        long oddCnt = 0;
        long oddSum = 0;
        long evenCnt = 0;
        long evenSum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                oddCnt++;
                oddSum += a[i];
            } else {
                evenCnt++;
                evenSum += a[i];
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            // 偶数不改变奇偶
            if (x[i] % 2 == 0) {
                if (type[i] == 0) {
                    evenSum += x[i] * evenCnt;
                } else {
                    oddSum += x[i] * oddCnt;
                }
            } else {
                if (type[i] == 0) {
                    evenSum += x[i] * evenCnt;
                    oddCnt += evenCnt;
                    evenCnt = 0;
                } else {
                    oddSum += x[i] * oddCnt;
                    evenCnt += oddCnt;
                    oddCnt = 0;
                }
            }
            resList.add(String.valueOf(oddSum + evenSum));
        }
        return resList;
    }
}
/*
B. Even-Odd Increments
https://codeforces.com/contest/1744/problem/B

题目大意：
给定整数 n 和 q，长度为 n 的数组 a，q 行 typej, xj 查询。
0 xj 的查询：将值 xj 加到数组 a 的所有偶数元素上；
1 xj 的查询：将值 xj 加到数组 a 的所有奇数元素上；
每次查询后，输出数组 a 元素之和。

模拟。加偶数不改变奇偶性，加奇数会改变奇偶性。
======

input
4
1 1
1
1 1
3 3
1 2 4
0 2
1 3
0 5
6 7
1 3 2 4 10 48
1 6
0 5
0 4
0 5
1 3
0 12
0 1
6 7
1000000000 1000000000 1000000000 11 15 17
0 17
1 10000
1 51
0 92
0 53
1 16
0 1

output
2
11
14
29
80
100
100
100
118
190
196
3000000094
3000060094
3000060400
3000060952
3000061270
3000061366
3000061366
 */