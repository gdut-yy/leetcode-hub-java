package c306;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc306_d {
    static int n;
    static int[] x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long[][] memo;

    private static String solve() {
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = dfs(0, 0);
        return String.valueOf(ans);
    }

    // state：0:健康 1:不舒服 2:die
    private static long dfs(int i, int state) {
        if (i == n) {
            return 0;
        }
        if (memo[i][state] != -1) {
            return memo[i][state];
        }

        long res;
        // 胃不舒服 && 食物有毒
        if (state == 1 && x[i] == 1) {
            // 不能吃
            res = dfs(i + 1, 1);
        } else {
            // 可吃可不吃
            res = Math.max(dfs(i + 1, state), dfs(i + 1, x[i]) + y[i]);
        }
        return memo[i][state] = res;
    }
}
/*
D - Poisonous Full-Course
https://atcoder.jp/contests/abc306/tasks/abc306_d

题目大意：
高桥决定在一家餐厅享用由 N 道菜组成的有线全餐。
第一个课程是:
如果 Xi=0，解毒过程的美味度为 Yi;
如果 Xi=1，一种有毒的食物的味道是 Yi。
当 Takahashi 吃一道菜时，他的状态变化如下:
- 起初，高桥有一个健康的胃。
- 当他的胃健康时
  - 如果他吃解毒剂，他的胃就会保持健康;
  - 如果他吃了有毒的食物，他的胃就会不舒服。
- 当他胃不舒服时，
  - 如果他吃解毒药，他的胃就会变得健康;
  - 如果他吃了有毒的食物，他就会死。
用餐过程如下。
对 i=1,...,N 按此顺序重复以下过程。
- 第一道菜是给高桥上的。
- 接下来，他选择是“吃”还是“跳过”这门课。
  - 如果他选择“吃”它，他吃第 i 道菜。他的状态也会随着他吃的食物而变化。
  - 如果他选择“跳过”，他就不吃第 i 道菜。这道菜不能晚上，也不能留。
- 最后，(如果他的状态改变了，在改变之后)如果他没有死，
  - 如果 i=N，他继续下一道菜。
  - 如果 i=N，他会活着走出餐馆。
有一个重要的会议等着他，所以他必须活着离开那里。
在这种情况下，当他决定是“吃”还是“跳过”这些课程时，求出他所吃的课程的最大可能的美味总和(如果他什么都不吃，则为 0)。

记忆化搜索
======

Input 1
5
1 100
1 300
0 -200
1 500
1 300
Output 1
600

Input 2
4
0 -1
1 -2
0 -3
1 -4
Output 2
0

Input 3
15
1 900000000
0 600000000
1 -300000000
0 -700000000
1 200000000
1 300000000
0 -600000000
1 -900000000
1 600000000
1 -100000000
1 -400000000
0 900000000
0 200000000
1 -500000000
1 900000000
Output 3
4100000000
 */