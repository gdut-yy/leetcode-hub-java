package c292;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc292_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int N) {
        long ans = 0L;
        for (int i = 1; i < N; i++) {
            int X = i, Y = N - i;

            long x = 0, y = 0;
            for (int j = 1; j * j <= X; j++) {
                if (X % j == 0) {
                    x++;
                    if (X != j * j) x++;
                }
            }
            for (int j = 1; j * j <= Y; j++) {
                if (Y % j == 0) {
                    y++;
                    if (Y != j * j) y++;
                }
            }
            ans += x * y;
        }
        return String.valueOf(ans);
    }
}
/*
C - Four Variables
https://atcoder.jp/contests/abc292/tasks/abc292_c

题目大意：
给定一个正整数 N，求出正整数(a,B,C,D)的四倍数使 AB+CD=N 的个数。
在此问题的约束下，可以证明答案最多为 9×10e18。

我们可以穷尽枚举所有 (A,B,C,D)，并检查 AB+CD=N 是否在总共 O(N^4)时间内找到答案，但对于执行时间限制来说太慢了。
对于一个固定的 (A,B,C)， AB+CD=N 最多有一个 D，这可以通过检查 N−AB 是否非负并且是 C 的倍数来确定，所以我们可以通过在总共 O(N^3) 时间内穷尽枚举 (A,B,C) 来找到答案，但这也太慢了。
当 AB 值固定为 X 时，CD 值，我们用 Y 表示，被确定为 N−X。正如我们上面所描述的，固定 A 决定 B, C 决定 d。通过穷尽搜索 X、A 和 C 的所有值，代价仍然是 O(N^3);
但是，我们可以分别求出 X=AB 的 (A,B) 和 Y=CD 的 (C,D) 的个数，因此可以化简为 O(N^2)。
此外，假设 A≤B，则 X=AB 的值 A 满足 A≤X, C 和 d 亦如此，总共需要 O(N√N)个时间即可解决问题。
======

Input 1
4
Output 1
8

Input 2
292
Output 2
10886

Input 3
19876
Output 3
2219958
 */