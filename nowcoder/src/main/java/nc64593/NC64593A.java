package nc64593;

import java.util.Scanner;

public class NC64593A {
    static int m, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            m = scanner.nextInt();
            x = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        x %= m;
        if (x == 0) {
            x = m;
        }
        return String.valueOf(x);
    }
}
/*
牛客周赛 Round 11
小美的外卖订单编号
https://ac.nowcoder.com/acm/contest/64593/A

题目描述
美团商家的订单发起时，订单编号最开始从 1 开始，后续每发起一个订单，订单编号便在上一订单编号的基础上 +1。为了防止订单号过大，商家还可以设置一个编号上限 m，当订单编号超过 m 时，将又从 1 开始编号。
小美想知道，当订单编号上限为 m 时，第 x 个订单编号是多少？将有 q 次询问。
输入描述:
第一行输入一个整数 q(1≤q≤50000)。
接下来 q 行，每行两个整数 m,x(1≤m,x≤10^9)。
输出描述:
q 行，每行一个整数表示答案。

取余，余为 0 则为 m。
======

示例1
输入
4
2 3
5 17
8 2
4 4
输出
1
2
2
4
 */