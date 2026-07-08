package p605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF605D {
    // Time limit exceeded on test 60
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[][] gB, gI;
    static int[] gPtr;
    static int[] segL, segR, segMin;
    static int curMaxY, curSrc;
    static int[] pre;
    static int[] queue;
    static int qHead, qTail;

    static void maintain(int o) {
        segMin[o] = Math.min(segMin[o << 1], segMin[o << 1 | 1]);
    }

    static void build(int o, int l, int r) {
        segL[o] = l;
        segR[o] = r;
        if (l == r) {
            segMin[o] = gB[l][gPtr[l]];
            return;
        }
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
        maintain(o);
    }

    static void delete(int o, int qr) {
        int l = segL[o];
        if (l > qr || segMin[o] > curMaxY) return;
        if (l == segR[o]) {
            while (gB[l][gPtr[l]] <= curMaxY) {
                pre[gI[l][gPtr[l]]] = curSrc;
                queue[qTail++] = gI[l][gPtr[l]];
                gPtr[l]++;
            }
            segMin[o] = gB[l][gPtr[l]];
            return;
        }
        delete(o << 1 | 1, qr);
        delete(o << 1, qr);
        maintain(o);
    }

    static int lowerBound(int[] a, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] aa = new int[n + 1], bb = new int[n + 1], cc = new int[n + 1], dd = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = scanner.nextInt();
            bb[i] = scanner.nextInt();
            cc[i] = scanner.nextInt();
            dd[i] = scanner.nextInt();
        }
        int[] xs = new int[n + 1];
        for (int i = 1; i <= n; i++) xs[i] = aa[i];
        int[] sortedXs = xs.clone();
        Arrays.sort(sortedXs);
        int m = 0;
        int[] cxs = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (m == 0 || sortedXs[i] != cxs[m - 1]) cxs[m++] = sortedXs[i];
        }
        int[][] cards = new int[n][3];
        for (int i = 1; i <= n; i++) {
            cards[i - 1][0] = aa[i];
            cards[i - 1][1] = bb[i];
            cards[i - 1][2] = i;
        }
        Arrays.sort(cards, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            int x = lowerBound(cxs, m, cards[i][0]);
            cnt[x]++;
        }
        gB = new int[m][];
        gI = new int[m][];
        gPtr = new int[m];
        for (int i = 0; i < m; i++) {
            gB[i] = new int[cnt[i] + 1];
            gI[i] = new int[cnt[i] + 1];
        }
        int[] idx = new int[m];
        for (int i = 0; i < n; i++) {
            int x = lowerBound(cxs, m, cards[i][0]);
            gB[x][idx[x]] = cards[i][1];
            gI[x][idx[x]] = cards[i][2];
            idx[x]++;
        }
        for (int i = 0; i < m; i++) {
            gB[i][idx[i]] = 2_000_000_000; // 哨兵
            gI[i][idx[i]] = 0;
        }
        int segN = 2 << (32 - Integer.numberOfLeadingZeros(Math.max(m - 1, 0)));
        segL = new int[segN];
        segR = new int[segN];
        segMin = new int[segN];
        if (m > 0) build(1, 0, m - 1);
        pre = new int[n + 1];
        queue = new int[n + 1];
        qHead = 0;
        qTail = 0;
        queue[qTail++] = 0;
        while (qHead < qTail) {
            int i = queue[qHead++];
            if (i == n) {
                int[] ans = new int[n + 1];
                int sz = 0;
                for (; i > 0; i = pre[i]) ans[sz++] = i;
                out.println(sz);
                StringBuilder sb = new StringBuilder();
                for (int j = sz - 1; j >= 0; j--) {
                    sb.append(ans[j]);
                    if (j > 0) sb.append(' ');
                }
                out.println(sb);
                return;
            }
            int maxX = lowerBound(cxs, m, cc[i] + 1) - 1;
            curMaxY = dd[i];
            curSrc = i;
            if (maxX >= 0) delete(1, maxX);
        }
        out.println(-1);
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
D. Board Game
https://codeforces.com/contest/605/problem/D

灵茶の试炼 2025-07-25
题目大意：
输入 n(1≤n≤1e5) 和 n 张魔法卡，每张魔法卡包含四个整数 a,b,c,d，范围 [0,1e9]。
你在二维坐标系中，设当前位置为 (x,y)。
每一步，你可以选择一张满足 a<=x 且 b<=y 的魔法卡，传送到 (c,d)。
一开始，你在 (0,0)。
你的目标是使用第 n 张魔法卡。
如果无法做到，输出 -1。
否则：
第一行，输出最少使用的魔法卡个数（包含第 n 张魔法卡）。
第二行，按顺序输出你使用的魔法卡的下标（编号从 1 到 n），最后一张卡一定是 n。

rating 2500
整体是个 BFS 的框架。直接暴力是 O(n^2) 的，如何优化？
由于访问过的魔法卡无需重复访问，我们可以移除访问过的魔法卡，加快效率。
如何快速找到所有需要移除的魔法卡？
一开始假设下标 0 处有一个 (0,0,0,0) 的魔法卡。一开始 BFS 队列中只有一个下标 0。
我们需要一个数据结构，支持：魔法卡 (a,b,c,d) 出队时，移除数据结构中的横坐标 <= c（离散化后）且纵坐标 <= d 的所有魔法卡。
用线段树套列表存储。
类似线段树二分，为方便找到魔法卡 <= c 的魔法卡，在线段树维护横坐标 a（离散化后）的最小值。
通过对比魔法卡的 d 和子树最小值，我们可以快速判断子树中是否有需要移除的魔法卡。
线段树的每个叶子维护相同横坐标 a 对应的纵坐标 b 列表。为了输出答案，实际保存的是 (b,i)，其中 i 是魔法卡的下标。删除魔法卡时，记录 pre[删除的魔法卡的下标] = 出队的魔法卡的下标。
注：可以在 (b,i) 列表末尾加个无穷大哨兵，这样不需要判断列表是不是空的，简化代码逻辑。
如果删除列表第一个数不方便的话，可以把列表 reverse，这样删除第一个变成删除最后一个。
相似题目：LC2612. 最少翻转操作数
代码 https://codeforces.com/contest/605/submission/328320663
代码备份（Ubuntu Pastebin）
======

Input
4
0 0 3 4
2 2 5 3
4 1 1 7
5 3 8 8
Output
3
1 2 4

Input
2
0 0 4 6
5 1 1000000000 1000000000
Output
-1
 */
