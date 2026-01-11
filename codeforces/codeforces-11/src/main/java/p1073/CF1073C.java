package p1073;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Function;

public class CF1073C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int[][] dirs = new int[128][];

    static {
        dirs['L'] = new int[]{-1, 0};
        dirs['R'] = new int[]{1, 0};
        dirs['D'] = new int[]{0, -1};
        dirs['U'] = new int[]{0, 1};
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();
        int tx = scanner.nextInt();
        int ty = scanner.nextInt();

        int sd = Math.abs(tx) + Math.abs(ty);
        if (n < sd || n % 2 != sd % 2) {
            out.print(-1);
            return;
        }

        int[][] sum = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            char b = s.charAt(i);
            sum[i + 1][0] = sum[i][0] + dirs[b][0];
            sum[i + 1][1] = sum[i][1] + dirs[b][1];
        }

        int ans = sortSearch(n, sz -> {
            for (int i = sz; i <= n; i++) {
                if (Math.abs(sum[i - sz][0] + sum[n][0] - sum[i][0] - tx) +
                        Math.abs(sum[i - sz][1] + sum[n][1] - sum[i][1] - ty) <= sz) {
                    return true;
                }
            }
            return false;
        });
        out.println(ans);
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
C. Vasya and Robot
https://codeforces.com/contest/1073/problem/C

灵茶の试炼 2025-09-03
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含 UDLR，表示上下左右。
然后输入 x y(-1e9≤x,y≤1e9)。
一个机器人一开始在原点，从左到右读取 s 中的指令，目标是移动到 (x,y)。每次只能移动一个单位长度。
你可以修改 s 中的某些指令为其他方向。注意是修改，不是删除。
设修改的指令的最大下标为 r，最小下标为 l，则修改范围长度为 r-l+1。
特别地，如果不修改，则修改范围长度为 0。
输出最小的修改范围长度。
如果无法做到，输出 -1。

rating 1800
设原点到 (x,y) 的曼哈顿距离为 D，那么必要条件是 n >= D 且 n 和 D 的奇偶性相同。若不满足则输出 -1。
如果能修改的范围为 m 时不满足要求，那么范围 < m 同样无法满足要求；如果能修改的范围为 m 时满足要求，那么范围 > m 同样可以满足要求。
所以可以二分猜答案。
然后用前缀和或者定长滑窗解决。
先去掉修改的范围，计算机器人的位置到 (x,y) 的曼哈顿距离 d。
如果 d <= mid，说明我们可以通过修改移动到 (x,y)，否则不行。
代码 https://codeforces.com/contest/1073/submission/335229309
代码备份（上面打不开的同学看这个）
======

Input
5
RURUU
-2 3
Output
3

Input
4
RULR
1 1
Output
0

Input
3
UUU
100 100
Output
-1
 */
