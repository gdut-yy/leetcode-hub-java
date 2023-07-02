package p1054;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1054D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static String solve(int n, int k, int[] a) {
        long ans = c2(n + 1);
        int m = (1 << k) - 1;
        int s = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        for (int ai : a) {
            s ^= ai;
            int key = Math.min(s, s ^ m);
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }
        for (Integer c : cntMap.values()) {
            ans -= c2(c / 2) + c2(c - c / 2);
        }
        return String.valueOf(ans);
    }

    private static long c2(long n) {
        return n * (n - 1) / 2;
    }
}
/*
D. Changing Array
https://codeforces.com/contest/1054/problem/D

灵茶の试炼 2023-03-16
题目大意：
输入正整数 n(≤2e5) k(≤30) 和长为 n 的数组 a(0≤a[i]≤pow(2,k)-1)。
设 mask = (1<<k)-1，每次操作你可以把任意 a[i] 修改为 a[i] XOR mask，你可以操作任意次（包括 0 次）。
修改后，最多有多少个 a 的非空连续子数组，其异或和不等于 0？

https://www.luogu.com.cn/blog/endlesscheng/solution-cf1054d
构造前缀异或和，使需要让 s 中的不同数对尽量的多。
正难则反。思考如何让 s 中的相同数对尽量的少。
======

input
3 2
1 3 0
output
5

input
6 3
1 4 4 7 3 4
output
19
 */
