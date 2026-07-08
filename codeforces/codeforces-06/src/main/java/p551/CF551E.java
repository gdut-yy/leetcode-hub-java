package p551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CF551E {
    // Time limit exceeded on test 9
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

    // 关键优化总结：
    // - 单Map存min/max：两个HashMap合并为一个，rebuild遍历减半
    // - 单次遍历update+rebuild：原来先加todo再逐个update再rebuild（3次遍历），现在1次遍历同时完成
    // - 原始类型OpenMap：无装箱，版本号O(1) clear
    // - 直接算bl/br：只处理受影响块
    // - byte[]直接IO：比BufferedReader+StringTokenizer快数倍
    // - StringBuilder批量输出：避免逐行flush
    static class OpenMap {
        long[] keys;
        int[] minP, maxP;
        int[] ver;
        int mask, curVer;

        OpenMap(int cap) {
            int sz = 16;
            while (sz <= cap * 3) sz <<= 1;
            keys = new long[sz];
            minP = new int[sz];
            maxP = new int[sz];
            ver = new int[sz];
            mask = sz - 1;
            curVer = 1;
        }

        void clear() {
            curVer++;
            if (curVer <= 0) {
                Arrays.fill(ver, 0);
                curVer = 1;
            }
        }

        int find(long k) {
            int h = (int) ((k ^ (k >>> 32)) * 0x9E3779B9L) & mask;
            while (true) {
                if (ver[h] != curVer) return ~h;
                if (keys[h] == k) return h;
                h = (h + 1) & mask;
            }
        }

        void put(long k, int p) {
            int s = find(k);
            if (s < 0) {
                s = ~s;
                keys[s] = k;
                ver[s] = curVer;
                minP[s] = maxP[s] = p;
            } else {
                if (p < minP[s]) minP[s] = p;
                if (p > maxP[s]) maxP[s] = p;
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
        int B = Math.max((int) Math.sqrt(n), 1);
        int m = (n - 1) / B + 1;
        int[] bL = new int[m], bR = new int[m];
        long[] todo = new long[m];
        OpenMap[] maps = new OpenMap[m];
        for (int i = 0; i < m; i++) {
            bL[i] = i * B;
            bR[i] = Math.min(bL[i] + B, n);
            OpenMap map = new OpenMap(bR[i] - bL[i]);
            maps[i] = map;
            for (int j = bL[i]; j < bR[i]; j++) map.put(a[j], j);
        }
        StringBuilder sb = new StringBuilder();
        for (int qi = 0; qi < q; qi++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int L = scanner.nextInt() - 1;
                int R = scanner.nextInt();
                long v = scanner.nextLong();
                if (v == 0) continue;
                int bl = L / B, br = (R - 1) / B;
                if (bl == br) {
                    long t = todo[bl];
                    todo[bl] = 0;
                    OpenMap map = maps[bl];
                    map.clear();
                    for (int j = bL[bl]; j < bR[bl]; j++) {
                        long val = a[j] + t + (j >= L && j < R ? v : 0);
                        a[j] = val;
                        map.put(val, j);
                    }
                } else {
                    long t0 = todo[bl];
                    todo[bl] = 0;
                    OpenMap mapL = maps[bl];
                    mapL.clear();
                    for (int j = bL[bl]; j < bR[bl]; j++) {
                        long val = a[j] + t0 + (j >= L ? v : 0);
                        a[j] = val;
                        mapL.put(val, j);
                    }
                    for (int i = bl + 1; i < br; i++) todo[i] += v;
                    long t1 = todo[br];
                    todo[br] = 0;
                    OpenMap mapR = maps[br];
                    mapR.clear();
                    for (int j = bL[br]; j < bR[br]; j++) {
                        long val = a[j] + t1 + (j < R ? v : 0);
                        a[j] = val;
                        mapR.put(val, j);
                    }
                }
            } else {
                long y = scanner.nextLong();
                int posL = -1;
                for (int i = 0; i < m; i++) {
                    long key = y - todo[i];
                    int s = maps[i].find(key);
                    if (s >= 0) {
                        posL = maps[i].minP[s];
                        break;
                    }
                }
                if (posL < 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                for (int i = m - 1; i >= 0; i--) {
                    long key = y - todo[i];
                    int s = maps[i].find(key);
                    if (s >= 0) {
                        sb.append(maps[i].maxP[s] - posL).append('\n');
                        break;
                    }
                }
            }
        }
        out.print(sb);
    }

    static class TLE {
        static class Block {
            int l, r;
            long todo;
            Map<Long, Integer> lp, rp;

            Block(int l, int r, long todo, Map<Long, Integer> lp, Map<Long, Integer> rp) {
                this.l = l;
                this.r = r;
                this.todo = todo;
                this.lp = lp;
                this.rp = rp;
            }
        }

        private static void solve() {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
            int blockSize = (int) Math.ceil(Math.sqrt(n / 5.0));
            if (blockSize == 0) blockSize = 1;
            int blockCnt = (n - 1) / blockSize + 1;
            Block[] blocks = new Block[blockCnt];
            for (int i = 0; i < n; i += blockSize) {
                int r = Math.min(i + blockSize, n);
                Map<Long, Integer> lp = new HashMap<>();
                for (int j = r - 1; j >= i; j--) lp.put(a[j], j);
                Map<Long, Integer> rp = new HashMap<>();
                for (int j = i; j < r; j++) rp.put(a[j], j);
                blocks[i / blockSize] = new Block(i, r, 0, lp, rp);
            }
            for (int qi = 0; qi < q; qi++) {
                int op = scanner.nextInt();
                long lv = scanner.nextLong();
                if (op == 1) {
                    int l = (int) lv - 1;
                    int r = scanner.nextInt();
                    long v = scanner.nextLong();
                    for (int i = 0; i < blockCnt; i++) {
                        Block b = blocks[i];
                        if (b.r <= l) continue;
                        if (b.l >= r) break;
                        if (l <= b.l && b.r <= r) {
                            b.todo += v;
                            continue;
                        }
                        for (int j = b.l; j < b.r; j++) {
                            a[j] += b.todo;
                            if (l <= j && j < r) a[j] += v;
                        }
                        b.todo = 0;
                        b.lp.clear();
                        b.rp.clear();
                        for (int j = b.r - 1; j >= b.l; j--) b.lp.put(a[j], j);
                        for (int j = b.l; j < b.r; j++) b.rp.put(a[j], j);
                    }
                } else {
                    int posL = n;
                    for (int i = 0; i < blockCnt; i++) {
                        Block b = blocks[i];
                        long key = lv - b.todo;
                        if (b.lp.containsKey(key)) {
                            posL = b.lp.get(key);
                            break;
                        }
                    }
                    if (posL == n) {
                        out.println(-1);
                        continue;
                    }
                    for (int i = blockCnt - 1; ; i--) {
                        Block b = blocks[i];
                        long key = lv - b.todo;
                        if (b.rp.containsKey(key)) {
                            out.println(b.rp.get(key) - posL);
                            break;
                        }
                    }
                }
            }
        }
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
E. GukiZ and GukiZiana
https://codeforces.com/contest/551/problem/E

灵茶の试炼 2025-08-15
题目大意：
输入 n(1≤n≤5e5) q(1≤q≤5e4) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入 q 个询问，格式如下：
"1 L R x"：把下标在闭区间 [L,R] 中的 a[i] 都增加 x(0≤x≤1e9)。注：a 的下标从 1 开始。
"2 y"：设 i 和 j 为元素 y(1≤y≤1e9) 在 a 中的最左下标和最右下标，输出 j-i。如果 a 中没有 y，输出 -1。
注：本题时间限制为 10s。

rating 2500
这种涉及精确元素位置+带修的题目，很难用线段树维护。由于本题给了 10s 时限，考虑分块。
把 a 分成若干段（块）。
每一块需要维护哪些信息？
有区间加，需要一个 lazy tag，表示这个块整体增加的值。（类似线段树）
需要知道区间中的每个数的最左位置和最右位置，用哈希表维护。
区间加：
块被 [L,R] 完全覆盖时，只把 lazy tag 增加 x。
块被 [L,R] 部分覆盖时（最多有两个这样的块），暴力更新区间中的每个数（注意应用 lazy tag），然后重置 lazy tag = 0，重新计算块中每个数的最左位置和最右位置。
查询：
正着遍历块，找最左位置。找到就退出循环。
倒着遍历块，找最右位置。找到就退出循环。
注：Go1.22 推荐块大小为 sqrt(n/5)，比 sqrt(n) 快一倍。
代码 https://codeforces.com/problemset/submission/551/333473872
代码备份（上面打不开的同学看这个）
也可以统计块内元素出现次数，避免反复重建哈希表。不过速度是一样的。
方法二 https://codeforces.com/problemset/submission/551/334008868
======

Input
4 3
1 2 3 4
1 1 2 1
1 1 1 1
2 3
Output
2

Input
2 3
1 2
1 2 2 1
2 3
2 4
Output
0
-1
 */
