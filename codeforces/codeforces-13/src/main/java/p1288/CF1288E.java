package p1288;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1288E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] mn = new int[n];
        int[] mx = new int[n];
        int[] pos = new int[n];
        BIT tr = new BIT(m + n);

        for (int i = 0; i < n; i++) {
            mn[i] = i;
            mx[i] = i;
            pos[i] = m + i;
            tr.add(m + i, 1);
        }

        for (int i = m - 1; i >= 0; i--) {
            int v = scanner.nextInt() - 1;
            mn[v] = 0;
            int old = pos[v];
            pos[v] = i;
            mx[v] = Math.max(mx[v], tr.pre(old));
            tr.add(old, -1);
            tr.add(i, 1);
        }

        for (int i = 0; i < n; i++) {
            out.println((mn[i] + 1) + " " + (Math.max(mx[i], tr.pre(pos[i])) + 1));
        }
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            // 注意做了++处理
            for (pos++; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
E. Messenger Simulator
https://codeforces.com/contest/1288/problem/E

灵茶の试炼 2025-09-11
题目大意：
输入 n m(1≤n,m≤3e5) 和长为 m 的数组 a(1≤a[i]≤n)。
你的近期聊天列表有 n 个好友，从上到下依次为 1 到 n。
你会依次接收到 m 条消息，记录在数组 a 中。
其中 a[i] 表示好友 a[i] 给你发了消息，这会导致好友 a[i] 移到列表的最上面，其余人下移一位。
对于每个好友 x=1,2,3,...,n，输出在这个过程中（包括开始和结束），x 在列表中的最小位置和最大位置。位置从 1 到 n。

rating 2000
直接删除元素、插在最前面的话，我们会把一段元素整体右移，复杂度太高。
能不能不右移呢？
想象有 m+n 个座位排成一行，一开始所有人都坐在最右边的 n 个座位上。
如果我们收到了某个人发来的消息，就把这个人移到前 m 个座位中。
由于收到消息的时间越靠后，这个人就越应该出现在前面，所以收到第 j 条消息等价于：把 a[j] 这个人移到第 m-j+1 个座位上。（编号从 1 开始）
比如最后一条消息对应的人，要坐到第 1 个座位上。
一个人的名次，就是在他左边的人的个数加一（加上这个人自己）。
座位上没人视作 0，有人视作 1。名次就是前缀和。
用树状数组维护这些 0 和 1。
座位 i 坐了人，就把 i 加一（变成 1），如果人从座位 i 离开，就把 i 减一（变成 0）。
所以还需要记录每个人现在坐在哪。
最小值：如果 i 没有出现在消息中，那么答案为 i，否则答案为 1。
最大值：当 i 移到左边的座位之前，计算 i 及其左边的人数，更新最大值。以及，处理完所有消息后，计算 i 及其左边的人数，更新最大值。
代码 https://codeforces.com/problemset/submission/1288/336077607
代码备份（上面打不开的同学看这个）
======

Input
5 4
3 5 1 4
Output
1 3
2 5
1 4
1 5
1 5

Input
4 3
1 2 4
Output
1 3
1 2
3 4
1 4
 */
