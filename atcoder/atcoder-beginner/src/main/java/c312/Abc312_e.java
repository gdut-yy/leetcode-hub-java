package c312;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Abc312_e {
    static int n;
    static int[][][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[105][105][105];
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int z2 = scanner.nextInt();
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    for (int z = z1; z < z2; z++) {
                        a[x][y][z] = i + 1;
                    }
                }
            }
        }
        System.out.println(solve());
    }

    static List<Set<Integer>> ans;

    private static String solve() {
        ans = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            ans.add(new HashSet<>());
        }

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                for (int z = 0; z < 100; z++) {
                    if (a[x][y][z] != 0) {
                        if (a[x + 1][y][z] != 0 && a[x + 1][y][z] != a[x][y][z]) {
                            add(a[x][y][z], a[x + 1][y][z]);
                        }
                        if (a[x][y + 1][z] != 0 && a[x][y + 1][z] != a[x][y][z]) {
                            add(a[x][y][z], a[x][y + 1][z]);
                        }
                        if (a[x][y][z + 1] != 0 && a[x][y][z + 1] != a[x][y][z]) {
                            add(a[x][y][z], a[x][y][z + 1]);
                        }
                    }
                }
            }
        }

        String[] output = new String[n];
        for (int i = 1; i <= n; i++) {
            output[i - 1] = String.valueOf(ans.get(i).size());
        }
        return String.join(System.lineSeparator(), output);
    }

    static void add(int i, int j) {
        ans.get(i).add(j);
        ans.get(j).add(i);
    }
}
/*
E - Tangency of Cuboids
https://atcoder.jp/contests/abc312/tasks/abc312_e

题目大意：
三维空间中有 N 个长方体。
这些长方体不重叠。形式上，对于其中任意两个不同的长方体，它们的交点体积为 0。
第 i 长方体的对角线是连接两点(Xi,1, Yi,1, Zi,1)和(Xi,2, Yi,2, Zi,2)的线段，它的边都平行于其中一个坐标轴。
对于每个长方体，找出与它共享一个面的其他长方体的个数。
形式上，对于每一个 i，求出 1≤j≤N 且 j- r =i 使得第 i 个长方体和第 j 个长方体的曲面相交的面积为正的 j 个数。

https://atcoder.jp/contests/abc312/editorial/6863
设 M 为最大绝对坐标。在我们的约束条件下，M=100。
对于整数元组(i,j,k)，我们用“cube (i,j,k)”来表示这个立方体，它的对角线是连接两点(i,j,k)和(i+1,j+1,k+1)的线段。如果我们不关心它的坐标，我们就称它为“立方体”。
当且仅当长方体 i 中的一个立方体和长方体 j 中的另一个立方体在三个方向上相邻时，两个长方体 i 和 j 共用一个表面。
因此，检查所有的正方体对而不是长方体对就足够了。具体可求解如下:
准备一个 M×M×M 数组。对于每一个 0≤i,j,k<M，记录哪些长方体包含立方体(i,j,k)。
对于所有立方体，检查哪些长方体包含立方体本身和相邻立方体，并在一个集合中维护结果(相邻长方体对)。
有 O(m^3)个立方体，每个立方体最多有 6 个相邻立方体，因此检查所有相邻立方体对总共需要 O(m^3)个。如果我们使用集合或数组+唯一来维护结果，则可以在总共 O(m^3 logN)时间内找到答案。如果您使用哈希集，它将减少到预期的 O(m^3)时间。
======

Input 1
4
0 0 0 1 1 1
0 0 1 1 1 2
1 1 1 2 2 2
3 3 3 4 4 4
Output 1
1
1
0
0

Input 2
3
0 0 10 10 10 20
3 4 1 15 6 10
0 9 6 1 20 10
Output 2
2
1
1

Input 3
8
0 0 0 1 1 1
0 0 1 1 1 2
0 1 0 1 2 1
0 1 1 1 2 2
1 0 0 2 1 1
1 0 1 2 1 2
1 1 0 2 2 1
1 1 1 2 2 2
Output 3
3
3
3
3
3
3
3
3
 */