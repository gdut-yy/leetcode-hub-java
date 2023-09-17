package c310;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc310_b {
    static int n, m;
    static Node[] nodes;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].p = scanner.nextInt();
            int c = scanner.nextInt();
            for (int j = 0; j < c; j++) {
                int f = scanner.nextInt();
                nodes[i].set.add(f);
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            Node nodeI = nodes[i];
            for (int j = 0; j < n; j++) {
                Node nodeJ = nodes[j];
                if (nodeI.p >= nodeJ.p
                        && jContainsI(nodeI.set, nodeJ.set)
                        && (nodeI.p > nodeJ.p || nodeJ.set.size() > nodeI.set.size())) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean jContainsI(Set<Integer> setI, Set<Integer> setJ) {
        for (Integer i : setI) {
            if (!setJ.contains(i)) return false;
        }
        return true;
    }

    private static class Node {
        int p;
        Set<Integer> set = new HashSet<>();
    }
}
/*
B - Strictly Superior
https://atcoder.jp/contests/abc310/tasks/abc310_b

题目大意：
AtCoder Shop 有 N 种产品。第 i 个产品(1≤i≤N)的价格为 pi。第 i 个积(1≤i≤N)有 ci 个函数。第 i 个乘积(1≤i≤N)的第 j 个函数(1≤j≤ci)表示为整数 Fi,j 在 1 到 M 之间，包括 1 到 M。
高桥想知道是否有一种产品严格优于另一种产品。如果有 i 和 j(1≤i,j≤N)且第 i 和第 j 个乘积满足以下所有条件，打印 Yes;否则，打印 No。
- Pi≥Pj。
- 第 j 个乘积具有第 i 个乘积的所有函数。
- Pi>Pj，或者第 j 个乘积具有第 i 个乘积所没有的一个或多个函数。

暴力模拟
======

Input 1
5 6
10000 2 1 3
15000 3 1 2 4
30000 3 1 3 5
35000 2 1 5
100000 6 1 2 3 4 5 6
Output 1
Yes

Input 2
4 4
3 1 1
3 1 2
3 1 2
4 2 2 3
Output 2
No

Input 3
20 10
72036 3 3 4 9
7716 4 1 2 3 6
54093 5 1 6 7 8 10
25517 7 3 4 5 6 7 9 10
96930 8 2 3 4 6 7 8 9 10
47774 6 2 4 5 6 7 9
36959 5 1 3 4 5 8
46622 7 1 2 3 5 6 8 10
34315 9 1 3 4 5 6 7 8 9 10
54129 7 1 3 4 6 7 8 9
4274 5 2 4 7 9 10
16578 5 2 3 6 7 9
61809 4 1 2 4 5
1659 5 3 5 6 9 10
59183 5 1 2 3 4 9
22186 4 3 5 6 8
98282 4 1 4 7 10
72865 8 1 2 3 4 6 8 9 10
33796 6 1 3 5 7 9 10
74670 4 1 2 6 8
Output 3
Yes
 */