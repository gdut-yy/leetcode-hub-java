package c248;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc248_d {
    static int n;
    static int[] a;
    static int q;
    static int[][] lrx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        lrx = new int[q][3];
        for (int i = 0; i < q; i++) {
            lrx[i][0] = scanner.nextInt();
            lrx[i][1] = scanner.nextInt();
            lrx[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(a[i], e -> new ArrayList<>()).add(i);
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = lrx[i][0] - 1, r = lrx[i][1] - 1, x = lrx[i][2];
            List<Integer> list = pos.get(x);
            if (list == null) continue;
            ans[i] = searchInts(list, r + 1) - searchInts(list, l);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

}
/*
D - Range Count Query
https://atcoder.jp/contests/abc248/tasks/abc248_d

灵茶の试炼 2023-09-18
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)，下标从 1 开始。
然后输入 q 个询问，每个询问输入 L R (1≤L≤R≤n) 和 x(1≤x≤n)。
对每个询问，输出有多少个下标 i 在 [L,R] 内的 a[i]，满足 a[i]=x。

遍历 a，把相同元素 x 的所有下标统计到列表 pos[x] 中。
每个询问的答案就是 <= R 的下标个数，减去 < L 的下标个数。
在 pos[x] 中二分查找即可算出。
https://atcoder.jp/contests/abc248/submissions/45034624
离线做法可以做到线性时间复杂度，见右图。@田永杰
======

Input 1
5
3 1 4 1 5
4
1 5 1
2 4 3
1 5 2
1 3 3
Output 1
2
0
0
1
 */