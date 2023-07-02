package p1247;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1247C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(solve(n, p));
    }

    private static String solve(int n, int p) {
        long delta = n;
        // https://www.wolframalpha.com/input?i=solve+equation
        // 30 + log_2(x+1) = x, x= 35.177
        for (int k = 1; k <= 36; k++) {
            delta -= p;
            // 每次最少减 2^0 = 1
            if (delta < k) break;
            if (Long.bitCount(delta) <= k) return String.valueOf(k);
        }
        return "-1";
    }
}
/*
C. p-binary
https://codeforces.com/contest/1247/problem/C

题目大意：
Vasya 喜欢任何数字，只要它是 2 的整数次幂。另一方面，Petya 非常保守，只喜欢单个整数 p(可能是正的、负的或零)。为了结合他们的口味，他们发明了形式为 2^x+p 的 p -二进制数，其中 x 是一个非负整数。
例如，一些- 9 -二进制(“-9”二进制)数是: -8, 7 和 1015 (-8=2^0-9, 7=2^4-9, 1015=2^10-9)。
男孩们现在用 p -二进制数来表示一切。他们现在面临一个问题:给定一个正整数 n，用 p -二进制数(不一定不同)来表示 n 的和所需的最小个数是多少?有可能表示是完全不可能的。帮助他们解决这个问题。
例如，如果 p=0，我们可以将 7 表示为 2^0+2^1+2^2。
如果 p=-9，我们可以把 7 表示成一个数(2^4-9)。
请注意，在总和中允许出现负的 p -二进制数(参见 Notes 小节中的示例)。

相似题目: 2749. 得到整数零需要执行的最少操作数
https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/
======

input
24 0
output
2

input
24 1
output
3

input
24 -1
output
4

input
4 -7
output
2

input
1 1
output
-1
 */
