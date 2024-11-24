package p1304;

import java.util.Scanner;

public class CF1304C {
    static int n, t;
    static int l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            t = scanner.nextInt();
            boolean ok = true;
            int ll = t, rr = t, pre = 0;
            for (; n > 0; n--) {
                t = scanner.nextInt();
                l = scanner.nextInt();
                r = scanner.nextInt();

                ll -= t - pre;
                rr += t - pre;
                if (l > rr || r < ll) {
                    ok = false;
                }
                ll = Math.max(ll, l);
                rr = Math.min(rr, r);
                pre = t;
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }

    private static String solve() {
        return "";
    }
}
/*
C. Air Conditioner
https://codeforces.com/contest/1304/problem/C

灵茶の试炼 2024-04-16
题目大意：
输入 T(≤500) 表示 T 组数据。
每组数据首先输入 n(1≤n≤100) t0(-1e9≤t0≤1e9)。
老兵烤肉今天要迎接 n 位顾客，在第 0 分钟，空调温度为 t0。
然后输入 n 行，第 i 行输入 t(1≤t≤1e9) low high(-1e9≤low≤high≤1e9)，表示第 i 名顾客会在第 t 分钟到达，这名顾客偏好的温度范围是闭区间 [low, high]。
保证 t 非递减，即第 i 名顾客的 t <= 第 i+1 名顾客的 t。
空调温度每分钟可以 +1 -1 或不变。
能否让所有顾客（仅在到店时刻）都对温度满意？输出 YES 或 NO。
反向问题：能否让所有顾客都对温度不满意？

rating 1500
初始空调温度区间为闭区间 [t0, t0]。
每过一分钟，空调可以达到的温度区间会从 [L,R] 变成 [L-1,R+1]。
计算 t 分钟时的温度区间（如果两名顾客之间相差 x 分钟，那么过了 x 分钟的温度区间是 [L-x,R+x]），如果空调温度区间与顾客的温度区间没有交集，输出 NO。
否则更新空调温度区间为交集。
https://codeforces.com/problemset/submission/1304/256438791
======

Input
4
3 0
5 1 2
7 3 5
10 -1 0
2 12
5 7 10
10 16 20
3 -100
100 0 0
100 -50 50
200 100 100
1 100
99 -100 0
Output
YES
NO
YES
NO
 */
