package lq240420;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240420T5 {
    static int n;
    static long[] A;
    static int q;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 2e9;

    private static String solve() {
        long ans = Arrays.stream(A).sum();
        A[0] = INF;

        SegTreeBinarySearch seg = new SegTreeBinarySearch(n);
        seg.buildCnt(1, 1, n);
        seg.buildMin(1, 1, n);

        for (int[] p : lr) {
            int l = p[0], r = p[1];
            l = seg.queryCnt(1, 1, n, l);
            r = seg.queryCnt(1, 1, n, r);
            int idx = seg.queryMin(1, 1, n, l, r);
            ans -= A[idx];
            seg.updateCnt(1, 1, n, idx);
            seg.updateMin(1, 1, n, idx);
        }
        return String.valueOf(ans);
    }

    static class SegTreeBinarySearch {
        int n;
        int[] cnto, who;

        public SegTreeBinarySearch(int n) {
            this.n = n;
            cnto = new int[4 * n];
            who = new int[4 * n];
        }

        void buildCnt(int id, int l, int r) {
            if (l == r) cnto[id] = 1;
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                buildCnt(nxt, l, mid);
                buildCnt(nxt | 1, mid + 1, r);
                cnto[id] = cnto[nxt] + cnto[nxt | 1];
            }
        }

        void maintainMin(int id) {
            int nxt = id << 1;
            if (A[who[nxt]] <= A[who[nxt | 1]]) who[id] = who[nxt];
            else who[id] = who[nxt | 1];
        }

        void buildMin(int id, int l, int r) {
            if (l == r) who[id] = l;
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                buildMin(nxt, l, mid);
                buildMin(nxt | 1, mid + 1, r);
                maintainMin(id);
            }
        }

        int queryCnt(int id, int l, int r, int qv) {
            if (l == r) return l;
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                if (cnto[nxt] >= qv) return queryCnt(nxt, l, mid, qv);
                else return queryCnt(nxt | 1, mid + 1, r, qv - cnto[nxt]);
            }
        }

        int queryMin(int id, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) return who[id];
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                int idxL = 0, idxR = 0;
                if (ql <= mid) idxL = queryMin(nxt, l, mid, ql, qr);
                if (qr > mid) idxR = queryMin(nxt | 1, mid + 1, r, ql, qr);
                return A[idxL] <= A[idxR] ? idxL : idxR;
            }
        }

        void updateCnt(int id, int l, int r, int qpos) {
            if (l == r) cnto[id] = 0;
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                if (qpos <= mid) updateCnt(nxt, l, mid, qpos);
                else updateCnt(nxt | 1, mid + 1, r, qpos);
                cnto[id] = cnto[nxt] + cnto[nxt | 1];
            }
        }

        void updateMin(int id, int l, int r, int qpos) {
            if (l == r) A[l] = INF;
            else {
                int nxt = id << 1, mid = (l + r) >> 1;
                if (qpos <= mid) updateMin(nxt, l, mid, qpos);
                else updateMin(nxt | 1, mid + 1, r, qpos);
                maintainMin(id);
            }
        }
    }
}
/*
仪仗队【算法赛】

考察线段树，或者平衡树。
我们在线段树上维护两个值，一个为数目，一个为最小值。
我们不用真的删除最小的元素，只需要在逻辑上删除即可，即维护的数量值减一。
每次询问区间时，我们线段树上二分，
求出实际的区间。然后找到最小值。
时间复杂度 O(nlogn)。
@TsReaper
 */