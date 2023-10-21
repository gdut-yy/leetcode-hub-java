package nc65051;

import java.util.Scanner;

public class NC65051A {
    static long x, y, z;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextLong();
        y = scanner.nextLong();
        z = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long s = y + x + x + x;
        long ans = z / s * 3;
        z %= s;
        if (z > 0) {
            z -= y + x;
            ans++;
        }
        if (z > 0) {
            z -= x;
            ans++;
        }
        if (z > 0) {
            z -= x;
            ans++;
        }
        return String.valueOf(ans);
    }
}
/*
牛客周赛 Round 12
小美种果树
https://ac.nowcoder.com/acm/contest/65051/A

题目描述
小美在手机上种果树，只要成熟了就可以领到免费的水果了。
小美每天可以给果树浇水，果树的成长值加 x。同时也可以给果树施肥，两次施肥至少需要间隔 2 天，果树的成长值加 y。果树成长值达到 z 就成熟了。
小美想知道，最少需要多少天可以领到免费的水果。
输入描述:
一行三个整数 x,y,z，分别表示浇水的成长值，施肥的成长值，果树成熟的成长值。
1≤x,y,z≤10^9
输出描述:
一行一个整数，表示最少需要多少天可以领到免费的水果。

取模
======

示例1
输入
1 2 10
输出
6
说明
第一天施肥浇水，成长值为 3。
第二天浇水，成长值为 3 + 1 = 4。
第三天浇水，成长值为 4 + 1 = 5。
第四天施肥浇水，成长值为 5 + 3 = 8。
第五天浇水，成长值为 8 + 1 = 9。
第六天浇水，成长值为 9 + 1 = 10。
果树成熟了，可以领到免费水果了！
 */