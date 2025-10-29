package p2110;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2110C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        List<Integer> pos = new ArrayList<>();
        int h = 0;
        for (int i = 0; i < n; i++) {
            int d = a[i];
            if (d < 0) {
                pos.add(i);
                a[i] = 0;
            } else {
                h += d;
            }
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (a[0] < 0 || h > r || pos.size() < l - h) {
                a[0] = -1;
                continue;
            }
            if (l > h) {
                for (int j = 0; j < l - h; j++) {
                    a[pos.getLast()] = 1;
                    pos.removeLast();
                }
                h = l;
            }
            int k = Math.min(r - h, pos.size());
            // Time limit exceeded on test 13
//            pos = pos.subList(0, k);
            pos.subList(k, pos.size()).clear();
        }
        if (a[0] < 0) {
            out.println(-1);
            return;
        }
        out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
/*
C. Racing
https://codeforces.com/contest/2110/problem/C

灵茶の试炼 2025-07-08
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 d(-1≤d[i]≤1)。
然后输入 n 个闭区间 [li,ri]，范围 [0,n]。
你需要把数组 d 中的每个 -1 改成 0 或者 1。
然后计算 d 的前缀和数组 s（即 d 的前 i 个数之和），要求满足 li <= si <= ri。
输出任意一个符合要求的修改后的 d。
无解输出 -1。

rating 1400
用一个名为 pos 的栈（或者列表）保存遍历过的 -1 的下标，以备后用。
先把 -1 视作 0，后面再调整。
如果 d 的前 i 个数之和（当前高度）h > r，无解。
如果 h + len(pos) < l，也就是把所有 -1 都变成 1，仍然 < l，无解。
否则，如果 h < l，那么从 pos 中取出 l-h 个位置，变成 1。
此外，如果 len(pos) 太大，大到 h+len(pos) > r，那么有些 -1 一定要是 0。去掉 pos 中多余的下标，让 len(pos) = r-h。
代码 https://codeforces.com/contest/2110/submission/325078628
代码备份（Ubuntu Pastebin）
======

Input
5
4
0 -1 -1 1
0 4
1 2
2 4
1 4
3
0 -1 -1
0 1
2 2
0 3
2
-1 -1
0 0
2 2
8
-1 -1 1 -1 -1 0 0 -1
0 0
0 1
0 2
0 2
1 3
0 4
2 5
4 5
1
0
1 1
Output
0 1 1 1
-1
-1
0 1 1 0 1 0 0 1
-1
 */
