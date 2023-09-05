package p1842;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1842B {
    static int n, x;
    static int[] a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1842/submission/210874367
    private static String solve() {
        int mask = 0;
        for (int y : a) {
            // y 是 x 的子集
            if ((y & x) == y) mask |= y;
            else break;
        }

        for (int y : b) {
            if ((y & x) == y) mask |= y;
            else break;
        }
        for (int y : c) {
            if ((y & x) == y) mask |= y;
            else break;
        }

        return mask == x ? "Yes" : "No";
    }
}
/*
B. Tenzing and Books
https://codeforces.com/contest/1842/problem/B

题目大意：
Tenzing 从他的粉丝那里收到了 3n 本书。这些书被排列成 3 摞，每摞有 n 本书。每本书都有一个非负整数难度评级。
Tenzing 想读一些(可能没有)书。起初，他的知识是 0。
要读的书，Tenzing 会选择一个非空的书堆，把最上面的书读一遍，然后把书丢弃。如果 Tenzing 目前的知识是 u，那么他读了一本难度等级为 v 的书后，他的知识就会变成 u|v。这里|表示按位或操作。请注意，Tenzing 以随时停止读书。
Tenzing 最喜欢的数字是 x。你能帮 Tenzing 查一下他的知识是否有可能变成 x 吗?

贪心
======

input
3
5 7
1 2 3 4 5
5 4 3 2 1
1 3 5 7 9
5 2
3 2 3 4 5
5 4 3 2 1
3 3 5 7 9
3 0
1 2 3
3 2 1
2 2 2
output
Yes
No
Yes
 */
