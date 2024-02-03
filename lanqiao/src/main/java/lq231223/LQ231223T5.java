package lq231223;

import java.util.Scanner;

public class LQ231223T5 {
    static long a, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextLong();
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long lcm = 1;
        long ans = 0;
        for (long i = 1; i <= a; i++) {
            lcm = getLCM(lcm, i);
            if (lcm > n) break;
            if (i == a - 1) {
                ans += n / lcm;
            } else if (i == a) {
                ans -= n / lcm;
            }
        }
        return a == 1 ? "0" : String.valueOf(ans);
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private static long getLCM(long num1, long num2) {
        return num1 / getGCD(num1, num2) * num2;
    }
}
/*
数学尖子生【算法赛】

考点：思维，数学
考虑 f(x)=a 需要满足的条件
1、x 需要是 1,2,3,...,a-1 的倍数
2、x 不能是 a 的倍数
考虑容斥，我们同时用 1,2,3,...,a-1 的倍数个数减去 1,2,3,...,a 的倍数的个数。
具体来说，我们定义 g(x) 为 x 的倍数的个数。
lcm(a1,a2,...,an) 为所有数的最小公倍数
答案为：g( lcm(1,2,3,...,a-1) ) - g( lcm(1,2,3,...,a) )
 */