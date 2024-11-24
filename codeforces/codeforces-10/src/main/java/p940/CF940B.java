package p940;

import java.util.Scanner;

public class CF940B {
    static long n, k, a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        while (n > 1) {
            ans += n % k * a;
            n -= n % k;
            if ((n - n / k) * a <= b) {
                ans += (n - 1) * a;
                break;
            }
            ans += b;
            n /= k;
        }
        return String.valueOf(ans);
    }
}
/*
B. Our Tanya is Crying Out Loud
https://codeforces.com/contest/940/problem/B

灵茶の试炼 2024-04-22
题目大意：
输入 n k a b (1≤n,k,a,b≤2e9)。
有两种操作：
花费 a，把 n 减一。
如果 n 是 k 的倍数，花费 b，把 n 变成 n/k。
输出把 n 变成 1 的最小总花费。
相似题目: 1553. 吃掉 N 个橘子的最少天数
https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/description/
397. 整数替换
https://leetcode.cn/problems/integer-replacement/

rating 1400
1. 如果 n 不是 k 的倍数，我们先把 n 减少 n % k，花费 n % k * a。
2. 现在 n 是 k 的倍数。如果把 n 变成 n/k，相当于减少了 n - n/k，如果用第一种操作来减少这么多，就需要花费 (n - n/k) * a。
3. 如果 (n - n/k) * a <= b，那么第二种操作就失去意义了（因为后面 n 只会更小），直接把 n 减少成 1，花费 (n-1) * a。
4. 否则花费 b，把 n 变成 n/k，回到第一步。
https://codeforces.com/contest/940/submission/257196401
======

Input
9
2
3
1
Output
6

Input
5
5
2
20
Output
8

Input
19
3
4
2
Output
12
 */
