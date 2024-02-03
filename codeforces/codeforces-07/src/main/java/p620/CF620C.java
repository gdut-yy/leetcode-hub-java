package p620;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF620C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int st = i;
            Set<Integer> vis = new HashSet<>();
            for (; i <= n; i++) {
                if (vis.contains(a[i])) {
                    break;
                }
                vis.add(a[i]);
            }
            if (i > n) {
                if (ans.isEmpty()) {
                    return "-1";
                }
                ans.get(ans.size() - 1)[1] = n;
            } else {
                ans.add(new int[]{st, i});
            }
        }

        return ans.size() + System.lineSeparator() +
                ans.stream().map(o -> o[0] + " " + o[1])
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C. Pearls in a Row
https://codeforces.com/contest/620/problem/C

灵茶の试炼 2023-12-12
题目大意：
输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
把 a 划分成尽量多的段，使得每一段都有重复数字。
如果无法做到，输出 -1。
否则，输出的第一行是段数 k，然后输出 k 行，表示每一段的开始和结束下标（下标从 1 开始）。
可以按任意顺序输出这些段。

rating 1500
首先，如果没有重复数字，输出 -1。
然后考虑 分组循环
从左到右遍历，只要发现在当前这段出现过的数，就立刻分割，因为留给后面的数字越多，分出的段数就越多。
如果最后一段没有重复数字，就合并到前一段。
https://codeforces.com/contest/620/submission/235734147
======

input
5
1 2 3 4 1
output
1
1 5

input
5
1 2 3 4 5
output
-1

input
7
1 2 1 3 1 2 1
output
2
1 3
4 7
 */
