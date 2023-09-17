package c317;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc317_a {
    static int n, h, x;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        h = scanner.nextInt();
        x = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (h + p[i] >= x) {
                return String.valueOf(i + 1);
            }
        }
        return "-1";
    }
}
/*
A - Potions
https://atcoder.jp/contests/abc317/tasks/abc317_a

题目大意：
直宏有个怪物。怪物目前的生命值是 H。
他也有 N 种药剂，从 1 到 N 按效力升序排列。
如果你给怪物 n 药水，它的生命值将增加 pn。这里，p1 < p2 < ... < pn。
他希望通过给予怪物一种药剂将其生命值提高到 X 或更高。
打印出能达到目的的最无效药水的数量。(约束条件保证了这种药剂的存在。)

======

Input 1
3 100 200
50 200 999
Output 1
2

Input 2
2 10 21
10 999
Output 2
2

Input 3
10 500 999
38 420 490 585 613 614 760 926 945 999
Output 3
4
 */