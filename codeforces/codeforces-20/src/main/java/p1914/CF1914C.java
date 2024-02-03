package p1914;

import java.util.Scanner;

public class CF1914C {
    static int n, k;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        int s = 0;
        int maxBi = 0;
        for (int i = 0; i < n && i < k; i++) {
            s += a[i];
            maxBi = Math.max(maxBi, b[i]);
            // 前 i+1 个数和为 s, 加上 k-(i+1) 个 bi
            int tot = s + (k - i - 1) * maxBi;
            ans = Math.max(ans, tot);
        }
        return String.valueOf(ans);
    }
}
/*
C. Quests
https://codeforces.com/contest/1914/problem/C

题目大意：
Monocarp 正在玩电脑游戏。为了升级角色，他可以完成任务。游戏中有 n 个任务，编号从 1 到 n。
Monocarp 可以根据以下规则完成任务:
- 第 1 个任务总是可以完成的;
- 如果所有任务 j<i 已经至少完成一次，则第 i-th 任务可以完成。注意，Monocarp 可以多次完成相同的任务。
每次完成任务，角色都会获得一定数量的经验值:
- 对于第一次完成任务，他将获得 ai 经验值;
- 之后每完成 i-th 个任务，他将获得 bi 点经验值。
Monocarp 是一个非常忙碌的人，所以他有空闲时间完成不超过 k 个任务。你的任务是计算 Monocarp 在完成不超过 k 个任务的情况下所能获得的最大经验值。

贪心。
======

input
4
4 7
4 3 1 2
1 1 1 1
3 2
1 2 5
3 1 8
5 5
3 2 4 1 4
2 3 1 4 7
6 4
1 4 5 4 5 10
1 5 1 2 5 1
output
13
4
15
15
 */
