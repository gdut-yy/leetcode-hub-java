package p1848;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1848B {
    static int n, k;
    static int[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1848/submission/214075150
    private static String solve() {
        Map<Integer, List<Integer>> idListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idListMap.computeIfAbsent(c[i], key -> new ArrayList<>()).add(i + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (List<Integer> a : idListMap.values()) {
            a.add(n + 1);

            List<Integer> g = new ArrayList<>();
            g.add(a.get(0));
            for (int i = 1; i < a.size(); i++) {
                g.add(a.get(i) - a.get(i - 1));
            }
            g.sort(Comparator.reverseOrder());
            if (g.size() == 1) {
                ans = Math.min(ans, g.get(0) - 1);
                continue;
            }
            ans = Math.min(ans, Math.max((g.get(0) - 1) / 2, g.get(1) - 1));
        }
        return String.valueOf(ans);
    }
}
/*
B. Vika and the Bridge
https://codeforces.com/contest/1848/problem/B

题目大意：
在夏天，维卡喜欢参观她的乡村别墅。这里应有尽有:舒适的秋千、自行车和一条河。
河上有一座由 n 块木板组成的木桥。它很旧，没有吸引力，所以 Vika 决定粉刷它。在棚屋里，他们发现了 k 种颜色的油漆罐。
在把每块木板涂成 k 种颜色中的一种后，维卡准备去荡秋千，休息一下。然而，她意识到房子在河的另一边，油漆还没有完全干透，所以她还不能在桥上走。
为了不破坏桥的外观，维卡决定她仍然会在桥上行走，但只是踩在同样颜色的木板上。否则，她鞋底上的一小层油漆会破坏另一种颜色的木板。维卡还剩下一点油漆，但只够重新粉刷桥的一块木板。
现在维卡站在第一块木板前的地上。为了过桥，她会选择一些相同颜色的木板(重新粉刷后)，这些木板的编号为 1≤i1<i2<…<im≤n(木板从左到右编号为 1)。然后 Vika 必须穿过 i1 - 1,i2 - i1 - 1,i3 - i2 - 1，…，im - im - 1 - 1,n - im 块木板作为每 m+1 步的结果。
因为 Vika 害怕摔倒，所以她不想走太长的路。帮助她，并告诉她，如果她能在过桥时将一块(或零块)木板重新涂上不同的颜色，她在一步中必须通过的木板的最小可能的最大数量。

分类讨论
要么最大间隔/2，要么是次大间隔
======

input
5
5 2
1 1 2 1 1
7 3
1 2 3 3 3 2 1
6 6
1 2 3 4 5 6
8 4
1 2 3 4 2 3 1 4
3 1
1 1 1
output
0
1
2
2
0
 */
