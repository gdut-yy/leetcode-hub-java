package nc60456;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NC60456C {
    static int n;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[8];
        for (int[] p : ab) {
            int a = p[0], b = p[1] - 1;

            if (a == 0) {
                int max = Math.max(ans[b], ans[b + 1]);
                ans[b] = max + 3;
                ans[b + 1] = max + 1;
            } else if (a == 90) {
                int max = Math.max(ans[b] + 1, Math.max(ans[b + 1], ans[b + 2]));
                ans[b] = max + 1;
                ans[b + 1] = max + 1;
                ans[b + 2] = max + 1;
            } else if (a == 180) {
                int max = Math.max(ans[b], ans[b + 1] + 2);
                ans[b] = max + 1;
                ans[b + 1] = max + 1;
            } else {
                int max = Math.max(ans[b], Math.max(ans[b + 1], ans[b + 2]));
                ans[b] = max + 1;
                ans[b + 1] = max + 1;
                ans[b + 2] = max + 2;
            }
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
小红的俄罗斯方块
https://ac.nowcoder.com/acm/contest/60456/C

题目描述
小红正在玩一个奇怪的俄罗斯方块游戏。已知这个俄罗斯方块只有以下一种图形：
这个图形可以顺时针不旋转，旋转 90 度、180 度、270 度，分别变成以下四种情况：
当图形无法下落的时候，会停住不动。
请注意，这个俄罗斯方块没有消除的情况。也就是说会越累积越高。
假设游戏共有 8 列，高度是无限的。请你输出最终每一列的高度。
输入描述:
第一行输入方块的数量 n。
接下来的 n 行，每行输入两个正整数 a 和 b，分别代表方块旋转的角度以及从哪一列下落的。方块是顺序下落的，也就是说前一个方块落到底之前，后一个方块不会开始下落。
1≤n≤100
a 一定是 0、90、180、270 四个中的一个，b 代表方块的左端那一列，保证右端不会超过 8。也就是说，若 a 为 0 或 180，1≤b≤7；若 a 为 90 或 270，1≤b≤6
输出描述:
输出 8 个正整数，分别代表最终 8 列的高度。

贪心。
======

示例1
输入
3
0 1
90 2
180 4
输出
3 3 3 4 4 0 0 0
 */
