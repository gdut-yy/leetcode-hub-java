package p1744;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1744E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(solve(a, b, c, d));
        }
    }

    private static String solve(int a, int b, int c, int d) {
        long ab = (long) a * b;

        List<Integer> aFactors = breakdown(a);
        List<Integer> bFactors = breakdown(b);
        for (long aFactor : aFactors) {
            for (long bFactor : bFactors) {
                long x = aFactor * bFactor;
                // s = a·b·gdc(a·b, x) = a·b·a'·b'
//                long s = ab * x;

                x = c / x * x;
                if (a < x) {
                    long y = ab / getGCD(ab, x);
                    y = d / y * y;
                    if (b < y) {
                        return x + " " + y;
                    }
                }
            }
        }
        return "-1 -1";
    }

    private static long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

    private static List<Integer> breakdown(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        return factors;
    }

}
/*
E1. Divisible Numbers (easy version)
https://codeforces.com/contest/1744/problem/E1

题目大意：
给定整数 a,b,c,d 求 x,y 使：
a < x <= c, b < y <= d
x*y 能被 a*b 整除
求出一组 x,y。如果不存在输出 -1 -1

https://codeforces.com/blog/entry/108101
让我们先看看慢解，它将引导我们到达完整解。我们将 x 从 a+1 迭代到 c。

给定一个数字 x，我们想找出一个从 b+1 到 d 的 y 让 x⋅y 能被 a⋅b 整除。
因为 x⋅y 一定能被 a⋅b 整除，所以可以得出如下结论：y 一定能被 a⋅b/gcd(a⋅b,x) 整除。让我们把这个数字表示为 s。
现在我们的任务是检查在 b+1 和 d 之间是否有 s 的倍数。这个问题可以有很多方法解决，你可以简单地考虑 s 的最大倍数不超过 d
—— 它等于 ⌊d/s⌋·s 我们将这个数字与 b+1 进行比较，如果它匹配，那么我们就找到了一个合适的组合。

现在我们注意到，我们不需要遍历 x 的所有值，因为从数字 x，我们只对 gcd(x,a⋅b) 感兴趣
—— 这是 a⋅b 的一个因数!

尽管 a⋅b 的乘积可能很大，但我们仍然可以考虑这个数的所有因数，因为 a 和 b 本身都是 10^9。
让我们分别求出 a 和 b 的因数，然后注意到，a·b 的任何因数都是 a'·b'
—— 其中 a' 是 a 的因数，b' 是 b 的因数。

让我们计算一下运行时间。我们需要把 a 和 b 分解成质因数，这可以在O(√a)中完成。接下来，您需要在除数 a 和 b 对上进行迭代。
回想一下对一个数的除数数量的估计(https://oeis.org/A066150)：不超过 10^9 的 x 的除数不超过 1344 个。
因此，我们可以对 1344^2 进行排序。我们学过如何求 O(1) 的最优 y。我们得到，对于每个测试用例，我们已经学会了解决 O(√a+(1344^2)) 中的问题。
======

input
5
1 1 2 2
3 4 5 7
8 9 15 18
12 21 14 24
36 60 48 66

output
2 2
4 6
12 12
-1 -1
-1 -1
 */
