package p1857;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1857D {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o] - b[o]));

        int lastId = ids[n - 1];
        int delta = a[lastId] - b[lastId];
        List<Integer> ans = new ArrayList<>();
        ans.add(lastId + 1);
        for (int i = n - 2; i >= 0; i--) {
            int id = ids[i];
            if (a[id] - b[id] == delta) {
                ans.add(id + 1);
            }
        }

        return ans.size() + System.lineSeparator()
                + ans.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Strong Vertices
https://codeforces.com/contest/1857/problem/D

题目大意：
给定两个数组 a 和 b，长度都是 n。两个数组中从 1 到 n 的元素。你正在构造一个有向图，当 au−av≥bu−bv 时，存在从 u 到 v 的边(u≠v)。
如果存在从顶点 V 到所有其他顶点的路径，则顶点 V 称为强顶点。
有向图中的路径是由几个顶点组成的链，由边连接起来，这样从顶点 u 开始，沿着边的方向移动，就可以到达顶点 v。
你的任务是找出所有强顶点。
例如，如果 a=[3,1,2,4]， b=[4,3,2,1]，则图将看起来像这样:
au−av≥bu−bv

移项 au-bu >= av-bv
======

input
5
4
3 1 2 4
4 3 2 1
5
1 2 4 1 2
5 2 3 3 1
2
1 2
2 1
3
0 2 1
1 3 2
3
5 7 4
-2 -3 -6
output
1
4
2
3 5
1
2
3
1 2 3
2
2 3
 */
