package p576;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF576A {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        boolean[] notPrime = new boolean[n + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (notPrime[i]) continue;
            for (int v = i; v <= n; v *= i) {
                ans.add(v);
            }
            for (int j = i * i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
A. Vasya and Petya's Game
https://codeforces.com/contest/576/problem/A

灵茶の试炼 2024-05-14
题目大意：
输入 n(1≤n≤1000)。
A 和 B 玩一个猜数字游戏。
A 心中想一个在 [1,n] 中的数字 x。
B 去猜 x 是多少。
猜测方法：B 一次性询问所有要询问的数，A 对于每个询问的数 y，回答 x 能否被 y 整除。
B 至少要询问多少个数，才能保证可以猜出数字 x？
输出询问的数字个数，以及具体询问了哪些数。
注意：B 知道 n 是多少。
变形：如果可以一次一次地问呢？

rating 1500
[1,n] 中的质数是肯定要问的。
根据算术基本定理，x = p1^e1 * p2^e2 * ...
知道质数还不够，还需要确定这些质数的幂次 e1,e2，才能确定 x。
所以需要猜的数字是 [1,n] 中的质数，以及这些质数的平方、立方、……（不超过 n）。
https://codeforces.com/contest/576/submission/260862354
======

Input
4
Output
3
2 4 3

Input
6
Output
4
2 4 3 5
 */
