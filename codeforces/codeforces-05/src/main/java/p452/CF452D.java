package p452;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF452D {
    static int k, n1, n2, n3, t1, t2, t3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        k = scanner.nextInt();
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        t1 = scanner.nextInt();
        t2 = scanner.nextInt();
        t3 = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int[] f1 = new int[n1];
        int[] f2 = new int[n2];
        int[] f3 = new int[n3];

        int finish = 0;
        for (int i = 0; i < k; i++) {
            finish = Math.max(Math.max(f1[i % n1] + t1 + t2 + t3, f2[i % n2] + t2 + t3), f3[i % n3] + t3);
            f1[i % n1] = finish - t2 - t3;
            f2[i % n2] = finish - t3;
            f3[i % n3] = finish;
        }
        return String.valueOf(finish);
    }
}
/*
D. Washer, Dryer, Folder
https://codeforces.com/contest/452/problem/D

灵茶の试炼 2023-06-22
题目大意：
输入 k (1≤k≤1e4) n1 n2 n3 t1 t2 t3 (1≤n1,n2,n3,t1,t2,t3≤1000)。
有 k 件衣服，每件都需要按照洗净 -> 烘干 -> 熨烫的顺序处理。
现在有 n1 个洗衣机，n2 个烘干机和 n3 个熨斗。
每个机器同时只能处理一件衣服，分别花费 t1, t2, t3 时间。
你必须将一件洗好的衣服立即烘干，烘干完毕后立即熨烫。
输出处理完所有衣服的最短时间。

rating 1900
https://codeforces.com/problemset/submission/452/210604954
题解 https://www.luogu.com.cn/blog/endlesscheng/solution-cf452d
======

input
1 1 1 1 5 5 5
output
15

input
8 4 3 2 10 5 2
output
32
 */
