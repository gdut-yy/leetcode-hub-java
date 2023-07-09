package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1846A {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] - b[i] > 0) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 883 (Div. 3)
A. Rudolph and Cut the Rope
https://codeforces.com/contest/1846/problem/A

题目大意：
墙上钉了 n 颗钉子，第 i 颗钉子钉在离地面 ai 米的地方，bi 米长的绳子的一端系在墙上。所有的钉子都挂在不同的高度，一个比一个高。一颗糖一次被绑在所有的绳子上。糖果被绑在绳子的一端，而绳子没有被绑在钉子上。
要拿起糖果，你需要把它放到地上。为了做到这一点，鲁道夫可以割断一些绳子，一次一根。帮助鲁道夫找到要得到糖果必须剪断的绳子的最小数目。
下图显示了第一个测试的示例:

枚举。
======

input
4
3
4 3
3 1
1 2
4
9 2
5 2
7 7
3 4
5
11 7
5 10
12 9
3 2
1 5
3
5 6
4 5
7 7
output
2
2
3
0
 */
