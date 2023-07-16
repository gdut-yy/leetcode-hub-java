package c310;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc310_d {
    static int n, t, m;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        t = scanner.nextInt();
        m = scanner.nextInt();
        ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = scanner.nextInt() - 1;
            ab[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc310/editorial/6804
    private static String solve() {
        // 1≤Ai<Bi≤N (1≤i≤M)
        int[] hate = new int[n];
        for (int[] p : ab) {
            int a = p[0], b = p[1];
            hate[b] |= 1 << a;
        }

        // possible_team[S] := The team with players in S does not have an incompatible pair
        // O(2^N N^2/w) time
        boolean[] possibleTeam = new boolean[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            int m = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    m |= hate[j];
                }
            }
            if ((i & m) == 0) {
                possibleTeam[i] = true;
            }
        }

        // f[s][t] 表示玩家的划分方式为数量 s 进入 t 队，不要将不兼容的球员放入一支球队
        long[][] f = new long[1 << n][t + 1];
        f[0][0] = 1;
        for (int i = 0; i < 1 << n; i++) {
            // brute-force over all possible teams that the remaining player with the minimum integer belongs
            for (int c = i + 1 | i, j = c; j < 1 << n; j = j + 1 | c) {
//                System.out.println("i=" + Integer.toBinaryString(i) + ",j=" + Integer.toBinaryString(j));
                if (possibleTeam[j ^ i]) {
                    for (int k = 0; k < t; k++) {
                        f[j][k + 1] += f[i][k];
                    }
                }
            }
        }
        return String.valueOf(f[(1 << n) - 1][t]);
    }
}
/*
D - Peaceful Teams
https://atcoder.jp/contests/abc310/tasks/abc310_d

题目大意：
有 N 个运动员。
其中，有 M 对不相容。第 i 对不相容的玩家(1≤i≤M)为第 i 位玩家 A 和第 i 位玩家 B。
你将球员分成 T 组。每个球员必须只属于一个队，每个队必须有一个或多个球员。此外，对于每个 i=1,2,...,M, Ai-th 和 Bi-th 球员不能属于同一个队。
找出满足这些条件的方法的个数。在这里，当两名球员在一个赛区属于同一支球队，而在另一个赛区属于不同的球队时，两个赛区被认为是不同的。

设 dp[S][t]:=(将 S 中的玩家分成 t 个小组而不将不相容的玩家分成一个小组的方法的数量)。
DP 表可以按照 S 的升序扫描 DP (Dynamic Programming)表(考虑为一个非负的 2 进制整数)，并强制选择{1,2,...,N}∈S 中最小整数对应的队员，来填充 DP 表。(也可以使用记忆递归)。
通过在总共 O(2^N poly(N)))时间内预先枚举不存在不相容配对的可能队伍，其复杂度为 O(T*3^N)。
======

Input 1
5 2 2
1 3
3 4
Output 1
4

Input 2
5 1 2
1 3
3 4
Output 2
0

Input 3
6 4 0
Output 3
65

Input 4
10 6 8
5 9
1 4
3 8
1 6
4 10
5 7
5 6
3 7
Output 4
8001
 */