package c421;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc421_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String[] a = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.next();
        }
        int x = scanner.nextInt();
        String y = scanner.next();

        out.println(a[x].equals(y) ? "Yes" : "No");
    }
}
/*
A - Misdelivery
https://atcoder.jp/contests/abc421/tasks/abc421_a

题目大意：
有 N(100) 个房间，房间编号从 1 到 N。
每个房间 i 都住着一个名叫 Si 的人。
您要将一个寄给 Y 先生/女士的包裹送到 X 房间。请判断目的地是否正确。

模拟。
======

Input 1
3
sato
suzuki
takahashi
3 takahashi
Output 1
Yes

Input 2
3
sato
suzuki
takahashi
1 aoki
Output 2
No

Input 3
2
smith
smith
1 smith
Output 3
Yes

Input 4
2
wang
li
2 wang
Output 4
No
 */
