package c428;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc428_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int s = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = scanner.nextInt();
        int round = x / (a + b);
        int remainder = x % (a + b);
        int ans = (round * a + Math.min(remainder, a)) * s;
        out.println(ans);
    }
}
/*
A - Grandma's Footsteps
https://atcoder.jp/contests/abc428/tasks/abc428_a

题目大意：
高桥在学校里玩得很开心。下课铃一响，游戏就开始了。
铃声响起后，他立即重复以下动作：
- 以每秒 S 米的速度跑 A 秒。然后，保持静止 B 秒。
到下课铃响后 X 秒时，他一共跑了多少米？

取余。
======

Input 1
7 3 2 11
Output 1
49

Input 2
6 3 2 9
Output 2
36

Input 3
1 1 666 428
Output 3
1
 */
