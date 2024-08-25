package p708;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF708B {
    private static final String IMPOSSIBLE = "Impossible";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int a00 = scanner.nextInt();
        int a01 = scanner.nextInt();
        int a10 = scanner.nextInt();
        int a11 = scanner.nextInt();
        System.out.println(solve(a00, a01, a10, a11));
    }

    private static String solve(int a00, int a01, int a10, int a11) {
        // 根据 f(0,0) 可以求出 0 的个数 c0，f(0,0) = C(c0, 2)
        int cnt0 = f(a00);
        int cnt1 = f(a11);
        if (cnt0 < 0 || cnt1 < 0) {
            return IMPOSSIBLE;
        }

        if (a01 == 0 && a10 == 0) {
            if (a00 > 0 && a11 > 0) {
                return IMPOSSIBLE;
            } else if (a11 == 0) {
                return "0".repeat(cnt0);
            } else {
                return "1".repeat(cnt1);
            }
        }
        if (a01 + a10 != cnt0 * cnt1) {
            return IMPOSSIBLE;
        }

        int left1 = a10 / cnt0;
        int right0 = a10 % cnt0;
        String res = "1".repeat(left1) + "0".repeat(cnt0 - right0);
        if (right0 > 0) {
            res += "1" + "0".repeat(right0);
            cnt1--;
        }
        res += "1".repeat(cnt1 - left1);
        return res;
    }

    // a·x^2 + b·x + c = 0 一元二次方程求根公式 (-b ± sqrt(b^2 - 4ac)) / 2a
    // x(x-1)/2 = a
    // x = (1 + sqrt(1 + 8a)) / 2
    private static int f(long a) {
        int x = (int) (1 + Math.sqrt(a * 8 + 1.0) / 2);
        if (x * (x - 1L) / 2 == a) {
            return x;
        }
        return -1;
    }
}
/*
B. Recover the String
https://codeforces.com/contest/708/problem/B

灵茶の试炼 2023-02-24
题目大意：
对于 01 字符串 s，定义 f(x,y) 表示子序列 [x,y] 在 s 中的出现次数。
输入 f(0,0), f(0,1), f(1,0) 和 f(1,1)，范围在 [0,1e9]。
请构造任意一个满足输入的非空字符串 s。
如果不存在，输出 Impossible。
注：子序列是从 s 中删除某些元素得到的。

rating 1900
constructive algorithms
https://codeforces.com/contest/708/submission/194669010
提示 1：根据 f(0,0) 可以求出 0 的个数 c0，因为 f(0,0) = C(c0,2)；同理可求出 1 的个数 c1。
提示 2：f(0,1) + f(1,0) = c0 * c1
======

input
1 2 3 4
output
Impossible

input
1 2 2 1
output
0110
 */
