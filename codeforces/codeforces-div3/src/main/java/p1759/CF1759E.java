package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CF1759E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, h, a));
        }
    }

    private static int[] A;

    private static String solve2(int n, int h, int[] a) {
        Arrays.sort(a);
        A = a;
        return String.valueOf(dfs(0, h, 2, 1));
    }

    private static long dfs(int pos, long power, int green, int blue) {
        if (pos == A.length) {
            return 0;
        }

        if (power > A[pos]) {
            return dfs(pos + 1, power + A[pos] / 2, green, blue) + 1;
        } else {
            long max = 0L;
            if (green > 0) {
                max = Math.max(max, dfs(pos, power * 2, green - 1, blue));
            }
            if (blue > 0) {
                max = Math.max(max, dfs(pos, power * 3, green, blue - 1));
            }
            return max;
        }
    }

    private static String solve(int n, int h, int[] a) {
        Arrays.sort(a);

        Queue<long[]> queue = new LinkedList<>();
        // pos, 能量, 绿色血清, 蓝色血清
        queue.add(new long[]{0, h, 2, 1});
        int max = 0;
        while (!queue.isEmpty()) {
            long[] tuple = queue.remove();
            int pos = (int) tuple[0];
            long power = tuple[1];
            long green = tuple[2];
            long blue = tuple[3];

            max = Math.max(max, pos);
            if (max == n) {
                return String.valueOf(max);
            }

            if (power > a[pos]) {
                queue.add(new long[]{pos + 1, power + a[pos] / 2, green, blue});
                continue;
            }
            if (green > 0) {
                queue.add(new long[]{pos, power * 2, green - 1, blue});
            }
            if (blue > 0) {
                queue.add(new long[]{pos, power * 3, green, blue - 1});
            }
        }
        return String.valueOf(max);
    }
}
/*
E. The Humanoid
https://codeforces.com/contest/1759/problem/E

题目大意：
给定整数 n,h 和长度为 n 的数组 a。人形机器人可以做出以下 3 种动作中的 1 种：
- 吸收一个严格小于它的宇航员能量的 一半
- 使用绿色血清，体力*2
- 使用蓝色血清，体力*3
初始有 2 个绿色血清和 1 个蓝色血清

贪心，宇航员能量从小到大吸收，且尽可能晚用血清。
注意爆 int
======

input
8
4 1
2 1 8 9
3 3
6 2 60
4 5
5 1 100 5
3 2
38 6 3
1 1
12
4 6
12 12 36 100
4 1
2 1 1 15
3 5
15 1 13

output
4
3
3
3
0
4
4
3
 */