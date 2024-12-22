package p204;

import java.util.Scanner;

public class CF204A {
    static long l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        l = scanner.nextLong();
        r = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = f(r) - f(l - 1);
        return String.valueOf(ans);
    }

    static long f(long n) {
        if (n < 10) {
            return n;
        }
        long res = 9 + n / 10;
        if (String.valueOf(n).charAt(0) - '0' > n % 10) {
            res--;
        }
        return res;
    }
}
/*
A. Little Elephant and Interval
https://codeforces.com/contest/204/problem/A

灵茶の试炼 2024-11-12
题目大意：
输入 L R (1≤L≤R≤1e18)。
如果整数 x 的首位数字等于末位数字，那么称 x 是合法数字。
例如 101, 477474, 9 是合法数字，而 47, 253, 1020 不是合法数字。
输出 [L,R] 中有多少个合法数字。

rating 1500
定义 f(n) 等于在 [1,n] 中的合法数字个数。
那么答案为 f(r) - f(l-1)。
讨论 f(n) 怎么算：
如果 n < 10，所有数都是合法的，返回 n。
对于 >= 10 的数，合法数字等价于，对于在 [1,n/10] 中的数字 x，在其末尾插入 x 的最高位。
例如 x=123，在其末尾插入最高位 1，得到合法数字 1231。
这有 n/10 个数。
再算上 < 10 的 9 个合法数字，所以答案为 9 + n/10。但如果 n 的最高位 > n%10，我们多算了一个不合法的数字，答案减一。
代码 https://codeforces.com/problemset/submission/204/284379601
代码备份（洛谷）
======

Input
2 47
Output
12

Input
47 1024
Output
98
 */
