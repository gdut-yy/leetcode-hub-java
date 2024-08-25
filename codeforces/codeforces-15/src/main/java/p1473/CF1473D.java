package p1473;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1473D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.next();

            // 预处理
            pretreatment(n, s);

            for (int i = 0; i < m; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(solve(l, r));
            }
        }
    }

    private static Node[] pre;
    private static Node[] suf;

    private static void pretreatment(int n, String s) {
        // 前后缀分解
        pre = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            pre[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            pre[i + 1].cur = pre[i].cur + (ch == '+' ? 1 : -1);
            pre[i + 1].max = Math.max(pre[i].max, pre[i + 1].cur);
            pre[i + 1].min = Math.min(pre[i].min, pre[i + 1].cur);
        }

        suf = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            suf[i] = new Node();
        }
        for (int i = n - 1; i >= 1; i--) {
            char ch = s.charAt(i);
            suf[i].cur = suf[i + 1].cur - (ch == '+' ? 1 : -1);
            suf[i].max = Math.max(suf[i + 1].max, suf[i].cur);
            suf[i].min = Math.min(suf[i + 1].min, suf[i].cur);
        }
    }

    private static class Node {
        int cur, min, max;
    }

    private static String solve(int l, int r) {
        Node p = pre[l - 1];
        Node s = suf[r];
        int max = Math.max(p.max, p.cur + (s.max - s.cur));
        int min = Math.min(p.min, p.cur + (s.min - s.cur));
        return String.valueOf(max - min + 1);
    }
}
/*
D. Program
https://codeforces.com/contest/1473/problem/D

灵茶の试炼 2023-04-12
题目大意：
输入 t(≤1e3) 表示 t 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(≤2e5) m(≤2e5) 和长为 n 的字符串 s，仅包含 '+' 和 '-'，分别表示 +1 和 -1，下标从 1 开始。
然后输入 m 个询问，每个询问输入 L 和 R，表示区间 [L,R] (1≤L≤R≤n)。
把从 s[L] 到 s[R] 的这段子串去掉后，s 的剩余部分记作 t。
对于数字 x=0，逐个执行 t 中的字符，输出你能得到多少个不同的数字。
例如 t="+--"，那么 x 分别为 0,1,0,-1，一共有 3 个不同的数字，输出 3。
又例如 t=""，那么只有 0，输出 1。
每个询问互相独立。

rating 1700
https://codeforces.com/contest/1473/submission/201614540
提示 1：前后缀分解，预处理从左往右、从右往左的信息。只需要记录哪些信息？
提示 2：
从左往右，需要知道：
- 当前 x，记作 cur。；
- x 的历史最大值，记作 max。
- x 的历史最小值，记作 min。
记录到数组 pre 中。
从右往左，由于需要拼接在某个 pre 之后，当前 x 的值是不重要的，重要的是：
- x 的历史最大值减去当前 x 的值，记作 up。换句话说，拼接的那个值可以增大多少。
- x 的历史最小值减去当前 x 的值，记作 down。换句话说，拼接的那个值可以减小多少。
记录到数组 suf 中。
把某个 pre 和某个 suf 拼接后：
最大值 = max(pre.max, pre.cur + suf.up)
最小值 = min(pre.min, pre.cur + suf.down)
不同 x 的个数 = 最大值 - 最小值 + 1
======

input
2
8 4
-+--+--+
1 8
2 8
2 5
1 1
4 10
+-++
1 1
1 2
2 2
1 3
2 3
3 3
1 4
2 4
3 4
4 4
output
1
2
4
4
3
3
4
2
3
2
1
2
2
2
 */
