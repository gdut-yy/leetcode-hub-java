package p1848;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1848C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1848/submission/214055424
    private static String solve() {
        int ert = 0;
        for (int i = 0; i < n; i++) {
            ert |= calc(a[i], b[i]);
        }
        int s = Integer.bitCount(ert);
        return s <= 1 ? "YES" : "NO";
    }

    static int calc(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        }
        int s = getGCD(a, b);
        a /= s;
        b /= s;
        if (a % 2 == 0) return 1;
        if (b % 2 == 0) return 2;
        return 4;
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
C. Vika and Price Tags
https://codeforces.com/contest/1848/problem/C

题目大意：
Vika 来到她最喜欢的化妆品店“金梨”。她注意到自从她上次来之后，有 n 件商品的价格发生了变化。
她决定分析价格变化了多少，并计算出 n 种商品中每一种的新旧价格之差。
Vika 喜欢计算价格差异，并决定继续这一过程。
将旧价格表示为非负整数数组 a，将新价格表示为非负整数数组 b。两个数组都有相同的长度 n。
在一个操作中，Vika 根据以下原则构造了一个新的数组 c: ci=|ai−bi|。然后，将数组 c 重命名为数组 b，同时将数组 b 重命名为数组 a，之后 Vika 对它们重复操作。
例如，如果 a=[1,2,3,4,5,6,7];B =[7,6,5,4,3,2,1]，那么 c=[6,4,2,0,2,4,6]然后，a=[7,6,5,4,3,2,1];b =[6 4 2 0、2、4、6]。
Vika 决定称一对数组为 a, b，如果经过一些这样的操作，数组 a 的所有元素都变为零。
如果原始数组对是无趣的，则输出“YES”，否则输出“NO”。


======

input
9
4
0 0 0 0
1 2 3 4
3
1 2 3
1 2 3
2
1 2
2 1
6
100 23 53 11 56 32
1245 31 12 6 6 6
7
1 2 3 4 5 6 7
7 6 5 4 3 2 1
3
4 0 2
4 0 2
3
2 5 2
1 3 4
2
6 1
4 2
2
0 0
0 3
output
YES
YES
NO
NO
YES
YES
NO
YES
YES
 */
