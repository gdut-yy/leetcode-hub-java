package p1878;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1878C {
    static int n, k;
    static long x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            x = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        // (1+k)k/2
        long min = (1L + k) * k / 2;
        // k(n-k+1 + k)/2
        long max = (n - k + 1L + n) * k / 2;
        return x >= min && x <= max ? "YES" : "NO";
    }
}
/*
C. Vasilije in Cacak
https://codeforces.com/contest/1878/problem/C

题目大意：
阿卡和米洛万是两个竞争激烈的程序员，他们决定给瓦西里耶出一道题来测试他的技能。
给 Vasilije 三个正整数:n, k 和 x，他必须确定他是否可以在 1 到 n 之间选择 k 个不同的整数，使它们的和等于 x。
因为 Vasilije 现在在塞尔维亚最奇怪的城市，Aca 和 Milovan 居住的地方，Cacak，这个问题对他来说似乎很奇怪。所以他需要你帮他解决这个问题。

上下界
======

input
12
5 3 10
5 3 3
10 10 55
6 5 20
2 1 26
187856 87856 2609202300
200000 190000 19000000000
28 5 2004
2 2 2006
9 6 40
47202 32455 613407217
185977 145541 15770805980
output
YES
NO
YES
YES
NO
NO
YES
NO
NO
NO
YES
YES
 */
