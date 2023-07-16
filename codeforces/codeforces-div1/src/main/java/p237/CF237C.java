package p237;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF237C {
    static int a, b, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> primes = new ArrayList<>();
        boolean[] np = new boolean[b + 1];
        for (int i = 2; i <= b; i++) {
            if (!np[i]) {
                if (i >= a) {
                    primes.add(i);
                }
                // java 46349 * 46349 = -2146737495
                // golang 整数回绕 (wrap around) 46349 * 46349 = 2148229801
//                for (int j = i * i; j <= b; j += i) {
                for (int j = i; j <= b; j += i) {
                    np[j] = true;
                }
            }
        }
        primes.add(0, a - 1);
        primes.add(b + 1);

        int m = primes.size();
        if (m - 2 < k) {
            return "-1";
        }
        int ans = 0;
        for (int i = k; i < m; i++) {
            ans = Math.max(ans, primes.get(i) - primes.get(i - k));
        }
        return String.valueOf(ans);
    }
}
/*
C. Primes on Interval
https://codeforces.com/contest/237/problem/C

灵茶の试炼 2023-05-30
题目大意：
输入 a b k，范围 [1,1e6]，a≤b。
请找到最短的 L，使得对于任意 a≤x≤b-L+1 都满足：在 x,x+1,...,x+L-1 中至少有 k 个质数。
输出 L。如果 L 不存在，输出 -1。

https://codeforces.com/contest/237/submission/207778331
预处理质数（埃氏筛/欧拉筛）。如果不足 k 个，输出 -1。
方法一：二分答案+滑窗验证（可以只在质数列表中滑窗）  O(b/logb * logb) = O(b)
方法二：既然可以只在质数列表中滑窗，那么干脆直接计算。
考虑 k+1 个连续质数对应的区间（减一），例如 5,7,11,13 & k=2，那么 [7,13-1] 就是一个包含 k 个质数的区间。向右滑动一格，变成 [7+1,13]，也仍然包含了 k 个质数。再短一点就不行了。最后再算上 a 和 b 的边界，你可以把 a-1 和 b+1 也视作质数。
答案就是 primes[i] - primes[i-k] 的最大值。
=====

input
2 4 2
output
3

input
6 13 1
output
4

input
1 4 3
output
-1

1 1000000 10000
 */
