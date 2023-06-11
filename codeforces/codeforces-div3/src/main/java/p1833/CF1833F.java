package p1833;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1833F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, m, a));
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int m, int[] a) {
        // 统计频次，转数组
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : a) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(cntMap.keySet());
        Collections.sort(keys);
        int sz = keys.size();
        // 特判
        if (sz < m) {
            return "0";
        }

        // 滑动窗口乘积
        long product = 1L;
        for (int i = 0; i < m; i++) {
            long c = cntMap.get(keys.get(i));
            product = product * c % MOD;
        }

        long ans = 0L;
        if (keys.get(m - 1) - keys.get(0) < m) {
            ans = (ans + product) % MOD;
        }
        for (int i = m; i < sz; i++) {
            long add = cntMap.get(keys.get(i));
            long rm = cntMap.get(keys.get(i - m));
            product = product * add % MOD;
            product = product * quickPow(rm, MOD - 2) % MOD;

            if (keys.get(i) - keys.get(i - m + 1) < m) {
                ans = (ans + product) % MOD;
            }
        }
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
F. Ira and Flamenco
https://codeforces.com/contest/1833/problem/F

题目大意：
艾拉非常喜欢西班牙弗拉门戈舞。她决定开办自己的舞蹈工作室，并找到了 n 名学生，其中第 i 名学生具有 ai 水平。
艾拉可以选择几个学生，和他们一起跳舞。所以她可以设置大量的舞蹈，但她只对华丽的舞蹈感兴趣。如果符合以下条件，这个舞蹈就被称为华丽:
- 正好同学们参加了舞会;
- 所有舞者的水平都是两两不同的;
- 每两个舞者的水平的绝对差异严格小于 m。
例如 m=3, a=[4,2,2,3,6]，下面的舞蹈是华丽的(参与舞蹈的学生用红色标出):[4,2,2,3,6]，[4,2,2,3,6]。与此同时，舞蹈[4,2,2,3,6]，[4,2,2,3,6]，[4,2,2,3,6]并不华丽。
在舞蹈[4,2,2,3,6]中，虽然 m=3，但只有 2 名学生参与。
舞蹈[4,2,2,3,6]涉及 2 级和 2 级的学生，尽管所有舞者的水平必须是两两不同的。
在舞蹈[4,2,2,3,6]中，3 级和 6 级的学生参与，但|3−6|=3，虽然 m=3。
帮艾拉数一数她能跳多少支华丽的舞。因为这个数可能非常大，所以以 10^9+7 为模。如果参加舞蹈的学生人数不同，则认为两种舞蹈不同。

滑动窗口 + 乘法原理 + 乘法逆元
======

input
9
7 4
8 10 10 9 6 11 7
5 3
4 2 2 3 6
8 2
1 5 2 2 3 1 3 3
3 3
3 3 3
5 1
3 4 3 10 7
12 3
5 2 1 1 4 3 5 5 5 2 7 5
1 1
1
3 2
1 2 3
2 2
1 2
output
5
2
10
0
5
11
1
2
1
 */
