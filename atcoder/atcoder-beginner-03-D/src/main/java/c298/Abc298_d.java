package c298;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Abc298_d {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();

        long res = 1L;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt();
                deque.addLast(x);
                res = (res * 10 + x) % MOD;
            } else if (op == 2) {
                int y = deque.removeFirst();
                int sz = deque.size();
                res = ((res - y * quickPow(10, sz)) % MOD + MOD) % MOD;
            } else {
                System.out.println(res);
            }
        }
    }

    // res = a^b % mod
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
D - Writing a Numeral
https://atcoder.jp/contests/abc298/tasks/abc298_d

灵茶の试炼 2023-08-21
题目大意：
我们有一个字符串 S，最初 S= 1。
按下列格式处理 Q 查询。
- 1 x:在 S 的末尾添加一个数字 x。
- 2:删除字母 S 开头的数字。
- 3:打印所代表的数字
S 为十进制，对 998244353 取模。

双端队列 + 快速幂模拟。
======

Input
3
3
1 2
3
Output
1
12

Input
3
1 5
2
3
Output
5

Input
11
1 9
1 9
1 8
1 2
1 4
1 4
1 3
1 5
1 3
2
3
Output
0
 */