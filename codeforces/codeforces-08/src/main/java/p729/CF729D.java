package p729;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF729D {
    static int n, a, b, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') continue;
            // 分组循环
            int st = i;
            for (i++; i < n && s[i] == '0'; i++) {
            }
            for (st += b - 1; st < i; st += b) {
                pos.add(st);
            }
        }
        pos = pos.subList(a - 1, pos.size());
        return pos.size() + System.lineSeparator() +
                pos.stream().map(i -> i + 1).map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Sea Battle
https://codeforces.com/contest/729/problem/D

灵茶の试炼 2022-09-06
题目大意：
输入 n (≤2e5) a b (1≤a,b≤n) k (0≤k≤n-1) 和一个长为 n 的字符串 s，只包含 0 和 1，且恰好有 k 个 1。
有 n 个格子排成一行，里面有 a 艘船，每艘船占据连续 b 个格子。两艘船不会占据同一个格子。
现在已经为你揭露了 k 个没有船的格子，用字符串 s 中的 1 表示（0 表示尚未揭露的格子）。
你可以发射炮弹，一次可以揭露一个格子。
输出保证射中一艘船，至少需要发射的次数和具体射击的格子编号（从 1 开始）。如果发射方案有多种，输出任意一种。
保证答案存在。

rating 1700
https://codeforces.com/contest/729/submission/171022830
提示 1：【跳跃性思维】射中所有船，需要发射多少次？
提示 2：对于一串连续的 0，我们可以从第 b 个格子开始，每 b 个格子发射一次。
提示 3：由于只需要射中一艘船，可以少发射 a-1 次。
======

input
5 1 2 1
00100
output
2
4 2

input
13 3 2 3
1000000010001
output
2
7 11
 */
