package lq240113;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240113T9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            p[i] = scanner.nextInt();
        }
        for (int i = 1; i <= k; ++i) {
            Pos[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; ++i) {
            Pos[p[i]].add(i);
        }
        for (int i = 1; i <= k; ++i) {
            s[i] = scanner.nextInt();
        }

        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < Pos[i].size(); ++j) {
                if (j - s[i] < 0) {
                    v[Pos[i].get(j)] = 0;
                } else {
                    v[Pos[i].get(j)] = Pos[i].get(j - s[i]);
                }
            }
        }
        Root[0] = ++idx;
        build(Root[0], 0, n + 1);

        for (int i = 1; i <= n; ++i) {
            Root[i] = ++idx;
            update(Root[i - 1], Root[i], v[i], 0, n + 1);
            // show(Root[i], 0, n + 1);
        }

        int ans = 0, l, r;
        while (m-- > 0) {
            l = (ans ^ scanner.nextInt());
            r = (ans ^ scanner.nextInt());
            ans = query(Root[r], 0, l - 1, 0, n + 1) - query(Root[l - 1], 0, l - 1, 0, n + 1);
            System.out.println(ans);
        }
    }

    static final int N = 100500;
    static int[] p = new int[N];
    static int[] s = new int[N];
    static int[] v = new int[N];
    static int[] Root = new int[N];
    static List<Integer>[] Pos = new ArrayList[N];
    static int[] L = new int[N * 40];
    static int[] R = new int[N * 40];
    static int[] val = new int[N * 40];
    static int idx = 0;

    static void build(int id, int l, int r) {
        if (l == r) {
            val[id] = 0;
            return;
        }
        int mid = (l + r) >> 1;
        L[id] = ++idx;
        R[id] = ++idx;
        build(L[id], l, mid);
        build(R[id], mid + 1, r);
        val[id] = val[R[id]] + val[L[id]];
    }

    static void update(int oldid, int id, int pos, int l, int r) {
        val[id] = val[oldid];
        L[id] = L[oldid];
        R[id] = R[oldid];
        if (l == r) {
            val[id]++;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            L[id] = ++idx;
            update(L[oldid], L[id], pos, l, mid);
        } else {
            R[id] = ++idx;
            update(R[oldid], R[id], pos, mid + 1, r);
        }
        val[id] = val[R[id]] + val[L[id]];
    }

    static int query(int id, int li, int ri, int l, int r) {
        if (li > r || ri < l) return 0;
        if (li <= l && r <= ri) return val[id];
        int mid = (l + r) >> 1;
        return query(L[id], li, ri, l, mid) + query(R[id], li, ri, mid + 1, r);
    }

    static void show(int id, int l, int r) {
        if (l == r) {
            System.out.println("(" + l + " " + val[id] + ")");
            return;
        }
        int mid = (l + r) >> 1;
        show(L[id], l, mid);
        show(R[id], mid + 1, r);
    }
}
/*
选糖果【算法赛】

解题思路
本题考察数据结构。
抽象一下，本题题意很简单，就是在区间中，取 i 不超过 si 个，问最多能取多少个数。
简单思考
最暴力的方法直接二维循环，并且用一个数组来计数，那么时间复杂度能够到达：O(mƩ(ri-li+1))。
最大复杂度能够到达 O(nm)。无法通过本题。
离线版本
考虑莫队。时间复杂度能够到达：O（m√n），勉强可以通过。
在线版本
考虑主席树，我们考虑第 i 个数为 pi，如果他是我们取的最后一个，那么在他前面的第 si 个一定不能取，也就是说，他前面的第 si 个同类数不在区间类。
那么我们将每个数的值改为，同类数的前第 si 个的位置，然后做一个区间类小于 l 的数的计数即可。
转换为可持久化权值线段树。可用可持久化线段树解决。
时间复杂度：O((n + m) log n)。
 */