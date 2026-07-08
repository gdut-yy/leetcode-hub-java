package p2200;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2200E {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = 1000001;
    static int[] lpf = new int[mx];

    static {
        lpf[1] = 1;
        for (int i = 2; i < mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j < mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        boolean win = false;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            int v = a[i];
            int p = lpf[v];
            while (v > 1 && v % p == 0) {
                v /= p;
            }
            if (v > 1) {
                win = true;
            } else {
                b[i] = p;
            }
        }
        if (isSorted(a) || !win && isSorted(b)) {
            out.println("Bob");
        } else {
            out.println("Alice");
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
/*
E. Divisive Battle
https://codeforces.com/contest/2200/problem/E

灵茶の试炼 2026-05-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
Alice 和 Bob 玩游戏。Alice 先手。
在任意时刻，如果 a 是递增的（a[i] <= a[i+1]），或者 a 中没有合数，游戏立即结束。
每回合，当前玩家执行如下三步：
1. 从 a 中选择一个合数 x。
2. 把 x 拆分成两个在 [2, x-1] 中的整数 y 和 z，满足 x = y * z。注：y 和 z 可以不在 a 中。
3. 把 x 原地替换成 y 和 z。（操作后，a 的长度增加 1）
游戏结束时，如果 a 是递增的，Bob 赢，否则 Alice 赢。
如果双方都采取最优策略，谁会赢？
输出 Alice 或 Bob。

rating 1500
如果一开始 a 就是递增的，Bob 直接赢。
否则，如果某个 a[i] 包含至少两个不同的质因子，那么 Alice 只需把 a[i] 最小的质因子拆出来，放在右边，即可让 a 非递增。Alice 赢。
还有什么情况 Alice 会赢？
如果每个 a[i] 都只有一个质因子（或者 a[i]=1），例如 a=[9,16,25,5]，那么 Alice 找到比左边质因子小的那个质因子，拆出来，放在右边。例如 16=8*2，数组变成 [9,8,2,25,5]，由于 9 无法拆出 <= 2 的数，所以 a 无法变成递增的。
但如果 a 的质因子是递增的，例如 a=[16,9,25]，无论 Alice 怎么操作，总是可以得到一个递增的数组。
综上所述，有两种情况 Bob 赢：
1. 一开始 a 就是递增的。
2. 每个 a[i] 都只有一个质因子 b[i]（没有质因子时 b[i]=1），且 b 是递增的。
其余情况 Alice 赢。
预处理 LPF 可以快速判断 a[i] 是否只有一个质因子。
代码 https://codeforces.com/contest/2200/submission/374145953
代码备份（上面打不开的同学看这个）
======

Input
4
10
10 9 8 7 6 5 4 3 2 1
3
1 8192 677
2
6 5
2
6 7
Output
Alice
Bob
Alice
Bob
 */
